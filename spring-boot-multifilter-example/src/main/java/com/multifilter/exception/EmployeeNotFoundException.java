package com.multifilter.exception;

public class EmployeeNotFoundException extends Exception {

	private static final long serialVersionUID = 1L;

	public EmployeeNotFoundException() {
		super();

	}

	public EmployeeNotFoundException(String message) {
		super(message);

	}

	/* Currently Not Required Below Things [ Ignore ] */

//	public EmployeeNotFoundException(String message, Throwable cause, boolean enableSuppression,
//			boolean writableStackTrace) {
//		super(message, cause, enableSuppression, writableStackTrace);
//		// TODO Auto-generated constructor stub
//	}
//
//	public EmployeeNotFoundException(String message, Throwable cause) {
//		super(message, cause);
//		// TODO Auto-generated constructor stub
//	}
//	public EmployeeNotFoundException(Throwable cause) {
//		super(cause);
//		// TODO Auto-generated constructor stub
//	}

}
