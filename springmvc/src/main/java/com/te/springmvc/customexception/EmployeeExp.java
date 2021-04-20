package com.te.springmvc.customexception;

public class EmployeeExp extends RuntimeException{
	public EmployeeExp(String msg) {
		super(msg);
	}

}
