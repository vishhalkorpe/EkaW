package com.ekalw.qa.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.ekalw.qa.base.TestBase;
import com.ekalw.qa.base.TestChk;

public class ClusterDetailsPage extends TestBase {

	// Page Factory or Object Repository
	@FindBy(css = "#root div.page-content div:nth-of-type(1) table.MuiTable-root-190 tbody.MuiTableBody-root-205 tr:nth-of-type(23) th:nth-of-type(2) a")
	@CacheLookup
	private WebElement _1033;

	@FindBy(css = "#root div.page-content div:nth-of-type(1) table.MuiTable-root-190 tbody.MuiTableBody-root-205 tr:nth-of-type(29) th:nth-of-type(2) a")
	@CacheLookup
	private WebElement _1133;

	@FindBy(css = "#root div.page-content div:nth-of-type(1) table.MuiTable-root-190 tbody.MuiTableBody-root-205 tr:nth-of-type(31) th:nth-of-type(2) a")
	@CacheLookup
	private WebElement _1233;

	@FindBy(css = "#root div.page-content div:nth-of-type(1) table.MuiTable-root-190 tbody.MuiTableBody-root-205 tr:nth-of-type(16) th:nth-of-type(2) a")
	@CacheLookup
	private WebElement _130;

	@FindBy(css = "#root div.page-content div:nth-of-type(1) table.MuiTable-root-190 tbody.MuiTableBody-root-205 tr:nth-of-type(2) th:nth-of-type(2) a")
	@CacheLookup
	private WebElement _132;

	@FindBy(css = "#root div.page-content div:nth-of-type(1) table.MuiTable-root-190 tbody.MuiTableBody-root-205 tr:nth-of-type(1) th:nth-of-type(2) a")
	@CacheLookup
	private WebElement _133;

	@FindBy(css = "#root div.page-content div:nth-of-type(1) table.MuiTable-root-190 tbody.MuiTableBody-root-205 tr:nth-of-type(33) th:nth-of-type(2) a")
	@CacheLookup
	private WebElement _1333;

	@FindBy(css = "#root div.page-content div:nth-of-type(1) table.MuiTable-root-190 tbody.MuiTableBody-root-205 tr:nth-of-type(4) th:nth-of-type(2) a")
	@CacheLookup
	private WebElement _134;

	@FindBy(css = "#root div.page-content div:nth-of-type(1) table.MuiTable-root-190 tbody.MuiTableBody-root-205 tr:nth-of-type(11) th:nth-of-type(2) a")
	@CacheLookup
	private WebElement _135;

	@FindBy(css = "#root div.page-content div:nth-of-type(1) table.MuiTable-root-190 tbody.MuiTableBody-root-205 tr:nth-of-type(24) th:nth-of-type(2) a")
	@CacheLookup
	private WebElement _230;

	@FindBy(css = "#root div.page-content div:nth-of-type(1) table.MuiTable-root-190 tbody.MuiTableBody-root-205 tr:nth-of-type(10) th:nth-of-type(2) a")
	@CacheLookup
	private WebElement _232;

	@FindBy(css = "#root div.page-content div:nth-of-type(1) table.MuiTable-root-190 tbody.MuiTableBody-root-205 tr:nth-of-type(3) th:nth-of-type(2) a")
	@CacheLookup
	private WebElement _233;

	@FindBy(css = "#root div.page-content div:nth-of-type(1) table.MuiTable-root-190 tbody.MuiTableBody-root-205 tr:nth-of-type(6) th:nth-of-type(2) a")
	@CacheLookup
	private WebElement _234;

	@FindBy(css = "#root div.page-content div:nth-of-type(1) table.MuiTable-root-190 tbody.MuiTableBody-root-205 tr:nth-of-type(18) th:nth-of-type(2) a")
	@CacheLookup
	private WebElement _235;

	@FindBy(css = "#root div.page-content div:nth-of-type(1) table.MuiTable-root-190 tbody.MuiTableBody-root-205 tr:nth-of-type(8) th:nth-of-type(2) a")
	@CacheLookup
	private WebElement _27;

	@FindBy(css = "#root div.page-content div:nth-of-type(1) table.MuiTable-root-190 tbody.MuiTableBody-root-205 tr:nth-of-type(17) th:nth-of-type(2) a")
	@CacheLookup
	private WebElement _31;

	@FindBy(css = "#root div.page-content div:nth-of-type(1) table.MuiTable-root-190 tbody.MuiTableBody-root-205 tr:nth-of-type(25) th:nth-of-type(2) a")
	@CacheLookup
	private WebElement _330;

