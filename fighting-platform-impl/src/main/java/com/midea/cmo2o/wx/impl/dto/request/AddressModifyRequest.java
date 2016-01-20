package com.midea.cmo2o.wx.impl.dto.request;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotBlank;

import com.midea.cmo2o.wx.impl.dto.BaseRequest;

/**
 * 
 * 类AddressRequest.java的实现描述：地址请求类 
 * @author huanghf 2016年1月2日 下午11:08:02
 * @email  haifeng1.huang@midea.com
 */
public class AddressModifyRequest extends BaseRequest {

	private Long id;

	@NotBlank(message = "收货人姓名不能为空")
	private String name;

	@NotBlank(message = "收货人手机号不能为空")
	private String phone;

	@NotNull(message = "省编码不能为空")
	private Integer province;

	@NotBlank(message = "省名不能为空")
	private String provinceName;

	@NotNull(message = "市编码不能为空")
	private Integer city;

	@NotBlank(message = "市名不能为空")
	private String cityName;

	private Integer district;

	private String districtName;

	@NotBlank(message = "详细地址不能为空")
	private String address;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
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

}
