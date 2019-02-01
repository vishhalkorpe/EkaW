package com.ekalw.qa.testcases;

import static org.testng.Assert.assertTrue;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.ekalw.qa.base.TestBase;
import com.ekalw.qa.pages.AdminOrganisationEnrollmentPage;
import com.ekalw.qa.pages.AdminTeacherEnrollmentPage;
import com.ekalw.qa.pages.DashBoardPage;
import com.ekalw.qa.pages.SignInPage;
import com.ekalw.qa.pages.WelcomePage;

public class AdminOrganisationEnrollmentPageTest extends TestBase {

	// define here class inst, so that we can call its methods throughout this class.

	WelcomePage welcomepage; // defined here so that we can use it throughout the class here.
	SignInPage signIn;
	AdminOrganisationEnrollmentPage aoep;
	DashBoardPage dashBoardPage;

	// Before calling initialization we need to call testbase constructor also as it reads file for initialization.
	public AdminOrganisationEnrollmentPageTest() {

		super();
	}

	// Now Calling initialization from testbase call in @BeforeMethod.
	@BeforeMethod
	public void setUp() throws InterruptedException {

		initialization();

		// here now creating obj ref of class so that we call the methods of that class.
		welcomepage = new WelcomePage();
		dashBoardPage = new DashBoardPage();
		signIn = new SignInPage();
		aoep = new AdminOrganisationEnrollmentPage();

		// now we need to land to page from were we can execute this testscript
		signIn = welcomepage.validateSignInPage(); 									// First takes to sign in page
		sleep(5000);
		
		dashBoardPage = signIn.signInWithSimsId(prop.getProperty("username"), prop.getProperty("password"));
		sleep(5000);												  				// now sign in page takes to dashboard via simsid.
		
		// dashBoardPage=signIn.signInWithGoogleId(prop.getProperty("username"),prop.getProperty("password"));
																					// now sign in page takes to dashboard via google act.

	}
	
	//@Test(enabled=false)
	@Test(priority=1)
	public void verifyPageLoadedTest(){
		
		Assert.assertTrue(aoep.verifyPageLoaded());
	}
	
	//@Test(enabled=false)
	@Test(priority=2)
	public void verifyclickOnOrganisationMenuTest(){
		
		Assert.assertTrue(aoep.verifyclickOnOrganisationMenu());
	}
	
		
	//@Test(enabled=false)
	@Test(priority=3)
	public void verifyPageUrlTest(){
		
		Assert.assertTrue(aoep.verifyPageUrl());
		
	}
	
	//@Test(enabled=false)
	@Test(priority=4)
	public void clickAddOrganisationButtonTest(){
		
		Assert.assertTrue(aoep.clickAddOrganisationButton());
	}
	
	//@Test(enabled=false)
	@Test(priority=5)
	public void clickNextButtonTest(){
		
		System.out.println("Clicking on next");
		Assert.assertTrue(aoep.clickNextButton());
		
	}
	
	//@Test(enabled=false)
	@Test(priority=6,dependsOnMethods="clickNextButtonTest")
	public void clickPreviousButtonTest(){
		
		System.out.println("Clicking on previous");
		Assert.assertTrue(aoep.clickPreviousButton());
		
	}
	
	@AfterMethod
	public void tearDown() throws InterruptedException {
		Thread.sleep(5000);
		driver.quit();
	}

}
