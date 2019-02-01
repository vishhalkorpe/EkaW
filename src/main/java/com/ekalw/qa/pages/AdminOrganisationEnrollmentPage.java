package com.ekalw.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

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

	// @FindBy(xpath="//div[@class='ReactTable -striped-highlight']//div[@class='pagination-bottom']//following::div//div[@class='-pageJump']")
	@FindBy(xpath = "//div[@class='pagination-bottom']//following::div[@class='-next']/button")
	@CacheLookup	
	WebElement next;

	@FindBy(xpath = "//div[@class='pagination-bottom']//div[@class='-previous']/button")
	@CacheLookup
	WebElement previous;

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
			if(result == true) {
				next.click();
				System.out.println("Next button clicked");
			}else {
				System.out.println("Button is not enabled");
				  }
			
			//reconfirming it 
			
			String xy = driver.findElement(By.xpath("//div[@class='-pageJump']//input[@value]")).getAttribute("value");
			int xy_conv = Integer.parseInt(xy);
			System.out.println("string to int value is:- " + xy_conv);

			if (xy_conv == 2) {
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

}
