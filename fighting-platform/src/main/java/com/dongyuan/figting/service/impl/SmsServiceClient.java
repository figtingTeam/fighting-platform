package com.dongyuan.figting.service.impl;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import com.dongyuan.figting.utils.StringUtil;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import ytx.org.apache.http.HttpEntity;
import ytx.org.apache.http.HttpResponse;
import ytx.org.apache.http.client.methods.HttpGet;
import ytx.org.apache.http.client.methods.HttpPost;
import ytx.org.apache.http.client.methods.HttpRequestBase;
import ytx.org.apache.http.entity.BasicHttpEntity;
import ytx.org.apache.http.impl.client.DefaultHttpClient;
import ytx.org.apache.http.message.AbstractHttpMessage;
import ytx.org.apache.http.util.EntityUtils;

import com.cloopen.rest.sdk.utils.CcopHttpClient;
import com.cloopen.rest.sdk.utils.DateUtil;
import com.cloopen.rest.sdk.utils.EncryptUtil;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

/**
 * 描述： 云通讯-短信发送服务
 *
 * @author huanghf
 * @email haifeng1.huang@midea.com
 * @date 2016年01月21日 13:49
 * @copyright 美的电子商务有限公司
 */
@Service("smsServiceClient")
public class SmsServiceClient {

	private static Logger LOGGER = LoggerFactory.getLogger(SmsServiceClient.class);

	private static final int Request_Get = 0;
	private static final int Request_Post = 1;
	private static final String TemplateSMS = "SMS/TemplateSMS";

	@Value("${sms_server_ip}")
	private String serverIp;
	@Value("${sms_server_port}")
	private String serverPort;
	@Value("${sms_account_sid}")
	private String accountSid;
	@Value("${sms_account_token}")
	private String accountToken;
	@Value("${sms_app_id}")
	public String appId;

	/**
	 * 发送短信模板请求
	 *
	 * @param to         必选参数 短信接收端手机号码集合，用英文逗号分开，每批发送的手机号数量不得超过100个
	 * @param templateId 必选参数 模板Id
	 * @param datas      可选参数 内容数据，用于替换模板中{序号}
	 * @return
	 */
	public HashMap<String, Object> sendTemplateSMS(String to, String templateId, String[] datas) {
		if (StringUtil.isBlank(to) || StringUtil.isBlank(appId) || StringUtil.isBlank(templateId))
			throw new IllegalArgumentException("必选参数:" + (StringUtil.isBlank(to) ? " 手机号码 " : "") + (StringUtil.isBlank(templateId) ? " 模板Id " : "") + "为空");
		CcopHttpClient chc = new CcopHttpClient();
		DefaultHttpClient httpclient;
		try {
			httpclient = chc.registerSSL(serverIp, "TLS", Integer.parseInt(serverPort), "https");
		} catch (Exception e1) {
			throw new RuntimeException("初始化httpclient异常" + e1.getMessage());
		}
		String result = "";
		try {
			HttpPost httppost = (HttpPost) getHttpRequestBase(1, TemplateSMS);
			String requsetbody;
			JsonObject json = new JsonObject();
			json.addProperty("appId", appId);
			json.addProperty("to", to);
			json.addProperty("templateId", templateId);
			if (datas != null) {
				StringBuilder sb = new StringBuilder("[");
				for (String s : datas) {
					sb.append("\"" + s + "\"" + ",");
				}
				sb.replace(sb.length() - 1, sb.length(), "]");
				JsonParser parser = new JsonParser();
				JsonArray Jarray = parser.parse(sb.toString()).getAsJsonArray();
				json.add("datas", Jarray);
			}
			requsetbody = json.toString();
			LOGGER.info("sendTemplateSMS Request body = {}", requsetbody);
			BasicHttpEntity requestBody = new BasicHttpEntity();
			requestBody.setContent(new ByteArrayInputStream(requsetbody.getBytes("UTF-8")));
			requestBody.setContentLength(requsetbody.getBytes("UTF-8").length);
			httppost.setEntity(requestBody);
			HttpResponse response = httpclient.execute(httppost);
			HttpEntity entity = response.getEntity();
			if (entity != null)
				result = EntityUtils.toString(entity, "UTF-8");
			EntityUtils.consume(entity);
		} catch (IOException e) {
			LOGGER.error("网络错误", e.getMessage());
			return getMyError("172001", "网络错误");
		} catch (Exception e) {
			LOGGER.error("无返回", e.getMessage());
			return getMyError("172002", "无返回");
		} finally {
			if (httpclient != null)
				httpclient.getConnectionManager().shutdown();
		}
		LOGGER.info("sendTemplateSMS response body = {}", result);
		try {
			return jsonToMap(result);
		} catch (Exception e) {
			return getMyError("172003", "返回包体错误");
		}
	}

