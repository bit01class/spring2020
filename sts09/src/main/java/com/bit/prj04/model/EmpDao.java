package com.bit.prj04.model;

import java.util.List;

import com.bit.prj04.model.entity.EmpVo;

public interface EmpDao {

	List<EmpVo> selectAll() throws Exception;
	EmpVo selectOne(int key) throws Exception;
	void insertOne(EmpVo bean) throws Exception;
	int updateOne(EmpVo bean) throws Exception;
	int deleteOne(int key) throws Exception;
}
