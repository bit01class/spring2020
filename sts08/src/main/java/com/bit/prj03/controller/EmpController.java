package com.bit.prj03.controller;

import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.bit.prj03.model.EmpDao;

@Controller
public class EmpController {
	@Autowired
	EmpDao empDao;

	@RequestMapping("/emp/list")
	public String list(Model model) throws SQLException {
		model.addAttribute("list", empDao.selectAll());		
		return "empList";
	}
}