	private HashMap<String, Object> jsonToMap(String result) {
		HashMap<String, Object> hashMap = new HashMap<String, Object>();
		JsonParser parser = new JsonParser();
		JsonObject asJsonObject = parser.parse(result).getAsJsonObject();
		Set<Entry<String, JsonElement>> entrySet = asJsonObject.entrySet();
		HashMap<String, Object> hashMap2 = new HashMap<String, Object>();

		for (Map.Entry<String, JsonElement> m : entrySet) {
			if ("statusCode".equals(m.getKey()) || "statusMsg".equals(m.getKey()))
				hashMap.put(m.getKey(), m.getValue().getAsString());
			else {
				if ("SubAccount".equals(m.getKey()) || "totalCount".equals(m.getKey())
						|| "token".equals(m.getKey()) || "downUrl".equals(m.getKey())) {
					if (!"SubAccount".equals(m.getKey()))
						hashMap2.put(m.getKey(), m.getValue().getAsString());
					else {
						try {
							if ((m.getValue().toString().trim().length() <= 2) && !m.getValue().toString().contains("[")) {
								hashMap2.put(m.getKey(), m.getValue().getAsString());
								hashMap.put("data", hashMap2);
								break;
							}
							if (m.getValue().toString().contains("[]")) {
								hashMap2.put(m.getKey(), new JsonArray());
								hashMap.put("data", hashMap2);
								continue;
							}
							JsonArray asJsonArray = parser.parse(m.getValue().toString()).getAsJsonArray();
							ArrayList<HashMap<String, Object>> arrayList = new ArrayList<HashMap<String, Object>>();
							for (JsonElement j : asJsonArray) {
								Set<Entry<String, JsonElement>> entrySet2 = j.getAsJsonObject().entrySet();
								HashMap<String, Object> hashMap3 = new HashMap<String, Object>();
								for (Map.Entry<String, JsonElement> m2 : entrySet2) {
									hashMap3.put(m2.getKey(), m2.getValue().getAsString());
								}
								arrayList.add(hashMap3);
							}
							hashMap2.put("SubAccount", arrayList);
						} catch (Exception e) {
							JsonObject asJsonObject2 = parser.parse(m.getValue().toString()).getAsJsonObject();
							Set<Entry<String, JsonElement>> entrySet2 = asJsonObject2.entrySet();
							HashMap<String, Object> hashMap3 = new HashMap<String, Object>();
							for (Map.Entry<String, JsonElement> m2 : entrySet2) {
								hashMap3.put(m2.getKey(), m2.getValue().getAsString());
							}
							hashMap2.put(m.getKey(), hashMap3);
							hashMap.put("data", hashMap2);
						}

					}
					hashMap.put("data", hashMap2);
				} else {

					JsonObject asJsonObject2 = parser.parse(m.getValue().toString()).getAsJsonObject();
					Set<Entry<String, JsonElement>> entrySet2 = asJsonObject2.entrySet();
					HashMap<String, Object> hashMap3 = new HashMap<String, Object>();
					for (Map.Entry<String, JsonElement> m2 : entrySet2) {
						hashMap3.put(m2.getKey(), m2.getValue().getAsString());
					}
					if (hashMap3.size() != 0) {
						hashMap2.put(m.getKey(), hashMap3);
					} else {
						hashMap2.put(m.getKey(), m.getValue().getAsString());
					}
					hashMap.put("data", hashMap2);
				}
			}
		}
		return hashMap;
	}

	private HttpRequestBase getHttpRequestBase(int get, String action) throws NoSuchAlgorithmException, UnsupportedEncodingException {
		String timestamp = DateUtil.dateToStr(new Date(), DateUtil.DATE_TIME_NO_SLASH);
		EncryptUtil eu = new EncryptUtil();
		String sig;
		String acountName;
		String acountType = "Accounts";

		acountName = accountSid;
		sig = accountSid + accountToken + timestamp;
		String signature = eu.md5Digest(sig);

		String url = getBaseUrl().append("/" + acountType + "/").append(acountName).append("/" + action + "?sig=").append(signature).toString();
		LOGGER.info(getmethodName(action) + " url = " + url);
		HttpRequestBase mHttpRequestBase = null;
		if (get == Request_Get)
			mHttpRequestBase = new HttpGet(url);
		else if (get == Request_Post)
			mHttpRequestBase = new HttpPost(url);

		setHttpHeader(mHttpRequestBase);
		String src = acountName + ":" + timestamp;
		String auth = eu.base64Encoder(src);
		mHttpRequestBase.setHeader("Authorization", auth);
		return mHttpRequestBase;
	}


	private String getmethodName(String action) {
		if (action.equals(TemplateSMS)) {
			return "sendTemplateSMS";
		} else {
			return "";
		}
	}

	private void setHttpHeader(AbstractHttpMessage httpMessage) {
		httpMessage.setHeader("Accept", "application/json");
		httpMessage.setHeader("Content-Type", "application/json;charset=utf-8");
	}

	private StringBuffer getBaseUrl() {
		StringBuffer sb = new StringBuffer("https://");
		sb.append(serverIp).append(":").append(serverPort);
		sb.append("/2013-12-26");
		return sb;
	}

	private HashMap<String, Object> getMyError(String code, String msg) {
		HashMap<String, Object> hashMap = new HashMap<String, Object>();
		hashMap.put("statusCode", code);
		hashMap.put("statusMsg", msg);
		return hashMap;
	}

}
