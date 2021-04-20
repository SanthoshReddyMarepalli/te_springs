package com.te.springmvc.dao;

import java.util.List;

import com.te.springmvc.beans.EmployeeBean;

public interface EmployeeDAO {
	
	public EmployeeBean authenticate(int id,String pwd);
	
	public EmployeeBean getId(int id);
	
	public boolean deleteEmp(int id);
	
	public List<EmployeeBean> getAllEmployees();
	
	public boolean addEmp(EmployeeBean bean);
	
	public boolean updateEmp(EmployeeBean bean);
}
