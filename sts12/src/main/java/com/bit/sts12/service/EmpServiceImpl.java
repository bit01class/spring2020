package com.bit.sts12.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import com.bit.sts12.model.entity.EmpVo;

@Service
public class EmpServiceImpl implements EmpService {
	Logger log=LoggerFactory.getLogger(getClass());

	@Override
	public void selectAll(Model model) {
		System.out.println("����Ʈ ����մϴ�...");

	}

	@Override
	public void selectOne(int key, Model model) {
		System.out.println("���ڵ带 ����մϴ�...");

	}

	@Override
	public void insertOne(EmpVo bean) {
		System.out.println("�����ͺ��̽��� �Է��ϰڽ��ϴ�...");

	}

	@Override
	public int updateOne(EmpVo bean) {
		System.out.println("���ڵ带 �����ϰڽ��ϴ�...");
		return 0;
	}

	@Override
	public int deleteOne(int key) {
		System.out.println("���ڵ带 �����ϰڽ��ϴ�...");
		return 0;
	}

}
