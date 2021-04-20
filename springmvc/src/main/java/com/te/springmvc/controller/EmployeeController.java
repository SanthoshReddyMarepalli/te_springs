package com.te.springmvc.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttribute;

import com.te.springmvc.beans.EmployeeBean;
import com.te.springmvc.service.EmployeeService;

@Controller
public class EmployeeController {

	@InitBinder
	public void initBinder(WebDataBinder binder) {

		CustomDateEditor dateEditor = new CustomDateEditor(new SimpleDateFormat("dd-MM-yyyy"), true);
		binder.registerCustomEditor(Date.class, dateEditor);
	}// End of initBinder method

	@Autowired
	private EmployeeService service;

	@GetMapping("/emplogin")
	public String getLogin() {
		return "emploginform";

	}// End of getLogin method

	@PostMapping("/emplogin")
	public String authenticate(int id, String pwd, HttpServletRequest request, ModelMap map) {
		EmployeeBean employeeBean = service.authenticate(id, pwd);

		if (employeeBean != null) {
			HttpSession session = request.getSession(true);
			session.setAttribute("emp", employeeBean);
			return "header";

		} else {
			map.addAttribute("errMsg", "Invalid Credential");
			return "emploginform";
		}

	}// End of aunthenticate method

	@GetMapping("/searchForm")
	public String getSearchForm(ModelMap map, HttpSession session) {

		if (session.getAttribute("emp") != null) {
			return "searchForm";
		} else {

			map.addAttribute("errMsg", "please login first");
			return "emploginform";
		}

	}// End of getSearchForm method

	@GetMapping("/search")
	public String getSearchEmp(int id, ModelMap map, @SessionAttribute("emp") EmployeeBean employeeBean) {

		if (employeeBean != null) {
			EmployeeBean employeeBean2 = service.getId(id);
			if (employeeBean2 != null) {
				map.addAttribute("data", employeeBean2);
			} else {

				map.addAttribute("msg", "Data Not Found for ID" + id);
			}
			return "searchForm";

		} else {

			map.addAttribute("errMsg", "Please login first");
			return "emploginform";
		}

	}// End of getSearchEmp method

	@GetMapping("/logout")
	public String logOut(HttpSession session, ModelMap map) {
		session.invalidate();
		map.addAttribute("msg", "Logout Successfull");

		return "emploginform";

	}// End of logout method

	@GetMapping("/showDeleteForm")
	public String getDeleteEmp(ModelMap map, @SessionAttribute(name = "emp") EmployeeBean bean) {

		if (bean != null) {
			return "delete";
		} else {

			map.addAttribute("errMsg", "please login first");
			return "emploginform";
		}
	}// End of getDeleteEmp method

	@GetMapping("/delete")
	public String delete(int id, ModelMap map, @SessionAttribute(name = "emp") EmployeeBean bean) {
		if (bean != null) {
			boolean data = service.deleteEmp(id);
			if (data == true) {

				map.addAttribute("msg", "Deleted successfully for ID" + id);
			}else {
				map.addAttribute("msg", "Something went wrong with ID :" + id);
			}
			
			return "delete";
			

		} else {

			map.addAttribute("errMsg", "Please login first");
			return "delete";
		}
		

	}// End of delete method

	@GetMapping("/getAll")
	public String viewAllEmployee(ModelMap map, @SessionAttribute(name = "emp") EmployeeBean bean) {
		if (bean != null) {
			List<EmployeeBean> employeeBeans = service.getAllEmployees();
			map.addAttribute("empdata", employeeBeans);
			return "getAll";
		} else {
			map.addAttribute("msg", "no employees found");
			return "getAll";
		}

	}// end of viewAllEmployee

	@GetMapping("/addEmp")
	public String addEmp(ModelMap map, @SessionAttribute(name = "emp", required = false) EmployeeBean bean,
			EmployeeBean employeeBean) {

		if (bean != null) {
			boolean dataAdded = service.addEmp(employeeBean);
			if (dataAdded) {
				map.addAttribute("msg", "Added Successfully");
			} else {

				map.addAttribute("errmsg", "something went wrong");
			}

			return "addEmpForm";

		} else {
			map.addAttribute("errMsg", "please login first");
			return "emploginform";
		}

	}// End of addEmp method

	@GetMapping("/updateForm")
	public String getUpdateForm(ModelMap map, @SessionAttribute(name = "emp", required = false) EmployeeBean bean) {
		if (bean != null) {
			map.addAttribute("id",bean.getId());
			return "update";
		} else {
			map.addAttribute("errMsg", "please login first");
			return "emploginform";
		}

	}// End of getUpdateForm method

	@GetMapping("/update")
	public String updateEmp(ModelMap map, @SessionAttribute(name = "emp", required = false) EmployeeBean bean,EmployeeBean employeeBean) {
		if (bean != null) {
			if (service.updateEmp(employeeBean)) {
				map.addAttribute("id", bean.getId());
				map.addAttribute("msg", "updated Successfully");
			} else {
				map.addAttribute("id", bean.getId());
				map.addAttribute("errMsg", "updated Not Done");
			}
			return "update";
		} else {
			map.addAttribute("errMsg", "please login first");
			return "emploginform";
		}
		
	}//End of updateEmp method

}// end of controller
