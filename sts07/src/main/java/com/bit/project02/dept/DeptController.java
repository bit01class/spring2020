package com.bit.project02.dept;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.bit.project02.dept.model.DeptDao;

@Controller
@RequestMapping("/dept/")
public class DeptController {
	
	@Autowired
	DeptDao dao;
	
	@RequestMapping("list")
	public String list(Model model) {
		model.addAttribute("list", dao.selectAll());
		return "deptlist";
	}
	
	@RequestMapping("add")
	public String addForm() {
		return "deptform";
	}
	
	@RequestMapping(value = "insert",method = RequestMethod.POST)
	public String insert(String dname,String loc) {
		dao.insertOne(dname,loc);
		return "redirect:list";
	}
}



















