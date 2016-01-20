package com.midea.cmo2o.wx.impl.core.excute;

import com.midea.cmo2o.wx.impl.dto.BodyData;


/**
 * 
* @ClassName: ServiceWrapper 
* @Description: 服务包装类
* @author 汪海霖  wanghl15@midea.com.cn
* @date 2015-4-23 下午1:57:12
 */

public abstract class ControllerWrapper {
	
	//调用服务
	public abstract String invokeService();
	
	//是否监控失败请求
	public boolean isMonitorFail(){
		return true;
	}
	
	//是否监控成功请求
	public boolean isMonitorSuccess(){
		return false;
	}
	
	//超时时间
	public int timeout(){
		return 300;
	}
	
	//获取请求traceId
	public String getTraceId(){
		return null;
	}
	
	//是否通知调用失败
	public boolean isNoticeInvokeFail(BodyData response){
		return false;
	}

}
