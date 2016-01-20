package com.midea.cmo2o.wx.impl.dto.response;

import java.io.Serializable;
import java.util.Arrays;

public class ResponseText implements Serializable {
	private static final long serialVersionUID = 1L;

	private Boolean status;

	private ErrorText error;

	private Object[] content;

	public ResponseText() {
		ErrorText error = new ErrorText();
		this.setError(error);
	}
	
	public void errorResponseText(String errorCode, String msg) {
		this.status = Boolean.FALSE;
		this.error.errorCode = Integer.parseInt(errorCode);
		this.error.msg = msg;
	}
	
	public static class ErrorText implements Serializable {
		private static final long serialVersionUID = 1L;

		private String msg;

		private int errorCode;

		public String getMsg() {
			return msg;
		}

		public void setMsg(String msg) {
			this.msg = msg;
		}

		public int getErrorCode() {
			return errorCode;
		}

		public void setErrorCode(int errorCode) {
			this.errorCode = errorCode;
		}

		@Override
		public String toString() {
			StringBuilder builder = new StringBuilder();
			builder.append("ErrorText [msg=");
			builder.append(msg);
			builder.append(", errorCode=");
			builder.append(errorCode);
			builder.append("]");
			return builder.toString();
		}
	}

	public ErrorText getError() {
		return error;
	}

	public void setError(ErrorText error) {
		this.error = error;
	}

	public Object[] getContent() {
		return content;
	}

	public void setContent(Object[] content) {
		this.content = content;
	}
	
	public Boolean getStatus() {
		return status;
	}

	public void setStatus(Boolean status) {
		this.status = status;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("ResponseText [status=");
		builder.append(status);
		builder.append(", error=");
		builder.append(error);
		builder.append(", content=");
		builder.append(Arrays.toString(content));
		builder.append("]");
		return builder.toString();
	}

}