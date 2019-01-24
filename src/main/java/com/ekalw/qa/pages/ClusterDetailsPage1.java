package com.ekalw.qa.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.ekalw.qa.base.TestBase;

public class ClusterDetailsPage1 extends TestBase{
	
	//Page repository
	@FindBy(xpath="//*[@id='root']/div/div[1]/table/tbody/tr")
	WebElement owpath;
	
	
	//Initializing Page Object
	public ClusterDetailsPage1(){
		
		PageFactory.initElements(driver, this);
	}
	
	//Actions
	
	public boolean validatePageUrl(){
		
		String pageUrl="/clusters";
		
		return driver.getCurrentUrl().contains(pageUrl);
		
	}
	
	public boolean verifyClusterHead(){
		
		List<WebElement> rows =driver.findElements(By.xpath("//*[@id='root']/div/div[1]/table/tbody/tr")); //get all rows
		int rowCount=rows.size();
		System.out.println("Total rows in table is "+rowCount);
		
		String beforexpath="//*[@id='root']/div/div[1]/table/tbody/tr[";
		String afterxpath="]/td[1]";
		String pecedingpath="//preceding-sibling::th/a";
		String followingpath="//following-sibling::th/a";
		
		for(int i=1; i<=rowCount; i++){
			
			String name ="Dhondiram";
			
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
}
