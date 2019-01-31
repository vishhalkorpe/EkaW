package com.ekalw.qa.adminpages;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Sleeper;

import com.ekalw.qa.util.GTakeScreenshot;

public class AdminTeacherSearchPage {

	public static WebDriver driver;

	public static void main(String[] args) throws Exception {

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
		//atsp.clickDeleteTeacher();
		// atsp.searchTeacherByEmailid();
		atsp.deleteTeacherRandom();

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

		// List<WebElement> listlinks =
		// driver.findElements(By.xpath("//div[@class='rt-td']//a[1]"));

		int listSize = listFound.size();
		// int listlinksize=listlinks.size();

		if (listSize == 0) {

			System.out.println("No Teacher available with name: " + emailid);

		} else if (listSize > 1) {

			System.out.println("Duplicate data found");
		}

		else {

			System.out.println(+listSize + " :Teacher found with name:- " + emailid);

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

		int listlinksize = listlinks.size();

		if (listlinksize > 1) {

			for (int i = 1; i <= listlinksize; i++) {

				String b2xapth = "//div[@class='rt-tbody']//div[";
				String a2xpath = "]//div//div[1]";
				String actual2xpath = b2xapth + i + a2xpath;

				WebElement we = driver.findElement(By.xpath(actual2xpath));
				System.out.println(we.getText());
			}
		}

	}

	public void clickDeleteTeacher() throws InterruptedException {

		String emailid = "vaishujain30@gmail.com";

		driver.findElement(By.xpath("//input[@id='filter']")).click();
		Thread.sleep(5000);
		driver.findElement(By.xpath("//input[@id='filter']")).sendKeys(emailid);
		Thread.sleep(5000);

		String bxpath = "//div[text()='";
		String axpath = "']";
		String actualxpath = bxpath + emailid + axpath;
		String furtherpath = "//following::a[starts-with(@id, 'Delete')][1]";

		List<WebElement> listFound = driver.findElements(By.xpath(actualxpath));

		int listSize = listFound.size();
		// int listlinksize=listlinks.size();

		if (listSize == 0) {

			System.out.println("No Teacher available with name: " + emailid);

		} else if (listSize > 1) {

			System.out.println("Duplicate data found");
		}

		else {

			System.out.println(+listSize + " :Teacher found with name:- " + emailid);

			for (WebElement webElement : listFound) {

				String foundnamedata = webElement.getText();

				if (foundnamedata.contains(emailid)) {
					System.out.println("Teachers found successfully");
					driver.findElement(By.xpath(actualxpath + furtherpath)).click();
					Thread.sleep(5000);
					boolean c = driver.findElement(By.xpath("//div[@role='alert']")).isDisplayed();
					if (c == true) {
						driver.findElement(By.xpath("//div[@role='alert']//button//span[text()='Yes']")).click();
						Thread.sleep(5000);
						System.out.println("Teacher is deleted.");
						System.out.println("Reconfirming it:");

						List<WebElement> relistFound = driver.findElements(By.xpath(actualxpath));

						int relistSize = relistFound.size();

						if (relistSize == 0) {

							System.out.println("No Teacher available with name: " + emailid);
							System.out.println("Means teacher is deleted successfully.");

						} else if (relistSize > 0) {

							System.out.println("Teacher is not deleted..its bug");
						}

					} else {
						System.out.println("Alert is not found");
					}

				}
			}

		}

	}

	// Verify teacher RANDOM delete via Name div(3) or email div(5) header //
	/// ***********For random string from row table*****************///

	public void deleteTeacherRandom() throws Exception {

		List<WebElement> rows = driver.findElements(By.xpath("//div[@class='rt-tbody']//div//div[@role='row']"));
		int rowCount = rows.size();
		System.out.println("Total rows in table is " + rowCount);

		String row4used = "//div[@class='rt-tbody']//div[4]/div[@role='row']/following::div[5]";
		
		String followingpath = "//following::a[starts-with(@id, 'Delete')][1]";
		
		String actualTeacherused = driver.findElement(By.xpath(row4used)).getText();
		
		System.out.println("Teacher used is " + actualTeacherused);

		WebElement ele = driver.findElement(By.xpath(row4used));
	 
		boolean flag;
		boolean reflag;
		// -->> now robot have to click hyperlinks 'Delete' // Count' of 'Cluster Head' used above. <<--//
		
		if(ele.getText().contains(actualTeacherused)){

			driver.findElement(By.xpath(row4used + followingpath)).click();
			Thread.sleep(5000);
			driver.findElement(By.xpath("//div[@role='alert']//button//span[text()='Yes']")).click();
			Thread.sleep(5000);
			GTakeScreenshot.takeSnapShot(driver,"D:\\WorkSpace\\Ekal\\EkalW\\ScreenShotManual\\clusterHeadusedpreceding.jpg");
			System.out.println("Teacher id deleted.");
		flag=true;
			}
		else{
				System.out.println("Teacher not found.");
				flag=true;
			}
		
		if(flag=true){
			
			System.out.println("Reconfirming delete");
			String rechkactualTeacherused=driver.findElement(By.xpath(row4used)).getText();
			
			if(rechkactualTeacherused==actualTeacherused){
				
				System.out.println("Reconfirmed teacher is deleted.PASSED");
				reflag=true;
				
			}else{
				
				System.out.println("Reconfirmed teacher not deleted");
				reflag=false;
				}
		}
		else{
			
			System.out.println("Reconfirmed delete failed");
		}
	}
		
}
	
