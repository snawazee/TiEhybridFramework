package com.qa.tie.tests;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.qa.tie.base.BasePage;
import com.qa.tie.page.HomePage;
import com.qa.tie.page.LoginPage;
import com.qa.tie.util.AppConstants;
import com.qa.tie.util.Credentials;

import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;

@Epic("Epic - 102 : create Home page features")
@Feature("US - 502 : create test for Home page on TiE")
public class HomePageTest {

	WebDriver driver;
	BasePage basePage;
	Properties prop;
	LoginPage loginPage;
	HomePage homePage;
	Credentials userCred;

	@BeforeTest(alwaysRun=true)
	@Parameters(value={"browser"})
	public void setUp(String browser) {
		String browserName = null;
		basePage = new BasePage();
		prop = basePage.init_properties();
				
		
		if(browser.equals(null) || browser.equals("") || browser.isEmpty()){
			 browserName = prop.getProperty("browser");
		}else{
			browserName = browser;
		}
		
		
		driver = basePage.init_driver(browserName);
		driver.get(prop.getProperty("url"));
		loginPage = new LoginPage(driver);
		userCred = new Credentials(prop.getProperty("username"), prop.getProperty("password"));
		homePage = loginPage.doLogin(userCred);
	}

	@Test(priority = 1, groups="sanity")
	@Description("verify Home Page Title Test....")
	@Severity(SeverityLevel.NORMAL)
	public void verifyHomePageTitleTest() {
		String title = homePage.getHomePageTitle();
		System.out.println("home page title is : " + title);
		Assert.assertEquals(title, AppConstants.HOME_PAGE_TITLE);
	}

	@Test(priority = 2)
	@Description("verify LoginPage Header Test....")
	@Severity(SeverityLevel.NORMAL)
	public void verifyHomePageHeaderTest() {
		String header = homePage.getHomePageHeader();
		System.out.println("home page header is : " + header);
		Assert.assertEquals(header, AppConstants.HOME_PAGE_HEADER);
	}

	@Test(priority = 3)
	@Description("verify Logged In User Test....")
	@Severity(SeverityLevel.CRITICAL)
	public void verifyLoggedInUserTest() {
		String accountName = homePage.getLoggedInUserAccountName();
		System.out.println("logged in account name : " + accountName);
		Assert.assertEquals(accountName, prop.getProperty("accountname"));
	}
	
	@Test(priority = 4, description="verifying Sales Tab is Dispaying")
	@Severity(SeverityLevel.NORMAL)
	@Description("verifying Sales Tab is Dispaying...")	
	@Story("Story Name:verifying Sales Tab is Dispaying") 
	public void verifySalesTabTest() {
		Assert.assertTrue(homePage.verifySalesMenu(), "sales tab is present or not...");
	
	}

	@Test(priority = 5, description="Pay Bills Button Test...")
	@Severity(SeverityLevel.BLOCKER)
	@Description("user should be able to see Pay Bills Button on dashboard....")	
	@Story("user should be able to see Pay Bills Button on dashboard....") 
	public void verifyPayBillsTabTest() {
		Assert.assertTrue(homePage.verifySalesMenu(), "Paybills  tab is present or not...");
	
	}

	
	@Test(priority = 6, description="Verify Sales Menu....")
	@Severity(SeverityLevel.BLOCKER)
	@Description("user should be able to see sales menu...")	
	@Story("user should be able to see sales menu...") 
	public void verifySalesParentTabTest() throws Exception {
		homePage.verifySalesMenu();
		
		
	}
	
	@Test(priority = 7, description="Verify Pay Bills Menu....")
	@Severity(SeverityLevel.BLOCKER)
	@Description("user should be able to see and open paybills menu...")	
	@Story("user should be able to see and open paybills menu...") 
	public void veriyPayBillsOverviewTabTest() throws Exception {
		homePage.veriyPayBillsOverviewTab();
		
		
	}
	
	@Test(priority = 8, description="Verify Bills Menu under Pay Bills....")
	@Severity(SeverityLevel.BLOCKER)
	@Description("user should be able to see and open bills  menu under Pay Bills...")	
	@Story("user should be able to see and open bills  menu under Pay Bills...") 
	public void veriyBillsMenuTabTest() throws Exception {
		homePage.veriyBillsMenuTab();
	
		
	}
	
	@Test(priority = 9, description="Verify Vendor Menu under Pay Bills....")
	@Severity(SeverityLevel.BLOCKER)
	@Description("user should be able to see and opne vendor  menu under Pay Bills...")	
	@Story("user should be able to see and opne vendor  menu under Pay Bills...") 
	public void veriyVendorMenuTabTest() throws Exception {
		homePage.veriyVendorMenuTab();
		
		
	}
	
	@Test(priority = 10, description="Verify transaction Menu under Pay Bills....")
	@Severity(SeverityLevel.BLOCKER)
	@Description("user should be able to see and opne transaction  menu under Pay Bills...")	
	@Story("user should be able to see and opne transaction  menu under Pay Bills...") 
	public void veriyPayBillsTransactionMenuTabTest() throws Exception {
		homePage.veriyPayBillsTransactionMenuTab();
	
		
	}
	
	@Test(priority = 11, description="Verify reports Menu under Pay Bills....")
	@Severity(SeverityLevel.BLOCKER)
	@Description("user should be able to see and opne reports  menu under Pay Bills...")	
	@Story("user should be able to see and opne reports  menu under Pay Bills...") 
	public void veriyPayBillsReportMenuTabTest() throws Exception {
		homePage.veriyPayBillsReportMenuTab();
		
		
	}
	
	@Test(priority = 12, description="Verify Overview Menu under Sales....")
	@Severity(SeverityLevel.BLOCKER)
	@Description("user should be able to see and opne Overview  menu under Sales...")	
	@Story("user should be able to see and opne Overview  menu under Sales...") 
	public void veriySalesOverviewTabTest() throws Exception {
		homePage.veriySalesOverviewTab();
	
		
	}
	
	@Test(priority = 13, description="Verify Customer Menu under Sales....")
	@Severity(SeverityLevel.BLOCKER)
	@Description("user should be able to see and opne Customer  menu under Sales...")	
	@Story("user should be able to see and opne Customer  menu under Sales...") 
	public void veriyCustomerTabTest() throws Exception {
		homePage.veriyCustomerTab();
	
		
	}
	
	@Test(priority = 14, description="Verify Invoice Menu under Sales....")
	@Severity(SeverityLevel.BLOCKER)
	@Description("user should be able to see and opne Invoice  menu under Sales...")	
	@Story("user should be able to see and opne Invoice  menu under Sales...") 
	public void veriyInvoiceMenuTabTest() throws Exception{
		homePage.verifyInvoiceMenu();
		
		
	}
	
	
	@Test(priority = 15, description="Verify Transaction Menu under Sales....")
	@Severity(SeverityLevel.BLOCKER)
	@Description("user should be able to see and opne Transaction  menu under Sales...")	
	@Story("user should be able to see and opne Transaction  menu under Sales...") 
	public void veriySalesTransactiomTabTest() throws Exception {
		homePage.veriySalesTransactiomTab();
		
		
	}
	
	
	@Test(priority = 16, description="Verify Reports Menu under Sales....")
	@Severity(SeverityLevel.BLOCKER)
	@Description("user should be able to see and opne Reports  menu under Sales...")	
	@Story("user should be able to see and opne Reports  menu under Sales...") 
	public void veriySalesReportTabTest() throws Exception {
		homePage.veriySalesReportTab();
		
		
	}
	//(alwaysRun=true)
	@AfterTest
	public void quitBrowser() {
		driver.quit();
	}

}
