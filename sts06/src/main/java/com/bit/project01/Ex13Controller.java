package com.bit.project01;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class Ex13Controller {

	@RequestMapping(value="/ex13")
	public void ex13() {}
	
	@RequestMapping(value = "/ex14"
					, method = RequestMethod.POST)
	public void ex14(String id) {
		System.out.println(id);
	}
}
