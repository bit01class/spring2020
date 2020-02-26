package com.bit.last.config;

import static org.junit.Assert.*;

import java.sql.SQLException;

import javax.sql.DataSource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = RootConfig.class)
public class RootConfigTest {
	
	@Autowired
	DataSource dataSource;

	@Test
	public void test() throws SQLException {
		assertNotNull(dataSource);
		assertNotNull(dataSource.getConnection());
		System.out.println(dataSource.getConnection().getMetaData().getUserName());
		//fail("Not yet implemented");
	}

}

















