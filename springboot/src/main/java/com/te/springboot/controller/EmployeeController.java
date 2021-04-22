package com.te.springboot.controller;

import java.util.List;

import javax.print.attribute.standard.Media;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.te.springboot.beans.EmployeeBean;
import com.te.springboot.beans.EmployeeResponce;
import com.te.springboot.service.EmployeeService;

@RestController
public class EmployeeController {

	@Autowired
	private EmployeeService service;

	@GetMapping(path = "/getEmp", produces = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
	public EmployeeResponce getEmp(Integer id) {

		EmployeeResponce responce = new EmployeeResponce();
		EmployeeBean employeeBean = service.getEmp(id);
		if (employeeBean != null) {
			responce.setStatus(200);
			responce.setMsg("success");
			responce.setDescription("employee detailes found for id :" + id);
			responce.setEmployeeBean(employeeBean);
		} else {
			responce.setStatus(404);
			responce.setMsg("failure");
			responce.setDescription("employee detailes not found for id :" + id);

		}
		return responce;

	}// End of getEmp method

	@GetMapping(path = "/getAll", produces = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
	public EmployeeResponce getAll() {
		EmployeeResponce responce = new EmployeeResponce();
		List<EmployeeBean> bean = service.getAllEmployees();
		if (bean != null) {
			responce.setStatus(200);
			responce.setMsg("success");
			responce.setDescription("employees detailes found");
			responce.setBeans(bean);

		} else {
			responce.setStatus(404);
			responce.setMsg("error");
			responce.setDescription("employees detailes not found");

		}

		return responce;

	}// End of getAll method

	@PutMapping(path = "/update", produces = { MediaType.APPLICATION_JSON_VALUE,
			MediaType.APPLICATION_XML_VALUE }, consumes = { MediaType.APPLICATION_JSON_VALUE,
					MediaType.APPLICATION_XML_VALUE })
	public EmployeeResponce update(@RequestBody EmployeeBean bean) {

		EmployeeResponce responce = new EmployeeResponce();
		if (service.updateEmp(bean)) {

			responce.setStatus(200);
			responce.setMsg("success");
			responce.setDescription("Updated successfully");

		} else {
			responce.setStatus(404);
			responce.setMsg("failure");
			responce.setDescription("Something went Wrong");

		}

		return responce;

	}// End of update method

	@PostMapping(path = "/addEmp", produces = { MediaType.APPLICATION_JSON_VALUE,
			MediaType.APPLICATION_XML_VALUE }, consumes = { MediaType.APPLICATION_JSON_VALUE,
					MediaType.APPLICATION_XML_VALUE })
	public EmployeeResponce addEmp(@RequestBody EmployeeBean bean) {

		EmployeeResponce responce = new EmployeeResponce();
		if (service.addEmp(bean)) {
			responce.setStatus(200);
			responce.setMsg("success");
			responce.setDescription("Added successfully");

		} else {
			responce.setStatus(404);
			responce.setMsg("Failure");
			responce.setDescription("Something went wrong");
		}

		return responce;

	}// End of addEmp method

	@DeleteMapping(path = "/deleteEmp", produces = { MediaType.APPLICATION_JSON_VALUE,
			MediaType.APPLICATION_XML_VALUE  })
	public EmployeeResponce deleteEmp(int id) {
		EmployeeResponce responce = new EmployeeResponce();
		if (service.deleteEmp(id)) {
			responce.setStatus(200);
			responce.setMsg("success");
			responce.setDescription("Added successfully");

		} else {
			responce.setStatus(404);
			responce.setMsg("failure");
			responce.setDescription("something went wrong");

		}
		return responce;

	}// End of deleteEmp method
}
