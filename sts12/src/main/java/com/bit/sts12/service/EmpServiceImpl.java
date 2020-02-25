package com.bit.sts12.service;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;

import com.bit.sts12.model.entity.EmpDao;
import com.bit.sts12.model.entity.EmpVo;



@Service
public class EmpServiceImpl implements EmpService {
//https://www.egovframe.go.kr/wiki/doku.php?id=egovframework:rte:psl:transaction:declarative_transaction_management
	/*
isolation	Transaction의 isolation Level 정의하는 요소. 별도로 정의하지 않으면 DB의 Isolation Level을 따름.	@Transactional(isolation=Isolation.DEFAULT)
noRollbackFor	정의된 Exception 목록에 대해서는 rollback을 수행하지 않음.	@Transactional(noRollbackFor=NoRoleBackTx.class)
noRollbackForClassName	Class 객체가 아닌 문자열을 이용하여 rollback을 수행하지 않아야 할 Exception 목록 정의	@Transactional(noRollbackForClassName=“NoRoleBackTx”)
propagation	Transaction의 propagation 유형을 정의하기 위한 요소	@Transactional(propagation=Propagation.REQUIRED)
readOnly	해당 Transaction을 읽기 전용 모드로 처리 (Default = false)	@Transactional(readOnly = true)
rollbackFor	정의된 Exception 목록에 대해서는 rollback 수행	@Transactional(rollbackFor=RoleBackTx.class)
rollbackForClassName	Class 객체가 아닌 문자열을 이용하여 rollback을 수행해야 할 Exception 목록 정의	@Transactional(rollbackForClassName=“RoleBackTx”)
timeout	지정한 시간 내에 해당 메소드 수행이 완료되지 않은 경우 rollback 수행. -1일 경우 no timeout (Default = -1)	@Transactional(timeout=10)  
	 */
	/* 
Propagation Behavior(** default)
**PROPAGATION_REQUIRED	기존 Transaction이 있는 경우에는 기존 Transaction 내에서 실행하고, 기존 Transaction이 없는 경우에는 새로운 Transaction을 생성한다.
PROPAGATION_REQUIRED_NEW	호출되는 메소드는 자신 만의 Transaction을 가지고 실행하고, 기존의 Transaction들은 보류된다
PROPAGATION_MADATORY	반드시 Transaction 내에서 메소드가 실행되어야 한다. 없으면 예외발생
PROPAGATION_NESTED	Transaction에 있는 경우, 기존 Transaction 내의 nested transaction 형태로 메소드를 실행하고, nested transaction 자체적으로 commit, rollback이 가능하다. Transaction이 없는 경우, PROPAGATION_REQUIRED 속성으로 행동한다. nested transaction 형태로 실행될 때는 수행되는 변경사항이 커밋이 되기 전에는 기존 Transaction에서 보이지 않는다.
PROPAGATION_NEVER	Manatory와 반대로 Transaction 없이 실행되어야 하며 Transaction이 있으면 예외를 발생시킨다.
PROPAGATION_NOT_SUPPORTED	Transaction 없이 메소드를 실행하며,기존의 Transaction이 있는 경우에는 이 Transaction을 호출된 메소드가 끝날 때까지 잠시 보류한다
PROPAGATION_SUPPORTS	새로운 Transaction을 필요로 하지는 않지만, 기존의 Transaction이 있는 경우에는 Transaction 내에서 메소드를 실행한다. 
	 */
	
	
	
	Logger log=LoggerFactory.getLogger(getClass());
	@Autowired
	SqlSession sqlSession;

	@Override
	public void selectAll(Model model) {
		EmpDao dao = sqlSession.getMapper(EmpDao.class);
		model.addAttribute("list", dao.selectAll());
	}

	@Override
	public void selectOne(int key, Model model) {
		EmpDao dao = sqlSession.getMapper(EmpDao.class);
		model.addAttribute("bean", dao.selectOne(key));
	}

	@Transactional
	@Override
	public void insertOne(EmpVo bean) throws Exception {
		EmpDao dao = sqlSession.getMapper(EmpDao.class);
		dao.insertOne(bean);
	}

	@Override
	public int updateOne(EmpVo bean) {
		EmpDao dao = sqlSession.getMapper(EmpDao.class);
		return dao.updateOne(bean);
	}

	@Override
	public int deleteOne(int key) {
		EmpDao dao = sqlSession.getMapper(EmpDao.class);
		return dao.deleteOne(key);
	}

}
