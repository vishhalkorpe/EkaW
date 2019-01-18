package com.ekalw.qa.pages;

import java.util.ArrayList;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.ekalw.qa.base.TestBase22;

public class SignInPage extends TestBase22{
	
	//Page Factory or Object Repository
	@FindBy(xpath=".//div[@class='cookie-notice-confirm']//button[@id='cookie-notice-confirm']")
	WebElement acceptCookiesButton;
	
	@FindBy(xpath="//img[contains(@alt,'Logo')]")
	WebElement simsLogo;
	
	@FindBy(xpath = ".//span[contains(text(),'Sign in with SIMS ID')]")
	WebElement signInWithSimsId;
	
	@FindBy(xpath = ".//span[contains(text(),'Sign in with Google')]")
	WebElement signInWithGoogle;
	
	@FindBy(xpath=".//input[@id='username']")
	WebElement username4signInWithSimsId;
	
	@FindBy(xpath=".//input[@id='password']")
	WebElement password4signInWithSimsId;
	
	@FindBy(xpath=".//input[@id='login-button']")
	WebElement loginButton4signInWithSimsId;
	
	@FindBy(xpath=".//h1[@id='headingText']/content[contains(text(),'Choose an account')]")
	WebElement chooseAccountLogo;
	
	@FindBy(xpath="//h1[@id='headingText']/content[contains(text(),'Sign in')]")
	WebElement chooseSignInToContinue;
	
	@FindBy(xpath=".//div[contains(text(),'Use another account')]")
	WebElement btnUseAnotherAccount;
	
	@FindBy(xpath=".//input[@type='email']")
	WebElement textEmailOrPhone;
	
	@FindBy(xpath=".//span[contains(text(),'Next')]")
	WebElement btnNext;
	
	@FindBy(xpath="//input[@type='password']")
	WebElement textPassword;
	
	@FindBy(xpath=".//div[contains(text(),'Get a verification code at ')]")
	WebElement getVerificationCodeAt;
	
	@FindBy(xpath=".//div[@id='links']/a[contains(text(),'Forgotten your SIMS ID Password?')]")
	WebElement forgottenYourSimsIdPassword;
	
	@FindBy(xpath=".//div[contains(text(),'Captcha answer cannot be empty.')]")
	WebElement errormsg;
	
	//Initializing the Page Object
		public SignInPage(){
			
			PageFactory.initElements(driver, this);
		}
	
	//Actions
	
	//Verify that the page title
		
	public String validateSignInPageTitle(){
		
		return driver.getTitle();
	}
	
	 /**
     * Click on Accept Button.
     */
	public boolean clickAcceptCookiesButton(){
		
		acceptCookiesButton.click();
		return true;
		
	}
	
	//Verify that the page loaded completely.
	
	public boolean validateSIMSImage(){
		return simsLogo.isDisplayed();
	}
	
	
	/**
     * Click on Sign In With SimsId.
     */
	public DashBoardPage signInWithSimsId(String un, String pwd) throws InterruptedException{
		
		signInWithSimsId.click();
		Thread.sleep(5000);
		username4signInWithSimsId.sendKeys(un);
		password4signInWithSimsId.sendKeys(pwd);
		Thread.sleep(5000);
		loginButton4signInWithSimsId.click();
		
		return new DashBoardPage();
	}
	
	 // Click on Forgotten Your Sims Id Password Link.
	
	public boolean forgetPasswordForSignInWithSimsId() throws InterruptedException{
		signInWithSimsId.click();
		clickOn(driver, forgottenYourSimsIdPassword, 10);
		forgottenYourSimsIdPassword.click();
		Thread.sleep(9000);
		// Get all Open Tabs
				ArrayList<String> tabHandles = new ArrayList<String>(driver.getWindowHandles());

				String pageTitle = "Forgot your password? - SIMS ID";  //page we looking for
				boolean myNewTabFound = true;

				for (String eachHandle : tabHandles) {
					driver.switchTo().window(eachHandle);
					// Check Your Page Title
					if (driver.getTitle().equalsIgnoreCase(pageTitle)) {
						// Report ur new tab is found with appropriate title
								
						driver.switchTo().window(eachHandle);  //not closing but switching to new tab
						sleep(3000);
						
					}
				}

				if (myNewTabFound) {
					driver.findElement(By.xpath("//input[@name='Username']")).sendKeys("ceciltest@example.com");
					sleep(3000);
				}
				
				sleep(5000);
				
				driver.switchTo().frame(0);
				driver.findElement(By.xpath(".//span[@id='recaptcha-anchor']//div[@class='recaptcha-checkbox-checkmark']")).click();
				
				Thread.sleep(5000);
				driver.switchTo().defaultContent();
				driver.navigate().refresh();
				
				driver.findElement(By.xpath("//input[@name='Username']")).sendKeys("ceciltest@example.com"); //as refresh again entering
				
				/*NOtes:-
				1.driver.switchTo().frame("frame1");
				2.driver.switchTo().frame("frame2");
				3.driver.switchTo().defaultContent(); //Switching back to the parent window //you are now outside frames
				
				There might be situations like, we might not be able to get the iframe values. At that time we can get name by using tagName method.

				driver.switchTo().frame(driver.findElements(By.tagName("iframe").get(0));*/
				
				/*//To iterate each frame and select the one we want

				int size = driver.findElements(By.tagName("iframe")).size();
				System.out.println("Size of frame is: "+size);
				
				for(int i=0; i<=size; i++){
					driver.switchTo().frame(i);
					//your code if any
					driver.switchTo().defaultContent(); //back to parent
					}*/
				
				driver.findElement(By.xpath(".//button[@id='btnSubmit']")).click();
				Thread.sleep(5000);
				
				System.out.println("Password tab test");
				return errormsg.isDisplayed();
	}
	
	 /**
     * Click on Sign In With Google Link.
     */
	
	public DashBoardPage signInWithGoogleId(String email_id,String email_password) throws InterruptedException{
		
	   signInWithGoogle.click();
	   Thread.sleep(5000);
	   
	   boolean isPresent = chooseSignInToContinue.isDisplayed();
	                 
	           if(isPresent==true){
	           textEmailOrPhone.click();
			   textEmailOrPhone.sendKeys(email_id);
			   clickOn(driver, btnNext, 5);
			   btnNext.click();
	           }			   	           
	           
	           else if(isPresent==false){
	       btnUseAnotherAccount.click();
	       clickOn(driver, textEmailOrPhone, 10);
	       textEmailOrPhone.click();
	 	   textEmailOrPhone.sendKeys(email_id);
	 	   btnNext.click();
	           }
	           
	           clickOn(driver, textPassword, 10);
	           textPassword.click();
			   textPassword.sendKeys(email_password);
			   btnNext.click();
			   Thread.sleep(5000);
	   
			   getVerificationCodeAt.click();
			   Thread.sleep(5000);
			   
			   //testcase looking good.
			   
	   return new DashBoardPage();
	   
	}

}
