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
		System.out.println("리스트 출력합니다...");

	}

	@Override
	public void selectOne(int key, Model model) {
		System.out.println("레코드를 출력합니다...");

	}

	@Override
	public void insertOne(EmpVo bean) {
		System.out.println("데이터베이스에 입력하겠습니다...");

	}

	@Override
	public int updateOne(EmpVo bean) {
		System.out.println("레코드를 수정하겠습니다...");
		return 0;
	}

	@Override
	public int deleteOne(int key) {
		System.out.println("레코드를 삭제하겠습니다...");
		return 0;
	}

}
