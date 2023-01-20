package com.multifilter.exception.response;

public class EmptyResponseDto {

	private String msgKey;
	private String message;

	public EmptyResponseDto() {
		super();
		// TODO Auto-generated constructor stub
	}

	public EmptyResponseDto(String msgKey, String message) {
		super();
		this.msgKey = msgKey;
		this.message = message;
	}

	public String getMessage() {
		return message;
	}

	public String getMsgKey() {
		return msgKey;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public void setMsgKey(String msgKey) {
		this.msgKey = msgKey;
	}

}