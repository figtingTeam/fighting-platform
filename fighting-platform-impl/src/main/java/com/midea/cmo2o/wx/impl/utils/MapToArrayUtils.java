package com.midea.cmo2o.wx.impl.utils;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/**
 * map转为数组
 * @author YANGZG5
 *
 */
public class MapToArrayUtils {

	/**
	 * 由map中的value构成数组
	 * @param columnMapper
	 * @return
	 */
	public static String[] mapToArrayByValue(Map columnMapper) {
		List<String> arrayList = new ArrayList<String>();
		for (Iterator propertyIterator = columnMapper.entrySet().iterator(); propertyIterator
				.hasNext();) {
			java.util.Map.Entry propertyEntry = (java.util.Map.Entry) propertyIterator
					.next();
			arrayList.add(propertyEntry.getValue().toString());
		}
		return arrayList.toArray(new String[arrayList.size()]);
	}

	/**
	 * 由map中的key构成数组
	 * @param columnMapper
	 * @return
	 */
	public static String[] mapToArrayByKey(Map columnMapper) {
		List<String> arrayList = new ArrayList<String>();
		for (Iterator propertyIterator = columnMapper.entrySet().iterator(); propertyIterator
				.hasNext();) {
			java.util.Map.Entry propertyEntry = (java.util.Map.Entry) propertyIterator
					.next();
			arrayList.add(propertyEntry.getKey().toString());
		}
		return arrayList.toArray(new String[arrayList.size()]);
	}
}
