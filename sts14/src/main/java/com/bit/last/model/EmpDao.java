package com.bit.last.model;

import java.util.List;

import org.apache.ibatis.annotations.Select;

import com.bit.last.model.entity.EmpVo;

public interface EmpDao {

	@Select("select * from emp")
	List<EmpVo> selectAll();
}
