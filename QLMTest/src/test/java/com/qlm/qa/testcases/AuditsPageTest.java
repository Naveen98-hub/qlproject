package com.qlm.qa.testcases;

import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qlm.qa.base.TestBase;
import com.qlm.qa.pages.AuditsPage;
import com.qlm.qa.pages.HomePage;
import com.qlm.qa.pages.LoginPage;

public class AuditsPageTest extends TestBase
{
	LoginPage loginpage;
	HomePage homePage;
	AuditsPage auditspage;
	
	Logger log = Logger.getLogger(AuditTemplateIndexPageTest.class);
	
	public AuditsPageTest()
	{
		super();
	}

	@BeforeMethod 
	public void setUp() throws InterruptedException
	{ 
		log.info("***************** Test SetUp Started *****************");
		initialize();
		loginpage = new LoginPage();
		homePage = loginpage.login(prop.getProperty("username"), prop.getProperty("password"));
		log.info("Admin Login Successfull");
		auditspage = homePage.clickOnAuditElement();
	}
	
	@Test(priority=1)
	public void validateAuditsPageTitleTest()
	{
		log.info("********* validateAuditsPageTitleTest Execution Started *********");
		String pageTitle=auditspage.validateAuditsPageTitle();
		Assert.assertEquals(pageTitle, "Audits - Quality Lifecycle Management - QA");
		log.info("Page title is:"+pageTitle);
		log.info("********* validateAuditsPageTitleTest Execution Ends *********");
	}
	
	@Test(priority=2)
	public void validateCreateNewAuditBtnTest() throws InterruptedException
	{
		log.info("********* validateCreateNewAuditBtn Execution Started *********");
		auditspage.createNewAuditBtn();
		log.info("********* validateCreateNewAuditBtn Execution Ends *********");
	}
	
	@AfterMethod
	public void tearDown()
	{
	  driver.quit();
	  log.info("********* Browser Closed *********");
	}
	
}
