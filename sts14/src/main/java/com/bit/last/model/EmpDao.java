package com.bit.last.model;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import com.bit.last.model.entity.EmpVo;

public interface EmpDao {

	@Select("select * from emp")
	List<EmpVo> selectAll();
	
	@Insert("insert into emp values (#{sabun},#{name},sysdate,#{pay})")
	void insertOne(EmpVo bean);
	
	@Select("select * from emp where sabun=#{value}")
	EmpVo selectOne(int key);
}
