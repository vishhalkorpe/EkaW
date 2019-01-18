package com.ekalw.qa.testcases;

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
import com.ekalw.qa.util.TestNGCustomListener;

@Listeners(TestNGCustomListener.class)   //calling listener to get screenshot.
public class SchoolSummaryPageTest extends TestBase{
		
		WelcomePage welcomepage; // defined here so that we can use it throughout the class here.
		SignInPage signIn;
		DashBoardPage dashBoardPage;
		ClusterDetailsPage clusterDetailsPage;
		SchoolSummaryPage schoolSummaryPage;
		TeacherEnrollmentDetailsPage teacherEnrollmentDetailsPage;
		StudentEnrollmentDetailsPage studentEnrollmentDetailsPage;
		
		
		public SchoolSummaryPageTest() {
			super(); // before calling initialization we need to call testbase constructor also as it reads files for initialization.

		}
		
		@BeforeMethod
		public void setUp() throws InterruptedException {

			initialization(); // calling initialization from testbase class
			welcomepage = new WelcomePage(); // so that we can access all methods of WelcomePage class
			
			signIn = welcomepage.validateSignInPage(); // First takes to sign in page
			dashBoardPage = signIn.signInWithSimsId(prop.getProperty("username"), prop.getProperty("password")); // now sign in page takes to dashboard.
			//clusterDetailsPage = dashBoardPage.validateClusterDashboardClick(); //dashboard takes to clusterdetails page.
			schoolSummaryPage = dashBoardPage.verifySchoolsDashboardClick();
			
		}
		
		@AfterMethod
		public void tearDown() throws InterruptedException {
			Thread.sleep(5000);
			driver.quit();
		}
		
		@Test(enabled=false)
		public void verifyPageUrlTest(){

			boolean b=schoolSummaryPage.verifyPageUrl();
			Assert.assertTrue(b);
			
		}
		
		@Test(priority=2)
		public void verifyPageLoadedTest(){

			Assert.assertTrue(schoolSummaryPage.verifyPageLoaded());
			
			
		}
		
		@Test(priority=3)
		public void clickATestSchoolSomewhereLinkTest(){

			Assert.assertTrue(schoolSummaryPage.clickATestSchoolSomewhereLink());
			
		}
		
		@Test(priority=4)
		public void clickDuageSchoolLinkTest(){

			Assert.assertTrue(schoolSummaryPage.clickDuageSchoolLink());
			
			
		}
		
		@Test(priority=5)
		public void clickZyucvSchoolLinkTest(){

			Assert.assertTrue(schoolSummaryPage.clickZyucvSchoolLink());
			
			
		}
}
