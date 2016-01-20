package com.dongyuan.figting.service;

import org.junit.Before;
import org.springframework.beans.factory.annotation.Autowired;

import me.chanjar.weixin.mp.api.WxMpService;

public class MenuServiceImplTest extends BaseServiceTest {

	@Autowired
	private WxMpService mpService;

	@Before
	public void init() {
		String redirectUrl = "http://ec.midea.com/midea-weixin/serviceHelper/reserve.htm";
		String url = mpService.oauth2buildAuthorizationUrl(redirectUrl, "snsapi_base", "ABC001");
		System.out.println(url);
	}

}
