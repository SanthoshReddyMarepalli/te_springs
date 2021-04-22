package com.te.springboot.dao;

import java.util.List;

import com.te.springboot.beans.EmployeeBean;

public interface EmployeeDAO {

	public EmployeeBean getEmp(int id);

	public boolean deleteEmp(int id);

	public List<EmployeeBean> getAllEmployees();

	public boolean addEmp(EmployeeBean bean);

	public boolean updateEmp(EmployeeBean bean);

}
