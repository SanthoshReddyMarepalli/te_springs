package com.te.springmvc.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.te.springmvc.customexception.EmployeeExp;

@ControllerAdvice
public class EmployeeControllerAdvicer {
	@ExceptionHandler(EmployeeExp.class)
	public String handlerExp(EmployeeExp exp,HttpServletRequest request) {
		
		request.setAttribute("err", exp.getMessage());
		return "errPage";
		
	}

}
