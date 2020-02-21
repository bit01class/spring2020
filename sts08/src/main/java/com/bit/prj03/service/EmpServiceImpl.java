package com.bit.prj03.service;

import java.sql.SQLException;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import com.bit.prj03.model.EmpDao;
import com.bit.prj03.model.entity.EmpVo;

@Service
public class EmpServiceImpl implements EmpService {
	Logger log=LoggerFactory.getLogger(getClass());
	
	@Autowired
	EmpDao empDao;

	@Override
	public void list(Model model) {
		log.info("list service run..."+empDao);
		try {
			List<EmpVo> list = empDao.selectAll();
			model.addAttribute("list",list);
			model.addAttribute("total",empDao.selectTotal());
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	

	@Override
	public void detail(Model model,int sabun) {
		try {
			empDao.updatePay(sabun);
			model.addAttribute("bean", empDao.selectOne(sabun));
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void insert(EmpVo bean) {
		try {
			empDao.insertOne(bean);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void update(EmpVo bean) {
		try {
			empDao.updateOne(bean);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void delete(int sabun) {
		try {
			empDao.deleteOne(sabun);
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

}
