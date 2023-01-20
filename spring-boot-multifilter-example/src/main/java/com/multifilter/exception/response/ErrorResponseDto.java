package com.multifilter.exception.response;

public class ErrorResponseDto {

	private String msgKey;
	private String errorMessage;

	public ErrorResponseDto() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ErrorResponseDto(String msgKey, String errorMessage) {
		super();
		this.msgKey = msgKey;
		this.errorMessage = errorMessage;
	}

	public String getErrorMessage() {
		return errorMessage;
	}

	public String getMsgKey() {
		return msgKey;
	}

	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}

	public void setMsgKey(String msgKey) {
		this.msgKey = msgKey;
	}

	@Override
	public String toString() {
		return "ErrorResponseDto [msgKey=" + msgKey + ", errorMessage=" + errorMessage + "]";
	}

}