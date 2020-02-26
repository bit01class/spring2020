package com.bit.last;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bit.last.model.EmpDao;
import com.bit.last.model.entity.EmpVo;

@RestController
public class RestEmpController {
	@Autowired
	SqlSession sqlSession;

	@GetMapping("/list")
	public List<EmpVo> list(){
		return sqlSession.getMapper(EmpDao.class).selectAll();
	}
}
