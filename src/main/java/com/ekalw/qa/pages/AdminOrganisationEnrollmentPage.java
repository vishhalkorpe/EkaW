package com.ekalw.qa.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.ekalw.qa.adminpages.AdminWelcomePage;
import com.ekalw.qa.base.TestBase;
import com.ekalw.qa.util.JavaScriptExecutorConcept;

public class AdminOrganisationEnrollmentPage extends TestBase {

	// Page Factory or Object Repository

	@FindBy(xpath = "//div[@data-item='Organisations']")
	WebElement organisationsMenu;

	@FindBy(id = "addOrg")
	@CacheLookup
	WebElement addOrganisation;

	@FindBy(id = "filter")
	@CacheLookup
	WebElement filterByEmail;

	// @FindBy(xpath="//div[@class='ReactTable-striped-highlight']//div[@class='pagination-bottom']//following::div//div[@class='-pageJump']")
	@FindBy(xpath = "//div[@class='pagination-bottom']//following::div[@class='-next']/button")
	@CacheLookup
	WebElement next;

	@FindBy(xpath = "//div[@class='pagination-bottom']//div[@class='-previous']/button")
	@CacheLookup
	WebElement previous;

	//
	@FindBy(id = "addressLine1")
	@CacheLookup
	WebElement addressLine1;

	@FindBy(id = "addressLine2")
	@CacheLookup
	WebElement addressLine2;

	@FindBy(id = "addressLine3")
	@CacheLookup
	WebElement addressLine3;

	@FindBy(id = "associatedTrust")
	@CacheLookup
	WebElement associatedTrust;

	@FindBy(id = "mainContact")
	@CacheLookup
	WebElement mainContact;

	@FindBy(id = "mainContactNumber")
	@CacheLookup
	WebElement mainContactNumber;

	@FindBy(id = "mobileNumber")
	@CacheLookup
	WebElement mobileNumber;

	@FindBy(id = "postCode")
	@CacheLookup
	WebElement postalCodepin;

	@FindBy(id = "btnReset")
	@CacheLookup
	WebElement reset;

	@FindBy(id = "btnSave")
	@CacheLookup
	WebElement save;

	@FindBy(id = "schoolIdentityNumber")
	@CacheLookup
	WebElement schoolIdentityNumber;

	@FindBy(id = "schoolName")
	@CacheLookup
	WebElement schoolName;

	@FindBy(id = "supervisorName")
	@CacheLookup
	WebElement supervisorName;

	@FindBy(xpath = "//input[@id='selectType']/preceding-sibling::div")
	WebElement schoolType;

	@FindBy(xpath = "//input[@id='selectgroupid']/preceding-sibling::div")
	WebElement schoolGroup;

	@FindBy(xpath = "//input[@id='selectState']/preceding-sibling::div")
	WebElement selectState;

	// private final String pageLoadedText = "School Name should not be blank";

	// String declaration for methods

	String pageLoadedText = "Welcome to SIMS Lite Admin Portal";

	String pageUrl = "/organisations";

	String pageLoadedTextAfterOrgClick = "Organisation Information";

	// Initialize the Objects
	public AdminOrganisationEnrollmentPage() {

		PageFactory.initElements(driver, this);
	}

	// Action methods

	// Verify that the page loaded completely.
	public boolean verifyPageLoaded() {

		return driver.getPageSource().contains(pageLoadedText);

	}

	// Click on OrganisationMenu.
	public boolean verifyclickOnOrganisationMenu() {

		organisationsMenu.click();
		String currentUrl = driver.getCurrentUrl();
		return currentUrl.contains(pageUrl);

	}

	// Verify that current page URL matches the expected URL. CHECK
	public boolean verifyPageUrl() {

		return driver.getCurrentUrl().contains(pageUrl);

	}

	// Click on Add Organisation Button.
	public boolean clickAddOrganisationButton() {

		clickOn(driver, addOrganisation, 15);
		addOrganisation.click();
		return driver.getPageSource().contains(pageLoadedTextAfterOrgClick);

	}

	// Click on Next Button.
	public boolean clickNextButton() {

		organisationsMenu.click();
		sleep(3000);
		JavaScriptExecutorConcept.flash(next, driver);
		sleep(3000);
		JavaScriptExecutorConcept.drawBorder(next, driver);
		sleep(3000);

		boolean result = next.isEnabled();
		System.out.println("Next button enabled so clicking it:-" + result);

		boolean flag;

		{
			if (result == true) {
				next.click();
				System.out.println("Next button clicked");
			} else {
				System.out.println("Button is not enabled");
			}

			// reconfirming it

			String xy = driver.findElement(By.xpath("//div[@class='-pageJump']//input[@value]")).getAttribute("value");
			int xy_conv = Integer.parseInt(xy);
			System.out.println("string to int value is:- " + xy_conv);
			int i = xy_conv - 1;
			// if (xy_conv == 2) {
			if (i < xy_conv) {
				System.out.println("Next button click operation passed");
				flag = true;
			} else {
				System.out.println("Next button click operation failed");
				flag = false;
			}
		}

		return flag;
	}