	@FindBy(css = "#root div.page-content div:nth-of-type(1) table.MuiTable-root-190 tbody.MuiTableBody-root-205 tr:nth-of-type(19) th:nth-of-type(2) a")
	@CacheLookup
	private WebElement _332;

	@FindBy(css = "#root div.page-content div:nth-of-type(1) table.MuiTable-root-190 tbody.MuiTableBody-root-205 tr:nth-of-type(5) th:nth-of-type(2) a")
	@CacheLookup
	private WebElement _333;

	@FindBy(css = "#root div.page-content div:nth-of-type(1) table.MuiTable-root-190 tbody.MuiTableBody-root-205 tr:nth-of-type(12) th:nth-of-type(2) a")
	@CacheLookup
	private WebElement _334;

	@FindBy(css = "#root div.page-content div:nth-of-type(1) table.MuiTable-root-190 tbody.MuiTableBody-root-205 tr:nth-of-type(26) th:nth-of-type(2) a")
	@CacheLookup
	private WebElement _335;

	@FindBy(css = "#root div.page-content div:nth-of-type(1) table.MuiTable-root-190 tbody.MuiTableBody-root-205 tr:nth-of-type(30) th:nth-of-type(2) a")
	@CacheLookup
	private WebElement _432;

	@FindBy(css = "#root div.page-content div:nth-of-type(1) table.MuiTable-root-190 tbody.MuiTableBody-root-205 tr:nth-of-type(7) th:nth-of-type(2) a")
	@CacheLookup
	private WebElement _433;

	@FindBy(css = "#root div.page-content div:nth-of-type(1) table.MuiTable-root-190 tbody.MuiTableBody-root-205 tr:nth-of-type(14) th:nth-of-type(2) a")
	@CacheLookup
	private WebElement _434;

	@FindBy(css = "#root div.page-content div:nth-of-type(1) table.MuiTable-root-190 tbody.MuiTableBody-root-205 tr:nth-of-type(9) th:nth-of-type(2) a")
	@CacheLookup
	private WebElement _533;

	@FindBy(css = "#root div.page-content div:nth-of-type(1) table.MuiTable-root-190 tbody.MuiTableBody-root-205 tr:nth-of-type(20) th:nth-of-type(2) a")
	@CacheLookup
	private WebElement _534;

	@FindBy(css = "#root div.page-content div:nth-of-type(1) table.MuiTable-root-190 tbody.MuiTableBody-root-205 tr:nth-of-type(13) th:nth-of-type(2) a")
	@CacheLookup
	private WebElement _633;

	@FindBy(css = "#root div.page-content div:nth-of-type(1) table.MuiTable-root-190 tbody.MuiTableBody-root-205 tr:nth-of-type(27) th:nth-of-type(2) a")
	@CacheLookup
	private WebElement _634;

	@FindBy(css = "#root div.page-content div:nth-of-type(1) table.MuiTable-root-190 tbody.MuiTableBody-root-205 tr:nth-of-type(15) th:nth-of-type(2) a")
	@CacheLookup
	private WebElement _733;

	@FindBy(css = "#root div.page-content div:nth-of-type(1) table.MuiTable-root-190 tbody.MuiTableBody-root-205 tr:nth-of-type(28) th:nth-of-type(2) a")
	@CacheLookup
	private WebElement _734;

	@FindBy(css = "#root div.page-content div:nth-of-type(1) table.MuiTable-root-190 tbody.MuiTableBody-root-205 tr:nth-of-type(21) th:nth-of-type(2) a")
	@CacheLookup
	private WebElement _833;

	@FindBy(css = "#root div.page-content div:nth-of-type(1) table.MuiTable-root-190 tbody.MuiTableBody-root-205 tr:nth-of-type(32) th:nth-of-type(2) a")
	@CacheLookup
	private WebElement _834;

	@FindBy(css = "#root div.page-content div:nth-of-type(1) table.MuiTable-root-190 tbody.MuiTableBody-root-205 tr:nth-of-type(22) th:nth-of-type(2) a")
	@CacheLookup
	private WebElement _933;

	@FindBy(css = "#root div.page-content div:nth-of-type(1) table.MuiTable-root-190 tbody.MuiTableBody-root-205 tr:nth-of-type(23) th:nth-of-type(1) a")
	@CacheLookup
	private WebElement aaptale;

	@FindBy(css = "#root div.page-content div:nth-of-type(1) table.MuiTable-root-190 tbody.MuiTableBody-root-205 tr:nth-of-type(24) th:nth-of-type(1) a")
	@CacheLookup
	private WebElement aase;

	@FindBy(css = "#root div.page-content div:nth-of-type(1) table.MuiTable-root-190 tbody.MuiTableBody-root-205 tr:nth-of-type(18) th:nth-of-type(1) a")
	@CacheLookup
	private WebElement bilgaon;

