package com.ekalw.qa.testcases;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.ekalw.qa.base.TestBase;
import com.ekalw.qa.pages.ClusterDetailsPage;
import com.ekalw.qa.pages.DashBoardPage;
import com.ekalw.qa.pages.SchoolSummaryPage;
import com.ekalw.qa.pages.SignInPage;
import com.ekalw.qa.pages.StudentEnrollmentDetailsPage;
import com.ekalw.qa.pages.TeacherEnrollmentDetailsPage;
import com.ekalw.qa.pages.WelcomePage;
import com.ekalw.qa.util.GTakeScreenshot;
import com.ekalw.qa.util.TestNGCustomListener;

@Listeners(TestNGCustomListener.class)   //calling listener to get screenshot.
public class ClusterDetailsPageTest extends TestBase {
	
	WelcomePage welcomepage; // defined here so that we can use it throughout the class here.
	SignInPage signIn;
	DashBoardPage dashBoardPage;
	ClusterDetailsPage clusterDetailsPage;
	SchoolSummaryPage schoolSummaryPage;
	TeacherEnrollmentDetailsPage teacherEnrollmentDetailsPage;
	StudentEnrollmentDetailsPage studentEnrollmentDetailsPage;
	
	
	public ClusterDetailsPageTest() {
		super(); // before calling initialization we need to call testbase constructor also as it reads files for initialization.

	}
	
	@BeforeMethod
	public void setUp() throws InterruptedException {

		initialization(); // calling initialization from testbase class
		welcomepage = new WelcomePage(); // so that we can access all methods of WelcomePage class
		
		signIn = welcomepage.validateSignInPage(); // First takes to sign in page
		dashBoardPage = signIn.signInWithSimsId(prop.getProperty("username"), prop.getProperty("password")); // now sign in page takes to dashboard.
		clusterDetailsPage = dashBoardPage.validateClusterDashboardClick(); //dashboard takes to clusterdetails page.
		
	}

	//@Test(enabled=false)
	@Test(priority=1)
	public void verifyPageUrlTest(){

		boolean b=clusterDetailsPage.verifyPageUrl();
		Assert.assertTrue(b);
		
	}
	
	//@Test(enabled=false)
	@Test(priority=2,dependsOnMethods = { "verifyPageUrlTest" })
	public void click1Link33Test(){

		Assert.assertTrue(clusterDetailsPage.click1Link33());
		String actual=driver.getCurrentUrl();
		String url="https://cecilweb.azurewebsites.net/villageList#";
		Assert.assertEquals(actual, url);
		
	}
	
	@Test(priority=3,dependsOnMethods = { "verifyPageUrlTest" })
	public void clickBilgaonLinkTest() throws Exception{
		
		Assert.assertTrue(clusterDetailsPage.clickBilgaonLink());
		String actual=driver.getCurrentUrl();
		String url="https://cecilweb.azurewebsites.net/villages#";
		Assert.assertEquals(actual, url);
		sleep(3000);
		GTakeScreenshot.takeSnapShot(driver,"D:\\WorkSpace\\Ekal\\EkalW\\Screenshots\\bilgaonscreen.jpg");	
	}
	
	@Test(priority=4,dependsOnMethods = { "verifyPageUrlTest" })
	public void clickMolgiLinkTest() throws Exception{
		
		Assert.assertTrue(clusterDetailsPage.clickMolgiLink());
		sleep(3000);
		GTakeScreenshot.takeSnapShot(driver,"D:\\WorkSpace\\Ekal\\EkalW\\Screenshots\\molgiscreen.jpg");	
	}
	
	@Test(priority=5,dependsOnMethods="verifyPageUrlTest")
	public void verifyClusterHeadTest(){
		
		boolean result=clusterDetailsPage.verifyClusterHead();
		Assert.assertTrue(result);
		
	}
	
	@Test(priority=6,dependsOnMethods="verifyPageUrlTest")
	public void verifyClusterHeadRandomTest() throws Exception{
		
		boolean flag=clusterDetailsPage.verifyClusterHeadRandom();
		Assert.assertEquals(flag, true);
		
	}
	
	
	@AfterMethod
	public void tearDown() throws InterruptedException {
		Thread.sleep(5000);
		driver.quit();
	}

}
