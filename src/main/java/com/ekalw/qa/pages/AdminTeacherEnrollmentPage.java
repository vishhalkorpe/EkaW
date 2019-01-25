package com.ekalw.qa.pages;

import java.awt.RenderingHints.Key;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Keyboard;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterMethod;

import com.ekalw.qa.adminpages.AdminWelcomePage;
import com.ekalw.qa.base.TestBase;
import com.ekalw.qa.util.JavaScriptExecutorConcept;

public class AdminTeacherEnrollmentPage extends TestBase {

	public final String pageLoadedTextTeachers = "Teacher Information";
	public final String pageUrlTeachers = "/teachers";

	// Page Factory or Object Repository
	@FindBy(xpath = "//div//label[text()='First Name*']//following::input[@id='outlined-name']")
	WebElement firstname;

	@FindBy(xpath = "//div//label[text()='Last Name*']//following::input[@id='outlined-name']")
	WebElement lastname;

	@FindBy(xpath = "//div//label[text()='Mobile number*']//following::input[@id='outlined-name']")
	WebElement mobilenumber;

	@FindBy(xpath = "//div//label[text()='Email-Id*']//following::input[@id='outlined-name']")
	WebElement emailid;

	@FindBy(xpath = "//div//label[text()='Aadhar Number']//following::input[@id='outlined-name']")
	WebElement aadharnumber;

	@FindBy(xpath = "//div//label[text()='Address Line 1']//following::input[@id='outlined-name']")
	WebElement addressline1;

	@FindBy(xpath = "//div//label[text()='Address Line 2']//following::input[@id='outlined-name']")
	WebElement addressline2;

	@FindBy(xpath = "//div//label[text()='Address Line 3']//following::input[@id='outlined-name']")
	WebElement addressline3;

	@FindBy(xpath = "//div//label[text()='Postal code(PIN)']//following::input[@id='outlined-name']")
	WebElement postalcode;

	@FindBy(xpath = "//div[@data-item='Teachers']")
	WebElement teacherMenu;
	
	@FindBy(xpath="//button[@type='button']//span[contains(text(),'Add Teacher')]")
	WebElement addTeacherBtn;
	
	@FindBy(xpath="//div[text()='Select gender']")
	WebElement genderClick;
	
	@FindBy(xpath="//ul[@role='listbox']//option[@data-value]")
	WebElement genderOptions;
	
	// Initialize the objects

	public AdminTeacherEnrollmentPage() {

		PageFactory.initElements(driver, this);
	}

	// Action functions
	public String verifyLoginPageTitle() {

		return driver.getTitle();
	}

	
	public boolean verifyclickOnTeacherMenu() {
		teacherMenu.click();
		String currentUrl = driver.getCurrentUrl();
		return currentUrl.contains(pageUrlTeachers);

	}

	public boolean clickAddTeacher() {
		teacherMenu.click();
		clickOn(driver, addTeacherBtn, 15);
		addTeacherBtn.click();
		return driver.getPageSource().contains(pageLoadedTextTeachers);

	}
	
	public void fillDataForTeacherSave() throws InterruptedException{
		
		AdminWelcomePage aw = new AdminWelcomePage();
		aw.fillTeacherInformation();
		//ckeckValidation();
		if(ckeckValidation()==true){
			System.out.println("Saving the form");
		aw.clickSaveButton();
		}
		
	}
	
