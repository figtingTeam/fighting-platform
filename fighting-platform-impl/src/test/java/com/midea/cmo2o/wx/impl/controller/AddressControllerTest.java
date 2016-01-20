package com.midea.cmo2o.wx.impl.controller;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.io.UnsupportedEncodingException;

import javax.servlet.ServletContext;
import javax.servlet.http.Cookie;

import org.junit.Test;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.ResultHandler;

import com.midea.cmo2o.wx.impl.base.BaseControllerTest;
import com.midea.cmo2o.wx.impl.dto.request.AddressRequest;
import com.midea.cmo2o.wx.impl.utils.FastJSONHelper;

/**
 * 类AddressControllerTest.java的实现描述：地址测试类
 * 
 * @author huanghf 2016年1月2日 下午3:55:11
 * @email haifeng1.huang@midea.com
 */
public class AddressControllerTest extends BaseControllerTest {

	// 根据认筹券ID获取地址列表
	@Test
	public void list() throws Exception {

		Cookie cookie = new Cookie("cmo2o_wx_mp_token",
				"cmo2o:wx-cache:cmo2o_wx_mp_token_6b5b4a511a714e9d854fa88d0152f1ba");
		Cookie cookie_ = new Cookie("cmo2o_wx_cp_token",
				"cmo2o:wx-cache:cmo2o_wx_cp_token_6b5b4a511a714e9d854fa88d0152f1ba");
		ResultActions results = mockMvc
				.perform(org.springframework.test.web.servlet.request.MockMvcRequestBuilders
						.get("/address/list").param("ticketId", "1000000359")
						.param("requestFrom", "cp").cookie(cookie).cookie(cookie_))
				.andExpect(status().isOk());
		results.andDo(new ResultHandler() {
			@Override
			public void handle(MvcResult result) throws Exception {
				System.out.println(result.getResponse().getContentAsString());
			}
		});

	}

	// 增加收货地址
	@Test
	public void add() throws Exception {

		ResultActions results = mockMvc.perform(new RequestBuilder() {
			@Override
			public MockHttpServletRequest buildRequest(ServletContext servletContext) {

				String params =
						"{\"address\":\"北滘美的海岸花园\",\"city\":571,\"cityName\":\"佛山市\",\"district\":0,\"districtName\":\"\",\"name\":\"黄海枫\",\"phone\":\"13951657704\",\"province\":440000,\"provinceName\":\"广东省\",\"ticketId\":\"1000000359\"}";
				Cookie cookie = new Cookie("cmo2o_wx_mp_token",
						"cmo2o:wx-cache:cmo2o_wx_mp_token_6b5b4a511a714e9d854fa88d0152f1ba");
				Cookie cookie_ = new Cookie("cmo2o_wx_cp_token",
						"cmo2o:wx-cache:cmo2o_wx_cp_token_6b5b4a511a714e9d854fa88d0152f1ba");
				MockHttpServletRequest request = new MockHttpServletRequest("POST", "/address/add");
				request.setContentType("application/json");
				request.setCookies(new Cookie[] { cookie, cookie_ });
				request.addParameter("requestFrom", "mp");
				try {
					request.setContent(params.getBytes("UTF-8"));
				} catch (UnsupportedEncodingException e) {
					e.printStackTrace();
				}
				return request;
			}
		});
		results.andDo(new ResultHandler() {
			@Override
			public void handle(MvcResult result) throws Exception {
				System.out.println(result.getResponse().getContentAsString());
			}
		});

	}

	// 增加收货地址
	@Test
	public void modify() throws Exception {

		ResultActions results = mockMvc.perform(new RequestBuilder() {
			@Override
			public MockHttpServletRequest buildRequest(ServletContext servletContext) {

				String params =
						"{\"id\":34,\"address\":\"北滘美的海岸花园大学生公寓公寓\",\"city\":571,\"cityName\":\"佛山市\",\"district\":7511,\"districtName\":\"顺德区\",\"name\":\"黄海枫\",\"phone\":\"13951657704\",\"province\":440000,\"provinceName\":\"广东省\"}";
				Cookie cookie = new Cookie("cmo2o_wx_mp_token",
						"cmo2o:wx-cache:cmo2o_wx_mp_token_6b5b4a511a714e9d854fa88d0152f1ba");
				Cookie cookie_ = new Cookie("cmo2o_wx_cp_token",
						"cmo2o:wx-cache:cmo2o_wx_cp_token_6b5b4a511a714e9d854fa88d0152f1ba");
				MockHttpServletRequest request =
						new MockHttpServletRequest("POST", "/address/modify");
				request.setContentType("application/json");
				request.setCookies(new Cookie[] { cookie, cookie_ });
				request.addParameter("requestFrom", "mp");
				try {
					request.setContent(params.getBytes("UTF-8"));
				} catch (UnsupportedEncodingException e) {
					e.printStackTrace();
				}
				return request;
			}
		});
		results.andDo(new ResultHandler() {
			@Override
			public void handle(MvcResult result) throws Exception {
				System.out.println(result.getResponse().getContentAsString());
			}
		});

	}

	// 删除地址
	@Test
	public void delete() throws Exception {

		Cookie cookie = new Cookie("cmo2o_wx_mp_token",
				"cmo2o:wx-cache:cmo2o_wx_mp_token_6b5b4a511a714e9d854fa88d0152f1ba");
		Cookie cookie_ = new Cookie("cmo2o_wx_cp_token",
				"cmo2o:wx-cache:cmo2o_wx_cp_token_6b5b4a511a714e9d854fa88d0152f1ba");
		ResultActions results =
				mockMvc.perform(org.springframework.test.web.servlet.request.MockMvcRequestBuilders
						.post("/address/delete").param("id", "36").param("requestFrom", "mp")
						.cookie(cookie).cookie(cookie_)).andExpect(status().isOk());
		results.andDo(new ResultHandler() {
			@Override
			public void handle(MvcResult result) throws Exception {
				System.out.println(result.getResponse().getContentAsString());
			}
		});

	}

	public static void main(String[] args) {
		AddressRequest addressRequest = new AddressRequest();
		addressRequest.setAddress("北滘美的海岸花园");
		addressRequest.setCity(571);
		addressRequest.setCityName("佛山市");
		addressRequest.setDistrict(7511);
		addressRequest.setDistrictName("顺德区");
		addressRequest.setName("黄海枫");
		addressRequest.setPhone("13951657704");
		addressRequest.setProvince(440000);
		addressRequest.setProvinceName("广东省");
		addressRequest.setTicketId("1000002318");
		System.out.println(FastJSONHelper.serialize(addressRequest));
	}
}