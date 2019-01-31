package com.ekalw.qa.testcases;

import java.util.ArrayList;
import java.util.Iterator;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.ekalw.qa.base.TestBase;
import com.ekalw.qa.pages.AdminTeacherEnrollmentPage;
import com.ekalw.qa.pages.DashBoardPage;
import com.ekalw.qa.pages.SignInPage;
import com.ekalw.qa.pages.WelcomePage;
import com.ekalw.qa.util.TeachersDataUtil;

public class AdminTeacherEnrollmentPageTest extends TestBase {
	
	WelcomePage welcomepage; // defined here so that we can use it throughout the class here.
	SignInPage signIn;
	AdminTeacherEnrollmentPage atep;
	DashBoardPage dashBoardPage;
	
	public AdminTeacherEnrollmentPageTest(){
		
		super();
	}
	
	@BeforeMethod
	public void setUp() throws InterruptedException{
		
		initialization();
		welcomepage = new WelcomePage();
		signIn = new SignInPage(); // so that we can call all methods of signInPage class
		dashBoardPage = new DashBoardPage();
		atep= new AdminTeacherEnrollmentPage();
		
		signIn = welcomepage.validateSignInPage(); // First takes to sign in page
		sleep(5000);
		dashBoardPage = signIn.signInWithSimsId(prop.getProperty("username"), prop.getProperty("password")); // now sign in page takes to dashboard.
																												
		// dashBoardPage=signIn.signInWithGoogleId(prop.getProperty("username"),prop.getProperty("password"));

	}
	
	@Test(enabled=false)
	//@Test(priority=1)
	public void verifyLoginPageTitleTest(){
		
		String loginPageTitleexpected="Home";
		
		String actual=atep.verifyLoginPageTitle();
		
		Assert.assertEquals(actual,loginPageTitleexpected);
	}
	
	@Test(enabled=false)
	//@Test(priority=2)
	public void verifyclickOnTeacherMenuTest(){
		
		Assert.assertTrue(atep.verifyclickOnTeacherMenu());
	}
	
	@Test(enabled=false)
	//@Test(priority=3,dependsOnMethods = "verifyclickOnTeacherMenuTest")
	public void clickAddTeacherTest(){
		
		Assert.assertTrue(atep.clickAddTeacher());
	}
	
	@DataProvider
	public Iterator<Object[]> getTestTeacherData(){
		
		ArrayList<Object[]> testDataTeacher= TeachersDataUtil.getTeacherSaveDataFromExcel();
		return testDataTeacher.iterator();
	}
	
	@DataProvider
	public Iterator<Object[]> getResetTeacherData(){
		
		ArrayList<Object[]> testDataTeacher= TeachersDataUtil.getTeacherResetDataFromExcel();
		return testDataTeacher.iterator();
	}
	
	//@Test(enabled=false)
	@Test(dataProvider="getResetTeacherData")
	//@Test(priority=4,dataProvider="getResetTeacherData",dependsOnMethods = "clickAddTeacherTest")
	public void clickResetTeacherEnrollmentFormButtonTest(String firstname,String lastname,String mobilenumber,String emailid,String aadharnumber,String addressline1,String addressline2,String addressline3,String postalcode,String gender,String dob,String slectorganisation,String selectstate){
		
		Assert.assertEquals((atep.clickResetTeacherEnrollmentFormButton(firstname, lastname, mobilenumber, emailid, aadharnumber, addressline1, addressline2, addressline3, postalcode, gender, dob, slectorganisation, selectstate)),false);
		sleep(5000);
	}
	
	@Test(enabled=false)
	//@Test(priority=5,dataProvider="getTestTeacherData",dependsOnMethods = "clickAddTeacherTest")
	//@Test(dataProvider="getTestTeacherData")
	public void clickSaveTeacherEnrollmentFormButtonTest(String firstname,String lastname,String mobilenumber,String emailid,String aadharnumber,String addressline1,String addressline2,String addressline3,String postalcode,String gender,String dob,String slectorganisation,String selectstate){
		Assert.assertEquals((atep.clickSaveTeacherEnrollmentFormButton(firstname, lastname, mobilenumber, emailid, aadharnumber, addressline1, addressline2, addressline3, postalcode, gender, dob, slectorganisation, selectstate)),true);
		sleep(5000);

	    }
	
	@Test(enabled=false)
	//@Test(priority=6,dependsOnMethods = "clickAddTeacherTest")
	public void verifySearchTeacherByEmailidTest(){
		atep.verifyclickOnTeacherMenu();
		Assert.assertTrue(atep.validateTeacherSearchByEmaiid());
		
		
	}
	
	@Test(enabled=false)
	//@Test(priority=7,dependsOnMethods = "clickAddTeacherTest")
	public void verifysearchTeacherBynameTest(){
		atep.verifyclickOnTeacherMenu();
		Assert.assertTrue(atep.validatesearchTeacherByname());
		
		
	}
	
	@Test(enabled=false)
	//@Test(priority=8,dependsOnMethods = "verifyclickOnTeacherMenuTest")
	public void deleteTeacherRandomTest(){
		atep.verifyclickOnTeacherMenu();
		Assert.assertTrue(atep.deleteTeacherRandom());
		
	}
	
	@AfterMethod
	public void tearDown() throws InterruptedException {
		Thread.sleep(5000);
		driver.quit();
	}
	
}
