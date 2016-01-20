package com.midea.cmo2o.wx.impl.core.monitor.annotions;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface MethodMonitor {
	//超时时间
	int timeout() default 500;
	//是否打印参数
	boolean isPrintAgru() default true;
	//是否通知
	boolean isNotice() default false;
}
