package com.qlm.qa.testcases;

import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qlm.qa.base.TestBase;
import com.qlm.qa.pages.HomePage;
import com.qlm.qa.pages.LoginPage;
import com.qlm.qa.pages.NonConformityPage;

public class NonConformityPageTest extends TestBase
{
	LoginPage loginpage;
	HomePage homepage;
	NonConformityPage nonconformitypage;

	Logger log = Logger.getLogger(AuditTemplateIndexPageTest.class);
	
	public NonConformityPageTest()
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
	}
	
	@Test(priority=1)
	public void validateNonConformityPageTitleTest()
	{
		log.info("********* validateNonConformityPageTitleTest Execution Started *********");
		String pagetitle=nonconformitypage.validateNonConformityPageTitle();
		Assert.assertEquals(pagetitle, "Non Conformity - Quality Lifecycle Management - QA");
		log.info("Page title is:"+pagetitle);
		log.info("********* validateNonConformityPageTitleTest Execution Ends *********");
	}
	
	@Test(priority=2)
	public void validateClickOnCreateNewNonConformityBtnTest() throws InterruptedException
	{
		log.info("********* validateClickOnCreateNewNonConformityBtnTest Execution Started *********");
		nonconformitypage.clickOnCreateNewNonConformityBtn();
		log.info("********* validateClickOnCreateNewNonConformityBtnTest Execution Ends *********");
	}
	
	@AfterMethod
	public void tearDown()
	{
	  driver.quit();
	  log.info("********* Browser Closed *********");
	}
	
}
