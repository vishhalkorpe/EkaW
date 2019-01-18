package com.ekalw.qa.demo;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.ekalw.qa.base.TestBase;
import com.ekalw.qa.base.TestBase22;
import com.ekalw.qa.pages.WelcomePage;
import com.ekalw.qa.util.TestNGCustomListener;

@Listeners(TestNGCustomListener.class)
public class ScreenshotTest extends TestBase{
	
	public ScreenshotTest(){
		
		super();
	}
	
	
	@BeforeMethod
	public void setUp() {

		initialization(); // calling initialization from testbase class
		
	}
	
	@Test(priority=1)
	public void takeScreenshotDemo(){
		
		Assert.assertEquals(false,true);
			
		}
	
	
	
	
	@AfterMethod
	public void tearDown() throws InterruptedException {
		Thread.sleep(5000);
		driver.quit();
	}

}
