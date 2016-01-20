package com.dongyuan.figting.helper;

import com.dongyuan.figting.utils.FastJSONHelper;
import com.dongyuan.figting.utils.StringUtils;

/**
 * 
 * 类AjaxControllerHelper.java的实现描述：解決前端ajax跨域問題
 * @author huanghf 2015年12月4日 下午2:20:07
 * @email  haifeng1.huang@midea.com
 */
public class AjaxControllerHelper {

	public static Object generateReturnValue(String callBackValue,Object obj){
		if(StringUtils.isBlank(callBackValue)){
			return obj;
		}
		StringBuilder sb = new StringBuilder();
		sb.append(callBackValue);
		sb.append("(");
		sb.append(FastJSONHelper.serialize(obj));
		sb.append(")");
		return sb.toString();
	}

}
