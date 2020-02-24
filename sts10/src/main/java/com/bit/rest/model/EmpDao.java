package com.bit.rest.model;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import com.bit.rest.model.entity.EmpVo;

public interface EmpDao {

	@Select("SELECT * FROM EMP01")
	List<EmpVo> selectAll();
	
	@Insert("INSERT INTO EMP01 VALUES (EMP01_SEQ.NEXTVAL,#{name},sysdate,#{pay},#{etc})")
	void insertOne(EmpVo bean);
}
