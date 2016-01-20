package com.midea.cmo2o.wx.impl.utils.httpclient;

import java.io.IOException;

import org.apache.http.HttpHost;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;

/**
 * 简单的GET请求执行器，请求的参数是String, 返回的结果也是String
 * 
 * @author Daniel Qian
 */
public class SimpleGetRequestExecutor implements RequestExecutor<String, String> {

	@Override
	public String execute(CloseableHttpClient httpclient, HttpHost httpProxy, String uri,
			String queryParam) throws ClientProtocolException, IOException {
		if (queryParam != null) {
			if (uri.indexOf('?') == -1) {
				uri += '?';
			}
			uri += uri.endsWith("?") ? queryParam : '&' + queryParam;
		}
		HttpGet httpGet = new HttpGet(uri);
		if (httpProxy != null) {
			RequestConfig config = RequestConfig.custom().setProxy(httpProxy).build();
			httpGet.setConfig(config);
		}

		try {
			CloseableHttpResponse response = httpclient.execute(httpGet);
			String responseContent = Utf8ResponseHandler.INSTANCE.handleResponse(response);
			return responseContent;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

}
