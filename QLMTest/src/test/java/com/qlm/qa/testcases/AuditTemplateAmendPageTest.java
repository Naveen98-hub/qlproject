package com.qlm.qa.testcases;

import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.qlm.qa.base.TestBase;
import com.qlm.qa.listener.CustomListener;
import com.qlm.qa.pages.AuditTemplateAmendPage;
import com.qlm.qa.pages.AuditTemplateCreatePage;
import com.qlm.qa.pages.AuditTemplateIndexPage;
import com.qlm.qa.pages.HomePage;
import com.qlm.qa.pages.LoginPage;

@Listeners(CustomListener.class)
public class AuditTemplateAmendPageTest extends TestBase
{
	LoginPage loginpage;
	HomePage homePage;
	AuditTemplateIndexPage audittemplateindexpage;
	AuditTemplateCreatePage audittemplatecreatepage;
	AuditTemplateAmendPage audittemplateamendpage;
	
	Logger log = Logger.getLogger(AuditTemplateAmendPageTest.class);
	
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
	public void validateAuditTemplateAmendPageTitleTest()
	{
		log.info("********* validateAuditTemplateAmendPageTitleTest Execution Started *********");
		String pageTitle=audittemplateamendpage.validateAuditTemplateAmendPageTitle();
		Assert.assertEquals(pageTitle, "Template Amend - Quality Lifecycle Management - QA");
		log.info("Page title is:"+pageTitle);
		log.info("********* validateAuditTemplateAmendPageTitleTest Execution Ends *********");
	}
	
	@Test(priority=2)// retryAnalyzer= Analyzer.RetryAnalyzer.class
	public void validateSubmitAuditTemplateTest() throws InterruptedException
	{
		log.info("********* validateSubmitAuditTemplateTest Execution Started *********");
		//Assert.assertEquals(false, true);
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
