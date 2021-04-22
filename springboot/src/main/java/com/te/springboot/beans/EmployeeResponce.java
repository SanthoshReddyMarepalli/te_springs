package com.te.springboot.beans;

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

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public EmployeeBean getEmployeeBean() {
		return employeeBean;
	}

	public void setEmployeeBean(EmployeeBean employeeBean) {
		this.employeeBean = employeeBean;
	}

	public List<EmployeeBean> getBeans() {
		return beans;
	}

	public void setBeans(List<EmployeeBean> beans) {
		this.beans = beans;
	}

	@Override
	public String toString() {
		return "EmployeeResponce [status=" + status + ", msg=" + msg + ", description=" + description
				+ ", employeeBean=" + employeeBean + ", beans=" + beans + "]";
	}

	
}
