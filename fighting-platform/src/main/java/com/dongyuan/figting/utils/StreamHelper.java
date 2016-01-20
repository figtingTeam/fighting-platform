package com.dongyuan.figting.utils;

import java.io.InputStream;
import java.util.Enumeration;
import java.util.HashSet;
import java.util.Properties;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class StreamHelper {

	private static final Logger logger = LoggerFactory.getLogger(StreamHelper.class);
	
	/**
	 * 从当前环境或者当前线程下加载资源
	 * 
	 * @param resourceName 资源的名称
	 * @return 资源的流
	 */
	public static Properties getStreamFromClasspath(String resourceName) {
		InputStream stream = null;
		Properties p = new Properties();
		try {
			ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
			stream = classLoader.getResourceAsStream(resourceName);

			if (stream == null) {
				stream = StreamHelper.class.getClassLoader().getResourceAsStream(resourceName);
			}

			if (stream == null) {
				throw new Exception("resource " + resourceName + " does not exist");
			}
			p.load(stream);
			logger.info("加载资源文件成功:{}",resourceName);
			
		} catch (SecurityException  e) {
			logger.error("未能获取上下文的ClassLoader",e);
		} catch (Exception e) {
			logger.error("加载资源文件成功:{}",resourceName,e);
		}
		return p;
	}
	
	public static HashSet<String> vToSet(Properties p) {
		HashSet<String> rerurnSet = new HashSet<String>();
		for(Enumeration<?> e = p.propertyNames(); e.hasMoreElements();){
			String key=(String) e.nextElement();
			/*rerurnSet.add(p.getProperty(key));  */
			rerurnSet.add(key);
		} 
		return rerurnSet;
	}
}
