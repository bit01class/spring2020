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
isolation	Transaction�� isolation Level �����ϴ� ���. ������ �������� ������ DB�� Isolation Level�� ����.	@Transactional(isolation=Isolation.DEFAULT)
noRollbackFor	���ǵ� Exception ��Ͽ� ���ؼ��� rollback�� �������� ����.	@Transactional(noRollbackFor=NoRoleBackTx.class)
noRollbackForClassName	Class ��ü�� �ƴ� ���ڿ��� �̿��Ͽ� rollback�� �������� �ʾƾ� �� Exception ��� ����	@Transactional(noRollbackForClassName=��NoRoleBackTx��)
propagation	Transaction�� propagation ������ �����ϱ� ���� ���	@Transactional(propagation=Propagation.REQUIRED)
readOnly	�ش� Transaction�� �б� ���� ���� ó�� (Default = false)	@Transactional(readOnly = true)
rollbackFor	���ǵ� Exception ��Ͽ� ���ؼ��� rollback ����	@Transactional(rollbackFor=RoleBackTx.class)
rollbackForClassName	Class ��ü�� �ƴ� ���ڿ��� �̿��Ͽ� rollback�� �����ؾ� �� Exception ��� ����	@Transactional(rollbackForClassName=��RoleBackTx��)
timeout	������ �ð� ���� �ش� �޼ҵ� ������ �Ϸ���� ���� ��� rollback ����. -1�� ��� no timeout (Default = -1)	@Transactional(timeout=10)  
	 */
	/* 
Propagation Behavior(** default)
**PROPAGATION_REQUIRED	���� Transaction�� �ִ� ��쿡�� ���� Transaction ������ �����ϰ�, ���� Transaction�� ���� ��쿡�� ���ο� Transaction�� �����Ѵ�.
PROPAGATION_REQUIRED_NEW	ȣ��Ǵ� �޼ҵ�� �ڽ� ���� Transaction�� ������ �����ϰ�, ������ Transaction���� �����ȴ�
PROPAGATION_MADATORY	�ݵ�� Transaction ������ �޼ҵ尡 ����Ǿ�� �Ѵ�. ������ ���ܹ߻�
PROPAGATION_NESTED	Transaction�� �ִ� ���, ���� Transaction ���� nested transaction ���·� �޼ҵ带 �����ϰ�, nested transaction ��ü������ commit, rollback�� �����ϴ�. Transaction�� ���� ���, PROPAGATION_REQUIRED �Ӽ����� �ൿ�Ѵ�. nested transaction ���·� ����� ���� ����Ǵ� ��������� Ŀ���� �Ǳ� ������ ���� Transaction���� ������ �ʴ´�.
PROPAGATION_NEVER	Manatory�� �ݴ�� Transaction ���� ����Ǿ�� �ϸ� Transaction�� ������ ���ܸ� �߻���Ų��.
PROPAGATION_NOT_SUPPORTED	Transaction ���� �޼ҵ带 �����ϸ�,������ Transaction�� �ִ� ��쿡�� �� Transaction�� ȣ��� �޼ҵ尡 ���� ������ ��� �����Ѵ�
PROPAGATION_SUPPORTS	���ο� Transaction�� �ʿ�� ������ ������, ������ Transaction�� �ִ� ��쿡�� Transaction ������ �޼ҵ带 �����Ѵ�. 
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
