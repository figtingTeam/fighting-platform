package com.midea.cmo2o.wx.impl.base;

import java.io.IOException;
import java.sql.SQLException;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;

/**
 * <p>
 * 所有DAO层（或涉及DAO层）的单元测试，需要继承此类。所有继承此类的dao单元测试方法执行完成后，都会将事务进行回滚，防止数据库操作之间互相影响。
 * </p>
 * 
 * @author wenhao.zeng
 * @version:
 */
@ContextConfiguration(locations = { "classpath:/testContext.xml" })
@RunWith(SpringJUnit4ClassRunner.class)
@TransactionConfiguration(transactionManager = "coreManager", defaultRollback = false)
@Transactional
public class BaseDaoTest {

	static {
	}

	protected JdbcTemplate jdbcTemplate;

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	@BeforeClass
	public static void initTestData() throws IOException, SQLException {
		ApplicationContext context = new ClassPathXmlApplicationContext(
				"/testContext.xml");

	}

	@AfterClass
	public static void afterDaoTest() {
	}
}
