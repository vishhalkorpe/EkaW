package com.ekalw.qa.demo;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.ekalw.qa.base.TestBase;
import com.ekalw.qa.base.TestBase22;
import com.ekalw.qa.pages.WelcomePage;
import com.ekalw.qa.util.MyScreenRecorder;
import com.ekalw.qa.util.TestNGCustomListener;

@Listeners(TestNGCustomListener.class)
public class ScreenRecTest extends TestBase{

	WelcomePage welcomepage;

	public ScreenRecTest() {

		super(); // super is used to call the constructor, methods and properties of parent class.
	}

	@BeforeMethod
	public void setUp() {

		initialization();
		welcomepage = new WelcomePage(); // so that we can access all methods of WelcomePage class
	}

	@Test(priority = 1)
	public void validateWelcomePageTitleTest() throws Exception {
		MyScreenRecorder.startRecording("validateWelcomePageTitleTest");
		String title = welcomepage.validateWelcomePageTitle();
		//Assert.assertEquals(title, "Home");
		Thread.sleep(5000);
		driver.get("http://www.google.com");
		driver.navigate().to("http://www.facebook.com");
		driver.navigate().back();
		driver.navigate().forward();
		driver.navigate().back();
		driver.navigate().forward();
		driver.navigate().back();
		driver.navigate().forward();
		driver.navigate().back();
		driver.navigate().forward();
		MyScreenRecorder.stopRecording();
	}

	@Test(enabled=false)
	public void validatePageLoadedTest() throws Exception {
		MyScreenRecorder.startRecording("validatePageLoadedTest");
		boolean b = welcomepage.validatePageLoaded();
		// Assert.assertTrue(b, pageLoadedText);
		Assert.assertTrue(b);
		MyScreenRecorder.stopRecording();
	}

	@AfterMethod
	public void tearDown() {

		driver.quit();
	}

}
