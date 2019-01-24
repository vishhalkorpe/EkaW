package com.ekalw.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.ekalw.qa.base.TestBase;

public class DashBoardPage extends TestBase{

	// Page Factory or Object Repository
	@FindBy(xpath=".//button[@type='button']//div//h2[contains(text(),'Clusters')]")
	WebElement clusterDashboardButton;
	
	@FindBy(xpath=".//button//div//h2[contains(text(),'Schools')]")
	WebElement schoolsDashboardButton;
	
	@FindBy(xpath=".//button//div//h2[contains(text(),'Teachers')]")
	WebElement teachersDashboardButton;
	
	@FindBy(xpath=".//button//div//h2[contains(text(),'Students')]")
	WebElement studentsDashboardButton;
	
	@FindBy(xpath="")
	WebElement clickClusterName;
	
	@FindBy(xpath="")
	WebElement clickClusterHead;
	
	@FindBy(xpath="")
	WebElement clickVillageCount;
	
	

	// Initializing the Page Object
	public DashBoardPage() {
		PageFactory.initElements(driver, this);
	}
	
		

	// Actions
	
	public ClusterDetailsPage verifyClusterDashboardClick(){
		
		clusterDashboardButton.click();
		
		return new ClusterDetailsPage();
	}
	
	public SchoolSummaryPage verifySchoolsDashboardClick(){
		
		schoolsDashboardButton.click();
		
		return new SchoolSummaryPage();
	}
	
	public TeacherEnrollmentDetailsPage verifyTeachersDashboardClick(){
		
		teachersDashboardButton.click();
		
		return new TeacherEnrollmentDetailsPage();
	}
	
	public StudentEnrollmentDetailsPage verifyStudentDashboardClick(){
		
		studentsDashboardButton.click();
		
		return new StudentEnrollmentDetailsPage();
	}
	
	//******************************All action methods for below will be created***********************//
	
	// path=//a[@href='/clusterLoc']/li[@role='menuitem'] OR /html/body/div[2]/div[2]/div/a[3]
	//OR path=//div[@role='document']//a[@href='/clusters']/li[@role='menuitem']

	//1. Click on Clusters 33there Are 33 Clusters In Maharastra That Are Govern By Ekal.
	     //https://cecilweb.azurewebsites.net/clusters

	//2. Click on Schools 319there Are 319 Schools Across The Clusters.

	//3. Click on Show On Map1 Button.

	//4. Click on Sims India Link.

	//5. Click on Students 557there Are Total 557 Students Enrolled In The Schools

	// Click on Teachers 136there Are 136 Teachers Working Across All The Schools

	// Verify that the page loaded completely.String pageLoadedText = "There are 136 teachers working across all the schools";

	// Click on App Crash Report Link.

	// Click on Application Error Logs Link

	// Click on Attendance Summary Link

	// Click on Cluster Details Link.

	// Click on Cluster Locations Link.

	// Click on Customer Feedback Report Link

	// Click on Devices Summary Link.

	// Click on School Details Link.

	// Click on School Summary Link.

	// Click on Sims India Link.

	// Click on Student Absence Report Link.

	// Click on Students Registrations Link.

	// Click on Teachers Registrations Link.

	// Click on Tree Chart Link.

	// Click on Tree Example Link.

}
