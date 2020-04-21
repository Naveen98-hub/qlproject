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
import com.qlm.qa.pages.AuditCreatePage;
import com.qlm.qa.pages.AuditsPage;
import com.qlm.qa.pages.HomePage;
import com.qlm.qa.pages.LoginPage;
import com.qlm.qa.util.TestUtil;

@Listeners(CustomListener.class)
public class AuditCreatePageTest extends TestBase
{
	LoginPage loginpage;
	HomePage homePage;
	AuditsPage auditspage;
	AuditCreatePage auditscreatepage;
	
	String sheetName="AuditCreate";
	
	Logger log = Logger.getLogger(AuditCreatePageTest.class);
	
	public AuditCreatePageTest()
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
		auditscreatepage = auditspage.createNewAuditBtn();
	}
	
	@Test(priority=1)
	public void validatAuditCreatePageTitleTest()
	{
		log.info("********* validatAuditCreatePageTitleTest Execution Started *********");
		String pagetitle=auditscreatepage.validateAuditCreatePageTitle();
		Assert.assertEquals(pagetitle, "Audit Create - Quality Lifecycle Management - QA");
		log.info("Page title is:"+pagetitle);
		log.info("********* validatAuditCreatePageTitleTest Execution Ends *********");
	}
	
	@DataProvider
	public Object[][] getAuditTestData()
	{
		Object data[][]=TestUtil.getTestData(sheetName);
		return data;
	}
	
	@Test(priority=2,dataProvider="getAuditTestData")
	public void validateAuditCreate(String aType,String aReason,String aSupplier,String aName,String tmpltName,
			String approvers,String aReviewers) throws InterruptedException
	{
		log.info("********* validateAuditCreate Execution Started *********");
		auditscreatepage.auditCreate(aType, aReason, aSupplier, aName,approvers);
		auditscreatepage.externalAuditSelect();                    //Use this code for selecting only External Audit type
		//auditscreatepage.internalAuditSelect(tmpltName);         //Use this code for selecting only Internal Audit type
		  auditscreatepage.selfAudit(aReviewers);
		//auditscreatepage.offSiteAudit(aReviewers);
		//auditscreatepage.onSiteAudit(aReviewers);
		log.info("********* validateAuditCreate Execution Ends *********");
	}
	
	@AfterMethod
	public void tearDown()
	{
	  driver.quit();
	  log.info("********* Browser Closed *********");
	}
}
