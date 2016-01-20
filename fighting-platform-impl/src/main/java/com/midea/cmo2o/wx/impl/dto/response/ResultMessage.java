package com.midea.cmo2o.wx.impl.dto.response;

import java.io.Serializable;

//返回值
public class ResultMessage implements Serializable {
	private static final long serialVersionUID = 1L;

	//返回码
	private String return_code;
	//返回描述
	private String return_desc;

	private Object data;
	
	
	public ResultMessage() {
		super();
	}

	public ResultMessage(String return_code, String return_desc, Object data) {
		super();
		this.return_code = return_code;
		this.return_desc = return_desc;
		this.data = data;
	}

	public void responseMsg(String return_code, String return_desc, Object data) {
		this.return_code = return_code;
		this.return_desc = return_desc;
		this.data = data;
	}
	
	public String getReturn_code() {
		return return_code;
	}

	public void setReturn_code(String return_code) {
		this.return_code = return_code;
	}

	public String getReturn_desc() {
		return return_desc;
	}

	public void setReturn_desc(String return_desc) {
		this.return_desc = return_desc;
	}

	public Object getData() {
		return data;
	}

	public void setData(Object data) {
		this.data = data;
	}
	
}