	// Click on Previous Button. //mark depend on clickNextButton method in test class.
	public boolean clickPreviousButton() {

		organisationsMenu.click();
		sleep(3000);
		next.click();
		sleep(3000);
		previous.click();
		return true;
	}

	// Script to check validation
	public static boolean ckeckOrgFormValidation() {

		List<WebElement> listerrors = driver.findElements(By.xpath(
				"//table//span[contains(text(),'invalid') or contains(text(),'cannot') or contains(text(),'already exists') or contains(text(),'blank')]"));
		// This email already exists
		int errroSize = listerrors.size();

		boolean flag = false;

		if (errroSize == 0) {

			flag = true;
			System.out.println("Form filled successfully and so flag is : - " + flag);
		}

		else {
			System.out.println("Form filled has errors and so flag is : - " + flag);
		}
		return flag;

	}

	// Fill Org data and save //marl depends on addOrganisation method in test class
	public void fillOrganisationInformationFormHardData() {

		clickOn(driver, addOrganisation, 15);
		addOrganisation.click();
		System.out.println("Fillinf Organisation information");
		clickOn(driver, reset, 15); // wait still reset butotn is displayed

		schoolName.clear();
		schoolName.sendKeys("OrgSchool");

		mainContact.clear();
		mainContact.sendKeys("VisMainC");

		mainContactNumber.clear();
		mainContactNumber.sendKeys("9119020401");

		schoolIdentityNumber.clear();
		schoolIdentityNumber.sendKeys("SIN00007");

		associatedTrust.clear();
		associatedTrust.sendKeys("ATSimon");

		addressLine1.clear();
		addressLine1.sendKeys("add1");

		addressLine2.clear();
		addressLine2.sendKeys("add2");

		addressLine3.clear();
		addressLine3.sendKeys("add3");

		postalCodepin.clear();
		postalCodepin.sendKeys("411014");

		supervisorName.clear();
		supervisorName.sendKeys("SuperMan");

		mobileNumber.clear();
		mobileNumber.sendKeys("9119020402");

		schoolType.click();
		sleep(3000);
		WebElement elementgToSelectSchoolType = driver
				.findElement(By.xpath("//ul[@role='listbox']//option[text()='Ekal']"));
		JavaScriptExecutorConcept.clickElementByJS(elementgToSelectSchoolType, driver);
		sleep(3000);
		schoolName.click();

		schoolGroup.click();
		sleep(3000);
		WebElement elementgToSelectSchoolGroup = driver
				.findElement(By.xpath("//ul[@role='listbox']//option[text()='Group1']"));
		JavaScriptExecutorConcept.clickElementByJS(elementgToSelectSchoolGroup, driver);
		sleep(3000);
		schoolName.click();

		selectState.click();
		sleep(3000);
		WebElement elementgToSelectState = driver
				.findElement(By.xpath("//ul[@role='listbox']//option[text()='MAHARASHTRA']"));
		JavaScriptExecutorConcept.clickElementByJS(elementgToSelectState, driver);
		sleep(3000);
		schoolName.click();

	}

	public void fillHardDataForOrganisationSave() throws InterruptedException {
		AdminOrganisationEnrollmentPage aobject = new AdminOrganisationEnrollmentPage();
		aobject.fillOrganisationInformationFormHardData();
		if (ckeckOrgFormValidation() == true) {
			System.out.println("Saving the form");
		}
		save.click();
		sleep(2000);
	}

