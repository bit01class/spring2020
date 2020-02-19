package com.bit.project01;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class Ex04Controller {

	@RequestMapping("/ex04")
	public String func(Model model) {
		model.addAttribute("serverTime", "ex04 page");
		return "home";
	}
}
