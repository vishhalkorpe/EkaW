package com.ekalw.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.ekalw.qa.base.TestBase;
import com.ekalw.qa.util.TestNGCustomListener;

@Listeners(TestNGCustomListener.class)
public class MyRetryTest extends TestBase{
	
	
	public MyRetryTest(){
		
		super(); //before calling initialization we need to call testbase constructor as it also has file to read.
	}
	
	@BeforeMethod
	public void setUp(){
		
		initialization(); //calling initialization from testbase
		
	}
	
	//@Test(retryAnalyzer= com.ekalw.qa.analyzer.RetryAnalyzer.class): NOT A GOOD APPROACH Because we need to add the id to every test case.
	//Better to add transformer in testng.xml
		
	@Test
	public void test1(){
		
		System.out.println("test1");
		Assert.assertEquals(true, false);
		
	}
	
	@Test
	public void test2(){
		
		System.out.println("test2");
		Assert.assertEquals(true, true);
	}
	
	
	
	@AfterMethod
	public void tearDown(){
		
		driver.quit();
	}
	
}
