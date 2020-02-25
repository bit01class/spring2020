package com.bit.sts12.service;

import org.springframework.ui.Model;

import com.bit.sts12.model.entity.EmpVo;

public interface EmpService {

	void selectAll(Model model);
	void selectOne(int key,Model model);
	void insertOne(EmpVo bean) throws Exception;
	int updateOne(EmpVo bean);
	int deleteOne(int key);
}
