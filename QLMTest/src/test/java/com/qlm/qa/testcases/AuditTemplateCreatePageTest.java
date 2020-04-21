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
import com.qlm.qa.pages.AuditTemplateAmendPage;
import com.qlm.qa.pages.AuditTemplateCreatePage;
import com.qlm.qa.pages.AuditTemplateIndexPage;
import com.qlm.qa.pages.HomePage;
import com.qlm.qa.pages.LoginPage;
import com.qlm.qa.util.TestUtil;

@Listeners(CustomListener.class)
public class AuditTemplateCreatePageTest extends TestBase
{
	LoginPage loginpage;
	HomePage homePage;
	AuditTemplateIndexPage audittemplateindexpage;
	AuditTemplateCreatePage audittemplatecreatepage;
	
	AuditTemplateAmendPage audittemplateamendpage;
	
	String sheetName="AuditTemplate";
	
	Logger log = Logger.getLogger(AuditTemplateCreatePageTest.class);

	public AuditTemplateCreatePageTest()
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
		audittemplatecreatepage = audittemplateindexpage.createNewAuditTemplateBtn();

	}
	
	@Test(priority=1)
	public void validateAuditTemplateCreatePageTitleTest()
	{
		log.info("********* validateAuditTemplateCreatePageTitleTest Execution Started *********");
		String pageTitle=audittemplatecreatepage.validateAuditTemplateCreatePageTitle();
		Assert.assertEquals(pageTitle, "Audit Template Create - Quality Lifecycle Management - QA");
		log.info("Page title is:"+pageTitle);
		log.info("********* validateAuditTemplateCreatePageTitleTest Execution Ends *********");
	}
	
	@DataProvider
	public Object[][] getAuditTestData()
	{
		Object data[][]=TestUtil.getTestData(sheetName);
		return data;
	}
	
	@Test(priority=2,dataProvider="getAuditTestData")
	public void createAuditTemplateTest(String tempName,String questGroup) throws InterruptedException
	{
		log.info("********* createAuditTemplate Execution Started *********");
		audittemplatecreatepage.createNewAuditTemplate(tempName, questGroup);
		log.info("********* createAuditTemplate Execution Ends *********");
	}

	@AfterMethod
	public void tearDown()
	{
	  driver.quit();
	  log.info("********* Browser Closed *********");
	}
}
