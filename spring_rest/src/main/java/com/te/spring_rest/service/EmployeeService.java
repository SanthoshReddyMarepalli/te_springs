package com.te.spring_rest.service;

import java.util.List;

import com.te.spring_rest.beans.EmployeeBean;

public interface EmployeeService {

	public EmployeeBean getEmp(int id);

	public boolean deleteEmp(int id);

	public List<EmployeeBean> getAllEmployees();

	public boolean addEmp(EmployeeBean bean);

	public boolean updateEmp(EmployeeBean bean);
	
}
