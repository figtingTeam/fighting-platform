package com.dongyuan.figting.service.impl;

import com.dongyuan.figting.code.BaseApiCode;
import com.dongyuan.figting.dao.FUserMapper;
import com.dongyuan.figting.dto.request.UserRegisterReq;
import com.dongyuan.figting.entity.FUser;
import com.dongyuan.figting.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * 描述： 用户信息业务实现层
 *
 * @author huanghf
 * @email haifeng1.huang@midea.com
 * @date 2016年01月21日 10:22
 * @copyright 美的电子商务有限公司
 */
@Service("userService")
public class UserServiceImpl implements UserService {

	@Autowired
	private FUserMapper fUserMapper;

	@Override
	public String register(UserRegisterReq userRegisterReq) {
		FUser fUser = new FUser();
		fUser.setNickname(userRegisterReq.getNickName());
		fUser.setPhone(userRegisterReq.getPhone());
		fUser.setPassword(userRegisterReq.getPassword());
		fUser.setEnabled(Boolean.TRUE);
		fUser.setCreatetime(new Date());
		int i = fUserMapper.insert(fUser);
		if (i == 1) {
			return BaseApiCode.OPERATE_SUCCESS;
		}
		return null;
	}
}
