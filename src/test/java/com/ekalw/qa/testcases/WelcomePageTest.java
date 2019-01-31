package com.ekalw.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.ekalw.qa.base.TestBase;
import com.ekalw.qa.pages.DashBoardPage;
import com.ekalw.qa.pages.SignInPage;
import com.ekalw.qa.pages.WelcomePage;
import com.ekalw.qa.util.GTakeScreenshot;
import com.ekalw.qa.util.TestNGCustomListener;

@Listeners(TestNGCustomListener.class)   //calling listener to get screenshot.

public class WelcomePageTest extends TestBase{

	WelcomePage welcomepage; // defined here so that we can use it throughout the class here.
	SignInPage signIn;
	DashBoardPage dashBoardPage;

	public WelcomePageTest() {

		super(); // before calling initialization we need to call testbase constructor also, as it reads file for initialization.
	}

	@BeforeMethod
	public void setUp() {

		initialization(); // calling initialization from testbase class
		welcomepage = new WelcomePage(); // so that we can access all methods of WelcomePage class
	}

	@Test(enabled = false)
	//@Test(priority=1)
	public void validateWelcomePageTitleTest() throws Exception {

		String title = welcomepage.validateWelcomePageTitle();
		Assert.assertEquals(title, "Home");
		Thread.sleep(5000);
		//GTakeScreenshot.takeSnapShot(driver, "D://WorkSpace//GScreenshtot//test1.png");

	}
	
	@Test(priority=2)
	//@Test(enabled = false)
	public void validatePageLoadedTest(){
		
		boolean b=welcomepage.validatePageLoaded();
		//Assert.assertTrue(b, pageLoadedText);
		System.out.println("validate page load test");
		Assert.assertTrue(b);
	}
	
	//@Test(enabled = false)
	//@Test(priority=3)
	public void validateSignInPageTest(){
		System.out.println("validateSignInPageTest");
		signIn = welcomepage.validateSignInPage();
	}

	@AfterMethod
	public void tearDown() throws InterruptedException {
		Thread.sleep(5000);
		driver.quit();
	}

}