	public static boolean ckeckValidation(){
		
		List<WebElement> listerrors=driver.findElements(By.xpath("//table//span[contains(text(),'invalid') or contains(text(),'cannot') or contains(text(),'12 digit') or contains(text(),'already exists')]"));
		//This email already exists
		int errroSize= listerrors.size();
		
		boolean flag=false;
		
		if(errroSize==0){
			
			flag=true;
			System.out.println("Form filled successfully and so flag is : - "+flag);
						}
		
		else{
			System.out.println("Form filled has errors and so flag is : - "+flag);
			}
		return flag;
		
		}
	
	
	public boolean clickResetTeacherEnrollmentFormButton(String firstname,String lastname,String mobilenumber,String emailid,String aadharnumber,String addressline1,String addressline2,String addressline3,String postalcode,String gender,String dob,String slectorganisation,String selectstate){
		teacherMenu.click();
		clickOn(driver, addTeacherBtn, 15);
		addTeacherBtn.click();
		clickOn(driver, this.firstname, 10);
		this.firstname.sendKeys(firstname);
		this.lastname.sendKeys(lastname);
		this.mobilenumber.sendKeys(mobilenumber);
		this.emailid.sendKeys(emailid);
		this.aadharnumber.sendKeys(aadharnumber);
		this.addressline1.sendKeys(addressline1);
		this.addressline2.sendKeys(addressline2);
		this.addressline3.sendKeys(addressline3);
		this.postalcode.sendKeys(postalcode);
		sleep(5000);	
		
		//********************************gender start >> ONE WAY >> For another way see select organisation +xpath logic
		
				genderClick.click();
				sleep(3000);
				{
				if(gender.equals("Male")){
					
					WebElement elementgenderToSelect1 =driver.findElement(By.xpath("//ul[@role='listbox']//option[@data-value='Male']"));
					JavaScriptExecutorConcept.clickElementByJS(elementgenderToSelect1, driver);
				}
				else if(gender.equals("Female")){
					
					WebElement elementgenderToSelect2 =driver.findElement(By.xpath("//ul[@role='listbox']//option[@data-value='Female']"));
					JavaScriptExecutorConcept.clickElementByJS(elementgenderToSelect2, driver);
				}
				else if(gender.equals("TransGender")){
					
					WebElement elementgenderToSelect3 =driver.findElement(By.xpath("//ul[@role='listbox']//option[@data-value='Transgender']"));
					JavaScriptExecutorConcept.clickElementByJS(elementgenderToSelect3, driver);
					
				}
				else
					System.out.println("Select gender not specified");
				}
				
				sleep(5000);
				this.firstname.click();		//click on this to remove control form dropdown
				
				//********************************gender end
				  			 
				
				//********************************date start
				
				sleep(5000);
				this.firstname.click();		//click on this to remove control form dropdown
				
				WebElement elementdateToSelect =driver.findElement(By.xpath("//input[@type='date']"));
				elementdateToSelect.click();
				elementdateToSelect.sendKeys(dob);
				
				sleep(5000);
				this.firstname.click();		//click on this to remove control form dropdown
				
				
				//********************************date end	


				
				//***************************select organization start
								
				sleep(5000);
				this.firstname.click();		//click on this to remove control form dropdown
				
				String firstorgXpath="//ul[@role='listbox']//option[text()='";
				String secondorgXpath="']";
				String totalorgXpath=firstorgXpath+slectorganisation+secondorgXpath;
				
				driver.findElement(By.xpath("//div//label[text()='Select Organisation*']//following::div[1]")).click();
				// wait for drop down to open
				sleep(5000);
				
				WebElement elementOrganisationToSelect =driver.findElement(By.xpath(totalorgXpath));
				JavaScriptExecutorConcept.clickElementByJS(elementOrganisationToSelect, driver);
				
				sleep(5000);
				this.firstname.click();			//click on this to remove control form dropdown
				
				//********************************select organization end
				 

				
				//**************************************select state start
				sleep(5000);
				this.addressline1.click();
				
				
				String firstpartstateXpath="//ul[@role='listbox']//option[text()='";
				String secondpartstateXpath="']";
				String totalstateXpath=firstpartstateXpath+selectstate+secondpartstateXpath;
				
				driver.findElement(By.xpath("//div[text()='Select state']")).click();
				// wait for drop down to open
				sleep(5000);
				
				WebElement elementstateToSelect =driver.findElement(By.xpath(totalstateXpath));
				JavaScriptExecutorConcept.clickElementByJS(elementstateToSelect, driver);
				
				sleep(5000);
				this.firstname.click();		//click on this to remove control form dropdown
				
				//**************************************select state end
							
		driver.findElement(By.xpath("//button//span[text()=' Reset']")).click();
		
		System.out.println("Reset button clicked");
		
		//this.firstname.click();
		//this.firstname.sendKeys(Keys.TAB);
		
		sleep(5000);
		
		driver.findElement(By.xpath("//span[text()='Save']")).click();
		
		sleep(5000);
		
		if(ckeckValidation()==true){
			System.out.println("Saving the form");
			
			return true;
		}
		
		else{
			
			return false;
		}
	}
	
	/////////////////
	
