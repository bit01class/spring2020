package com.bit.project02.dept.model;

import java.util.List;

import com.bit.project02.dept.model.entity.DeptVo;

public interface DeptDao {
	List<DeptVo> selectAll();

	void insertOne(String dname, String loc);
	
	DeptVo selectOne(int key);

	int updateOne(String dname, String loc, int deptno);
}
