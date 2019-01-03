package com.ekalw.qa.base;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.ekalw.qa.util.TestUtil;

public class TestBase {

	public static WebDriver driver;
	public static Properties prop;

	public TestBase() {

		prop = new Properties();
		try {
			FileInputStream ip = new FileInputStream("D://WorkSpace//Ekal//EkalW//src//main//java//com//ekalw//qa//config//config.properties");
			prop.load(ip);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
	
	public static void initialization(){
		String browsername = prop.getProperty("browser");
		
		if(browsername.equals("chrome")){
			System.setProperty("webdriver.chrome.driver", "D://softwares//browsers//chromedriver_win32//chromedriver.exe");
			driver = new ChromeDriver();
			
		}
		else if(browsername.equals("firefox")){
			System.setProperty("webdriver.gecko.driver", "D://softwares//browsers//geckodriver-v0.23.0-win64//geckodriver.exe");
			driver = new FirefoxDriver();
		}
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT,TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT,TimeUnit.SECONDS);
		driver.get(prop.getProperty("url"));
	}
	
	public void failed(String testMethodName){
		File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		
		try {
			//FileUtils.copyFile(scrFile, new File("E:\\WorkSpace\\CRMProject\\screenshots\\testfailure.jpg")); //will overwrite the jpg with latest failure shots.
			//FileUtils.copyFile(scrFile, new File("E:\\WorkSpace\\CRMProject\\screenshots\\"+"failshot_"+this.getClass().getName()+"_"+".jpg"));
			FileUtils.copyFile(scrFile, new File("D:\\WorkSpace\\Ekal\\EkalW\\Screenshots\\"+testMethodName+"_"+".jpg"));
			} catch (IOException e) {e.printStackTrace();}
	}
	
	   //* Waits for given element to be clickable nvn
	   public static void clickOn(WebDriver driver,WebElement locator,int timeout){
		
		new WebDriverWait(driver, timeout).ignoring(StaleElementReferenceException.class).until(ExpectedConditions.elementToBeClickable(locator));
		
		//in test-case just call clickOn(driver,driver.findElement(By.id(someid)),20); //will wait for 20 sec to load login button.
		
		//OR use below syntax:-
		 //WebDriverWait wait = new WebDriverWait(driver, 10);
		// WebElement element = wait.until(ExpectedConditions.elementToBeClickable(By.id(>someid>)));
	}
	   //WaitUtilities
	   
	   //* Waits for a given element to be visible
	   public static void waitForElementVisible(WebDriver driver, WebElement e){
			WebDriverWait wait = new WebDriverWait(driver, 60);
			WebElement element = wait.until(ExpectedConditions.visibilityOf(e));
			
			//in test-case just call waitForElementVisible(driver, driver.findElement(By.xpath(".//span[contains(text(),'Login With SIMS ID')]")));
		}
	   
	   //*Waits for a given element to be selected
	   public static void waitForElementSelected(WebDriver driver, WebElement e){
			WebDriverWait wait = new WebDriverWait(driver, 60);
			Boolean bool = wait.until(ExpectedConditions.elementToBeSelected(e));
		}
	   
	   
	   //* Waits for the page to have a given title
	   public static boolean waitForPageTitle(WebDriver driver, String title){
			WebDriverWait wait = new WebDriverWait(driver, 60);
			return wait.until(ExpectedConditions.titleContains(title));
		}
	   
	   //*Sleep script for the specified length Generally for testcase trial
	   public static void sleep(long length){
		    try {
		        Thread.sleep(length);
		    } catch (InterruptedException e) {
		        e.printStackTrace();
		    }
		}
	   
	   
   
  
	
}
