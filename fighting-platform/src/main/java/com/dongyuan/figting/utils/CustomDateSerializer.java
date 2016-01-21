package com.dongyuan.figting.utils;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.dongyuan.figting.Constants;
import org.codehaus.jackson.JsonGenerator;
import org.codehaus.jackson.JsonProcessingException;
import org.codehaus.jackson.map.JsonSerializer;
import org.codehaus.jackson.map.SerializerProvider;

/**
 * 自定义返回JSON 数据格中日期格式化处理
 *
 * @author <a href="http://www.micmiu.com">Michael Sun</a>
 */
public class CustomDateSerializer extends JsonSerializer<Date> {
	@Override
	public void serialize(Date value, JsonGenerator jgen,
			SerializerProvider provider) throws IOException,
			JsonProcessingException {
		SimpleDateFormat formatter = new SimpleDateFormat(Constants.FORMAT_STR_DATETIME);
		String formattedDate = formatter.format(value);
		jgen.writeString(formattedDate);
	}

}