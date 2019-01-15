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
import com.ekalw.qa.util.TestNGCustomListener;
import com.sun.xml.internal.bind.v2.runtime.unmarshaller.XsiNilLoader.Single;

@Listeners(TestNGCustomListener.class)   //calling listener to get screenshot.
public class SignInPageTest extends TestBase {

	WelcomePage welcomepage; // defined here so that we can use it throughout the class here.
	SignInPage signIn;
	DashBoardPage dashBoardPage;

	public SignInPageTest() {

		super(); // before calling initialization we need to call testbase constructor also as it reads files for initialization.

	}

	@BeforeMethod
	public void setUp() {

		initialization();
		dashBoardPage = new DashBoardPage();// so that we can call all methods of signInPage class
		welcomepage = new WelcomePage();

		signIn = welcomepage.validateSignInPage();

	}

	@Test(priority=1)
	public void validateSignInPageTitleTest() {

		String title = signIn.validateSignInPageTitle();
		Assert.assertEquals(title, "SIMS ID");
	}

	@Test(priority=2)
	public void clickAcceptCookiesButtonTest() {

		boolean clicked = signIn.clickAcceptCookiesButton();
		Assert.assertTrue(clicked);
	}

	@Test(priority=3)
	public void validateSIMSImageTest() {

		boolean simsimage = signIn.validateSIMSImage();
		Assert.assertTrue(simsimage);
	}

	@Test(priority=4)
	public void signInWithSimsIdTest() throws InterruptedException {

		dashBoardPage = signIn.signInWithSimsId(prop.getProperty("username"), prop.getProperty("password"));

		System.out.println("dome");

	}

	@Test(priority=5)
	public void signInWithGoogleIdTest() throws InterruptedException {

		dashBoardPage = signIn.signInWithGoogleId(prop.getProperty("email_id"), prop.getProperty("email_password"));

		System.out.println("dome");

	}
	
	
	@Test(priority=6)
	public void forgetPasswordForSignInWithSimsIdTest() throws InterruptedException{
		
		boolean errorFlag=signIn.forgetPasswordForSignInWithSimsId();
		Assert.assertTrue(errorFlag);
		
	}

	@AfterMethod
	public void tearDown() throws InterruptedException {
		Thread.sleep(5000);
		driver.quit();
	}

}
