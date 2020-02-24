package com.bit.rest.model;

import java.util.List;

import org.apache.ibatis.annotations.Select;

import com.bit.rest.model.entity.EmpVo;

public interface EmpDao {

	@Select("select * from emp01")
	List<EmpVo> selectAll();
}
