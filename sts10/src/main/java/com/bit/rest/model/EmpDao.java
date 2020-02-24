package com.bit.rest.model;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.bit.rest.model.entity.EmpVo;

public interface EmpDao {

	@Select("SELECT * FROM EMP01")
	List<EmpVo> selectAll();
	
	@Insert("INSERT INTO EMP01 VALUES (EMP01_SEQ.NEXTVAL,#{name},sysdate,#{pay},#{etc})")
	void insertOne(EmpVo bean);

	@Select("SELECT * FROM EMP01 WHERE SABUN=#{value}")
	EmpVo selectOne(int key);

	@Update("UPDATE EMP01 SET NAME=#{name},PAY=#{pay} WHERE SABUN=#{sabun}")
	int updateOne(EmpVo bean);

	@Delete("DELETE FROM EMP01 WHERE SABUN=#{value}")
	int deleteOne(int key);
}
