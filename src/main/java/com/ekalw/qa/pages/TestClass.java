package com.ekalw.qa.pages;
	import java.util.regex.Pattern;
	import java.util.concurrent.TimeUnit;
	import org.testng.annotations.*;

import com.ekalw.qa.base.TestBase;

import static org.testng.Assert.*;
	import org.openqa.selenium.*;
	import org.openqa.selenium.firefox.FirefoxDriver;
	import org.openqa.selenium.support.ui.Select;

	public class TestClass extends TestBase {
	  
	  private boolean acceptNextAlert = true;
	  private StringBuffer verificationErrors = new StringBuffer();

	  WelcomePage welcomepage; // defined here so that we can use it throughout the class here.
		SignInPage signIn;
		DashBoardPage dashBoardPage;

		public TestClass() {

			super(); // before calling initialization we need to call testbase constructor also, as it reads file for initialization.
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
	  public void testDash() throws Exception {
	    //driver.get("https://cecilweb.azurewebsites.net/login");
	    //sleep(5000);
	    //driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Welcome to SIMS-I Reporting Tool'])[1]/following::span[1]")).click();
	    sleep(5000);
	    driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Show on Map'])[1]/following::h2[1]")).click();
	    sleep(5000);
	    driver.findElement(By.linkText("33")).click();
	    sleep(5000);
	    driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='School Count : 33'])[1]/following::button[1]")).click();
	    sleep(5000);
	    driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='School Count : 33'])[1]/following::button[1]")).click();
	    sleep(5000);
	    driver.findElement(By.linkText("Molgi")).click();
	    sleep(5000);
	    driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='School Count : 33'])[1]/following::button[1]")).click();
	    sleep(5000);
	    driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='School Count : 33'])[1]/following::button[1]")).click();
	  }

	  @AfterMethod
	  public void tearDown() throws Exception {
	    driver.quit();
	    String verificationErrorString = verificationErrors.toString();
	    if (!"".equals(verificationErrorString)) {
	      fail(verificationErrorString);
	    }
	  }

	  private boolean isElementPresent(By by) {
	    try {
	      driver.findElement(by);
	      return true;
	    } catch (NoSuchElementException e) {
	      return false;
	    }
	  }

	  private boolean isAlertPresent() {
	    try {
	      driver.switchTo().alert();
	      return true;
	    } catch (NoAlertPresentException e) {
	      return false;
	    }
	  }

	  private String closeAlertAndGetItsText() {
	    try {
	      Alert alert = driver.switchTo().alert();
	      String alertText = alert.getText();
	      if (acceptNextAlert) {
	        alert.accept();
	      } else {
	        alert.dismiss();
	      }
	      return alertText;
	    } finally {
	      acceptNextAlert = true;
	    }
	  }
	}
