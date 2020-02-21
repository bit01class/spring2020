package com.bit.prj03.model;

import java.sql.SQLException;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;

import com.bit.prj03.model.entity.EmpVo;

public class EmpDaoImpl implements EmpDao {
	
	@Autowired
	SqlSession sqlSession;

	@Override
	public List<EmpVo> selectAll() throws SQLException {
		return sqlSession.selectList("emp.selectAll");
	}

	@Override
	public EmpVo selectOne(int key) throws SQLException {
		return null;
	}

	@Override
	public void insertOne(EmpVo bean) throws SQLException {
		sqlSession.insert("emp.insertOne",bean);
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
