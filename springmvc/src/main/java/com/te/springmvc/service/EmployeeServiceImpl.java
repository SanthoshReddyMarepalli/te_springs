package com.te.springmvc.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.te.springmvc.beans.EmployeeBean;
import com.te.springmvc.dao.EmployeeDAO;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	private EmployeeDAO dao;

	@Override
	public EmployeeBean authenticate(int id, String pwd) {

		return dao.authenticate(id, pwd);
	}//end of authenticate method

	@Override
	public EmployeeBean getId(int id) {

		return dao.getId(id);
	}//end of getId method

	@Override
	public boolean deleteEmp(int id) {

		return dao.deleteEmp(id);
	}//end of deleteEmployee method

	@Override
	public List<EmployeeBean> getAllEmployees() {

		return dao.getAllEmployees();
	}//End of getAllemployees method

	@Override
	public boolean addEmp(EmployeeBean bean) {
		
		return dao.addEmp(bean);
	}

	@Override
	public boolean updateEmp(EmployeeBean bean) {

		return dao.updateEmp(bean);
	}

}//End of class
