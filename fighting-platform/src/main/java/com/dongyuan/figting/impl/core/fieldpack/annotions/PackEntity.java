package com.dongyuan.figting.impl.core.fieldpack.annotions;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/** 
 * @ClassName: PackEntity 
 * @Description: 
 * @author 汪海霖     wanghl15@midea.com.cn
 * @date 2014-9-30 下午8:44:51  
 */
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface PackEntity {
	String querySql();
	String cacheKey();
	String idFieldName();
	String dbColumn();
}
