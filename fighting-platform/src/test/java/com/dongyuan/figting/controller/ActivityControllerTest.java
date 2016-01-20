package com.dongyuan.figting.controller;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import javax.servlet.ServletContext;
import javax.servlet.http.Cookie;

import com.dongyuan.figting.base.BaseControllerTest;
import org.junit.Test;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.ResultHandler;

/**
 * 类AddressControllerTest.java的实现描述：活动测试类
 * 
 * @author huanghf 2016年1月2日 下午3:55:11
 * @email haifeng1.huang@midea.com
 */
public class ActivityControllerTest extends BaseControllerTest {

	// 活动首页
	@Test
	public void info() throws Exception {

		Cookie cookie = new Cookie("cmo2o_wx_mp_token",
				"cmo2o:wx-cache:cmo2o_wx_mp_token_6b5b4a511a714e9d854fa88d0152f1ba");
		Cookie cookie_ = new Cookie("cmo2o_wx_cp_token",
				"cmo2o:wx-cache:cmo2o_wx_cp_token_6b5b4a511a714e9d854fa88d0152f1ba");
		ResultActions results = mockMvc
				.perform(org.springframework.test.web.servlet.request.MockMvcRequestBuilders
						.get("/activity/info").param("ticketId", "1000018153").param("activityId", "1")
						.param("requestFrom", "mp").cookie(cookie).cookie(cookie_))
				.andExpect(status().isOk());
		results.andDo(new ResultHandler() {
			@Override
			public void handle(MvcResult result) throws Exception {
				System.out.println(
						"*********************************************\n[request]GET /activity/info\n[response]:"
								+ result.getResponse().getContentAsString()
								+ "\n*********************************************");
			}
		});

	}

	// 获取导购参与的活动列表
	@Test
	public void list() throws Exception {

		ResultActions results = mockMvc.perform(new RequestBuilder() {
			@Override
			public MockHttpServletRequest buildRequest(ServletContext servletContext) {

				Cookie cookie = new Cookie("cmo2o_wx_mp_token",
						"cmo2o:wx-cache:cmo2o_wx_mp_token_6b5b4a511a714e9d854fa88d0152f1ba");
				Cookie cookie_ = new Cookie("cmo2o_wx_cp_token",
						"cmo2o:wx-cache:cmo2o_wx_cp_token_6b5b4a511a714e9d854fa88d0152f1ba");
				MockHttpServletRequest request =
						new MockHttpServletRequest("GET", "/activity/list");
				request.setContentType("application/json");
				request.setCookies(cookie, cookie_);
				request.addParameter("requestFrom", "cp");
				return request;
			}
		});
		results.andDo(new ResultHandler() {
			@Override
			public void handle(MvcResult result) throws Exception {
				System.out.println(
						"*********************************************\n[request]GET /activity/list\n[response]:"
								+ result.getResponse().getContentAsString()
								+ "\n*********************************************");
			}
		});

	}

}