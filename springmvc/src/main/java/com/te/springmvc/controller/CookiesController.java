package com.te.springmvc.controller;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
//@RequestMapping("/cookie")
public class CookiesController {
	@GetMapping("/cookiesPage")
	public String getCookies() {

		return "cookiesPage";
	}

	@GetMapping("/createCookie")
	public String createCookies(HttpServletResponse response, ModelMap map) {
		Cookie cookie = new Cookie("EmpName", "Santhosh");
		response.addCookie(cookie);
		map.addAttribute("msg", "created cookies");
		return "cookiesPage";
	}

	@GetMapping("/showCookie")
	private String showCookies(@CookieValue(name = "EmpName", required = false) String name, ModelMap map) {
		map.addAttribute("cookies", name);
		return "cookiesPage";

	}

}
