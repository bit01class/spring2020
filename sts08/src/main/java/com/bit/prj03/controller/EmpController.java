package com.bit.prj03.controller;

import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
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
	
	@RequestMapping("/emp/detail/{idx}")
	public String detail(Model model,@PathVariable("idx") int sabun) throws SQLException {
		model.addAttribute("bean", empDao.selectOne(sabun));
		return "empOne";
	}
	
	@RequestMapping(value = "/emp/edit",method = RequestMethod.POST)
	public String edit(@ModelAttribute EmpVo bean) throws SQLException {
		empDao.updateOne(bean);
		return "redirect:detail/"+bean.getSabun();
	}
	
	@RequestMapping(value="/emp/delete",method=RequestMethod.POST)
	public String delete(int sabun) throws SQLException {
		empDao.deleteOne(sabun);
		return "home";
	}
}













