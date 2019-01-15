package com.ekalw.qa.demo;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class PaginationTableNestedForLoopUsingBreak {

	static ChromeDriver driver;

	public static void main(String[] args) throws InterruptedException {

		System.setProperty("webdriver.chrome.driver", "D://softwares//browsers//chromedriver_win32//chromedriver.exe");
		driver = new ChromeDriver();

		driver.get("https://demo.openmrs.org/openmrs/appointmentschedulingui/manageAppointmentTypes.page");
		// driver.get("https://demo.openmrs.org/openmrs/login.htm");
		Thread.sleep(5000);
		driver.findElement(By.id("username")).sendKeys("Admin");
		driver.findElement(By.id("password")).sendKeys("Admin123");
		driver.findElement(By.id("Inpatient Ward")).click();
		driver.findElement(By.xpath("//form[@id='login-form']")).submit();
		boolean result = verifyServiceType("Urology");
		System.out.println("result is : " + result);

	}

	public static boolean verifyServiceType(String sName) throws InterruptedException {
		boolean result = false;
		List<WebElement> pageList = driver.findElements(By.xpath(".//*[@id='appointmentTypesTable_paginate']/span/a"));
		List<WebElement> tdList = driver.findElements(By.xpath(".//*[@id='appointmentTypesTable']/tbody/tr/td[1]"));

		// Example for Nested for loop

		if (pageList.size() > 0) {
			
			System.out.println("pagination exists");

			// click on pagination link
			for (int i = 0; i < pageList.size(); i++) {

				pageList = driver.findElements(By.xpath(".//*[@id='appointmentTypesTable_paginate']/span/a"));
				pageList.get(i).click();
				tdList = driver.findElements(By.xpath(".//*[@id='appointmentTypesTable']/tbody/tr/td[1]"));

				for (int j = 0; j < tdList.size(); j++) {

					// System.out.println(tdList.get(j).getText()); Check if all from first to last table data displayed correctly
					
					if (tdList.get(j).getText().equals(sName)) {

						System.out.println("Service Type Found!!!");
						result = true;
						break;
						}

					}
				}
			
			} else {
					System.out.println("pagination not exists");
					}

		return result;
	}
}
