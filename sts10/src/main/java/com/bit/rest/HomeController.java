package com.bit.rest;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.bit.rest.service.EmpService;

@Controller
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	@Autowired
	EmpService service;
	
	@RequestMapping("/")
	public String home() {
		return "home";
	}
	
	@RequestMapping("/emp/")
	@ResponseBody
	public List list() {
		return service.list();
	}
		
}


















