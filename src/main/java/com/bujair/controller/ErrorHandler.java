/**
 * 
 */
package com.bujair.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import com.bujair.exception.NoDataFoundException;
import com.bujair.vo.BaseVo;

/**
 * @author Bujair
 *
 */
@ControllerAdvice(basePackages = "com.bujair")
public class ErrorHandler {

	@ExceptionHandler(NoDataFoundException.class)
	public @ResponseBody BaseVo notFoundException(final NoDataFoundException e) {
		return error(e, HttpStatus.NOT_FOUND, e.getMessage());
	}

	@ExceptionHandler(Exception.class)
	public @ResponseBody BaseVo notFoundException(final Exception e) {
		return error(e, HttpStatus.BAD_REQUEST, e.getMessage());
	}
	private BaseVo error(Exception e, HttpStatus notFound, String message) {
		BaseVo result = new BaseVo();
		result.setStatus("Fail");
		result.setMessage(message);
		result.setErrorCode(notFound.toString());
		return result;
	}

}
