package com.qlm.qa.testcases;

import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.qlm.qa.base.TestBase;
import com.qlm.qa.listener.CustomListener;
import com.qlm.qa.pages.HomePage;
import com.qlm.qa.pages.LoginPage;
import com.qlm.qa.pages.NonConformityCreatePage;
import com.qlm.qa.pages.NonConformityPage;
import com.qlm.qa.util.TestUtil;

@Listeners(CustomListener.class)
public class NonConformityCreatePageTest extends TestBase
{
	LoginPage loginpage;
	HomePage homepage;
	NonConformityPage nonconformitypage;
	NonConformityCreatePage nonconformitycreatepage;
	
	String sheetName="NonConformityCreate";
	
	Logger log = Logger.getLogger(NonConformityCreatePageTest.class);
	
	public NonConformityCreatePageTest()
	{
		super();
	}
	
	@BeforeMethod 
	public void setUp() throws InterruptedException
	{ 
		log.info("***************** Test SetUp Started *****************");
		initialize();
		loginpage = new LoginPage();
		homepage = loginpage.login(prop.getProperty("username"), prop.getProperty("password"));
		log.info("Admin Login Successfull");
		nonconformitypage = homepage.clickOnNonConformitylink();
		nonconformitycreatepage = nonconformitypage.clickOnCreateNewNonConformityBtn();
	}
	
	@Test(priority=1)
	public void validateNonConformityCreatePageTitleTest()
	{
		log.info("********* validateNonConformityCreatePageTitleTest Execution Started *********");
		String pagetitle=nonconformitycreatepage.validateNonConformityCreatePageTitle();
		Assert.assertEquals(pagetitle, "Non Conformity Create - Quality Lifecycle Management - QA");
		log.info("Page title is:"+pagetitle);
		log.info("********* validateNonConformityCreatePageTitleTest Execution Ends *********");
	}
	
	@DataProvider
	public Object[][] getNCTestData()
	{
		Object data[][]=TestUtil.getTestData(sheetName);
		return data;
	}  

	@Test(priority=2,dataProvider="getNCTestData")
	public void validateCreateNonConformityTest(String tName,String tProductLine,String tNCCategory,String tNCType,String tPartNumber,String tDefect,
            String tReviewer,String tSupplier,String tSupplierCoordinator,String tSupplierLocation,String tSupplierPlant) throws InterruptedException
	{
		log.info("********* validateCreateNonConformityTest Execution Started *********");
		nonconformitycreatepage.createNonConformity(tName, tProductLine, tNCCategory, tNCType, tPartNumber, tDefect, tReviewer, tSupplier, tSupplierCoordinator, tSupplierLocation, tSupplierPlant);
		log.info("********* validateCreateNonConformityTest Execution Ends *********");
	}

	@AfterMethod
	public void tearDown()
	{
	  driver.quit();
	  log.info("********* Browser Closed *********");
	}
	
}
