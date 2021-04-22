package com.te.springboot.service;

import java.util.List;

import com.te.springboot.beans.EmployeeBean;

public interface EmployeeService {

	public EmployeeBean getEmp(int id);

	public boolean deleteEmp(int id);

	public List<EmployeeBean> getAllEmployees();

	public boolean addEmp(EmployeeBean bean);

	public boolean updateEmp(EmployeeBean bean);

}
