package com.multifilter.exception.response;

public class SuccessResponseDto {

	private String msgKey;
	private String message;
	private Object data;

	public SuccessResponseDto() {
		super();
		// TODO Auto-generated constructor stub
	}

	public SuccessResponseDto(String msgKey, String message, Object data) {
		super();
		this.msgKey = msgKey;
		this.message = message;
		this.data = data;
	}

	public Object getData() {
		return data;
	}

	public String getMessage() {
		return message;
	}

	public String getMsgKey() {
		return msgKey;
	}

	public void setData(Object data) {
		this.data = data;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public void setMsgKey(String msgKey) {
		this.msgKey = msgKey;
	}

	@Override
	public String toString() {
		return "SuccessResponseDto [msgKey=" + msgKey + ", message=" + message + ", data=" + data + "]";
	}

}
