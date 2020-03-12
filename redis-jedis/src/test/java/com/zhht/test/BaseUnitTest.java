package com.zhht.test;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

/**
 * 
* @ClassName: BaseTest  
* <p>Description: 单元测试  
* https://www.cnblogs.com/peak911/p/9293145.html 单元测试例子 
* </p>
* @author  frankman
* @date 2020年3月6日 下午3:59:24  
*
 */
@RunWith(value = SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:bean.xml"})
//@Rollback(value=false)
//@Transactional(transactionManager="transactionManager")
public class BaseUnitTest {
	 	@BeforeClass
	    public static void setUpBeforeClass() throws Exception {
	        System.out.println("==============单元测试开始=============");
	    }

	    @AfterClass
	    public static void tearDownAfterClass() throws Exception {
	        System.out.println("==============单元测试结束=============");
	    }

}
