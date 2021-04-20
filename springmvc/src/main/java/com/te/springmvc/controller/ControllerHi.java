package com.te.springmvc.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.te.springmvc.beans.UserBean;

@Controller
public class ControllerHi {
	@RequestMapping(path = "/hi", method = RequestMethod.GET)
	public ModelAndView getHi() {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("hipage");
		return modelAndView;

	}

//	@RequestMapping(path = "/search", method = RequestMethod.GET)
//	public ModelAndView getName(ModelAndView modelAndView, HttpServletRequest request) {
//		String name = request.getParameter("name");
//		request.setAttribute("userName", name);
//		modelAndView.setViewName("namePage");
//		return modelAndView;
//
//	}
	@GetMapping("/login")
	public String getdata() {
		return "login";
		
	}
	@PostMapping("/login")
	public String getFormData(HttpServletRequest request,ModelMap map) {
		
		String name= request.getParameter("user");
		int pwd=Integer.parseInt(request.getParameter("pwd"));
		
		map.addAttribute("name",name);
		map.addAttribute("pwd",pwd);
		return "userDetiles";
	}
	
	@PostMapping("/login1")
	public String getName(ModelMap map,int pwd,String name) {
		
		map.addAttribute("name",name);
		map.addAttribute("pwd",pwd);
		return "userDetiles";
	}
	@PostMapping("/login2")
	public String getBeanData(ModelMap map,UserBean userBean) {
	
		map.addAttribute("name",userBean.getName());
		map.addAttribute("pwd",userBean.getPwd());
		return "userDetiles";
	}
	@PostMapping("/login3")
	public String getRequestParam(ModelMap map,
			@RequestParam(name="")String user,
			@RequestParam(name="pwd") int password) {
		
		map.addAttribute("name",user);
		map.addAttribute("pwd",password);
		return "userDetiles";
	}

}
