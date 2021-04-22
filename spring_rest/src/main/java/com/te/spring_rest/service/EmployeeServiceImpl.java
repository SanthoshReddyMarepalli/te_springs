package com.te.spring_rest.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.te.spring_rest.beans.EmployeeBean;
import com.te.spring_rest.dao.EmployeeDAO;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	private EmployeeDAO dao;

	@Override
	public EmployeeBean getEmp(int id) {

		return dao.getEmp(id);
	}

	@Override
	public boolean deleteEmp(int id) {

		return dao.deleteEmp(id);
	}

	@Override
	public List<EmployeeBean> getAllEmployees() {

		return dao.getAllEmployees();
	}

	@Override
	public boolean addEmp(EmployeeBean bean) {

		return dao.addEmp(bean);
	}

	@Override
	public boolean updateEmp(EmployeeBean bean) {

		return dao.updateEmp(bean);
	}

}
