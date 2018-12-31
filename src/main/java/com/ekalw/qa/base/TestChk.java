package com.ekalw.qa.base;

import java.util.ArrayList;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

public class TestChk {

	public static void main(String[] args) throws InterruptedException {

		System.out.println("WebDriver Demo");

		 System.setProperty("webdriver.chrome.driver","D://softwares//browsers//chromedriver_win32//chromedriver.exe");
		WebDriver driver = new ChromeDriver();

//		System.setProperty("webdriver.gecko.driver","D://softwares//browsers//geckodriver-v0.23.0-win64//geckodriver.exe");
//		WebDriver driver = new FirefoxDriver();

		driver.get("http://cecilweb.azurewebsites.net");
		System.out.println(driver.getTitle());
		Thread.sleep(5000);

		driver.findElement(By.xpath(".//span[contains(text(),'Login With SIMS ID')]")).click();
		Thread.sleep(3000);

		driver.findElement(By.xpath(".//span[contains(text(),'Sign in with SIMS ID')]")).click();
		Thread.sleep(3000);

		//String currentPageHandle = driver.getWindowHandle();
		driver.findElement(By.xpath(".//div[@id='links']/a[contains(text(),'Forgotten your SIMS ID Password?')]")).click();

		// Add Logic to Wait till Page Load
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
				Thread.sleep(3000);
				
			}
		}

		if (myNewTabFound) {
			driver.findElement(By.xpath("//input[@name='Username']")).sendKeys("ceciltest@example.com");
			Thread.sleep(3000);
		}
		
		Thread.sleep(5000);
		
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

			}

}