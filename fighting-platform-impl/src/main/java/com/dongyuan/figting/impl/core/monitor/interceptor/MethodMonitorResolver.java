package com.dongyuan.figting.impl.core.monitor.interceptor;

import java.lang.reflect.Method;
import java.util.Arrays;

import com.dongyuan.figting.impl.core.monitor.annotions.MethodMonitor;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.dongyuan.figting.impl.utils.JacksonMapper;

/**
 * 
* @ClassName: MethodMonitorResolver 
* @Description: 方法监控类
* @author 汪海霖  wanghl15@midea.com.cn
* @date 2015-4-13 下午5:59:42
 */

@Aspect
@Component
public class MethodMonitorResolver {
	
	private static Logger logger = LoggerFactory.getLogger(MethodMonitorResolver.class);
	
	@Pointcut("execution(@com.dongyuan.figting.impl.core.monitor.annotions.MethodMonitor * *(..))")
	private void pointRepeat() {
	};// 切入点的名称就是	方法名
	
	// 定义切入点allMethod()的环绕通知,环绕通知方法一定要按照下面的形式定义(只可以修改方法名和参数名)
	@Around("pointRepeat()")
	public Object doSomethingAround(ProceedingJoinPoint point) throws Throwable {
		long startTime = System.currentTimeMillis();
		//执行方法逻辑
		Object obj = point.proceed();
		MethodMonitor monitor = getMethodMonitor(point);
		if(monitor != null){
			//服务名
			String facadeName = point.getTarget().getClass().getSimpleName().concat(".")
									.concat(point.getSignature().getName());
			long runTime = System.currentTimeMillis() - startTime;
			if(monitor.timeout() < runTime /*|| RespPackUtil.isPrintDebugLog(facadeName)*/){//超时后打印日志
				String pringContent = getPrintLog(point, monitor, facadeName, runTime, obj);
				logger.info(pringContent);
			}
		}
		return obj;
	}
	
	private String getPrintLog(ProceedingJoinPoint point,MethodMonitor monitor,
			String facadeName,long runTime,Object obj){
		StringBuilder strBuff = new StringBuilder();
		strBuff.append("调用内部方法或外部服务==").append(facadeName);
		if(monitor.isPrintAgru()){
			strBuff.append(";请求数据==").append(JacksonMapper.listToJson(Arrays.asList(point.getArgs())));
		}
		strBuff.append(";共耗时==").append(runTime)
			.append(";response==").append(JacksonMapper.beanToJson(obj));
		return strBuff.toString();
	}
	
	@AfterThrowing(pointcut="pointRepeat()",throwing="ex")
	public void doAfterThrowing(JoinPoint joinPoint,Exception ex){
		String serviceName = joinPoint.getTarget().getClass().getSimpleName();
		String methodName = joinPoint.getSignature().getName();
		String reqStr = JacksonMapper.listToJson(Arrays.asList(joinPoint.getArgs()));
		StringBuilder strBuff = new StringBuilder();
		strBuff.append("调用内部方法或外部服务==").append(serviceName).append(".").append(methodName)
			   .append("异常;请求数据==").append(reqStr).append(";error_msg==");
		/*Throwable cause = ex.getCause();
		if(RespPackUtil.isTimeoutThrowable(cause) false){
			strBuff.append(cause.getMessage());
			logger.warn(strBuff.toString());
		}else{*/
			strBuff.append(ex.getMessage());
			logger.error(strBuff.toString(),ex);
		//}
		MethodMonitor monitor = getMethodMonitor(joinPoint);
		if(monitor != null && monitor.isNotice()){
			/*RespPackUtil.execInvokeFailToNotice(serviceName, methodName, ex, reqStr);*/
		}
	}
	
	private MethodMonitor getMethodMonitor(JoinPoint joinPoint){
		MethodMonitor monitor = ((MethodSignature)joinPoint.getSignature()).getMethod()
				.getAnnotation(MethodMonitor.class);
		if(monitor == null){//接口的实现类
			//拦截的实体类
			Object target = joinPoint.getTarget();
			//拦截的方法名称
			String methodName = joinPoint.getSignature().getName();
			//拦截的方法参数类型
			Class<?>[] parameterTypes = ((MethodSignature)joinPoint.getSignature()).getMethod().getParameterTypes();
			try {
				//获取实体类的方法
				Method method = target.getClass().getMethod(methodName, parameterTypes);
				//获取方法上的注解
				monitor = method.getAnnotation(MethodMonitor.class);
			} catch (SecurityException ex) {
			} catch (NoSuchMethodException ex) {
			}
		}
		return monitor;
	}
}
