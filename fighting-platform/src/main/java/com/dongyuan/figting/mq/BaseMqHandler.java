package com.dongyuan.figting.mq;

import com.dongyuan.figting.utils.JacksonMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.alibaba.rocketmq.client.consumer.listener.ConsumeConcurrentlyStatus;

/**
 * 
* @ClassName: BaseMqHandler 
* @Description: MQ消息转化基类
* @author 汪海霖  wanghl15@midea.com.cn
* @date 2015-4-21 上午9:31:13
 */

public abstract class BaseMqHandler<T> {
	
	private static Logger logger = LoggerFactory.getLogger(BaseMqHandler.class);
	
	
	//处理MQ消息
	public ConsumeConcurrentlyStatus dealMqMessage(String bodyStr,String mqKey){
		T obj = JacksonMapper.jsonToBean(bodyStr, getMqClass());
		if(obj == null){
			logger.warn("数据转换异常,bodyStr=="+bodyStr);
			return ConsumeConcurrentlyStatus.CONSUME_SUCCESS;
		}
		String resultCode = null;
		try{
			resultCode = processMessageLogic(obj, mqKey);
			/*if(StringUtils.isBlank(resultCode)){
				//resultCode = BaseApiCode.OPERATE_SUCCESS;
			}*/
			if(resultCode.equals("")){//操作超时、操作处理中、外围系统异常、操作失败、系统异常
				return ConsumeConcurrentlyStatus.RECONSUME_LATER;
			}else{
				logger.info("》》订单状态信息发送成功《《.");
				return ConsumeConcurrentlyStatus.CONSUME_SUCCESS;
			}
		}finally{
		}
	}
	
	//处理消息逻辑
	protected abstract String processMessageLogic(T obj,String mqKey);
	
	//获取MQ请求class
	protected abstract Class<T> getMqClass();

}
