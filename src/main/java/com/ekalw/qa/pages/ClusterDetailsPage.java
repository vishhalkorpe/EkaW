package com.ekalw.qa.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.ekalw.qa.base.TestBase;
import com.ekalw.qa.demo.TestChk;
import com.ekalw.qa.util.GTakeScreenshot;

public class ClusterDetailsPage extends TestBase {

	// Page Factory or Object Repository
	@FindBy(css = "#root div.page-content div:nth-of-type(1) table.MuiTable-root-190 tbody.MuiTableBody-root-205 tr:nth-of-type(18) th:nth-of-type(1) a")
	@CacheLookup
	WebElement bilgaon;
	
	@FindBy(css = "#root div.page-content div:nth-of-type(1) table.MuiTable-root-190 tbody.MuiTableBody-root-205 tr:nth-of-type(1) th:nth-of-type(2) a")
	@CacheLookup
	WebElement _133;
	
	@FindBy(css = "#root div.page-content div:nth-of-type(1) table.MuiTable-root-190 tbody.MuiTableBody-root-205 tr:nth-of-type(1) th:nth-of-type(1) a")
	@CacheLookup
	WebElement molgi;
	
	
	

	// Initializing the Page Object
	public ClusterDetailsPage() {

		PageFactory.initElements(driver, this);

	}

	// Actions
	
	/**
	 * Verify that current page URL matches the expected URL.
	 *
	 */
	
	public boolean verifyPageUrl() {
					
		String pageUrl = "/clusters";
		sleep(5000);
		System.out.println("pageurl verified");
		
		return driver.getCurrentUrl().contains(pageUrl);
			
	}
	
	/**
	 * Click on 33 Link.
	 */
	public boolean click1Link33() {
		sleep(5000);
		System.out.println("click click1Link33");
		
		_133.click();
		
		return this != null;
	}
	
	/**
	 * Click on Bilgaon Link.
	 *
	 * @return the DashboardPage2 class instance.
	 */
	public boolean clickBilgaonLink() {
		sleep(5000);
		System.out.println("click BilgaonLink");
		bilgaon.click();
		return this != null;
	}
	
	/**
	 * Click on Molgi Link.
	 *
	 * @return the DashboardPage2 class instance.
	 */
	public boolean clickMolgiLink() {
		sleep(5000);
		System.out.println("click molgi");
		molgi.click();
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
		GTakeScreenshot.takeSnapShot(driver, "D:\\WorkSpace\\Ekal\\EkalW\\Screenshots\\clusterHeadusedpreceding.jpg");
		
		driver.findElement(By.xpath(backBtn)).click();
		driver.findElement(By.xpath(backBtn)).click();
		sleep(5000);
		
		driver.findElement(By.xpath(row4used+followingpath)).click();
		sleep(10000);
		GTakeScreenshot.takeSnapShot(driver, "D:\\WorkSpace\\Ekal\\EkalW\\Screenshots\\clusterHeadusedfollowing.jpg");
		
		driver.findElement(By.xpath(backBtn)).click();
		driver.findElement(By.xpath(backBtn)).click();
		
		return true;
		
	}

}
