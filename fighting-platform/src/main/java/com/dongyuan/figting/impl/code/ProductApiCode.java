package com.dongyuan.figting.impl.code;

import java.util.Map;

public class ProductApiCode {

	/** 商品不存在**/
	public static final String PRODUCT_NOT_EXIST = "7001";
	
	public static void initResponseCode() {
		Map<String, String> enMsgMap = BaseApiCode.enMsgMap;
		Map<String, String> zhMsgMap = BaseApiCode.zhMsgMap;
		enMsgMap.put(PRODUCT_NOT_EXIST, "product.product_not_exist");
		zhMsgMap.put(PRODUCT_NOT_EXIST, "商品不存在");
	}
}
