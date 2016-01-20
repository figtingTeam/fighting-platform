package com.dongyuan.figting.impl.utils.hessian;

import org.springframework.aop.framework.ProxyFactory;
import org.springframework.beans.factory.FactoryBean;

/** 
 * @author 李易成   yicheng.li@midea.com.cn
 * @Description: 
 * @date 2015年10月9日
 * @version 1.0 
 */
public class TCHessianProxyFactoryBean extends TCHessianClientInterceptor implements FactoryBean<Object> {

	private Object serviceProxy;


	@Override
	public void afterPropertiesSet() {
		super.afterPropertiesSet();
		this.serviceProxy = new ProxyFactory(getServiceInterface(), this).getProxy(getBeanClassLoader());
	}


	public Object getObject() {
		return this.serviceProxy;
	}

	public Class<?> getObjectType() {
		return getServiceInterface();
	}

	public boolean isSingleton() {
		return true;
	}

}
