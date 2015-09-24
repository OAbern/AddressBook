package com.bern.test;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.bern.utils.ValidateUtils;

/**
 * 校验工具类的测试用例
 * @author Bern
 *
 */
public class ValidateUtilsTest {

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
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
	 * 测试通配符匹配方法
	 */
	@Test
	public void testWildcardMatching() {
		String test1 = "aaa*aaa";
		String test2 = "bb*aaa";
		String v2 = "aaa1q中aaa";
		boolean result1 = ValidateUtils.wildcardMatching(test1, v2);
		boolean result2 = ValidateUtils.wildcardMatching(test2, v2);
		assertEquals(true, result1);
		assertEquals(false, result2);
	}

}
