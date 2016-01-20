package com.midea.cmo2o.wx.impl.core.fieldpack.annotions;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/** 
 * @ClassName: PackTarget 
 * @Description: 
 * @author 汪海霖     wanghl15@midea.com.cn
 * @date 2014-10-1 上午9:14:13  
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface PackTarget {
}