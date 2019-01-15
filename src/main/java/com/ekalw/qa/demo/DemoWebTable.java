package com.ekalw.qa.demo;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
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

public class DemoWebTable extends TestBase {
	
	WelcomePage welcomepage; // defined here so that we can use it throughout the class here.
	SignInPage signIn;
	DashBoardPage dashBoardPage;
	ClusterDetailsPage clusterDetailsPage;
	SchoolSummaryPage schoolSummaryPage;
	TeacherEnrollmentDetailsPage teacherEnrollmentDetailsPage;
	StudentEnrollmentDetailsPage studentEnrollmentDetailsPage;

	public DemoWebTable() {

		super();
	}

	@BeforeMethod
	public void setUp() throws InterruptedException {

		initialization();
		welcomepage = new WelcomePage(); // so that we can access all methods of WelcomePage class
		
		signIn = welcomepage.validateSignInPage(); // First takes to sign in page
		dashBoardPage = signIn.signInWithSimsId(prop.getProperty("username"), prop.getProperty("password")); // now sign in page takes to dashboard.
		clusterDetailsPage = dashBoardPage.validateClusterDashboardClick(); //dashboard takes to clusterdetails page.
		sleep(5000);
	}

			///***********For specific string i mentioned from table*****************///
	@Test(enabled=false)
	public void test1(){
		
		List<WebElement> rows =driver.findElements(By.xpath("//*[@id='root']/div/div[1]/table/tbody/tr"));
		int rowCount=rows.size();
		System.out.println("Total rows in table is "+rowCount);
		
		String beforexpath="//*[@id='root']/div/div[1]/table/tbody/tr[";
		String afterxpath="]/td[1]";
		String pecedingpath="//preceding-sibling::th/a";
		String followingpath="//following-sibling::th/a";
		
			
		for(int i=1; i<=rowCount; i++){
			
			String name ="Dhondiram";
			
			String actualxpath=beforexpath + i +afterxpath;
								
			String precedingpathtotal= actualxpath + pecedingpath;
						
			String followingpathtotal= actualxpath + followingpath;
						
			WebElement element=driver.findElement(By.xpath(actualxpath));
					
			if(element.getText().contains(name)){
				
				System.out.println("data of table cluster head: "+element.getText()+" is found "+"at position: "+i);
				
				sleep(6000);
				
				driver.findElement(By.xpath(precedingpathtotal)).click();
				
				sleep(6000);
				
				System.out.println("did click on precedingtotalpath");
				
				driver.findElement(By.xpath("//button[contains(text(),'Back')]")).click();
				driver.findElement(By.xpath("//button[contains(text(),'Back')]")).click();
								
				//driver.navigate().back();
				//driver.navigate().back();
				
				sleep(6000);
				
				driver.findElement(By.xpath(followingpathtotal)).click();
				
				sleep(6000);
				
				System.out.println("did click on followingxpath");
				
				driver.findElement(By.xpath("//button[contains(text(),'Back')]")).click();
				driver.findElement(By.xpath("//button[contains(text(),'Back')]")).click();
				
											
				break;
			}
		}
		
	}
	
	
				///***********For random string from row table*****************///
	@Test
	public void test2(){
		
		List<WebElement> rows =driver.findElements(By.xpath("//*[@id='root']/div/div[1]/table/tbody/tr"));
		int rowCount=rows.size();
		System.out.println("Total rows in table is "+rowCount);
				
		String row4used="//*[@id='root']/div/div[1]/table/tbody/tr[4]";
		String precedingpath="/td[1]//preceding-sibling::th/a";
		String followingpath="/td[1]//following-sibling::th/a";
		String backBtn="//button[contains(text(),'Back')]";
		
		String actualclusterHeadused=driver.findElement(By.xpath(row4used)).getText();
		
		WebElement ele= driver.findElement(By.xpath(row4used));
		
		System.out.println("clusterHeadused is " +actualclusterHeadused);
		
				
		//-->>  now robot have to click hyperlinks 'Cluster Name' and 'Village Count' of 'Cluster Head' used above.  <<--//
		
		if(ele.getText().contains(actualclusterHeadused))
		
		driver.findElement(By.xpath(row4used+precedingpath)).click();
		sleep(10000);
		driver.findElement(By.xpath(backBtn)).click();
		driver.findElement(By.xpath(backBtn)).click();
		sleep(5000);
		driver.findElement(By.xpath(row4used+followingpath)).click();
		sleep(10000);
		driver.findElement(By.xpath(backBtn)).click();
		driver.findElement(By.xpath(backBtn)).click();
		
	}
	
	
	
	
	@AfterMethod
	public void tearDown() {
		
		//driver.quit();
	}
}
