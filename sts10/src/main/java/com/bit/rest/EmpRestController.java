package com.bit.rest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
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
	
	@RequestMapping(value = "/{sabun}",method=RequestMethod.GET)
	public EmpVo detail(@PathVariable int sabun) {
		EmpVo bean=service.detail(sabun);
		return bean;
	}
	@RequestMapping(value = "/{sabun}",method=RequestMethod.PUT
//			, produces = {MediaType.APPLICATION_JSON_VALUE}
			)
	public String update(@PathVariable int sabun, @RequestBody EmpVo bean) {
		log.debug(bean.toString());
		service.update(bean);
		return "success";
	}
//	@RequestMapping(value = "/{sabun}",method=RequestMethod.GET)
//	@RequestMapping(value = "/{sabun}",method=RequestMethod.GET)
}

















