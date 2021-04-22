package com.te.springboot.controller;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.te.springboot.beans.EmployeeResponce;
import com.te.springboot.exception.EmployeeExpception;

@RestControllerAdvice
public class EmployeeControllerAdvicer {
	@ExceptionHandler(EmployeeExpception.class)
	public EmployeeResponce handler(EmployeeExpception expception) {

		EmployeeResponce responce = new EmployeeResponce();

		responce.setStatus(500);
		responce.setMsg(expception.getMessage());
		responce.setDescription(expception.getMessage());

		return responce;

	}

}
