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

@Listeners(TestNGCustomListener.class)
public class DashBoardPageTest extends TestBase {
	WelcomePage welcomepage; // defined here so that we can use it throughout the class here.
	SignInPage signIn;
	DashBoardPage dashBoardPage;
	ClusterDetailsPage clusterDetailsPage;
	SchoolSummaryPage schoolSummaryPage;
	TeacherEnrollmentDetailsPage teacherEnrollmentDetailsPage;
	StudentEnrollmentDetailsPage studentEnrollmentDetailsPage;

	public DashBoardPageTest() {

		super(); // before calling initialization we need to call testbaseconstructor also as it reads files for initialization.

	}

	@BeforeMethod
	public void setUp() throws InterruptedException {

		initialization();
		welcomepage = new WelcomePage();
		signIn = new SignInPage(); // so that we can call all methods of signInPage class
		dashBoardPage = new DashBoardPage();

		signIn = welcomepage.validateSignInPage(); // First takes to sign in page
		dashBoardPage = signIn.signInWithSimsId(prop.getProperty("username"), prop.getProperty("password")); // now sign in page takes to dashboard.
		sleep(5000);																										
		// dashBoardPage=signIn.signInWithGoogleId(prop.getProperty("username"),prop.getProperty("password"));

	}

	@Test
	public void validateClusterDashboardClickTest() {

		System.out.println("Test clusterDetailsPage");
		clusterDetailsPage = dashBoardPage.validateClusterDashboardClick();
		System.out.println("Landing to clusterDetailsPage");

	}

	@Test
	public void validateSchoolsDashboardClickTest() {

		System.out.println("Test schoolSummaryPage");
		schoolSummaryPage = dashBoardPage.validateSchoolsDashboardClick();
		System.out.println("Landing to schoolSummaryPage");
	}

	@Test
	public void validateTeachersDashboardClickTest() {

		System.out.println("Test teacherEnrollmentDetailsPage");
		teacherEnrollmentDetailsPage = dashBoardPage.validateTeachersDashboardClick();
		System.out.println("Landing to teacherEnrollmentDetailsPage");
	}

	@Test
	public void validateStudentDashboardClickTest() {

		System.out.println("Test studentEnrollmentDetailsPage");
		studentEnrollmentDetailsPage = dashBoardPage.validateStudentDashboardClick();
		System.out.println("Landing to studentEnrollmentDetailsPage");

	}

	@AfterMethod
	public void tearDown() throws InterruptedException {
		Thread.sleep(5000);
		driver.quit();
	}

}
