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
import com.qlm.qa.pages.SelfAuditPage;

public class SelfAuditPageTest extends TestBase
{
	LoginPage loginpage;
	HomePage homePage;
	AuditsPage auditspage;
	SelfAuditPage selfauditpage;
	
	Logger log = Logger.getLogger(AuditTemplateIndexPageTest.class);
	
	public SelfAuditPageTest()
	{
		super();
	}
   
	@BeforeMethod 
	public void setUp() throws InterruptedException
	{ 
		log.info("***************** Test SetUp Started *****************");
		initialize();
		loginpage = new LoginPage();
		homePage = loginpage.login(prop.getProperty("supplierusername"), prop.getProperty("supplierpassword"));
		log.info("Admin Login Successfull");
		auditspage = homePage.clickOnSupplierAuditLink();
		selfauditpage=auditspage.clickOnselfAssessment();
	}
	
	@Test(priority=1)
	public void validateSelfAuditPageTitleTest()
	{
		log.info("********* validateSelfAuditPageTitleTest Execution Started *********");
		String pageTitle=selfauditpage.validateSelfAuditPageTitle();
		Assert.assertEquals(pageTitle, "Self Audit - Quality Lifecycle Management - QA");
		log.info("Page title is:"+pageTitle);
		log.info("********* validateSelfAuditPageTitleTest Execution Ends *********");
	}
	
	@Test(priority=2)
	public void validateSelfAuditResponseSubmitTest() throws InterruptedException
	{
		log.info("********* validateSelfAuditResponseSubmitTest Execution Started *********");
		selfauditpage.selfAuditResponseSubmit();
		log.info("********* validateSelfAuditResponseSubmitTest Execution Ends *********");
	}
	
	@AfterMethod
	public void tearDown()
	{
	  driver.quit();
	  log.info("********* Browser Closed *********");
	}
	
}
