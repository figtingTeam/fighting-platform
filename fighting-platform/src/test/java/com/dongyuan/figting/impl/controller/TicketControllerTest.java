package com.dongyuan.figting.impl.controller;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.io.UnsupportedEncodingException;

import javax.servlet.ServletContext;
import javax.servlet.http.Cookie;

import com.dongyuan.figting.impl.base.BaseControllerTest;
import com.dongyuan.figting.impl.dto.request.TicketActivateRequest;
import com.dongyuan.figting.impl.utils.FastJSONHelper;
import org.junit.Test;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.ResultHandler;

/**
 * 类TicketControllerTest.java的实现描述：认筹券测试类
 * 
 * @author huanghf 2016年1月2日 下午3:55:11
 * @email haifeng1.huang@midea.com
 */
public class TicketControllerTest extends BaseControllerTest {

	// 根据openid获取认筹券列表
	@Test
	public void list() throws Exception {

		Cookie cookie = new Cookie("cmo2o_wx_mp_token",
				"cmo2o:wx-cache:cmo2o_wx_mp_token_6b5b4a511a714e9d854fa88d0152f1ba");
		ResultActions results = mockMvc
				.perform(org.springframework.test.web.servlet.request.MockMvcRequestBuilders
						.get("/ticket/list").param("requestFrom", "mp").cookie(cookie))
				.andExpect(status().isOk());
		results.andDo(new ResultHandler() {
			@Override
			public void handle(MvcResult result) throws Exception {
				System.out.println(
						"*********************************************\n[request]GET /ticket/list\n[response]:"
								+ result.getResponse().getContentAsString()
								+ "\n*********************************************");
			}
		});

	}

	// 校验认筹券
	@Test
	public void check() throws Exception {

		Cookie cookie = new Cookie("cmo2o_wx_mp_token",
				"cmo2o:wx-cache:cmo2o_wx_mp_token_6b5b4a511a714e9d854fa88d0152f1ba");
		ResultActions results =
				mockMvc.perform(org.springframework.test.web.servlet.request.MockMvcRequestBuilders
						.get("/ticket/check").param("ticketId", "3100199907")
						.param("requestFrom", "mp").cookie(cookie)).andExpect(status().isOk());
		results.andDo(new ResultHandler() {
			@Override
			public void handle(MvcResult result) throws Exception {
				System.out.println(
						"*********************************************\n[request]GET /ticket/check\n[response]:"
								+ result.getResponse().getContentAsString()
								+ "\n*********************************************");
			}
		});

	}

	// 获取短信验证码
	@Test
	public void smsCaptcha() throws Exception {

		Cookie cookie = new Cookie("cmo2o_wx_mp_token",
				"cmo2o:wx-cache:cmo2o_wx_mp_token_6b5b4a511a714e9d854fa88d0152f1ba");
		ResultActions results =
				mockMvc.perform(org.springframework.test.web.servlet.request.MockMvcRequestBuilders
						.get("/ticket/smsCaptcha").param("mobile", "13951657704")
						.param("requestFrom", "mp").cookie(cookie)).andExpect(status().isOk());
		results.andDo(new ResultHandler() {
			@Override
			public void handle(MvcResult result) throws Exception {
				System.out.println(result.getResponse().getContentAsString());
			}
		});

	}

	// 绑定认筹券
	@Test
	public void bind() throws Exception {

		ResultActions results = mockMvc.perform(new RequestBuilder() {
			@Override
			public MockHttpServletRequest buildRequest(ServletContext servletContext) {

				String params =
						"{\"ticketId\":\"1000000359\",\"captcha\":\"722981\",\"mobile\":\"13951657704\"}";
				Cookie cookie = new Cookie("cmo2o_wx_mp_token",
						"cmo2o:wx-cache:cmo2o_wx_mp_token_6b5b4a511a714e9d854fa88d0152f1ba");
				MockHttpServletRequest request = new MockHttpServletRequest("POST", "/ticket/bind");
				request.setContentType("application/json");
				request.setCookies(cookie);
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

	// 激活认筹券
	@Test
	public void activate() throws Exception {

		ResultActions results = mockMvc.perform(new RequestBuilder() {
			@Override
			public MockHttpServletRequest buildRequest(ServletContext servletContext) {

				String params =
						"{\"activateType\":-1,\"activityId\":1,\"address\":\"广东省佛山市顺德区北滘镇美的海岸花园\",\"captcha\":\"992835\",\"city\":571,\"cityName\":\"佛山市\",\"district\":7511,\"districtName\":\"顺德区\",\"mobile\":\"13951657704\",\"name\":\"黄海枫\",\"province\":440000,\"provinceName\":\"广东省\",\"ticketId\":\"1000100191\"}";
				Cookie cookie = new Cookie("cmo2o_wx_mp_token",
						"cmo2o:wx-cache:cmo2o_wx_mp_token_6b5b4a511a714e9d854fa88d0152f1ba");
				MockHttpServletRequest request =
						new MockHttpServletRequest("POST", "/ticket/activate");
				request.setContentType("application/json");
				request.setCookies(cookie);
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

	// 根据认筹券号或手机号查认筹券信息
	@Test
	public void query() throws Exception {

		Cookie cookie_ = new Cookie("cmo2o_wx_cp_token",
				"cmo2o:wx-cache:cmo2o_wx_cp_token_6b5b4a511a714e9d854fa88d0152f1ba");
		ResultActions results = mockMvc
				.perform(org.springframework.test.web.servlet.request.MockMvcRequestBuilders
						.get("/ticket/query").param("requestFrom", "cp").param("activityId", "1")
						.param("mobile", "13951657704").cookie(cookie_))
				.andExpect(status().isOk());
		results.andDo(new ResultHandler() {
			@Override
			public void handle(MvcResult result) throws Exception {
				System.out.println(result.getResponse().getContentAsString());
			}
		});

	}

	public static void main(String[] args) {
		TicketActivateRequest ticket = new TicketActivateRequest();
		ticket.setActivateType(-1);
		ticket.setActivityId(1L);
		ticket.setAddress("广东省佛山市顺德区北滘镇美的海岸花园");
		ticket.setCaptcha("1111");
		ticket.setCity(571);
		ticket.setCityName("佛山市");
		ticket.setDistrict(7511);
		ticket.setDistrictName("顺德区");
		ticket.setMobile("13951657704");
		ticket.setName("黄海枫");
		ticket.setProvince(440000);
		ticket.setProvinceName("广东省");
		ticket.setTicketId("1000000359");
		System.out.println(FastJSONHelper.serialize(ticket));
	}
}