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
import com.ekalw.qa.util.TeachersDataUtil;

public class AdminTeacherEnrollmentPageTest extends TestBase {
	
	AdminTeacherEnrollmentPage atep;
	
	public AdminTeacherEnrollmentPageTest(){
		
		super();
	}
	
	@BeforeMethod
	public void setUp(){
		
		initialization();
		
		atep= new AdminTeacherEnrollmentPage();
	}
	
	//@Test(enabled=false)
	@Test(priority=1)
	public void verifyLoginPageTitleTest(){
		
		String loginPageTitleexpected="Home";
		
		String actual=atep.verifyLoginPageTitle();
		
		Assert.assertEquals(actual,loginPageTitleexpected);
	}
	
	//@Test(enabled=false)
	@Test(priority=2)
	public void verifyclickOnTeacherMenuTest(){
		
		Assert.assertTrue(atep.verifyclickOnTeacherMenu());
	}
	
	//@Test(enabled=false)
	@Test(priority=3,dependsOnMethods = "verifyclickOnTeacherMenuTest")
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
	//@Test(dataProvider="getResetTeacherData")
	@Test(priority=4,dataProvider="getResetTeacherData",dependsOnMethods = "clickAddTeacherTest")
	public void clickResetTeacherEnrollmentFormButtonTest(String firstname,String lastname,String mobilenumber,String emailid,String aadharnumber,String addressline1,String addressline2,String addressline3,String postalcode,String gender,String dob,String slectorganisation,String selectstate){
		
		Assert.assertEquals((atep.clickResetTeacherEnrollmentFormButton(firstname, lastname, mobilenumber, emailid, aadharnumber, addressline1, addressline2, addressline3, postalcode, gender, dob, slectorganisation, selectstate)),false);
		sleep(5000);
	}
	
	//@Test(enabled=false)
	@Test(priority=5,dataProvider="getTestTeacherData",dependsOnMethods = "clickAddTeacherTest")
	//@Test(dataProvider="getTestTeacherData")
	public void clickSaveTeacherEnrollmentFormButtonTest(String firstname,String lastname,String mobilenumber,String emailid,String aadharnumber,String addressline1,String addressline2,String addressline3,String postalcode,String gender,String dob,String slectorganisation,String selectstate){
		Assert.assertEquals((atep.clickSaveTeacherEnrollmentFormButton(firstname, lastname, mobilenumber, emailid, aadharnumber, addressline1, addressline2, addressline3, postalcode, gender, dob, slectorganisation, selectstate)),true);
		sleep(5000);

	    }
	
	@Test(priority=6,dependsOnMethods = "clickAddTeacherTest")
	public void verifySearchTeacherByEmailidTest(){
		atep.verifyclickOnTeacherMenu();
		Assert.assertTrue(atep.validateTeacherSearchByEmaiid());
		
		
	}
	
	@Test(priority=7,dependsOnMethods = "clickAddTeacherTest")
	public void verifysearchTeacherBynameTest(){
		atep.verifyclickOnTeacherMenu();
		Assert.assertTrue(atep.validatesearchTeacherByname());
		
		
	}
	
	@AfterMethod
	public void tearDown() throws InterruptedException {
		Thread.sleep(5000);
		driver.quit();
	}
	
}
