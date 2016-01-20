package com.dongyuan.figting.impl.controller;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import javax.servlet.http.Cookie;

import com.dongyuan.figting.impl.base.BaseControllerTest;
import org.junit.Test;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.ResultHandler;

public class OrderControllerTest extends BaseControllerTest {

	@Test
	public void list() throws Exception {

		Cookie cookie = new Cookie("cmo2o_wx_mp_token",
				"cmo2o:wx-cache:cmo2o_wx_mp_token_6b5b4a511a714e9d854fa88d0152f1ba");
		Cookie cookie_ = new Cookie("cmo2o_wx_cp_token",
				"cmo2o:wx-cache:cmo2o_wx_cp_token_6b5b4a511a714e9d854fa88d0152f1ba");

		ResultActions results = mockMvc
				.perform(org.springframework.test.web.servlet.request.MockMvcRequestBuilders
						.get("/order/list").param("ticketId", "1000000753")
						.param("requestFrom", "mp").cookie(cookie).cookie(cookie_))
				.andExpect(status().isOk());
		results.andDo(new ResultHandler() {
			@Override
			public void handle(MvcResult result) throws Exception {
				System.out.println(
						"*********************************************\n[request]GET /order/list\n[response]:"
								+ result.getResponse().getContentAsString()
								+ "\n*********************************************");
			}
		});

	}

}