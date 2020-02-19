package com.bit.project01;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class Ex03Controller {

	@RequestMapping("/ex03")
	public String func() {
		return "home";
	}
}
