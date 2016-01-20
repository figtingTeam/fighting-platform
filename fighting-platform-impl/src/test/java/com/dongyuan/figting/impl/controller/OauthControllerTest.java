package com.dongyuan.figting.impl.controller;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Test;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.ResultHandler;

import com.dongyuan.figting.impl.base.BaseControllerTest;
import com.dongyuan.figting.impl.dto.request.TicketActivateRequest;
import com.dongyuan.figting.impl.utils.FastJSONHelper;

/**
 * 类TicketControllerTest.java的实现描述：认筹券测试类
 * 
 * @author huanghf 2016年1月2日 下午3:55:11
 * @email haifeng1.huang@midea.com
 */
public class OauthControllerTest extends BaseControllerTest {

	// 根据openid获取认筹券列表
	@Test
	public void authorize() throws Exception {

		ResultActions results = mockMvc
				.perform(org.springframework.test.web.servlet.request.MockMvcRequestBuilders
						.get("/authorize").param("requestFrom", "cp").param("code", "000000000000"))
				.andExpect(status().isOk());
		results.andDo(new ResultHandler() {
			@Override
			public void handle(MvcResult result) throws Exception {
				System.out.println(
						"*********************************************\n[request]GET /authorize\n[response]:"
								+ result.getResponse().getContentAsString()
								+ "\n*********************************************");
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