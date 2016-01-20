package com.dongyuan.figting.utils;

import java.util.UUID;

public class UUIDUtils {

	public final static int LEN = getUUID().length();

	public static String getUUID() {
		UUID uuid = UUID.randomUUID();
		String str = uuid.toString();
		// 去掉"-"符号
		String uuidStr = str.substring(0, 8) + str.substring(9, 13) + str.substring(14, 18) + str.substring(19, 23) + str.substring(24);
		return uuidStr;
	}
}