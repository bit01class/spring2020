package com.bit.rest.service;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import com.bit.rest.model.EmpDao;
import com.bit.rest.model.entity.EmpVo;

@Service
public class EmpServiceImpl implements EmpService {
	
	@Autowired
	SqlSession sqlSession;

	@Override
	public List list() {
		EmpDao dao = sqlSession.getMapper(EmpDao.class);
		return dao.selectAll();
	}

	@Override
	public EmpVo detail(int key) {
		EmpDao dao= sqlSession.getMapper(EmpDao.class);
		return dao.selectOne(key);
	}

	@Override
	public void insert(EmpVo bean) {
		EmpDao dao= sqlSession.getMapper(EmpDao.class);
		dao.insertOne(bean);
	}

	@Override
	public boolean update(EmpVo bean) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delete(int key) {
		// TODO Auto-generated method stub
		return false;
	}

}
