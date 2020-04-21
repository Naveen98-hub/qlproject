package com.qlm.qa.testcases;

import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.qlm.qa.base.TestBase;
import com.qlm.qa.listener.CustomListener;
import com.qlm.qa.pages.HomePage;
import com.qlm.qa.pages.LoginPage;
import com.qlm.qa.pages.NonConformityPage;
import com.qlm.qa.pages.NonConformityViewPage;

@Listeners(CustomListener.class)
public class NonConformityViewPageTest extends TestBase
{
	LoginPage loginpage;
	HomePage homepage;
	NonConformityPage nonconformitypage;
	NonConformityViewPage nonconformityviewpage;
	
	Logger log = Logger.getLogger(NonConformityViewPageTest.class);
	
	public NonConformityViewPageTest()
	{
		super();
	}
	
	@BeforeMethod 
	public void setUp() throws InterruptedException
	{ 
		log.info("***************** Test SetUp Started *****************");
		initialize();
	}
	
	@Test(priority=1)
	public void validateNonConformityViewPageTitleTest()
	{
		log.info("********* validateNonConformityViewPageTitleTest Execution Started *********");
		String pagetitle=nonconformityviewpage.validateNonConformityViewPageTitle();
		Assert.assertEquals(pagetitle, "Non Conformity View - Quality Lifecycle Management - QA");
		log.info("Page title is:"+pagetitle);
		log.info("********* validateNonConformityViewPageTitleTest Execution Ends *********");
	}
		
	void beforeMethodforAdmin() throws InterruptedException
	{
		loginpage = new LoginPage();
		homepage = loginpage.login(prop.getProperty("username"), prop.getProperty("password"));
		nonconformitypage = homepage.clickOnNonConformitylink();
		nonconformityviewpage=nonconformitypage.clickOnNonConformityViewBtn();
	}
		
	@Test(priority=2)
	public void validateRequestSortingTest() throws InterruptedException
	{
		log.info("********* validateRequestSortingTest Execution Started *********");
		beforeMethodforAdmin();
		nonconformityviewpage.clickOnRequestSortingBtn();
		nonconformityviewpage.submitRequestSorting();
		log.info("********* validateRequestSortingTest Execution Ends *********");
	}
	
	void beforeMethodforSupplier() throws InterruptedException
	{
		loginpage = new LoginPage();
		homepage = loginpage.login(prop.getProperty("supplierusername"), prop.getProperty("supplierpassword"));
		nonconformitypage = homepage.clickOnNonConformitylink();
		nonconformityviewpage=nonconformitypage.clickOnNonConformityViewBtn();
	}
	
	@Test(priority=3)
	public void validateAcknowledgeSortingTest() throws InterruptedException
	{
		log.info("********* validateAcknowledgeSortingTest Execution Started *********");
		beforeMethodforSupplier();
		nonconformityviewpage.clickOnAcknowledgeSortingBtn();
		nonconformityviewpage.submitAcknowledgeSorting();
		log.info("********* validateAcknowledgeSortingTest Execution Ends *********");
	}
			
	@AfterMethod
	public void tearDown()
	{
	  driver.quit();
	  log.info("********* Browser Closed *********");
	}

}
