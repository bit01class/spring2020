package com.bit.last.model;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import org.apache.ibatis.session.SqlSession;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import com.bit.last.config.RootConfig;
import com.bit.last.model.entity.EmpVo;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {RootConfig.class})
//~4.x
//@TransactionConfiguration(defaultRollback = true) 
//@Transactional
//5.x
@Transactional
@Rollback
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
	
	@Test
	public void insertOneTest() {
		EmpVo target=new EmpVo();
		target.setSabun(1215);
		target.setName("test");
		target.setPay(9000);
		EmpDao dao=sqlSession.getMapper(EmpDao.class);
		dao.insertOne(target);
		assertEquals(target, dao.selectOne(target.getSabun()));
	}

}




























