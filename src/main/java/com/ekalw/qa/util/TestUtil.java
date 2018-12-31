package com.ekalw.qa.util;

import com.ekalw.qa.base.TestBase;

public class TestUtil extends TestBase {
	
	public static long PAGE_LOAD_TIMEOUT =40;
	public static long IMPLICIT_WAIT=30;

    //Below method not used till date 
	public void switchToFrame(){
		
		driver.switchTo().frame("mainpanel");
	}

}
