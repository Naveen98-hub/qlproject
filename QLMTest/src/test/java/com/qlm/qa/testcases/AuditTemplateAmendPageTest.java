package com.qlm.qa.testcases;

import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qlm.qa.base.TestBase;
import com.qlm.qa.pages.AuditTemplateAmendPage;
import com.qlm.qa.pages.AuditTemplateCreatePage;
import com.qlm.qa.pages.AuditTemplateIndexPage;
import com.qlm.qa.pages.HomePage;
import com.qlm.qa.pages.LoginPage;

public class AuditTemplateAmendPageTest extends TestBase
{
	LoginPage loginpage;
	HomePage homePage;
	AuditTemplateIndexPage audittemplateindexpage;
	AuditTemplateCreatePage audittemplatecreatepage;
	AuditTemplateAmendPage audittemplateamendpage;
	
	Logger log = Logger.getLogger(AuditTemplateIndexPageTest.class);
	
	public AuditTemplateAmendPageTest()
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
		audittemplateindexpage = homePage.clickOnAuditTemplate();
		audittemplateamendpage=audittemplateindexpage.navigateToAuditTemplateAmendScreen();
	}
	
	@Test(priority=1)
	public void validateAuditTemplateAmendPageTest()
	{
		log.info("********* validateAuditTemplateAmendPageTest Execution Started *********");
		String pageTitle=audittemplateamendpage.validateAuditTemplateAmendPage();
		Assert.assertEquals(pageTitle, "Template Amend - Quality Lifecycle Management - QA");
		log.info("Page title is:"+pageTitle);
		log.info("********* validateAuditTemplateAmendPageTest Execution Ends *********");
	}
	
	@Test(priority=2)
	public void validateSubmitAuditTemplateTest() throws InterruptedException
	{
		log.info("********* validateSubmitAuditTemplateTest Execution Started *********");
		audittemplateamendpage.submitAuditTemplate();
		log.info("********* validateSubmitAuditTemplateTest Execution Ends *********");
	}
	
	@AfterMethod
	public void tearDown()
	{
	  driver.quit();
	  log.info("********* Browser Closed *********");
	}
}