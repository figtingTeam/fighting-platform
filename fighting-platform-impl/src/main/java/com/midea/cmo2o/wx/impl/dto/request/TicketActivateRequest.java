package com.midea.cmo2o.wx.impl.dto.request;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.NotEmpty;

public class TicketActivateRequest extends WxUserRequest {

	@NotBlank(message = "认筹券号不能为空")
	private String ticketId;

	@NotNull(message = "活动ID不能为空")
	private Long activityId;

	@NotBlank(message = "用户姓名不能为空")
	private String name;

	@NotBlank(message = "手机不能为空")
	private String mobile;

	@NotNull(message = "省级编码不能为空")
	private Integer province;

	@NotBlank(message = "省名不能为空")
	private String provinceName;

	@NotNull(message = "市级编码不能为空")
	private Integer city;

	@NotBlank(message = "市名不能为空")
	private String cityName;

	private Integer district;

	private String districtName;

	@NotBlank(message = "详细地址不能为空")
	private String address;

	@NotEmpty(message = "验证码不能为空")
	private String captcha;

	@NotNull(message = "激活方式不能为空")
	private Integer activateType;

	public String getCaptcha() {
		return captcha;
	}

	public void setCaptcha(String captcha) {
		this.captcha = captcha;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getTicketId() {
		return ticketId;
	}

	public void setTicketId(String ticketId) {
		this.ticketId = ticketId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getProvince() {
		return province;
	}

	public void setProvince(Integer province) {
		this.province = province;
	}

	public String getProvinceName() {
		return provinceName;
	}

	public void setProvinceName(String provinceName) {
		this.provinceName = provinceName;
	}

	public Integer getCity() {
		return city;
	}

	public void setCity(Integer city) {
		this.city = city;
	}

	public String getCityName() {
		return cityName;
	}

	public void setCityName(String cityName) {
		this.cityName = cityName;
	}

	public Integer getDistrict() {
		return district;
	}

	public void setDistrict(Integer district) {
		this.district = district;
	}

	public String getDistrictName() {
		return districtName;
	}

	public void setDistrictName(String districtName) {
		this.districtName = districtName;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Long getActivityId() {
		return activityId;
	}

	public void setActivityId(Long activityId) {
		this.activityId = activityId;
	}

	public Integer getActivateType() {
		return activateType;
	}

	public void setActivateType(Integer activateType) {
		this.activateType = activateType;
	}

}
