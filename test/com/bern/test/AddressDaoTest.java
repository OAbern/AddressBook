package com.bern.test;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;

import com.bern.dao.AddressDao;
import com.bern.model.Address;
import com.bern.model.ConstantValue;

/**
 * 地址信息持久层的测试用例
 * @author Bern
 *
 */
public class AddressDaoTest {
	private static AddressDao addressDao;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		addressDao = new AddressDao();
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}
	
	/**
	 * 测试添加的操作
	 */
	@Test
	@Ignore
	public void testAdd() {
		Address address = new Address("Test","/>12345678912","CQ");
		assertEquals(true, addressDao.add(address));
	}
	
	/**
	 * 测试删除操作
	 */
	@Test
	@Ignore
	public void testRemove() {
		int result = addressDao.remove(ConstantValue.F_NAME, "Test");
		assertEquals(result, 3);
	}
	
	@Test
//	@Ignore
	public void testSearch() {
		List<Address> list = addressDao.search(ConstantValue.F_NAME, "Test");
		assertEquals(list.size(), 3);
	}

}
