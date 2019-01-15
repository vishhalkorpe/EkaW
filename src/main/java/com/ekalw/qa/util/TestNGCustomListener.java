package com.ekalw.qa.util;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.ekalw.qa.base.TestBase;



public class TestNGCustomListener extends TestBase implements ITestListener {

	public void onFinish(ITestContext arg0) {
		// TODO Auto-generated method stub
		
	}

	public void onStart(ITestContext arg0) {
		// TODO Auto-generated method stub
		
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult arg0) {
		// TODO Auto-generated method stub
		
	}

	public void onTestFailure(ITestResult arg0) {
		//get screenshot for every testcase failed
		System.out.println("Failed Test");
		failed(arg0.getMethod().getMethodName());
		
	}

	public void onTestSkipped(ITestResult arg0) {
		// TODO Auto-generated method stub
		//System.out.println("Skipped Test");
		//failed(arg0.getMethod().getMethodName());
		
	}

	public void onTestStart(ITestResult arg0) {
		// TODO Auto-generated method stub
		
	}

	public void onTestSuccess(ITestResult arg0) {
		// TODO Auto-generated method stub
		//System.out.println("Passed Test");
		//failed(arg0.getMethod().getMethodName());
		
	}

		

}
