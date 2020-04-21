package com.qlm.qa.testcases;

import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.qlm.qa.base.TestBase;
import com.qlm.qa.listener.CustomListener;
import com.qlm.qa.pages.AuditorAuditPage;
import com.qlm.qa.pages.AuditsPage;
import com.qlm.qa.pages.HomePage;
import com.qlm.qa.pages.LoginPage;

@Listeners(CustomListener.class)
public class AuditorAuditPageTest extends TestBase
{
	LoginPage loginpage;
	HomePage homePage;
	AuditsPage auditspage;
	AuditorAuditPage auditorauditpage;
	
	Logger log = Logger.getLogger(AuditorAuditPageTest.class);
	
	public AuditorAuditPageTest()
	{
		super();
	}
	
	@BeforeMethod 
	public void setUp() throws InterruptedException
	{ 
		log.info("***************** Test SetUp Started *****************");
		initialize();
		loginpage = new LoginPage();
		homePage = loginpage.login(prop.getProperty("auditapprover"), prop.getProperty("auditapproverpassword"));
		log.info("Admin Login Successfull");
		auditspage = homePage.clickOnAuditElement();
		auditspage.scrollPage();
		auditorauditpage = auditspage.clickOnAssessment();
	}

	@Test(priority=1)
	public void validateAuditorAuditPageTitleTest()
	{
		log.info("********* validateAuditorAuditPageTitleTest Execution Started *********");
		String pageTitle=auditorauditpage.validateAuditorAuditPageTitle();
		Assert.assertEquals(pageTitle, "Auditor Audit - Quality Lifecycle Management - QA");
		log.info("Page title is:"+pageTitle);
		log.info("********* validateAuditorAuditPageTitleTest Execution Ends *********");
	}
	
	@Test(priority=2)
	public void validateAuditorAuditResponseSubmitTest() throws InterruptedException
	{
		log.info("********* validateauditorAuditResponseSubmitTest Execution Started *********");
		auditorauditpage.auditorAuditResponseSubmit();
		log.info("********* validateauditorAuditResponseSubmitTest Execution Ends *********");
	}
	
	@AfterMethod
	public void tearDown()
	{
	  driver.quit();
	  log.info("********* Browser Closed *********");
	}
	
}
