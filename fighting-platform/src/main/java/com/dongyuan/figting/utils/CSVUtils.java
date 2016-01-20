package com.dongyuan.figting.utils;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStreamWriter;
import java.nio.charset.Charset;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.dongyuan.figting.Constants;
import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.beanutils.PropertyUtils;
import org.apache.commons.lang.StringUtils;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellValue;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.FormulaEvaluator;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

import com.csvreader.CsvReader;

/**
 * CSV导出
 * 
 * @author xiejun1
 */
public class CSVUtils {

	/**
	 * 导出
	 * 
	 * @param exportData 导出数据
	 * @param rowMapper 导出列
	 * @param outPutPath 文件存放路径
	 * @param filename 导出文件名
	 * @return
	 */
	@SuppressWarnings("rawtypes")
	public static File exportCsv(List exportData, Map columnMapper, String outPutPath,
			String filename) {

		File csvFile = null;
		BufferedWriter csvFileOutputStream = null;
		/* LinkedHashMap rowMapper = getExportOrderClomn(columnMapper); */
		try {
			csvFile = new File(outPutPath + filename + ".csv");
			File parent = csvFile.getParentFile();
			if (parent != null && !parent.exists()) {
				parent.mkdirs();
			}
			csvFile.createNewFile();

			// GB2312使正确读取分隔符","
			csvFileOutputStream = new BufferedWriter(
					new OutputStreamWriter(new FileOutputStream(csvFile), "gb2312"), 1024);

			// 写入文件头部
			for (Iterator propertyIterator = columnMapper.entrySet().iterator(); propertyIterator
					.hasNext();) {
				java.util.Map.Entry propertyEntry = (java.util.Map.Entry) propertyIterator.next();
				csvFileOutputStream.write("\"" + propertyEntry.getValue().toString() + "\"");
				if (propertyIterator.hasNext()) {
					csvFileOutputStream.write(",");
				}
			}
			csvFileOutputStream.newLine();

			// 写入文件内容
			for (Iterator iterator = exportData.iterator(); iterator.hasNext();) {
				Object row = iterator.next();
				for (Iterator propertyIterator =
						columnMapper.entrySet().iterator(); propertyIterator.hasNext();) {
					java.util.Map.Entry propertyEntry =
							(java.util.Map.Entry) propertyIterator.next();
					Object val = PropertyUtils.getProperty(row, propertyEntry.getKey().toString());
					String value = null;
					if (val instanceof Date) {
						value = (val == null ? null
								: new SimpleDateFormat(Constants.FORMAT_STR_DATETIME)
										.format(value));
					} else {
						value = (val == null ? null : val.toString());
					}
					if (BeanUtils.getProperty(row, propertyEntry.getKey().toString()) != null) {
						Pattern pattern = Pattern.compile("^-?\\d+(\\.\\d{1,5})?$");
						Matcher matcher = pattern.matcher(value);
						if (matcher.find()) {
							value = value + "\t"; // 避免数字变成科学计数法，前后加\t,或前面加=
						}
						csvFileOutputStream.write("\"" + value + "\"");
					}
					if (propertyIterator.hasNext()) {
						csvFileOutputStream.write(",");
					}
				}
				if (iterator.hasNext()) {
					csvFileOutputStream.newLine();
				}
			}
			csvFileOutputStream.flush();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				csvFileOutputStream.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return csvFile;
	}

	/*
	 * @SuppressWarnings({ "rawtypes", "unchecked" }) private static
	 * LinkedHashMap getExportOrderClomn(Map exportColumn) { LinkedHashMap
	 * rowMapper = new LinkedHashMap(); for (Iterator propertyIterator =
	 * exportColumn.entrySet().iterator(); propertyIterator .hasNext();) {
	 * java.util.Map.Entry propertyEntry = (java.util.Map.Entry)
	 * propertyIterator.next(); rowMapper.put(propertyEntry.getKey(),
	 * propertyEntry.getValue()); } return rowMapper; }
	 */

	/**
	 * jxl读excel格式. poi, jxl, jxls等。 jxl是一个韩国人写的java操作excel的工具,
	 * 在开源世界中，有两套比较有影响的API可供使用，一个是POI，一个是jExcelAPI。
	 * 其中功能相对POI比较弱一点。但jExcelAPI对中文支持非常好，API是纯Java的，
	 * 并不依赖Windows系统，即使运行在Linux下，它同样能够正确的处理Excel文件。
	 * 另外需要说明的是，这套API对图形和图表的支持很有限，而且仅仅识别PNG格式
	 */
	public static List<List<String>> readFromExcel(InputStream inputStream) throws Exception {
		DecimalFormat df = new DecimalFormat("#");
		try {
			Workbook wb = WorkbookFactory.create(inputStream);
			FormulaEvaluator evaluator = wb.getCreationHelper().createFormulaEvaluator();
			// int sheetNum = wb.getNumberOfSheets();
			Sheet sheet = wb.getSheetAt(0);
			int startRow = sheet.getFirstRowNum();
			int endRow = sheet.getLastRowNum();
			if (endRow > 500) {
				throw new Exception("上传数量太大，请分开上传！");
			}

			List<List<String>> excelData = new ArrayList<List<String>>();
			for (int i = startRow; i <= endRow; i++) {
				Row row = sheet.getRow(i);
				List<String> rowData = new ArrayList<String>();
				StringBuffer auditEmptyRow = new StringBuffer();
				if (row != null) {
					int cellNum = row.getLastCellNum();
					for (int j = 0; j < cellNum; j++) {
						StringBuffer value = new StringBuffer();
						Cell cell = row.getCell(j);
						CellValue cellValue = evaluator.evaluate(cell);
						if (cellValue != null) {
							switch (cellValue.getCellType()) {
							case Cell.CELL_TYPE_BOOLEAN:
								value.append(cellValue.getBooleanValue());
								break;
							case Cell.CELL_TYPE_NUMERIC:
								if (DateUtil.isCellDateFormatted(cell)) {
									value.append(DateUtil
											.DateToString(cell.getDateCellValue(),
													DateStyle.YYYY_MM_DD_HH_MM_SS.getValue()));
								} else {
									value.append(df.format(cellValue.getNumberValue()));
								}
								break;
							case Cell.CELL_TYPE_STRING:
								value.append(cellValue.getStringValue().trim());
								break;
							default:
								value.append("");
								break;
							}
						}
						auditEmptyRow.append(value.toString().trim());
						if (StringUtils.isBlank(value.toString())) {
							rowData.add(null);
						} else {
							rowData.add(value.toString());
						}
					}
				}
				if (StringUtils.isNotBlank(auditEmptyRow.toString())) {
					excelData.add(rowData);
				}
			}
			return excelData;
		} catch (InvalidFormatException e) {
			throw new Exception("文件解析出错");
		} catch (IOException e) {
			throw new Exception("文件解析出错");
		}
	}

	/**
	 * 读csv格式. 开源jar包有opencsv， javacsv, csvObjects(可以装换成对象)，csv, csvjdbc等.
	 * 此处用javacsv
	 */
	public static List<List<String>> readFromCsv(InputStream inputStream) throws Exception {
		CsvReader reader = null;
		try {
			List<List<String>> excelData = new ArrayList<List<String>>();
			reader = new CsvReader(inputStream, ',', Charset.forName("utf-8")); // 一般用这编码读就可以了
			reader.readHeaders(); // 跳过表头 如果需要表头的话，不要写这句。
			while (reader.readRecord()) {
				String[] filedArry = reader.getValues();
				List<String> filedList = Arrays.asList(filedArry);
				excelData.add(filedList);
			}
			return excelData;
		} catch (Exception e) {
			throw new Exception("csv文件解析出错");
		} finally {
			reader.close();
		}
	}

}
