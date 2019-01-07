package com.ekalw.qa.testcases;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.ekalw.qa.base.TestBase;
import com.ekalw.qa.pages.ClusterDetailsPage;
import com.ekalw.qa.pages.DashBoardPage;
import com.ekalw.qa.pages.SchoolSummaryPage;
import com.ekalw.qa.pages.SignInPage;
import com.ekalw.qa.pages.StudentEnrollmentDetailsPage;
import com.ekalw.qa.pages.TeacherEnrollmentDetailsPage;
import com.ekalw.qa.pages.WelcomePage;

public class ClusterDetailsPageTest extends TestBase {
	
	//
	WelcomePage welcomepage; // defined here so that we can use it throughout the class here.
	SignInPage signIn;
	DashBoardPage dashBoardPage;
	ClusterDetailsPage clusterDetailsPage;
	SchoolSummaryPage schoolSummaryPage;
	TeacherEnrollmentDetailsPage teacherEnrollmentDetailsPage;
	StudentEnrollmentDetailsPage studentEnrollmentDetailsPage;
	
	//
	public ClusterDetailsPageTest() {
		// Before Initialization step
		super();
	}
	
	@BeforeMethod
	public void setUp() throws InterruptedException {

		initialization(); // calling initialization from testbase class
		welcomepage = new WelcomePage(); // so that we can access all methods of WelcomePage class
		
		signIn = welcomepage.validateSignInPage(); // First takes to sign in page
		dashBoardPage = signIn.signInWithSimsId(prop.getProperty("username"), prop.getProperty("password")); // now sign in page takes to dashboard.
		clusterDetailsPage = dashBoardPage.validateClusterDashboardClick(); //dashboard takes to clusterdetails page.
		sleep(5000);
	}

	//@Test(enabled=false)
	@Test(priority=1)
	public void verifyPageUrlTest(){

		boolean b=clusterDetailsPage.verifyPageUrl();
		Assert.assertTrue(b);
		

	}
	
	@Test(priority=2)
	//@Test(enabled=false)
		public void click1Link33Test(){

		Assert.assertTrue(clusterDetailsPage.click1Link33());
		
	}
	
	@Test(priority=3)
	public void togetvalue(){
		
		clusterDetailsPage.click1Link33();
		sleep(4000);

		String count=driver.findElement(By.xpath("//div/h2[starts-with(text(),'School')]")).getAttribute("innerhtml");
				
		System.out.println("COunt is : "+count);  
		
		sleep(4000);
		
		String texcount=driver.findElement(By.xpath("//div/h2[starts-with(text(),'School')]")).getText();
		
		System.out.println("texCOunt is : "+texcount); 
		
		sleep(4000);
		
		String attrcount=driver.findElement(By.xpath("//div/h2[starts-with(text(),'School')]")).getAttribute("value");
		
		System.out.println("texCOunt is : "+attrcount);
		
		sleep(4000);
		
		String tagnamecount=driver.findElement(By.xpath("//div/h2[starts-with(text(),'School')]")).getTagName();
		
		System.out.println("texCOunt is : "+tagnamecount);
		
		sleep(4000);
		
		String tacount=driver.findElement(By.xpath("//div/h2[starts-with(text(),'School')]")).getCssValue("v");
		
		System.out.println("texCOunt is : "+tagnamecount);
		
	}
	
	
	
	@AfterMethod
	public void tearDown() throws InterruptedException {
		Thread.sleep(5000);
		driver.quit();
	}

}
