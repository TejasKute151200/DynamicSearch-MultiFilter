package com.multifilter.exception;

import java.io.IOException;
import java.net.InetAddress;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.ObjectError;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.multipart.support.StandardMultipartHttpServletRequest;
import org.springframework.web.servlet.NoHandlerFoundException;

import com.multifilter.entities.ErrorLoggerEntity;
import com.multifilter.entities.MethodEnum;
import com.multifilter.exception.response.ErrorResponseDto;
import com.multifilter.repo.ErrorLoggerRepo;

@ControllerAdvice
public class HandlerControllerAdvice {

	@Autowired
	private ErrorLoggerRepo errorLoggerRepo;

	@ResponseBody
	@ExceptionHandler(MethodArgumentNotValidException.class)
	@ResponseStatus(value = HttpStatus.BAD_REQUEST)
	public ErrorResponseDto handleValidatioinException(final MethodArgumentNotValidException exception) {

		List<String> details = new ArrayList<>();

		for (ObjectError error : exception.getBindingResult().getAllErrors()) {

			details.add(error.getDefaultMessage());

		}

		ErrorResponseDto error = new ErrorResponseDto();
		error.setErrorMessage(details.get(0).split("\\*", 2)[0]);
		error.setMsgKey(details.get(0).split("\\*", 2)[1]);
		return error;

	}

	@ResponseBody
	@ExceptionHandler(HttpRequestMethodNotSupportedException.class)
	@ResponseStatus(value = HttpStatus.METHOD_NOT_ALLOWED)
	public ErrorResponseDto handleMethodNotSupportException(final HttpRequestMethodNotSupportedException exception) {

		ErrorResponseDto error = new ErrorResponseDto();
		error.setErrorMessage("Invalid request, Please check URL");
		error.setMsgKey("invalidRequest");
		return error;

	}

	@ResponseBody
	@ExceptionHandler(NoHandlerFoundException.class)
	@ResponseStatus(value = HttpStatus.BAD_REQUEST)
	public ErrorResponseDto noHandlerFoundException(final NoHandlerFoundException exception) {

		ErrorResponseDto error = new ErrorResponseDto();
		error.setErrorMessage("URL not Found");
		error.setMsgKey("urlNotFound");
		return error;

	}

	@ResponseBody
	@ExceptionHandler(Exception.class)
	@ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR)
	public ErrorResponseDto handleException(final Exception exception, HttpServletRequest request) throws IOException {

		ErrorLoggerEntity errorRequest = new ErrorLoggerEntity();
		errorRequest.setBody(request instanceof StandardMultipartHttpServletRequest ? null
				: request.getReader().lines().collect(Collectors.joining(System.lineSeparator())));
		errorRequest.setHost(InetAddress.getLoopbackAddress().getHostAddress());
		errorRequest.setMessage(exception.getMessage());
		errorRequest.setMethod(Enum.valueOf(MethodEnum.class, request.getMethod()));
		errorRequest.setUrl(request.getRequestURI());
		errorLoggerRepo.save(errorRequest);
		ErrorResponseDto error = new ErrorResponseDto();
		error.setErrorMessage("Something Went Wrong");
		error.setMsgKey("somethingWentWrong");
		return error;

	}

	@ResponseBody
	@ExceptionHandler(EmployeeNotFoundException.class)
	@ResponseStatus(value = HttpStatus.NOT_FOUND)
	public ExceptionResponse handleEmployeeNotFound(final EmployeeNotFoundException exception,
			final HttpServletRequest request) {

		ExceptionResponse error = new ExceptionResponse();
		error.setErrorMessage(exception.getMessage());
		error.callerURL(request.getRequestURI());
		return error;

	}

	@ResponseBody
	@ExceptionHandler(DesignationNotFoundException.class)
	@ResponseStatus(value = HttpStatus.NOT_FOUND)
	public ExceptionResponse handleDesignationNotFound(final DesignationNotFoundException exception,
			final HttpServletRequest request) {

		ExceptionResponse error = new ExceptionResponse();
		error.setErrorMessage(exception.getMessage());
		error.callerURL(request.getRequestURI());
		return error;

	}

	@ResponseBody
	@ExceptionHandler(DepartmentNotFoundException.class)
	@ResponseStatus(value = HttpStatus.NOT_FOUND)
	public ExceptionResponse handleDepartmentNotFound(final DepartmentNotFoundException exception,
			final HttpServletRequest request) {

		ExceptionResponse error = new ExceptionResponse();
		error.setErrorMessage(exception.getMessage());
		error.callerURL(request.getRequestURI());
		return error;

	}

	@ResponseBody
	@ExceptionHandler(BranchNotFoundException.class)
	@ResponseStatus(value = HttpStatus.NOT_FOUND)
	public ExceptionResponse handleBranchNotFound(final BranchNotFoundException exception,
			final HttpServletRequest request) {

		ExceptionResponse error = new ExceptionResponse();
		error.setErrorMessage(exception.getMessage());
		error.callerURL(request.getRequestURI());
		return error;

	}

}
