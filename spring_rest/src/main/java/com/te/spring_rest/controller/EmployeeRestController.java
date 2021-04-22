package com.te.spring_rest.controller;

import java.util.List;

import javax.print.attribute.standard.Media;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.te.spring_rest.beans.EmployeeBean;
import com.te.spring_rest.beans.EmployeeResponce;
import com.te.spring_rest.service.EmployeeService;

@RestController
public class EmployeeRestController {
	@Autowired
	EmployeeService service;

	@GetMapping(path = "/getAll", produces = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
	public EmployeeResponce getAll() {

		EmployeeResponce responce = new EmployeeResponce();
		List<EmployeeBean> beans = service.getAllEmployees();
		if (beans != null) {

			responce.setStatus(200);
			responce.setMsg("Success");
			responce.setDescription("Employees information is here");
			responce.setBeans(beans);

		} else {

			responce.setStatus(404);
			responce.setMsg("failure");
			responce.setDescription("Something went Wrong");

		}

		return responce;
	}// End of getAll method

	@GetMapping(path = "/getEmp", produces = { MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE })
	public EmployeeBean getEmployee(int id) {
		EmployeeBean employeeBean = service.getEmp(id);
		if (employeeBean != null) {
			return employeeBean;
		} else {

			return null;
		}

	}// End of getEmployee method

	@DeleteMapping(path = "/delete/{emp_id}", produces = { MediaType.APPLICATION_JSON_VALUE,
			MediaType.APPLICATION_XML_VALUE })
	public EmployeeResponce deleteEmp(@PathVariable(name = "emp_id") int id) {

		EmployeeResponce responce = new EmployeeResponce();
		if (service.deleteEmp(id)) {

			responce.setStatus(200);
			responce.setMsg("success");
			responce.setDescription("Deleted for this id :" + id);

		} else {

			responce.setStatus(404);
			responce.setMsg("Failure");
			responce.setDescription("Something went wrong");

		}
		return responce;

	}// End of deleteEmp method

	@PostMapping(path = "/add", produces = { MediaType.APPLICATION_JSON_VALUE,
			MediaType.APPLICATION_XML_VALUE }, consumes = { MediaType.APPLICATION_JSON_VALUE,
					MediaType.APPLICATION_XML_VALUE })
	public EmployeeResponce addEmp(@RequestBody EmployeeBean bean) {

		EmployeeResponce responce = new EmployeeResponce();
		if (service.addEmp(bean)) {

			responce.setStatus(200);
			responce.setMsg("Success");
			responce.setDescription("Added Successfully");

		} else {

			responce.setStatus(404);
			responce.setMsg("Failure");
			responce.setDescription("Something went wrong");

		}
		return responce;

	}// End of addEmp method

	@PutMapping(path = "/update", produces = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
	public EmployeeResponce updateEmp(@RequestBody EmployeeBean Bean) {

		EmployeeResponce responce = new EmployeeResponce();
		if (service.updateEmp(Bean)) {

			responce.setStatus(200);
			responce.setMsg("Success");
			responce.setDescription("Updated Successfully");

		} else {

			responce.setStatus(404);
			responce.setMsg("Failure");
			responce.setDescription("Something went wrong");

		}
		return responce;

	}

}