	@FindBy(css = "#root div.page-content div:nth-of-type(1) table.MuiTable-root-190 tbody.MuiTableBody-root-205 tr:nth-of-type(27) th:nth-of-type(1) a")
	@CacheLookup
	private WebElement dab;

	@FindBy(css = "#root div.page-content div:nth-of-type(1) table.MuiTable-root-190 tbody.MuiTableBody-root-205 tr:nth-of-type(22) th:nth-of-type(1) a")
	@CacheLookup
	private WebElement dehane;

	@FindBy(css = "#root div.page-content div:nth-of-type(1) table.MuiTable-root-190 tbody.MuiTableBody-root-205 tr:nth-of-type(11) th:nth-of-type(1) a")
	@CacheLookup
	private WebElement gargaon;

	@FindBy(css = "#root div.page-content div:nth-of-type(1) table.MuiTable-root-190 tbody.MuiTableBody-root-205 tr:nth-of-type(2) th:nth-of-type(1) a")
	@CacheLookup
	private WebElement ghatandevi;

	@FindBy(css = "#root div.page-content div:nth-of-type(1) table.MuiTable-root-190 tbody.MuiTableBody-root-205 tr:nth-of-type(26) th:nth-of-type(1) a")
	@CacheLookup
	private WebElement jogmodi;

	@FindBy(css = "#root div.page-content div:nth-of-type(1) table.MuiTable-root-190 tbody.MuiTableBody-root-205 tr:nth-of-type(20) th:nth-of-type(1) a")
	@CacheLookup
	private WebElement karanjali;

	@FindBy(css = "#root div.page-content div:nth-of-type(1) table.MuiTable-root-190 tbody.MuiTableBody-root-205 tr:nth-of-type(19) th:nth-of-type(1) a")
	@CacheLookup
	private WebElement kogda;

	@FindBy(css = "#root div.page-content div:nth-of-type(1) table.MuiTable-root-190 tbody.MuiTableBody-root-205 tr:nth-of-type(10) th:nth-of-type(1) a")
	@CacheLookup
	private WebElement kothali;

	@FindBy(css = "#root div.page-content div:nth-of-type(1) table.MuiTable-root-190 tbody.MuiTableBody-root-205 tr:nth-of-type(12) th:nth-of-type(1) a")
	@CacheLookup
	private WebElement mandvi;

	@FindBy(css = "#root div.page-content div:nth-of-type(1) table.MuiTable-root-190 tbody.MuiTableBody-root-205 tr:nth-of-type(33) th:nth-of-type(1) a")
	@CacheLookup
	private WebElement modhalgaon;

	@FindBy(css = "#root div.page-content div:nth-of-type(1) table.MuiTable-root-190 tbody.MuiTableBody-root-205 tr:nth-of-type(1) th:nth-of-type(1) a")
	@CacheLookup
	private WebElement molgi;

	@FindBy(css = "#root div.page-content div:nth-of-type(1) table.MuiTable-root-190 tbody.MuiTableBody-root-205 tr:nth-of-type(15) th:nth-of-type(1) a")
	@CacheLookup
	private WebElement morhanda;

	@FindBy(css = "#root div.page-content div:nth-of-type(1) table.MuiTable-root-190 tbody.MuiTableBody-root-205 tr:nth-of-type(3) th:nth-of-type(1) a")
	@CacheLookup
	private WebElement naylonthi;

	@FindBy(css = "#root div.page-content div:nth-of-type(1) table.MuiTable-root-190 tbody.MuiTableBody-root-205 tr:nth-of-type(8) th:nth-of-type(1) a")
	@CacheLookup
	private WebElement nimgiri;

	@FindBy(css = "#root div.page-content div:nth-of-type(1) table.MuiTable-root-190 tbody.MuiTableBody-root-205 tr:nth-of-type(29) th:nth-of-type(1) a")
	@CacheLookup
	private WebElement otur;

	@FindBy(css = "#root div.page-content div:nth-of-type(1) table.MuiTable-root-190 tbody.MuiTableBody-root-205 tr:nth-of-type(13) th:nth-of-type(1) a")
	@CacheLookup
	private WebElement ozarkhed;

	private final String pageLoadedText = "Varsha Dnyaneshwar Memane (sanch nimgiri)";

	private final String pageUrl = "/clusters";

	@FindBy(css = "#root div.page-content div:nth-of-type(1) table.MuiTable-root-190 tbody.MuiTableBody-root-205 tr:nth-of-type(25) th:nth-of-type(1) a")
	@CacheLookup
	private WebElement parali;

