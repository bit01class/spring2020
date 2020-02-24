package com.bit.rest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.bit.rest.model.entity.EmpVo;
import com.bit.rest.service.EmpService;

@RestController
@RequestMapping("/emp")
public class EmpRestController {
	Logger log=LoggerFactory.getLogger(this.getClass());
	@Autowired
	EmpService service;

	@RequestMapping(value = "/",method = RequestMethod.POST)
	public String insert(@ModelAttribute EmpVo bean) {
		log.debug(bean.toString());
		service.insert(bean);
		return "success";
	}
	
}

















