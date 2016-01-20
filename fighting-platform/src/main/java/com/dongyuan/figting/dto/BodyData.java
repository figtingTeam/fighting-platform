package com.dongyuan.figting.dto;


public class BodyData {
	/**
	 * 错误信息,error为空或error.errCode=0时为成功
	 */
	private ResponseError error;

	/**
	 * 响应报文
	 */
	private Object content;
	
	public ResponseError getError() {
		return error;
	}

	public void setError(ResponseError error) {
		this.error = error;
	}

	public Object getContent() {
		return content;
	}

	public void setContent(Object content) {
		this.content = content;
	}
	
	public BodyData(ResponseError error, Object content) {
		super();
		this.error = error;
		this.content = content;
	}
	
	public static BodyData make() {
		return make(null, null);
	}
	
	public static BodyData make(Object content) {
		return make(content, null);
	}
	
	public static BodyData make(ResponseError error) {
		return make(null, error);
	}

	public static BodyData make(Object content, ResponseError error) {
		return new BodyData(error, content);
	}

}