	public boolean clickSaveTeacherEnrollmentFormButton(String firstname,String lastname,String mobilenumber,String emailid,String aadharnumber,String addressline1,String addressline2,String addressline3,String postalcode,String gender,String dob,String slectorganisation,String selectstate){
		
		teacherMenu.click();
		clickOn(driver, addTeacherBtn, 15);
		addTeacherBtn.click();
		clickOn(driver, this.firstname, 10);
		this.firstname.sendKeys(firstname);
		this.lastname.sendKeys(lastname);
		this.mobilenumber.sendKeys(mobilenumber);
		this.emailid.sendKeys(emailid);
		this.aadharnumber.sendKeys(aadharnumber);
		this.addressline1.sendKeys(addressline1);
		this.addressline2.sendKeys(addressline2);
		this.addressline3.sendKeys(addressline3);
		this.postalcode.sendKeys(postalcode);
		sleep(5000);	
		
		//********************************gender start >> ONE WAY >> For another way see select organisation +xpath logic
		
		genderClick.click();
		sleep(3000);
		{
		if(gender.equals("Male")){
			
			WebElement elementgenderToSelect1 =driver.findElement(By.xpath("//ul[@role='listbox']//option[@data-value='Male']"));
			JavaScriptExecutorConcept.clickElementByJS(elementgenderToSelect1, driver);
		}
		else if(gender.equals("Female")){
			
			WebElement elementgenderToSelect2 =driver.findElement(By.xpath("//ul[@role='listbox']//option[@data-value='Female']"));
			JavaScriptExecutorConcept.clickElementByJS(elementgenderToSelect2, driver);
		}
		else if(gender.equals("TransGender")){
			
			WebElement elementgenderToSelect3 =driver.findElement(By.xpath("//ul[@role='listbox']//option[@data-value='Transgender']"));
			JavaScriptExecutorConcept.clickElementByJS(elementgenderToSelect3, driver);
			
		}
		else
			System.out.println("Select gender not specified");
		}
		
		sleep(5000);
		this.firstname.click();		//click on this to remove control form dropdown
		
		//********************************gender end
		  
		 
		
		//********************************date start
		
		sleep(5000);
		this.firstname.click();		//click on this to remove control form dropdown
		
		WebElement elementdateToSelect =driver.findElement(By.xpath("//input[@type='date']"));
		elementdateToSelect.click();
		elementdateToSelect.sendKeys(dob);
		
		//String dateVal="05-01-2019";
		//JavaScriptExecutorConcept.selectDateByJS(driver, elementdateToSelect, dateVal);
		
		sleep(5000);
		this.firstname.click();		//click on this to remove control form dropdown
		
		
		//********************************date end	


		
		//***************************select organization start
			
				 
		// NOTE:-try to select an element which is in the list but hidden from view without scrolling
	    // note it isn't a real drop down <select> element. It's KendoUI.
		//Hard Coded:-
		//WebElement elementorgToSelect =driver.findElement(By.xpath("//ul[@role='listbox']//option[text()='Winston school']"));
		//JavaScriptExecutorConcept.clickElementByJS(elementorgToSelect, driver);
		
		
		//******START************If don't want to call class 'JavaScriptExecutorConcept' below is original syntax********\\
		
		//WebElement elementToSelect =driver.findElement(By.xpath("//ul[@role='listbox']//option[text()='Winston school']")); 
		//JavascriptExecutor executor = (JavascriptExecutor)driver;
		//executor.executeScript("arguments[0].click();", elementToSelect);
		
		//********END**********If don't want to call class 'JavaScriptExecutorConcept' below is original syntax********\\
		 
				
		//BEST Logic for excel
		
		sleep(5000);
		this.firstname.click();		//click on this to remove control form dropdown
		
		String firstorgXpath="//ul[@role='listbox']//option[text()='";
		String secondorgXpath="']";
		String totalorgXpath=firstorgXpath+slectorganisation+secondorgXpath;
		
		driver.findElement(By.xpath("//div//label[text()='Select Organisation*']//following::div[1]")).click();
		// wait for drop down to open
		sleep(5000);
		
		WebElement elementOrganisationToSelect =driver.findElement(By.xpath(totalorgXpath));
		JavaScriptExecutorConcept.clickElementByJS(elementOrganisationToSelect, driver);
		
		sleep(5000);
		this.firstname.click();			//click on this to remove control form dropdown
		
		//********************************select organization end
		 

		
		//**************************************select state start
		sleep(5000);
		this.addressline1.click();
		
		
		String firstpartstateXpath="//ul[@role='listbox']//option[text()='";
		String secondpartstateXpath="']";
		String totalstateXpath=firstpartstateXpath+selectstate+secondpartstateXpath;
		
		driver.findElement(By.xpath("//div[text()='Select state']")).click();
		// wait for drop down to open
		sleep(5000);
		
		WebElement elementstateToSelect =driver.findElement(By.xpath(totalstateXpath));
		JavaScriptExecutorConcept.clickElementByJS(elementstateToSelect, driver);
		
		sleep(5000);
		this.firstname.click();		//click on this to remove control form dropdown
		
		
		//**************************************select state end
		
		sleep(5000);
		driver.findElement(By.xpath("//span[text()='Save']")).click();
		
		sleep(5000);
		
		if(ckeckValidation()==true){
			System.out.println("Saving the form");
			
			return true;
		}
		
		else{
			
			return false;
		}
			
		}

		
	}


