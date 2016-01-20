package com.midea.cmo2o.wx.impl.utils;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.beanutils.PropertyUtils;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFClientAnchor;
import org.apache.poi.hssf.usermodel.HSSFPatriarch;
import org.apache.poi.hssf.usermodel.HSSFRichTextString;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

public class ExcelUtils {

	/**
	 * 导出
	 * 
	 * @param exportData 导出数据
	 * @param rowMapper 导出列
	 * @param outPutPath 文件存放路径
	 * @param filename 导出文件名
	 * @return
	 */
	public static File exportExcel(List exportData, Map columnMapper, String outPutPath,
			String filename) {
		OutputStream out = null;
		File xlsFile = new File(outPutPath + filename + ".xls");
		File parent = xlsFile.getParentFile();
		if (parent != null && !parent.exists()) {
			parent.mkdirs();
		}
		try {
			xlsFile.createNewFile();
			out = new FileOutputStream(xlsFile);
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		LinkedHashMap rowMapper = new LinkedHashMap();
		for (Iterator propertyIterator = columnMapper.entrySet().iterator(); propertyIterator
				.hasNext();) {
			java.util.Map.Entry propertyEntry = (java.util.Map.Entry) propertyIterator.next();
			rowMapper.put(propertyEntry.getKey(), propertyEntry.getValue());
		}
		String[] headers = MapToArrayUtils.mapToArrayByValue(rowMapper);
		// 声明一个工作薄
		HSSFWorkbook workbook = new HSSFWorkbook();
		// 生成一个表格
		HSSFSheet sheet = workbook.createSheet(filename);
		// 设置表格默认列宽度为15个字节
		sheet.setDefaultColumnWidth((short) 15);
		// 生成一个样式
		HSSFCellStyle style = workbook.createCellStyle();
		// 设置这些样式
		// 生成并设置另一个样式
		HSSFCellStyle style2 = workbook.createCellStyle();

		// 产生表格标题行
		HSSFRow row = sheet.createRow(0);
		for (short i = 0; i < headers.length; i++) {
			HSSFCell cell = row.createCell(i);
			cell.setCellStyle(style);
			HSSFRichTextString text = new HSSFRichTextString(headers[i]);
			cell.setCellValue(text);
		}

		// 遍历集合数据，产生数据行
		Iterator it = exportData.iterator();
		int index = 0;
		while (it.hasNext()) {
			index++;
			row = sheet.createRow(index);
			HSSFCell cell = null;
			Object rowObject = (Object) it.next();

			String[] fields = MapToArrayUtils.mapToArrayByKey(rowMapper);
			for (int i = 0; i < fields.length; i++) {
				Object val = null;
				try {
					val = PropertyUtils.getProperty(rowObject, fields[i]);
					cell = row.createCell((short) i);
					cell.setCellStyle(style2);
					String value = null;
					if (val instanceof Date) {
						value = (val == null ? null : DateUtil.DateToString((Date) val,
								DateStyle.YYYY_MM_DD_HH_MM_SS.getValue()));
					} else {
						value = (val == null ? null : val.toString());
					}
					if (BeanUtils.getProperty(rowObject, fields[i]) != null) {
						Pattern pattern = Pattern.compile("^-?\\d+(\\.\\d{1,5})?$");
						Matcher matcher = pattern.matcher(value);
						if (matcher.find()) {
							value = value + "\t"; // 避免数字变成科学计数法，前后加\t,或前面加=
							cell.setCellValue(value);
						} else {
							HSSFRichTextString richString = new HSSFRichTextString(value);
							cell.setCellValue(richString);
						}
					}
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}

		try {
			workbook.write(out);
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			// 关闭资源
			if (null != out) {
				try {
					out.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		return xlsFile;
	}

}
