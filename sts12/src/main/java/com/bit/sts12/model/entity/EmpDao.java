package com.bit.sts12.model.entity;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

public interface EmpDao {
	
	@Select("select * from emp01")
	List<EmpVo> selectAll();
	
	@Select("select * from emp01 where sabun=#{value}")
	EmpVo selectOne(int key);
	
	@Insert("insert into emp01 values (emp01_seq.nextval,#{name},sysdate,#{pay},'test')")
	void insertOne(EmpVo bean);
	
	@Update("update emp01 set name=#{name},pay=#{pay} where sabun=#{sabun}")
	int updateOne(EmpVo bean);
	
	@Delete("delete from emp01 where sabun=#{value}")
	int deleteOne(int key);
	
}


















