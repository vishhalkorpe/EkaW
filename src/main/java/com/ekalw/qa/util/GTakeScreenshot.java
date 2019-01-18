package com.ekalw.qa.util;

import java.io.File;

import org.apache.commons.io.FileUtils;

import org.openqa.selenium.OutputType;

import org.openqa.selenium.TakesScreenshot;

import org.openqa.selenium.WebDriver;

import org.openqa.selenium.firefox.FirefoxDriver;

import org.testng.annotations.Test;

import com.ekalw.qa.base.TestBase22;



public class GTakeScreenshot extends TestBase22 {

	public static void takeSnapShot(WebDriver driver, String fileWithPath) throws Exception {

		// Convert web driver object to TakeScreenshot

		TakesScreenshot scrShot = ((TakesScreenshot) driver);

		// Call getScreenshotAs method to create image file

		File SrcFile = scrShot.getScreenshotAs(OutputType.FILE);

		// Move image file to new destination

		File DestFile = new File(fileWithPath);

		// Copy file at destination

		FileUtils.copyFile(SrcFile, DestFile);

	}

}