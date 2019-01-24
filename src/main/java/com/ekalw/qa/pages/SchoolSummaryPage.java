package com.ekalw.qa.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.ekalw.qa.base.TestBase;

public class SchoolSummaryPage extends TestBase{
	
	// Page Factory or Object Repository
	public final String pageUrl = "/schoolReportDetails";
	
	public final String pageLoadedText = "School Summary";
	
	 @FindBy(css = "#root div.page-content div:nth-of-type(1) table.MuiTable-root-216 tbody.MuiTableBody-root-231 tr:nth-of-type(206) th.MuiTableCell-root-223.MuiTableCell-body-225 a")
	    @CacheLookup
	    public WebElement zyucvSchool;
	 
	    @FindBy(css = "#root div.page-content div:nth-of-type(1) table.MuiTable-root-216 tbody.MuiTableBody-root-231 tr:nth-of-type(139) th.MuiTableCell-root-223.MuiTableCell-body-225 a")
	    @CacheLookup
	    public WebElement duageSchool;
	    
	    @FindBy(css = "#root div.page-content div:nth-of-type(1) table.MuiTable-root-216 tbody.MuiTableBody-root-231 tr:nth-of-type(4) th.MuiTableCell-root-223.MuiTableCell-body-225 a")
	    @CacheLookup
	    public WebElement aTestSchoolSomewhere;
	    
	    	
	// Initializing the Page Object
		public SchoolSummaryPage() {
			PageFactory.initElements(driver, this);
		}
		
		//******************************Actions**************************************\\
		 /**
	     * Click on A Test School Somewhere Link.
	     *
	     * @return the SSSS class instance.
	     */
	    public boolean clickATestSchoolSomewhereLink() {
	        aTestSchoolSomewhere.click();
	        return this != null;
	    }

	    
	    /**
	     * Click on Duage School Link.
	     *
	     * @return the SSSS class instance.
	     */
	    public boolean clickDuageSchoolLink() {
	        duageSchool.click();
	        return this != null;
	    }

	    		    
	    /**
	     * Click on Zyucv School Link.
	     *
	     * @return the SSSS class instance.
	     */
	    public boolean clickZyucvSchoolLink() {
	        zyucvSchool.click();
	        return this != null;
	    }

	    /**
	     * Verify that the page loaded completely.
	     *
	     * @return the SSSS class instance.
	     */
	    public boolean verifyPageLoaded() {
	        (new WebDriverWait(driver, 10)).until(new ExpectedCondition<Boolean>() {
	            public Boolean apply(WebDriver d) {
	                return d.getPageSource().contains(pageLoadedText);
	            }
	        });
	        return this != null;
	    }

	    /**
	     * Verify that current page URL matches the expected URL.
	     *
	     * @return the SSSS class instance.
	     */
	    public boolean verifyPageUrl() {
	        (new WebDriverWait(driver, 10)).until(new ExpectedCondition<Boolean>() {
	            public Boolean apply(WebDriver d) {
	                return d.getCurrentUrl().contains(pageUrl);
	            }
	        });
	        return this != null;
	    }
	}

