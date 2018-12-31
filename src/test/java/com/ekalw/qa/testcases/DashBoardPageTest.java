package com.ekalw.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.ekalw.qa.base.TestBase;
import com.ekalw.qa.pages.DashBoardPage;
import com.ekalw.qa.pages.SignInPage;
import com.ekalw.qa.pages.WelcomePage;

public class DashBoardPageTest extends TestBase {
	WelcomePage welcomepage; // defined here so that we can use it throughout the class here.
	SignInPage signIn;
	DashBoardPage dashBoardPage;

	public DashBoardPageTest() {
		
		super(); //before calling initialization we need to call testbase constructor also as it reads files for initialization.
		
		}
	
	@BeforeMethod
	public void setUp() throws InterruptedException{
		
		initialization();
		welcomepage=new WelcomePage();
		signIn = new SignInPage(); //so that we can call all methods of signInPage class
		
		signIn = welcomepage.validateSignInPage();  //First takes to sign in page
		dashBoardPage = signIn.signInWithSimsId(prop.getProperty("username"), prop.getProperty("password")); //now sign in page takes to dashboard
	    //dashBoardPage=signIn.signInWithGoogleId(prop.getProperty("username"), prop.getProperty("password"));
		
	}
	
	@Test
	public void test(){
		
		System.out.println("Test comp");
		Assert.assertEquals(true, false);
	}
	
	@AfterMethod
	public void tearDown() throws InterruptedException {
		Thread.sleep(5000);
		driver.quit();
	}
	
	

}

