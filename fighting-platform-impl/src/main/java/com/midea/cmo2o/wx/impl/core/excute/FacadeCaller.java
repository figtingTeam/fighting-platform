package com.midea.cmo2o.wx.impl.core.excute;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 服务调用，封装了对异常的处理。使用 process 方法可简化服务方法的调用
 */
public class FacadeCaller {

	private static final Logger LOGGER = LoggerFactory.getLogger(FacadeCaller.class);

	/**
	 * 调用服务
	 */
	public static <T> T process(ServiceMethod<T> method) {
		try {
			// 通过新建异常获得服务方法和类名
			StackTraceElement ste = new Exception().getStackTrace()[1];
			String methodName = ste.getMethodName();
			String serviceName = getSimpleClassName(ste.getClassName());
			String facadeName = serviceName.concat(".").concat(methodName);
			// 执行具体的方法调用
			long tick = System.currentTimeMillis();
			T ret = method.invoke();
			tick = System.currentTimeMillis() - tick;
			if (tick > 3000) {
				LOGGER.warn("方法:{}执行时间过长，耗时：{}，请确认!", facadeName, tick);
			}
			return ret;
		} catch (Exception e) {
			e.printStackTrace();
		} 
		return null;
	}

	private static String getSimpleClassName(String className) {
		return className.substring(className.lastIndexOf(".") + 1);
	}
}
