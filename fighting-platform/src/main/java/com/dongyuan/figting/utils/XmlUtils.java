package com.dongyuan.figting.utils;

import org.apache.commons.lang.StringUtils;

import com.thoughtworks.xstream.XStream;

public class XmlUtils {
	
	private static XStream xstream = new XStream();

	public static Object xml2Object(String inputXml, Class<?>[] types)
			throws Exception {
		if (StringUtils.isBlank(inputXml)) {
			return null;
		}
		xstream.processAnnotations(types);
		return xstream.fromXML(inputXml);
	}

	public static String object2Xml(Object ro, Class<?>[] types)
			throws Exception {
		if (null == ro) {
			return null;
		}
		xstream.processAnnotations(types);
		return xstream.toXML(ro);
	}
	
}
