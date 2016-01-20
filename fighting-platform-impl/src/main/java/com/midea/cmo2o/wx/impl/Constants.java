package com.midea.cmo2o.wx.impl;

import java.math.BigDecimal;

public class Constants {
	
	/**无效的int**/
	public static final int CONSTANT_INVALID_INT = -1;
	/**常量int类型0 **/
	public static final int CONSTANT_ZERO_INT = 0;
	/**常量int类型1**/
	public static final int CONSTANT_ONE_INT = 1;
	/**常量int类型2  **/
	public static final int CONSTANT_TWO_INT = 2;
	/** 常量int类型3 **/
	public static final int CONSTANT_THREE_INT = 3;
	/** 常量int类型4 **/
	public static final int CONSTANT_FOUR_INT = 4;
	/** 常量int类型5 **/
	public static final int CONSTANT_FIVE_INT = 5;
	/** 常量int类型6 **/
	public static final int CONSTANT_SIX_INT = 6;
	/** 常量int类型8 **/
	public static final int CONSTANT_EIGHT_INT = 8;
	/** 常量int类型9 **/
	public static final int CONSTANT_NINE_INT = 9;
	/** 常量int类型10 **/
	public static final int CONSTANT_TEN_INT = 10;
	/** 常量int类型100 **/
	public final static int CONSTANT_HUNDRED_INT = 100;
	
	/**无效的int**/
	public static final byte CONSTANT_INVALID_BYTE = -1;
	/**常量byte类型0 **/
	public static final byte CONSTANT_ZERO_BYTE = 0;
	/**常量byte类型1**/
	public static final byte CONSTANT_ONE_BYTE = 1;
	/**常量byte类型2  **/
	public static final byte CONSTANT_TWO_BYTE = 2;
	/** 常量byte类型3 **/
	public static final byte CONSTANT_THREE_BYTE = 3;	
	
	/**空字符串**/
	public final static String CONSTANT_EMPTY_STR = "";
	/** 常量字符串类型0 **/
	public static final String CONSTANT_ZERO_STR = "0";
	/** 常量字符串类型1 **/
	public static final String CONSTANT_ONE_STR = "1";
	/** 常量字符串类型2**/
	public static final String CONSTANT_TWO_STR = "2";
	/** 常量字符串类型3**/
	public static final String CONSTANT_THREE_STR = "3";
	/** 常量字符串类型4**/
	public static final String CONSTANT_FOUR_STR = "4";
	/**无效的string**/
	public static final String CONSTANT_INVALID_STR = "-1";
	
	/**常量Long类型0L **/
	public static final Long CONSTANT_ZERO_LONG = Long.valueOf(0L);
	/**常量Long类型1L **/
	public static final Long CONSTANT_ONE_LONG = 1L;
	/**常量Long类型50L **/
	public static final Long CONSTANT_FIFTY_LONG = 50L;
	/**常量Long类型300L **/
	public static final Long CONSTANT_THREEHUNDRED_LONG = 300L;
	/**常量Long类型1000L **/
	public static final Long CONSTANT_THOUSAND_LONG = 1000L;
	/**常量Long类型3000L **/
	public static final Long CONSTANT_THREE_THOUSAND_LONG = 3000L;
	/**常量Long类型5000L **/
	public static final Long CONSTANT_FIVE_THOUSAND_LONG = 5000L;
	
	/**常量BigDecimal类型0**/
	public static final BigDecimal CONSTANT_ZERO_DECIMAL = BigDecimal.valueOf(CONSTANT_ZERO_LONG);
	/**常量BigDecimal类型100**/
	public static final BigDecimal CONSTANT_HUNDRED_DECIMAL = BigDecimal.valueOf(100);
	/**常量BigDecimal类型300**/
	public final static BigDecimal CONSTANT_THREE_HUNDRED_DECIMAL = BigDecimal.valueOf(300);
	
	/**缓存过期时间一个月**/
	public final static int REDIS_ONEMONTH = 2592000;//60*60*24*30 
	/**过期时间为一周**/
	public static final int REDIS_ONEWEEK = 604800;
	/**缓存过期时间一天**/
	public final static int REDIS_ONEDAY = 86400;//60*60*24 
	/**缓存过期时间半天**/
	public final static int REDIS_HALFDAY = 43200;//60*60*12 
	/**缓存过期时间十天**/
	public final static int REDIS_TENDAY = 864000;//60*60*24*10
	/**缓存过期时间一小时**/
	public final static int REDIS_ONEHOUR = 3600;//60*60
	/**缓存过期时间半小时**/
	public final static int REDIS_HALFHOUR = 1800;//60*30
	/**缓存过期时间十分钟**/
	public final static int REDIS_TENMINUTE = 600;//60*10
	/**缓存过期时间90秒**/
	public final static int REDIS_NINETY = 90;
	/**缓存过期时间半分钟**/
	public final static int REDIS_HALFMINUTE = 30;
	
	/**时间一天秒数**/
	public final static int CONSTANT_ONEDAY_SECOND = 86400;//60*60*24 
	/**一周毫秒数**/
	public final static long CONSTANT_ONEWEEK_MILLISCOND = 604800000;//7*24*3600*1000
	/**常量1秒 **/
	public static final long CONSTANT_ONE_SECOND = 1000;
	
	
	/**响应名称**/
	public static final String RESPONSE_NAME = "result_code";
	/**响应描述**/
	public static final String RESPONSE_DESCR = "result_descr";
	/**响应记录**/
	public static final String RESPONSE_CONTENT = "result_content";
	
	/**本地ip地址**/
	public static final String DEFAULT_IP = "127.0.0.1";
	
	/**日期格式 **/
	public static final String FORMAT_STR_DATETIME = "yyyy-MM-dd HH:mm:ss";
	public static final String FORMAT_DIR_DATE = "yyyyMMdd";
	
	/** 分页默认参数 **/
	public static final String DEFAUTL_PAGE_INDEX = "0";
	public static final String DEFAUTL_PAGE_SIZE = "20";
	
	/** 文件上传后存放路径 **/
	public static final String UPLOAD_PATH = "/data/uploadFile";
	
	public static final String CALLBACK = "callback";
	
}
