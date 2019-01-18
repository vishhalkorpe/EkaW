package com.ekalw.qa.util;

import com.ekalw.qa.base.TestBase22;

public class TestUtil extends TestBase22 {
	
	public static long PAGE_LOAD_TIMEOUT =50;
	public static long IMPLICIT_WAIT=40;
	public static int Click_VISIBLE_WAIT=20;
	

    //Below method not used till date 
	public void switchToFrame(){
		
		driver.switchTo().frame("mainpanel");
	}

}
