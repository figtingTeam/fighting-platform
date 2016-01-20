package com.dongyuan.figting.impl.utils;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.HashMap;
import java.util.Map;

import org.springframework.util.StringUtils;

public class QueryUtils {
	/**
	 * 解析查询json为Map
	 * 
	 * @param query
	 *            查询json，例如{id:1,name:"tc"}
	 * @return
	 */
	public static Map parseQueryString2Map(String query) {
		return parseQueryJson2Object(query, HashMap.class);
	}

	/**
	 * http的Query字符串解析为对象
	 * 
	 * @param query
	 * @param clazz
	 * @return
	 */
	public static <T> T parseQueryJson2Object(String query, Class<T> clazz) {
		if (StringUtils.isEmpty(query)) {
			return null;
		}

		if (clazz == null) {
			return null;
		}

		String decodeQuery = null;
		try {
			decodeQuery = URLDecoder.decode(query, "UTF-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}

		if (decodeQuery == null) {
			decodeQuery = query;
		}

		return FastJSONHelper.deserialize(decodeQuery, clazz);
	}

	/**
	 * Json字符串解析为对象
	 * 
	 * @param jsonString
	 * @param clazz
	 * @return
	 */
	public static <T> T parseJsonString2Object(String jsonString, Class<T> clazz) {
		if (StringUtils.isEmpty(jsonString)) {
			return null;
		}

		if (clazz == null) {
			return null;
		}

		return FastJSONHelper.deserialize(jsonString, clazz);
	}
}
