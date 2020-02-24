package com.bit.rest.service;

import java.util.List;

import org.springframework.ui.Model;

import com.bit.rest.model.entity.EmpVo;

public interface EmpService {

	List list();
	EmpVo detail(int key);
	void insert(EmpVo bean);
	boolean update(EmpVo bean);
	boolean delete(int key);
}
