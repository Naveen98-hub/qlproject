package com.qlm.qa.testcases;

import java.awt.AWTException;

import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qlm.qa.base.TestBase;
import com.qlm.qa.pages.AuditsPage;
import com.qlm.qa.pages.ExternalDocumentUploadPage;
import com.qlm.qa.pages.HomePage;
import com.qlm.qa.pages.LoginPage;

public class ExternalDocumentUploadPageTest extends TestBase
{
	LoginPage loginpage;
	HomePage homePage;
	AuditsPage auditspage;
	ExternalDocumentUploadPage externaldocumentuploadpage;
	
	Logger log = Logger.getLogger(AuditTemplateIndexPageTest.class);
	
	public ExternalDocumentUploadPageTest()
	{
		super();
	}
	
	@BeforeMethod 
	public void setUp() throws InterruptedException
	{ 
		log.info("***************** Test SetUp Started *****************");
		initialize();
		loginpage = new LoginPage();
		homePage = loginpage.login(prop.getProperty("supplierusername"), prop.getProperty("supplierpassword")); //For Supplier Docs Upload 
		//homePage = loginpage.login(prop.getProperty("auditapprover"), prop.getProperty("auditapproverpassword")); // For Auditor Docs Upload
		log.info("Admin Login Successfull");
		auditspage = homePage.clickOnSupplierAuditLink();  //For Supplier Audits Page
		//auditspage = homePage.clickOnAuditElement();         //For Auditor Audits Page
		auditspage.scrollPage();
		externaldocumentuploadpage = auditspage.clickOnExternalAuditUpload();
	}  
	
	@Test(priority=1)
	public void validateExternalDocumentUploadPageTitleTest()
	{
		log.info("********* validateExternalDocumentUploadPageTitleTest Execution Started *********");
		String pageTitle=externaldocumentuploadpage.validateExternalDocumentUploadPageTitle();
		Assert.assertEquals(pageTitle, "External Document Upload - Quality Lifecycle Management - QA");
		log.info("Page title is:"+pageTitle);
		log.info("********* validateExternalDocumentUploadPageTitleTest Execution Ends *********");
	}
	
	@Test(priority=2)
	public void validateAuditorDocUploadTest() throws InterruptedException, AWTException
	{
		log.info("********* validateAuditorDocUploadTest Execution Started *********");
		externaldocumentuploadpage.auditorDocUpload();
		log.info("********* validateAuditorDocUploadTest Execution Ends *********");
	}
	
	@AfterMethod
	public void tearDown()
	{
	  driver.quit();
	  log.info("********* Browser Closed *********");
	}

}
