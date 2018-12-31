package com.ekalw.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.ekalw.qa.base.TestBase;

public class WelcomePage extends TestBase {

	// Page Factory or Object Repository

	@FindBy(xpath = ".//span[contains(text(),'Login With SIMS ID')]")
	WebElement loginWithSimsId;

	// Initializing the Page Object

	public WelcomePage() {

		PageFactory.initElements(driver, this);
	}
	
	//Actions
	
	public String validateWelcomePageTitle(){
		
		return driver.getTitle();
		
	} //Home
	
	public SignInPage validateSignInPage(){
		
		loginWithSimsId.click();				
		return new SignInPage(); //this is returning SignIn page
	} 
	
	
	

}
