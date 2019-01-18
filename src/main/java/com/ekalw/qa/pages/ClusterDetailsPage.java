package com.ekalw.qa.pages;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.ekalw.qa.base.TestBase22;
import com.ekalw.qa.demo.TestChk;
import com.ekalw.qa.util.GTakeScreenshot;
import com.ekalw.qa.util.JavaScriptExecutorConcept;
import com.ekalw.qa.util.TestUtil;

public class ClusterDetailsPage extends TestBase22 {

	// Page Factory or Object Repository
	@FindBy(linkText="Bilgaon")
	@CacheLookup
	WebElement bilgaon;
	
	@FindBy(linkText="Kogda")
	@CacheLookup
	WebElement kogda;
	
	@FindBy(linkText="Molgi")
	@CacheLookup
	WebElement molgi;
	
	@FindBy(xpath="//tbody//tr[1]//th//a[text()='Molgi']//following::a[1]")
	@CacheLookup
	WebElement _133;
	
	@FindBy(xpath="//th[contains(text(),'Cluster Name')]")
	@CacheLookup
	WebElement clusterNameText;
	
	@FindBy(xpath="//div[@class='page-content']//p[contains(text(),'Active school:')]")
	@CacheLookup
	WebElement villagesText;	
	
	@FindBy(xpath="//th[text()=' Student Count']")
	@CacheLookup
	WebElement clusterDetailStudentCountText;

	// Initializing the Page Object
	public ClusterDetailsPage() {

		PageFactory.initElements(driver, this);

	}

	// Actions
	
	/**
	 * Verify that current page URL matches the expected URL.
	 * @throws Exception 
	 *
	 */
	
	public boolean verifyPageUrl() throws Exception {
					
		String pageUrl = "/clusters";
		waitForElementVisible(driver,clusterNameText);
		System.out.println("Testing verifyPageUrlTest");
		GTakeScreenshot.takeSnapShot(driver, "D:\\WorkSpace\\Ekal\\EkalW\\ScreenShotManual\\verifyPageUrlM.jpg");
		return driver.getCurrentUrl().contains(pageUrl);
			
	}
	
	/*
	 * Click on 33 Link.
	 */
	public boolean click1Link33() throws Exception {
		//sleep(3000);
		System.out.println("Testing click click1Link33");
		clickOn(driver, _133,TestUtil.Click_VISIBLE_WAIT);
		_133.click();
		waitForElementVisible(driver,villagesText);
		sleep(3000);
		GTakeScreenshot.takeSnapShot(driver, "D:\\WorkSpace\\Ekal\\EkalW\\ScreenShotManual\\click1Link33M.jpg");
		
		return this != null;
	}
	
	/**
	 * Click on Bilgaon Link.
	 *
	 * @return the DashboardPage2 class instance.
	 * @throws Exception 
	 */
	public boolean clickBilgaonLink() throws Exception {
		System.out.println("Testing click BilgaonLink");
		waitForElementVisible(driver, bilgaon);
		JavaScriptExecutorConcept.scrollIntoView(bilgaon, driver);
		sleep(5000);
		JavaScriptExecutorConcept.flash(bilgaon, driver);
		bilgaon.click();
		waitForElementVisible(driver,clusterDetailStudentCountText);
		sleep(3000);
		GTakeScreenshot.takeSnapShot(driver, "D:\\WorkSpace\\Ekal\\EkalW\\ScreenShotManual\\clickBilgaonLinkM.jpg");
		return this != null;
	}
	
	/**
	 * Click on Molgi Link.
	 *
	 * @return the DashboardPage2 class instance.
	 * @throws Exception 
	 */
	public boolean clickMolgiLink() throws Exception {
		sleep(5000);
		System.out.println("Testing click molgi");
		waitForElementVisible(driver, molgi);
		molgi.click();
		waitForElementVisible(driver,clusterDetailStudentCountText);
		sleep(3000);
		GTakeScreenshot.takeSnapShot(driver, "D:\\WorkSpace\\Ekal\\EkalW\\ScreenShotManual\\clickMolgiLinkM.jpg");
		return this != null;
	}
	
		
	// Verify cluster head column >> get any cluster head and navigate to its corresponding Village Count and Cluster Name links.//
					///***********For specific string i mentioned from table*****************///
						
	
	public boolean verifyClusterHead(){
		
		List<WebElement> rows =driver.findElements(By.xpath("//*[@id='root']/div/div[1]/table/tbody/tr")); //get all rows
		int rowCount=rows.size();
		System.out.println("Total rows in table is "+rowCount);
		
		String beforexpath="//*[@id='root']/div/div[1]/table/tbody/tr[";
		String afterxpath="]/td[1]";
		String pecedingpath="//preceding-sibling::th/a";
		String followingpath="//following-sibling::th/a";
		
		for(int i=1; i<=rowCount; i++){
			
			String name ="Dhondiram";						//cluster head we using.
			
			String actualxpath=beforexpath + i +afterxpath;
								
			String precedingpathtotal= actualxpath + pecedingpath;
						
			String followingpathtotal= actualxpath + followingpath;
			
			WebElement element=driver.findElement(By.xpath(actualxpath));
			
			if(element.getText().contains(name)){
				
				System.out.println("data of table cluster head: "+element.getText()+" is found "+"at position: "+i);
				
				sleep(6000);
				
				break;
			}
		}
		return true;
	}
	
	// Verify cluster head RANDOM column >> get any cluster head and navigate to its corresponding Village Count and Cluster Name links.//
							///***********For random string from row table*****************///
	
	public boolean verifyClusterHeadRandom() throws Exception{
		
		List<WebElement> rows =driver.findElements(By.xpath("//*[@id='root']/div/div[1]/table/tbody/tr"));
		int rowCount=rows.size();
		System.out.println("Total rows in table is "+rowCount);
				
		String row4used="//*[@id='root']/div/div[1]/table/tbody/tr[4]";
		String precedingpath="/td[1]//preceding-sibling::th/a";
		String followingpath="/td[1]//following-sibling::th/a";
		String backBtn="//button[contains(text(),'Back')]";
		
		String actualclusterHeadused=driver.findElement(By.xpath(row4used)).getText();
		
		WebElement ele= driver.findElement(By.xpath(row4used));
		
		System.out.println("clusterHeadused is " +actualclusterHeadused);
		
				
		//-->>  now robot have to click hyperlinks 'Cluster Name' and 'Village Count' of 'Cluster Head' used above.  <<--//
		
		if(ele.getText().contains(actualclusterHeadused))
		
		driver.findElement(By.xpath(row4used+precedingpath)).click();
		sleep(10000);
		GTakeScreenshot.takeSnapShot(driver, "D:\\WorkSpace\\Ekal\\EkalW\\ScreenShotManual\\clusterHeadusedpreceding.jpg");
		
		driver.findElement(By.xpath(backBtn)).click();
		driver.findElement(By.xpath(backBtn)).click();
		sleep(5000);
		
		driver.findElement(By.xpath(row4used+followingpath)).click();
		sleep(10000);
		GTakeScreenshot.takeSnapShot(driver, "D:\\WorkSpace\\Ekal\\EkalW\\ScreenShotManual\\clusterHeadusedfollowing.jpg");
		
		driver.findElement(By.xpath(backBtn)).click();
		driver.findElement(By.xpath(backBtn)).click();
		
		return true;
		
	}

}
