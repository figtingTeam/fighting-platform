package com.dongyuan.figting.impl.code;

import java.util.Map;

public class ShoppingCartApiCode {

	/** 购物车无商品 **/
	public static final String PRODUCT_ITEM_NOT_EXIST = "8000";

	/** 导购不存在 **/
	public static final String SALE_MAN_NOT_EXIST = "8001";

	/** 购物车已满 */
	public static final String SHOPPING_CART_FULL = "9001";

	/** 单个商品购买数量超过99*/
	public static final String SKU_NUM_MAX_LIMIT = "9002";

	public static void initResponseCode() {
		Map<String, String> enMsgMap = BaseApiCode.enMsgMap;
		Map<String, String> zhMsgMap = BaseApiCode.zhMsgMap;
		enMsgMap.put(SALE_MAN_NOT_EXIST, "cart.sale_man_not_exist");
		zhMsgMap.put(SALE_MAN_NOT_EXIST, "导购不存在");
		enMsgMap.put(PRODUCT_ITEM_NOT_EXIST, "cart.product_item_not_exist");
		zhMsgMap.put(PRODUCT_ITEM_NOT_EXIST, " 购物车无商品");
		enMsgMap.put(SHOPPING_CART_FULL, "cart.shopping_cart_full");
		zhMsgMap.put(SHOPPING_CART_FULL, " 购物车已满");
		enMsgMap.put(SKU_NUM_MAX_LIMIT, "cart.sku-num-max-limit");
		zhMsgMap.put(SKU_NUM_MAX_LIMIT, "单个商品购买数量超过99");
	}
}
