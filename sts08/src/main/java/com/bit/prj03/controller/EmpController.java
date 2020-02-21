package com.bit.prj03.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class EmpController {

	@RequestMapping("/emp/list")
	public String list() {
		return "empList";
	}
}
