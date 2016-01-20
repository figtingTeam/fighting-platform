package com.midea.cmo2o.wx.impl.utils.httpclient;

import java.io.IOException;

import org.apache.http.Consts;
import org.apache.http.HttpHost;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpResponseException;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;

/**
 * 简单的POST请求执行器，请求的参数是String, 返回的结果也是String
 * @author Daniel Qian
 *
 */
public class SimplePostRequestExecutor implements RequestExecutor<String, String> {

	@Override
	public String execute(CloseableHttpClient httpclient, HttpHost httpProxy, String uri,
			String postEntity) throws HttpResponseException, ClientProtocolException, IOException {
		HttpPost httpPost = new HttpPost(uri);
		httpPost.setHeader("Content-Type", "application/json");
		if (httpProxy != null) {
			RequestConfig config = RequestConfig.custom().setProxy(httpProxy).build();
			httpPost.setConfig(config);
		}

		if (postEntity != null) {
			StringEntity entity = new StringEntity(postEntity, Consts.UTF_8);
			httpPost.setEntity(entity);
		}
		CloseableHttpResponse response = httpclient.execute(httpPost);
		String responseContent = Utf8ResponseHandler.INSTANCE.handleResponse(response);
		return responseContent;
	}

}
