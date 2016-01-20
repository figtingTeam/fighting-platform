package com.dongyuan.figting.impl.controller;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import javax.servlet.http.Cookie;

import com.dongyuan.figting.impl.base.BaseControllerTest;
import org.junit.Test;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.ResultHandler;

/**
 * 类ProductControllerTest.java的实现描述：商品控制器测试类
 * 
 * @author huanghf 2016年1月2日 下午6:31:19
 * @email haifeng1.huang@midea.com
 */
public class ProductControllerTest extends BaseControllerTest {

	//根据商品断码、活动ID获取商品信息
	@Test
	public void info() throws Exception {
		Cookie cookie = new Cookie("cmo2o_wx_mp_token",
				"cmo2o:wx-cache:cmo2o_wx_mp_token_6b5b4a511a714e9d854fa88d0152f1ba");
		String shortCode = "120012";
		String activityId = "1";
		ResultActions results =
				mockMvc.perform(org.springframework.test.web.servlet.request.MockMvcRequestBuilders
						.get("/product/info").param("shortCode", shortCode)
						.param("activityId", activityId).cookie(cookie)).andExpect(status().isOk());
		results.andDo(new ResultHandler() {
			@Override
			public void handle(MvcResult result) throws Exception {
				System.out.println(result.getResponse().getContentAsString());
			}
		});

	}

}