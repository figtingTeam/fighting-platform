package com.midea.cmo2o.wx.impl.controller;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Test;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.ResultHandler;

import com.midea.cmo2o.wx.impl.base.BaseControllerTest;

public class AreaControllerTest extends BaseControllerTest {

	private static String parentCode = "440000";

	@Test
	public void list() throws Exception {

		ResultActions results = mockMvc
				.perform(org.springframework.test.web.servlet.request.MockMvcRequestBuilders
						.get("/area/list").param("parentCode", parentCode))
				.andExpect(status().isOk());
		results.andDo(new ResultHandler() {
			@Override
			public void handle(MvcResult result) throws Exception {
				System.out.println(result.getResponse().getContentAsString());
			}
		});

	}

}