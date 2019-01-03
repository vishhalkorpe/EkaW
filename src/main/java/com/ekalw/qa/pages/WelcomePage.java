package com.ekalw.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.ekalw.qa.base.TestBase;

public class WelcomePage extends TestBase {

	// Page Factory or Object Repository

	@FindBy(xpath = ".//span[contains(text(),'Login With SIMS ID')]")
	WebElement loginWithSimsId;
	
	@FindBy(xpath="//div/h1[contains(text(),'Welcome to SIMS-I Reporting Tool')]")
	WebElement pageLoadedText;

	// Initializing the Page Object

	public WelcomePage() {

		PageFactory.initElements(driver, this);
	}
	
	//Actions
	
	/*
     * Verify that the page title.
     */
	public String validateWelcomePageTitle(){
		
		return driver.getTitle();
		
	} //Home
	
	/*
     * Verify that the page loaded completely.
     */
	public boolean validatePageLoaded(){ 
		
		String pageLoadedText = "Welcome to SIMS-I Reporting Tool";
	
		return driver.getPageSource().contains(pageLoadedText);
				                
            }
	
	/**
     * Click on Login With Sims Id Button.
     *
     * @return the SignInPage class instance.
     */
	public SignInPage validateSignInPage(){
		
		loginWithSimsId.click();				
		return new SignInPage(); //this is returning SignIn page
	} 
	
	}
