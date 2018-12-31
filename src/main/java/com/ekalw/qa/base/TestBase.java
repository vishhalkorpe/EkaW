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
			FileUtils.copyFile(scrFile, new File("D:\\WorkSpace\\EKalTestNgScreenshot\\"+testMethodName+"_"+".jpg"));
			} catch (IOException e) {e.printStackTrace();}
	}
	
   public static void clickOn(WebDriver driver,WebElement locator,int timeout){
		
		new WebDriverWait(driver, timeout).ignoring(StaleElementReferenceException.class).until(ExpectedConditions.elementToBeClickable(locator));
		
		//in test-case just call clickOn(driver,driver.findElement(By.id(someid)),20); //will wait for 20 sec to load login button.
		
		//OR syntax:-
		 //WebDriverWait wait = new WebDriverWait(driver, 10);

		// WebElement element = wait.until(ExpectedConditions.elementToBeClickable(By.id(>someid>)));
	}
   
   //Vishal methodshttps://www.testingexcellence.com/page-object-framework-java-webdriver/
   
   public static WebDriverWait wait;
   
   public static void waitForElementToAppear(By locator) {
       wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
   }
   
   public void waitForElementToDisappear(By locator) {
       wait.until(ExpectedConditions.invisibilityOfElementLocated(locator));
   }

   public void waitForTextToDisappear(By locator, String text) {
       wait.until(ExpectedConditions.not(ExpectedConditions.textToBe(locator, text)));
   }
	
}
