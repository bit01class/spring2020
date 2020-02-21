package com.bit.prj03.model;

import java.util.List;

import com.bit.prj03.model.entity.EmpVo;

import java.sql.SQLException;

public interface EmpDao {

	List<EmpVo> selectAll() throws SQLException;
	EmpVo selectOne(int key) throws SQLException;
	void insertOne(EmpVo bean) throws SQLException;
	int updateOne(EmpVo bean) throws SQLException;
	int deleteOne(int key) throws SQLException;
	int updatePay(int pay) throws SQLException;
	int selectTotal() throws SQLException;
}
