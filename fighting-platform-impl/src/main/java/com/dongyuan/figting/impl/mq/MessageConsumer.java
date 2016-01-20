package com.dongyuan.figting.impl.mq;

import java.util.List;

import org.apache.commons.collections.CollectionUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import com.alibaba.rocketmq.client.consumer.DefaultMQPushConsumer;
import com.alibaba.rocketmq.client.consumer.listener.ConsumeConcurrentlyContext;
import com.alibaba.rocketmq.client.consumer.listener.ConsumeConcurrentlyStatus;
import com.alibaba.rocketmq.client.consumer.listener.MessageListenerConcurrently;
import com.alibaba.rocketmq.client.exception.MQClientException;
import com.alibaba.rocketmq.common.consumer.ConsumeFromWhere;
import com.alibaba.rocketmq.common.message.MessageExt;
import com.dongyuan.figting.impl.core.AppSpringContext;

/**
 * @ClassName: MessageConsumer
 * @Description: MQ消息消费类
 * @author 汪海霖 wanghl15@midea.com.cn
 * @date 2015-4-29 上午8:44:32
 */

@Component
public class MessageConsumer implements ApplicationListener<ContextRefreshedEvent> {

	private static Logger logger = LoggerFactory.getLogger(MessageConsumer.class);

	@Value("${mq.monitor.flag}")
	private boolean isMonitor;

/*	@Autowired*/
	@Qualifier("defaultMQPushConsumer")
	private DefaultMQPushConsumer defaultMQPushConsumer;

	public void receiveMessage() throws MQClientException {
		// 这里可以设置批量接受消息
		defaultMQPushConsumer.setConsumeMessageBatchMaxSize(1);
		defaultMQPushConsumer.subscribe("lsb2b", "wx-msg");
		defaultMQPushConsumer.setConsumeFromWhere(ConsumeFromWhere.CONSUME_FROM_FIRST_OFFSET);
		defaultMQPushConsumer.registerMessageListener(new MessageListenerConcurrently() {
			@Override
			public ConsumeConcurrentlyStatus consumeMessage(List<MessageExt> msgs,
					ConsumeConcurrentlyContext context) {
				// msgs的元素可以是多个
				if (CollectionUtils.isNotEmpty(msgs)) {
					MessageExt msg = msgs.get(0);
					MqDealType type = MqDealType.getMqDealTypeByTag(msg.getTags());
					if ("lsb2b".equals(msg.getTopic()) && type != null) {
						String bodyStr = new String(msg.getBody());
						String keys = msg.getKeys();
						BaseMqHandler<?> handler =
								AppSpringContext.getBean(type.getBeanName(), BaseMqHandler.class);
						return handler.dealMqMessage(bodyStr, keys);
					}
					return ConsumeConcurrentlyStatus.RECONSUME_LATER;
				} else {
					return ConsumeConcurrentlyStatus.CONSUME_SUCCESS;
				}
			}
		});
		defaultMQPushConsumer.start();
		logger.info("MQ单条消费监听成功");
	}

	@Override
	public void onApplicationEvent(ContextRefreshedEvent event) {
		try {
			if (isMonitor) {
				receiveMessage();
			} else {
				logger.warn("MQ系统配置不监听,请确认?");
			}
		} catch (MQClientException ex) {
			logger.error(ex.getMessage(), ex);
		}
	}

	public void unsubscribeMq() {
		defaultMQPushConsumer.unsubscribe("lsb2b");
	}
}
