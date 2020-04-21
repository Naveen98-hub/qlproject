package com.qlm.qa.testcases;

import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.qlm.qa.base.TestBase;
import com.qlm.qa.listener.CustomListener;
import com.qlm.qa.pages.AuditTemplateIndexPage;
import com.qlm.qa.pages.HomePage;
import com.qlm.qa.pages.LoginPage;

@Listeners(CustomListener.class)
public class AuditTemplateIndexPageTest extends TestBase
{
	LoginPage loginpage;
	HomePage homePage;
	AuditTemplateIndexPage audittemplateindexpage;
	
	Logger log = Logger.getLogger(AuditTemplateIndexPageTest.class);
	
	public AuditTemplateIndexPageTest()
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
	}
	
	@Test(priority=1)
	public void validateAuditTemplateIndexPageTitleTest()
	{
		log.info("********* validateAuditTemplateIndexPageTitleTest Execution Started *********");
		String pageTitle=audittemplateindexpage.validateAuditTemplateIndexPageTitle();
		Assert.assertEquals(pageTitle, "Audit Template Index - Quality Lifecycle Management - QA");
		log.info("Page title is:"+pageTitle);
		log.info("********* validateAuditTemplateIndexPageTitleTest Execution Ends *********");
	}

	@Test(priority=2)
	public void validateCreateNewAuditTemplateBtnTest() throws InterruptedException
	{
		log.info("********* validateCreateNewAuditTemplateBtn Execution Started *********");
		audittemplateindexpage.createNewAuditTemplateBtn();
		log.info("********* validateCreateNewAuditTemplateBtn Execution Ends *********");
	}

	@AfterMethod
	public void tearDown()
	{
	  driver.quit();
	  log.info("********* Browser Closed *********");
	}
}
