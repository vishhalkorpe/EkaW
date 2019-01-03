package com.ekalw.qa.pages;

import org.openqa.selenium.support.PageFactory;

import com.ekalw.qa.base.TestBase;

public class DashBoardPage extends TestBase {

	// Page Factory or Object Repository
	
	
	
	

	// Initializing the Page Object
	public DashBoardPage() {
		PageFactory.initElements(driver, this);
	}
	
	
	

	// Actions
	
	//******************************All action methods for below will be created***********************//
	
	// path=//a[@href='/clusterLoc']/li[@role='menuitem'] OR /html/body/div[2]/div[2]/div/a[3]
	//OR path=//div[@role='document']//a[@href='/clusters']/li[@role='menuitem']

	//1. Click on Clusters 33there Are 33 Clusters In Maharastra That Are Govern By Ekal.

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
