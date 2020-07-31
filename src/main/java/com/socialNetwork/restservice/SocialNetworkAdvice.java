package com.socialNetwork.restservice;


import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class SocialNetworkAdvice {

	@ResponseBody
	@ExceptionHandler(RegisterUnsuccesfulException.class)
	@ResponseStatus(HttpStatus.NOT_FOUND)
	String employeeNotFoundHandler(RegisterUnsuccesfulException ex) {
		return ex.getMessage();
	}
}