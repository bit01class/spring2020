package com.bit.project01;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/ex/")
public class Ex10Controller {

	@RequestMapping("ex01")
	public String ex10(HttpServletRequest req) {
		System.out.println(req.getParameter("id"));
		return "home";
	}
}
