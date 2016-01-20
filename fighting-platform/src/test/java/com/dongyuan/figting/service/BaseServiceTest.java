package com.dongyuan.figting.service;



import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;

/**
 * biz层测试基类
 * 
 * @author wenhao.zeng
 */
@ContextConfiguration(locations = { "classpath:/testContext.xml" })
@RunWith(SpringJUnit4ClassRunner.class)
@TransactionConfiguration(transactionManager = "transactionManager", defaultRollback = true)
public class BaseServiceTest {

	static {
		// 禁用远程调用组件
	}

	@Autowired
	private JdbcTemplate coreJdbcTemplate;

	@BeforeClass
	public static void initTestData() throws IOException, SQLException {
		ApplicationContext context = new ClassPathXmlApplicationContext(
				"/testContext.xml");
	}

	@AfterClass
	public static void afterDaoTest() {
	}

	public void save(String sql) {
		coreJdbcTemplate.execute(sql);
	}

	public void update(String sql) {
		coreJdbcTemplate.execute(sql);
	}

	public void delete(String sql) {
		coreJdbcTemplate.execute(sql);
	}

	/**
	 * List 里的每个对应是一个Map
	 * */
	@SuppressWarnings("rawtypes")
	public List query(String sql) {
		return coreJdbcTemplate.queryForList(sql);
	}

	public JdbcTemplate getJdbcTemplate() {
		return coreJdbcTemplate;
	}

}