	@FindBy(css = "#root div.page-content div:nth-of-type(1) table.MuiTable-root-190 tbody.MuiTableBody-root-205 tr:nth-of-type(9) th:nth-of-type(1) a")
	@CacheLookup
	private WebElement pimplekhunta;

	@FindBy(css = "#root div.page-content div:nth-of-type(1) table.MuiTable-root-190 tbody.MuiTableBody-root-205 tr:nth-of-type(14) th:nth-of-type(1) a")
	@CacheLookup
	private WebElement pratapgad;

	@FindBy(css = "#root div.page-content div:nth-of-type(1) table.MuiTable-root-190 tbody.MuiTableBody-root-205 tr:nth-of-type(6) th:nth-of-type(1) a")
	@CacheLookup
	private WebElement sakur;

	@FindBy(css = "#root div.page-content div:nth-of-type(1) table.MuiTable-root-190 tbody.MuiTableBody-root-205 tr:nth-of-type(7) th:nth-of-type(1) a")
	@CacheLookup
	private WebElement saturli;

	@FindBy(css = "#root div.page-content div:nth-of-type(1) table.MuiTable-root-190 tbody.MuiTableBody-root-205 tr:nth-of-type(4) th:nth-of-type(1) a")
	@CacheLookup
	private WebElement shirasgaon;

	@FindBy(css = "a.headerLink")
	@CacheLookup
	private WebElement simsIndia;

	@FindBy(css = "#root div.page-content div:nth-of-type(1) table.MuiTable-root-190 tbody.MuiTableBody-root-205 tr:nth-of-type(28) th:nth-of-type(1) a")
	@CacheLookup
	private WebElement survani;

	@FindBy(css = "#root div.page-content div:nth-of-type(1) table.MuiTable-root-190 tbody.MuiTableBody-root-205 tr:nth-of-type(16) th:nth-of-type(1) a")
	@CacheLookup
	private WebElement suryamal;

	@FindBy(css = "#root div.page-content div:nth-of-type(1) table.MuiTable-root-190 tbody.MuiTableBody-root-205 tr:nth-of-type(17) th:nth-of-type(1) a")
	@CacheLookup
	private WebElement taleghar;

	@FindBy(css = "#root div.page-content div:nth-of-type(1) table.MuiTable-root-190 tbody.MuiTableBody-root-205 tr:nth-of-type(30) th:nth-of-type(1) a")
	@CacheLookup
	private WebElement thanapada;

	@FindBy(css = "#root div.page-content div:nth-of-type(1) table.MuiTable-root-190 tbody.MuiTableBody-root-205 tr:nth-of-type(5) th:nth-of-type(1) a")
	@CacheLookup
	private WebElement tirpad;

	@FindBy(css = "#root div.page-content div:nth-of-type(1) table.MuiTable-root-190 tbody.MuiTableBody-root-205 tr:nth-of-type(32) th:nth-of-type(1) a")
	@CacheLookup
	private WebElement umbarthan;

	@FindBy(css = "#root div.page-content div:nth-of-type(1) table.MuiTable-root-190 tbody.MuiTableBody-root-205 tr:nth-of-type(21) th:nth-of-type(1) a")
	@CacheLookup
	private WebElement vaitarna;

	@FindBy(css = "#root div.page-content div:nth-of-type(1) table.MuiTable-root-190 tbody.MuiTableBody-root-205 tr:nth-of-type(31) th:nth-of-type(1) a")
	@CacheLookup
	private WebElement vinval;

	// Initializing the Page Object
	public ClusterDetailsPage() {

		PageFactory.initElements(driver, this);

	}

	// Actions
	
	/**
	 * Verify that current page URL matches the expected URL.
	 *
	 */
	
	public boolean verifyPageUrl() {
					
		String pageUrl = "/clusters";
		sleep(5000);
		System.out.println("pageurl verified");
		
		return driver.getCurrentUrl().contains(pageUrl);
			
	}
	
	/**
	 * Click on 33 Link.
	 */
	public boolean click1Link33() {
		sleep(5000);
		System.out.println("click click1Link33");
		
		_133.click();
		
		return this != null;
	}
	
	/**
	 * Click on Bilgaon Link.
	 *
	 * @return the DashboardPage2 class instance.
	 */
	public ClusterDetailsPage clickBilgaonLink() {
		sleep(5000);
		System.out.println("click Bilgain");
		bilgaon.click();
		return this;
	}
	
	/**
	 * Click on Molgi Link.
	 *
	 * @return the DashboardPage2 class instance.
	 */
	public ClusterDetailsPage clickMolgiLink() {
		sleep(5000);
		System.out.println("click molgi");
		molgi.click();
		return this;
	}
	

}
