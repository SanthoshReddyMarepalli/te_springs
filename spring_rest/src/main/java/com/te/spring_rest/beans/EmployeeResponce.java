package com.te.spring_rest.beans;

import java.io.Serializable;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.annotation.JsonRootName;

import lombok.Data;

@Data
@JsonPropertyOrder({ "status", "msg" })
@JsonRootName("employee_responce")
@JsonInclude(JsonInclude.Include.NON_NULL)
public class EmployeeResponce implements Serializable {

	private int status;

	private String msg;

	private String description;

	@JsonProperty("employee_info")
	private EmployeeBean employeeBean;

	@JsonProperty("employee_detailes")
	private List<EmployeeBean> beans;

}
