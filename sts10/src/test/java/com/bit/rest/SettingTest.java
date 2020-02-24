package com.bit.rest;

import static org.junit.Assert.assertNotNull;

import javax.sql.DataSource;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SettingTest {

	@Test
	public void test() {
		ApplicationContext ac=null;
		ac=new ClassPathXmlApplicationContext("applicationContext.xml");
		DataSource dataSource=(DataSource) ac.getBean("dataSource");
		assertNotNull(dataSource);
	}

}
















