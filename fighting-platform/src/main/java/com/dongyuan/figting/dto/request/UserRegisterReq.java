package com.dongyuan.figting.dto.request;

import com.dongyuan.figting.dto.BaseRequest;
import org.hibernate.validator.constraints.NotEmpty;

/**
 * 描述： 用户注册请求信息
 *
 * @author huanghf
 * @email haifeng1.huang@midea.com
 * @date 2016年01月21日 10:17
 * @copyright 美的电子商务有限公司
 */
public class UserRegisterReq extends BaseRequest{

	@NotEmpty(message = "昵称不能为空")
	private String nickName;

	@NotEmpty(message = "手机号码不能为空")
	private String phone;

	@NotEmpty(message = "密码不能为空")
	private String password;

	public String getNickName() {
		return nickName;
	}

	public String getPhone() {
		return phone;
	}

	public String getPassword() {
		return password;
	}

	public void setNickName(String nickName) {
		this.nickName = nickName;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public void setPassword(String password) {
		this.password = password;
	}
}
