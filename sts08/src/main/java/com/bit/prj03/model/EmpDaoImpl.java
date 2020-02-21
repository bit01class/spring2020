package com.bit.prj03.model;

import java.sql.SQLException;
import java.util.List;

import com.bit.prj03.model.entity.EmpVo;

public class EmpDaoImpl implements EmpDao {

	@Override
	public List<EmpVo> selectAll() throws SQLException {
		return null;
	}

	@Override
	public EmpVo selectOne(int key) throws SQLException {
		return null;
	}

	@Override
	public void insertOne(EmpVo bean) throws SQLException {

	}

	@Override
	public int updateOne(EmpVo bean) throws SQLException {
		return 0;
	}

	@Override
	public int deleteOne(int key) throws SQLException {
		return 0;
	}

	@Override
	public int updatePay(int pay) throws SQLException {
		return 0;
	}

	@Override
	public int selectTotal() throws SQLException {
		return 0;
	}

}
