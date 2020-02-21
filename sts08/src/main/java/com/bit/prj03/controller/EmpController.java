package com.bit.prj03.controller;

import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.bit.prj03.model.EmpDao;
import com.bit.prj03.model.entity.EmpVo;

@Controller
public class EmpController {
	@Autowired
	EmpDao empDao;

	@RequestMapping("/emp/list")
	public String list(Model model) throws SQLException {
		model.addAttribute("list", empDao.selectAll());		
		return "empList";
	}
	
	@RequestMapping(value = "/emp/add",method=RequestMethod.GET)
	public String add() {return "empAdd";}
	
	@RequestMapping(value = "/emp/add",method=RequestMethod.POST)
	public String add(@ModelAttribute EmpVo bean) throws SQLException {
		empDao.insertOne(bean);
		return "redirect:list"; 
	}
}













