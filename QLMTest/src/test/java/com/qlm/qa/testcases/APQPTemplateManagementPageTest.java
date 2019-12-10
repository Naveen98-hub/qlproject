package com.qlm.qa.testcases;

import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.qlm.qa.base.TestBase;
import com.qlm.qa.pages.APQPTemplateManagementPage;
import com.qlm.qa.pages.HomePage;
import com.qlm.qa.pages.LoginPage;
import com.qlm.qa.util.TestUtil;

public class APQPTemplateManagementPageTest extends TestBase
{
	LoginPage loginpage;
	HomePage homePage;
	APQPTemplateManagementPage apqptemplatemanagementpage;
	
	String sheetName="APQPTemplate";
	
	Logger log = Logger.getLogger(APQPTemplateManagementPageTest.class);
	
	public APQPTemplateManagementPageTest()
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
		apqptemplatemanagementpage = homePage.clickOnAPQPTemplate();
	}
	
	@Test(priority=1)
	public void apqpTemplatePageTitleTest()
	{
		log.info("********* apqpTemplatePageTitleTest Execution Started *********");
		String pagetitle=apqptemplatemanagementpage.validateAPQPTemplateManagementPageTitle();
		Assert.assertEquals(pagetitle, "Template Management - Quality Lifecycle Management - QA");
		log.info("Page title is:"+pagetitle);
		log.info("********* apqpTemplatePageTitleTest Execution Ends *********");
	}
	
	@DataProvider
	public Object[][] getAPQPTestData()
	{
		Object data[][]=TestUtil.getTestData(sheetName);
		return data;
	}
	
	@Test(priority=2,dataProvider="getAPQPTestData")
	public void validateCreateAPQPTemplateTest(String tempName) throws InterruptedException
	{
		log.info("********* validateCreateAPQPTemplateTest Execution Started *********");
		apqptemplatemanagementpage.clickOnCreateNewTemplateButton();
		apqptemplatemanagementpage.createNewAPQPTemplate(tempName);
		log.info("********* validateCreateAPQPTemplateTest Execution Ends *********");
	}
	
	@Test(priority=3)
	public void validateEditAPQPTemplateTest() throws InterruptedException
	{
		log.info("********* validateEditAPQPTemplateTest Execution Started *********");
		apqptemplatemanagementpage.editAPQPTemplate();
		log.info("********* validateEditAPQPTemplateTest Execution Ends *********");
	}
	
	@Test(priority=4)
	public void validateViewAPQPTemplateTest() throws InterruptedException
	{
		log.info("********* validateViewAPQPTemplateTest Execution Started *********");
		apqptemplatemanagementpage.viewAPQPTemplate();
		log.info("********* validateViewAPQPTemplateTest Execution Ends *********");
	}
	
	@AfterMethod
	public void tearDown()
	{
	  driver.quit();
	  log.info("********* Browser Closed *********");
	}

}
