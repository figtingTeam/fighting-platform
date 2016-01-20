package com.midea.cmo2o.wx.impl.task.schedule;

import java.io.InputStream;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import org.apache.commons.lang.StringUtils;
import org.apache.zookeeper.common.IOUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.midea.cmo2o.wx.impl.core.AppSpringContext;
import com.taobao.pamirs.schedule.strategy.TBScheduleManagerFactory;

/**
 * 
* @ClassName: TbScheduleLauncher 
* @Description: TbSchedule启动器
* @author 汪海霖  wanghl15@midea.com.cn
* @date 2015-3-25 下午3:17:27
 */
@Component
public class TbScheduleLauncher implements InitializingBean{
	
	private static Logger logger = LoggerFactory.getLogger(TbScheduleLauncher.class);
	
	@Value("${schedule.status.flag}")
	private boolean isOpen;
	

	@Override
	public void afterPropertiesSet() throws Exception {
		if(!isOpen){
			logger.warn("schedule系统配置不启动,请确认?");
			return;
		}
		Properties props = new Properties();  
		InputStream inputStream = TbScheduleLauncher.class.getClassLoader()
				.getResourceAsStream("schedule_conf.properties");
		props.load(inputStream); 
		TBScheduleManagerFactory tbscheduleManagerFactory = new TBScheduleManagerFactory();
		tbscheduleManagerFactory.setApplicationContext(AppSpringContext.getApplicationContext());
		tbscheduleManagerFactory.init(props);
		tbscheduleManagerFactory.setZkConfig(convert(props));
		IOUtils.closeStream(inputStream);
		logger.info("schedule启动完成");
	}

	private Map<String,String> convert(Properties props){
		Map<String, String> map = new HashMap<String, String>();
		Enumeration<?> e = props.propertyNames();
		while (e.hasMoreElements()) {
			String key = (String) e.nextElement();
			String value = StringUtils.trimToEmpty(props.getProperty(key));
			map.put(key, value);
		}
		return map;
	}
}
