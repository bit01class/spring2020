package com.bit.last.model;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import org.apache.ibatis.session.SqlSession;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.bit.last.config.RootConfig;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {RootConfig.class})
public class EmpDaoTest {

	@Autowired
	SqlSession sqlSession;
	
	@Test
	public void selectAllTest() {
		EmpDao dao = sqlSession.getMapper(EmpDao.class);
		assertNotNull(dao);
		assertNotNull(dao.selectAll());
		assertTrue(dao.selectAll().size()>0);
		
		//fail("Not yet implemented");
	}

}


















