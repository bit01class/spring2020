package com.bit.project02.dept.model;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;

import com.bit.project02.dept.model.entity.DeptVo;

public class DeptDaoImpl3 implements DeptDao {
	
	@Autowired
	SqlSession sqlSession;

	@Override
	public List<DeptVo> selectAll() {
		return sqlSession.selectList("dept.selectAll");
	}

	@Override
	public void insertOne(String dname, String loc) {
		sqlSession.insert("dept.insertOne",new DeptVo(0,dname,loc));
	}

	@Override
	public DeptVo selectOne(int key) {
		return sqlSession.selectOne("dept.selectOne",key);
	}

	@Override
	public int updateOne(String dname, String loc, int deptno) {
		// TODO Auto-generated method stub
		return 0;
	}

}
