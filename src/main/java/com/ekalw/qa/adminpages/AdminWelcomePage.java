package com.ekalw.qa.adminpages;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Keyboard;
import org.openqa.selenium.support.ui.Select;

import com.ekalw.qa.util.JavaScriptExecutorConcept;

public class AdminWelcomePage {

	public static WebDriver driver;

	public static void main(String[] args) throws InterruptedException {

		System.setProperty("webdriver.chrome.driver", "D://softwares//browsers//chromedriver_win32//chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(15, TimeUnit.SECONDS);
		driver.get("http://cecilwebadmin.azurewebsites.net");
		//driver.findElement(By.xpath("//div[@data-item='Teachers']")).click();
		getXpath("//div[@data-item='Teachers']").click();
		Thread.sleep(10000);
		System.out.println("*******ADMIN PAGE*******");
		
		AdminWelcomePage aw = new AdminWelcomePage();
		aw.fillTeacherInformation();
		//aw.clickResetButton();
		//aw.clickSaveButton();
		//aw.fillDataForTeacherReset();
		//aw.fillDataForTeacherSave();
		//ckeckValidation();

	}
	
	public static WebElement getXpath(String path){
		
		WebElement we=driver.findElement(By.xpath(path));
		return we;
		
	}
	
	public void fillTeacherInformation() throws InterruptedException{
		
	System.out.println("Fillinf teacher information");
	
	getXpath("//div//button[@id='addTeacher']").click();
	Thread.sleep(5000);
	
	getXpath("//div//input[@id='selectOrgid']//preceding::div[1]").click();
	Thread.sleep(5000);
	
	getXpath("//div//label[text()='First Name*']//following::input[@id='outlined-name']").clear();
	getXpath("//div//label[text()='First Name*']//following::input[@id='outlined-name']").sendKeys("First Name");
	
	getXpath("//div//label[text()='Last Name*']//following::input[@id='outlined-name']").clear();
	getXpath("//div//label[text()='Last Name*']//following::input[@id='outlined-name']").sendKeys("Last Name");
	
	getXpath("//div//label[text()='Mobile number*']//following::input[@id='outlined-name']").clear();
	getXpath("//div//label[text()='Mobile number*']//following::input[@id='outlined-name']").sendKeys("9119532222");
	
	getXpath("//div//label[text()='Email-Id*']//following::input[@id='outlined-name']").clear();
	getXpath("//div//label[text()='Email-Id*']//following::input[@id='outlined-name']").sendKeys("Email-Id@gmail.com");
	
	//getXpath("//div//label[text()='Select Organisation*']//following::input[@id='outlined-name']").clear();
	//getXpath("//div/label[text()='Select Organisation*']//following-sibling::div//following-sibling::div//div[@role='button']").sendKeys("Dora");
	
	getXpath("//div//label[text()='Aadhar Number']//following::input[@id='outlined-name']").clear();
	getXpath("//div//label[text()='Aadhar Number']//following::input[@id='outlined-name']").sendKeys("121212121212");
	
	getXpath("//div//label[text()='Address Line 1']//following::input[@id='outlined-name']").clear();
	getXpath("//div//label[text()='Address Line 1']//following::input[@id='outlined-name']").sendKeys("Address Line 1");
	
	getXpath("//div//label[text()='Address Line 2']//following::input[@id='outlined-name']").clear();
	getXpath("//div//label[text()='Address Line 2']//following::input[@id='outlined-name']").sendKeys("Address Line 2");
	
	getXpath("//div//label[text()='Postal code(PIN)']//following::input[@id='outlined-name']").clear();
	getXpath("//div//label[text()='Postal code(PIN)']//following::input[@id='outlined-name']").sendKeys("411014");
	
	getXpath("//div//label[text()='Address Line 3']//following::input[@id='outlined-name']").clear();
	getXpath("//div//label[text()='Address Line 3']//following::input[@id='outlined-name']").sendKeys("Address Line 3");
	
	//gender start
	
	Thread.sleep(5000);
	getXpath("//h2[text()='Teacher Information']").click();		//click on this to remove control form dropdown
	Thread.sleep(5000);
	
	getXpath("//div[text()='Select gender']").click();
	// wait for drop down to open
	Thread.sleep(5000);
	
	WebElement elementgenderToSelect =driver.findElement(By.xpath("//ul[@role='listbox']//option[@data-value='Male']"));
	JavaScriptExecutorConcept.clickElementByJS(elementgenderToSelect, driver);
	
	Thread.sleep(5000);
	getXpath("//h2[text()='Teacher Information']").click(); 	//click on this to remove control form dropdown
	Thread.sleep(5000);
	
	//gender END
	
	//date start
	
	WebElement elementdateToSelect =driver.findElement(By.xpath("//input[@type='date']"));
	elementdateToSelect.click();
	elementdateToSelect.sendKeys("11012019");
	//String dateVal="05-01-2019";
	//JavaScriptExecutorConcept.selectDateByJS(driver, elementdateToSelect, dateVal);
	
	Thread.sleep(5000);
	getXpath("//h2[text()='Teacher Information']").click(); 	//click on this to remove control form dropdown
	Thread.sleep(5000);
	
	//date end
	
	
	
	//select organization start
	
	getXpath("//div//label[text()='Select Organisation*']//following::div[1]").click();
	// wait for drop down to open
	Thread.sleep(5000);
	
	
	// NOTE:-try to select an element which is in the list but hidden from view without scrolling
    // note it isn't a real drop down <select> element. It's KendoUI.
	
	WebElement elementorgToSelect =driver.findElement(By.xpath("//ul[@role='listbox']//option[text()='Winston school']"));
	JavaScriptExecutorConcept.clickElementByJS(elementorgToSelect, driver);
	
	
	//******START************If don't want to call class 'JavaScriptExecutorConcept' below is original syntax********\\
	
	//WebElement elementToSelect =driver.findElement(By.xpath("//ul[@role='listbox']//option[text()='Winston school']")); 
	//JavascriptExecutor executor = (JavascriptExecutor)driver;
	//executor.executeScript("arguments[0].click();", elementToSelect);
	
	//********END**********If don't want to call class 'JavaScriptExecutorConcept' below is original syntax********\\
	Thread.sleep(5000);
	getXpath("//h2[text()='Teacher Information']").click();		//click on this to remove control form dropdown
	Thread.sleep(5000);
	
	//select organisation end
	
	//select state start
	
	//getXpath("//div//label[text()='State']//following::div[@role='button']").click();
	getXpath("//div//label[text()='State']//following::div[1]").click();
	// wait for drop down to open
	Thread.sleep(5000);
	
	WebElement elementstateToSelect =driver.findElement(By.xpath("//ul[@role='listbox']//option[text()='GOA']"));
	JavaScriptExecutorConcept.clickElementByJS(elementstateToSelect, driver);
	
	Thread.sleep(5000);
	getXpath("//h2[text()='Teacher Information']").click(); 	//click on this to remove control form dropdown
	Thread.sleep(5000);
	
	//select state end.
	
	}
	
	public void clickResetButton(){
		
		//click on reset button
		
		getXpath("//button[@type='button']//span[text()=' Reset']").click();
		
	}
	
	public void clickSaveButton(){
		

	//click on save button
	
	getXpath("//button[@type='submit']//span[text()='Save']").click();
		
	}
	
	public void fillDataForTeacherReset() throws InterruptedException{
				
		AdminWelcomePage aw = new AdminWelcomePage();
		aw.fillTeacherInformation();
		ckeckValidation();
		aw.clickResetButton();
				
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
		
		List<WebElement> listerrors=driver.findElements(By.xpath("//table//span[contains(text(),'invalid') or contains(text(),'cannot') or contains(text(),'12 digit')]"));
		
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
}
