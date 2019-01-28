package com.ekalw.qa.adminpages;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Sleeper;

public class AdminTeacherSearchPage {

	public static WebDriver driver;

	public static void main(String[] args) throws InterruptedException {

		System.setProperty("webdriver.chrome.driver", "D://softwares//browsers//chromedriver_win32//chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(15, TimeUnit.SECONDS);
		driver.get("http://cecilwebadmin.azurewebsites.net");
		Thread.sleep(10000);
		driver.findElement(By.xpath("//div[@data-item='Teachers']")).click();
		Thread.sleep(5000);
		System.out.println("*******ADMIN Teachers PAGE*******");

		AdminTeacherSearchPage atsp = new AdminTeacherSearchPage();
		atsp.searchTeacherByname();

	}

	public void searchTeacherByEmailid() throws InterruptedException {

		String emailid = "sj@sj.com";
		
		driver.findElement(By.xpath("//input[@id='filter']")).click();
		Thread.sleep(5000);
		driver.findElement(By.xpath("//input[@id='filter']")).sendKeys(emailid);
		Thread.sleep(5000);

		String bxpath = "//div[@class='rt-tbody']//div[@role='rowgroup']//div[@class='rt-td' and contains( text(),'";
		String axpath = "')]";
		String actualxpath = bxpath + emailid + axpath;
		

		List<WebElement> listFound = driver.findElements(By.xpath(actualxpath));
		
		//List<WebElement> listlinks = driver.findElements(By.xpath("//div[@class='rt-td']//a[1]"));
		

		int listSize = listFound.size();
		//int listlinksize=listlinks.size();
		
		if (listSize == 0 ) {

			System.out.println("No Teacher available with name: "+emailid);

		}
		else if(listSize>1){
			
			System.out.println("Duplicate data found");
		}

		else{
			
			System.out.println(+listSize+" :Teacher found with name:- "+emailid);

			for (WebElement webElement : listFound) {

				String foundnamedata = webElement.getText();

				if (foundnamedata.contains(emailid)) {
					System.out.println("Teachers found successfully");
				} else {
					System.out.println("Teacher not found");
				}

			}
		}
		
		
		

	}
	
	public void searchTeacherByname() throws InterruptedException {

		String name = "John";
		
		driver.findElement(By.xpath("//input[@id='filter']")).click();
		Thread.sleep(5000);
		driver.findElement(By.xpath("//input[@id='filter']")).sendKeys(name);
		Thread.sleep(5000);

		String bxpath = "//div[@class='rt-tbody']//div[@role='rowgroup']//div[@class='rt-td' and contains( text(),'";
		String axpath = "')]";
		String actualxpath = bxpath + name + axpath;
		
	
		List<WebElement> listlinks = driver.findElements(By.xpath("//div[@class='rt-td']//a[1]"));
		
		
		int listlinksize=listlinks.size();
				
		if(listlinksize>1){
			
			for(int i=1; i<=listlinksize;i++){
				
				String b2xapth="//div[@class='rt-tbody']//div[";
				String a2xpath="]//div//div[1]";
				String actual2xpath=b2xapth+i+a2xpath;
				
				WebElement we=driver.findElement(By.xpath(actual2xpath));
				System.out.println(we.getText());
			}
		}

	}

}
