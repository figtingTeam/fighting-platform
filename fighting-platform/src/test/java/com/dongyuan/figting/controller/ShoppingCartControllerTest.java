package com.dongyuan.figting.controller;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.io.UnsupportedEncodingException;

import javax.servlet.ServletContext;
import javax.servlet.http.Cookie;

import com.dongyuan.figting.dto.request.CartAddRequest;
import com.dongyuan.figting.utils.FastJSONHelper;
import org.junit.Test;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.ResultHandler;

import com.dongyuan.figting.base.BaseControllerTest;
import com.dongyuan.figting.dto.request.CartModifyRequest;

/**
 * 类AddressControllerTest.java的实现描述：地址测试类
 * 
 * @author huanghf 2016年1月2日 下午3:55:11
 * @email haifeng1.huang@midea.com
 */
public class ShoppingCartControllerTest extends BaseControllerTest {

	// 根据认筹券ID获取购物车列表
	@Test
	public void list() throws Exception {

		Cookie cookie = new Cookie("cmo2o_wx_mp_token",
				"cmo2o:wx-cache:cmo2o_wx_mp_token_6b5b4a511a714e9d854fa88d0152f1ba");
		Cookie cookie_ = new Cookie("cmo2o_wx_cp_token",
				"cmo2o:wx-cache:cmo2o_wx_cp_token_6b5b4a511a714e9d854fa88d0152f1ba");
		ResultActions results = mockMvc
				.perform(org.springframework.test.web.servlet.request.MockMvcRequestBuilders
						.get("/cart/list").param("ticketId", "1000018153").param("activityId", "1")
						.param("requestFrom", "mp").cookie(cookie).cookie(cookie_))
				.andExpect(status().isOk());
		results.andDo(new ResultHandler() {
			@Override
			public void handle(MvcResult result) throws Exception {
				System.out.println(result.getResponse().getContentAsString());
			}
		});

	}

	// 添加购物车
	@Test
	public void add() throws Exception {

		ResultActions results = mockMvc.perform(new RequestBuilder() {
			@Override
			public MockHttpServletRequest buildRequest(ServletContext servletContext) {

				String params =
						"{\"activityId\":1,\"count\":94,\"productAttr\":2,\"shortCode\":\"120011\",\"ticketId\":\"1000018153\",\"tradeFrom\":\"服务号\"}";
				Cookie cookie = new Cookie("cmo2o_wx_mp_token",
						"cmo2o:wx-cache:cmo2o_wx_mp_token_6b5b4a511a714e9d854fa88d0152f1ba");
				Cookie cookie_ = new Cookie("cmo2o_wx_cp_token",
						"cmo2o:wx-cache:cmo2o_wx_cp_token_6b5b4a511a714e9d854fa88d0152f1ba");
				MockHttpServletRequest request = new MockHttpServletRequest("POST", "/cart/add");
				request.setContentType("application/json");
				request.setCookies(cookie, cookie_);
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

	// 修改购物车数量
	@Test
	public void modify() throws Exception {

		ResultActions results = mockMvc.perform(new RequestBuilder() {
			@Override
			public MockHttpServletRequest buildRequest(ServletContext servletContext) {

				String params =
						"{\"activityId\":1,\"count\":100,\"shoppingCartId\":480,\"ticketId\":\"1000005426\",\"updateTime\":\"2016-01-03 13:16:24\"}";
				Cookie cookie = new Cookie("cmo2o_wx_mp_token",
						"cmo2o:wx-cache:cmo2o_wx_mp_token_6b5b4a511a714e9d854fa88d0152f1ba");
				Cookie cookie_ = new Cookie("cmo2o_wx_cp_token",
						"cmo2o:wx-cache:cmo2o_wx_cp_token_6b5b4a511a714e9d854fa88d0152f1ba");
				MockHttpServletRequest request = new MockHttpServletRequest("POST", "/cart/modify");
				request.setContentType("application/json");
				request.setCookies(cookie, cookie_);
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
				System.out.println(
						"*********************************************\n[request]POST /cart/modify\n[response]:"
								+ result.getResponse().getContentAsString()
								+ "\n*********************************************");
			}
		});

	}

	// 删除购物车
	@Test
	public void delete() throws Exception {

		ResultActions results = mockMvc.perform(new RequestBuilder() {
			@Override
			public MockHttpServletRequest buildRequest(ServletContext servletContext) {

				String params = "{\"shoppingCartId\":142,\"ticketId\":\"1000000359\"}";
				Cookie cookie = new Cookie("cmo2o_wx_mp_token",
						"cmo2o:wx-cache:cmo2o_wx_mp_token_6b5b4a511a714e9d854fa88d0152f1ba");
				Cookie cookie_ = new Cookie("cmo2o_wx_cp_token",
						"cmo2o:wx-cache:cmo2o_wx_cp_token_6b5b4a511a714e9d854fa88d0152f1ba");
				MockHttpServletRequest request = new MockHttpServletRequest("POST", "/cart/delete");
				request.setContentType("application/json");
				request.setCookies(cookie, cookie_);
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
				System.out.println(
						"*********************************************\n[request]POST /cart/delete\n[response]:"
								+ result.getResponse().getContentAsString()
								+ "\n*********************************************");
			}
		});

	}

	public static void main(String[] args) {
		CartAddRequest cart = new CartAddRequest();
		cart.setActivityId(1L);
		cart.setShortCode("120012");
		cart.setTicketId("1000000359");
		cart.setCount((short) 5);
		cart.setProductAttr((byte) 2);
		cart.setSalesmanId(123L);
		cart.setTradeFrom("服务号");
		System.out.println(FastJSONHelper.serialize(cart));

		CartModifyRequest cartModify = new CartModifyRequest();
		cartModify.setTicketId("1000000359");
		cartModify.setShoppingCartId(142L);
		cartModify.setCount((short) 10);
		cartModify.setUpdateTime("2016-01-03 13:16:24");
		System.out.println(FastJSONHelper.serialize(cartModify));
	}
}