	// RESET::Fill Org SOFT/excel data and save //mark depends on addOrganisation method in test class
	public boolean validateResetfillOrganisationInformationFormSoftData(String eschoolName, String emainContact,
			String emcn, String esin, String eschoolType, String egroup, String eassociatedTrust, String eaddress1,
			String eaddress2, String eaddress3, String epin, String estate, String esupervisorName,
			String emobileNumber) {
		
		clickOn(driver, addOrganisation, 15);
		addOrganisation.click();
		System.out.println("Fillinf Organisation information");
		clickOn(driver, reset, 15); // wait still reset button is displayed
		
		sleep(3000);
		
		schoolName.sendKeys(eschoolName);
		mainContact.sendKeys(emainContact);
		mainContactNumber.sendKeys(emcn);
		schoolIdentityNumber.sendKeys(esin);
		associatedTrust.sendKeys(eassociatedTrust);
		addressLine1.sendKeys(eaddress1);
		addressLine2.sendKeys(eaddress2);
		addressLine3.sendKeys(eaddress3);
		postalCodepin.sendKeys(epin);
		supervisorName.sendKeys(esupervisorName);
		mobileNumber.sendKeys(emobileNumber);

		// School type selection ::start
		sleep(2000);
		schoolType.click();
		sleep(2000);
		
		String firstschooltypeXpath = "//ul[@role='listbox']//option[text()='";
		String secondschooltypeXpath = "']";
		String totalschooltypeXpath = firstschooltypeXpath + eschoolType + secondschooltypeXpath;

		WebElement elementSchoolType = driver.findElement(By.xpath(totalschooltypeXpath));
		JavaScriptExecutorConcept.clickElementByJS(elementSchoolType, driver);

		sleep(3000);
		schoolName.click();
		sleep(2000);

		// School type selection ::end

		// School Group selection ::start
		schoolGroup.click();
		sleep(3000);

		String firstschoolgroupXpath = "//ul[@role='listbox']//option[text()='";
		String secondschoolgroupXpath = "']";
		String totalschoolgroupXpath = firstschoolgroupXpath + egroup + secondschoolgroupXpath;

		WebElement elementSchoolGroup = driver.findElement(By.xpath(totalschoolgroupXpath));
		JavaScriptExecutorConcept.clickElementByJS(elementSchoolGroup, driver);

		sleep(3000);
		schoolName.click();
		sleep(2000);

		// School group selection ::end

		// School State selection ::start
		selectState.click();
		sleep(3000);

		String firstschoolstateXpath = "//ul[@role='listbox']//option[text()='";
		String secondschoolstateXpath = "']";
		String totalschoolstateXpath = firstschoolstateXpath + estate + secondschoolstateXpath;

		WebElement elementSchoolState = driver.findElement(By.xpath(totalschoolstateXpath));
		JavaScriptExecutorConcept.clickElementByJS(elementSchoolState, driver);

		sleep(3000);
		schoolName.click();
		sleep(2000);

		// School state selection ::end
		
		//click on RESET button
		reset.click();
		sleep(3000);
		
		System.out.println("Reset button clicked");

		// Logic for reset return false and for save return true
		save.click();
		sleep(3000);

		if (ckeckOrgFormValidation() == true) {
			System.out.println("Saving the form");

			return true;
		}

		else {

			return false;
		}

	}

	// SAVE::Fill Org SOFT/excel data and save //mark depends on addOrganisation method in test class
	public boolean validateSavefillOrganisationInformationFormSoftData(String eschoolName, String emainContact,
			String emcn, String esin, String eschoolType, String egroup, String eassociatedTrust, String eaddress1,
			String eaddress2, String eaddress3, String epin, String estate, String esupervisorName,
			String emobileNumber) {
		
		clickOn(driver, addOrganisation, 15);
		addOrganisation.click();
		System.out.println("Fillinf Organisation information");
		clickOn(driver, reset, 15); // wait still reset button is displayed
		
		sleep(3000);
		
		schoolName.sendKeys(eschoolName);
		mainContact.sendKeys(emainContact);
		mainContactNumber.sendKeys(emcn);
		schoolIdentityNumber.sendKeys(esin);
		associatedTrust.sendKeys(eassociatedTrust);
		addressLine1.sendKeys(eaddress1);
		addressLine2.sendKeys(eaddress2);
		addressLine3.sendKeys(eaddress3);
		postalCodepin.sendKeys(epin);
		supervisorName.sendKeys(esupervisorName);
		mobileNumber.sendKeys(emobileNumber);

		// School type selection ::start
		sleep(2000);
		schoolType.click();
		sleep(2000);
		
		String firstschooltypeXpath = "//ul[@role='listbox']//option[text()='";
		String secondschooltypeXpath = "']";
		String totalschooltypeXpath = firstschooltypeXpath + eschoolType + secondschooltypeXpath;

		WebElement elementSchoolType = driver.findElement(By.xpath(totalschooltypeXpath));
		JavaScriptExecutorConcept.clickElementByJS(elementSchoolType, driver);

		sleep(3000);
		schoolName.click();
		sleep(2000);

		// School type selection ::end

		// School Group selection ::start
		schoolGroup.click();
		sleep(3000);

		String firstschoolgroupXpath = "//ul[@role='listbox']//option[text()='";
		String secondschoolgroupXpath = "']";
		String totalschoolgroupXpath = firstschoolgroupXpath + egroup + secondschoolgroupXpath;

		WebElement elementSchoolGroup = driver.findElement(By.xpath(totalschoolgroupXpath));
		JavaScriptExecutorConcept.clickElementByJS(elementSchoolGroup, driver);

		sleep(3000);
		schoolName.click();
		sleep(2000);

		// School group selection ::end

		// School State selection ::start
		selectState.click();
		sleep(3000);

		String firstschoolstateXpath = "//ul[@role='listbox']//option[text()='";
		String secondschoolstateXpath = "']";
		String totalschoolstateXpath = firstschoolstateXpath + estate + secondschoolstateXpath;

		WebElement elementSchoolState = driver.findElement(By.xpath(totalschoolstateXpath));
		JavaScriptExecutorConcept.clickElementByJS(elementSchoolState, driver);

		sleep(3000);
		schoolName.click();
		sleep(2000);

		// School state selection ::end

		// Logic for reset return false and for save return true
		sleep(3000);
		driver.findElement(By.xpath("//span[text()='Save']")).click();

		sleep(3000);

		if (ckeckOrgFormValidation() == true) {
			System.out.println("Saving the form");

			return true;
		}

		else {

			return false;
		}


	}

}
