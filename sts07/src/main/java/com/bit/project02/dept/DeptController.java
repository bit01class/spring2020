package com.bit.project02.dept;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.bit.project02.dept.model.DeptDao;
import com.bit.project02.dept.model.entity.DeptVo;

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
	
	@RequestMapping(value = {"add","insert"},method=RequestMethod.GET)
	public String addForm(Model model) {

		model.addAttribute("title","입력");
		model.addAttribute("action","insert");
		model.addAttribute("method","post");
		model.addAttribute("btn1","입력");
		return "deptform";
	}
	
	@RequestMapping(value = "insert",method = RequestMethod.POST)
	public String insert(String dname,String loc,Model model) {
		if(dname.isEmpty()) {
			model.addAttribute("bean",new DeptVo(0, dname,loc));
			model.addAttribute("title","입력");
			model.addAttribute("action","insert");
			model.addAttribute("method","post");
			model.addAttribute("btn1","입력");
			return "deptform";
		}
		dao.insertOne(dname,loc);
		return "redirect:list";
	}
	
	@RequestMapping("detail")
	public String detail(int idx,Model model) {
		model.addAttribute("bean",dao.selectOne(idx));
		model.addAttribute("title","상세");
		model.addAttribute("action","edit");
		model.addAttribute("method","get");
		model.addAttribute("disabled","disabled");
		model.addAttribute("btn1","수정으로 이동");
		return "deptform";
	}
	
	@RequestMapping(value = "edit",method = RequestMethod.GET)
	public String edit(int deptno,Model model) {
		model.addAttribute("bean", dao.selectOne(deptno));
		model.addAttribute("title", "수정");
		model.addAttribute("method","post");
		model.addAttribute("btn1","수정");
		return "deptform";
	}
	
	@RequestMapping(value = "edit",method = RequestMethod.POST)
	public String edit(int deptno, String dname, String loc,Model model) {
		if(dname.isEmpty()) {
			model.addAttribute("bean", new DeptVo(deptno, dname, loc));
			model.addAttribute("title", "수정");
			model.addAttribute("method","post");
			model.addAttribute("btn1","수정");
			return "deptform";
		}
		
		if(dao.updateOne(dname,loc,deptno)>0)
			return "redirect:detail?idx="+deptno;
		model.addAttribute("bean", dao.selectOne(deptno));
		return "redirect:edit?deptno="+deptno;
	}
}



















