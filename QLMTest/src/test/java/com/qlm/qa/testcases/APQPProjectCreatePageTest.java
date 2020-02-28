package com.qlm.qa.testcases;

import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.qlm.qa.base.TestBase;
import com.qlm.qa.pages.APQPProjectCreatePage;
import com.qlm.qa.pages.APQPProjectManagementPage;
import com.qlm.qa.pages.HomePage;
import com.qlm.qa.pages.LoginPage;
import com.qlm.qa.util.TestUtil;

public class APQPProjectCreatePageTest extends TestBase
{
	LoginPage loginpage;
	HomePage homepage;
	APQPProjectManagementPage apqpprojectmanagementpage;
	APQPProjectCreatePage apqpprojectcreatepage;
	
	String sheetName="APQPCreateData";
	
	Logger log = Logger.getLogger(APQPProjectManagementPageTest.class);
	
	public APQPProjectCreatePageTest()
	{
		super();
	}
	
	@BeforeMethod 
	public void setUp() throws InterruptedException
	{ 
		log.info("***************** Test SetUp Started *****************");
		initialize();
		loginpage = new LoginPage();
		homepage = loginpage.login(prop.getProperty("username"), prop.getProperty("password"));
		log.info("Admin Login Successfull");
		apqpprojectmanagementpage = homepage.clickOnAPQPProject();
		apqpprojectcreatepage=apqpprojectmanagementpage.createNewAPQPProjectButton();
	}
	
	@Test(priority=1)
	public void validatAPQPProjectCreatePageTestTitleTest()
	{
		log.info("********* apqpProjectCreatePageTitleTest Execution Started *********");
		String pagetitle=apqpprojectcreatepage.validateAPQPProjectCreatePageTitle();
		Assert.assertEquals(pagetitle, "Project Create - Quality Lifecycle Management - QA");
		log.info("Page title is:"+pagetitle);
		log.info("********* apqpProjectCreatePageTitleTest Execution Ends *********");
	}
	
	@DataProvider
	public Object[][] getAPQPTestData()
	{
		Object data[][]=TestUtil.getTestData(sheetName);
		return data;
	}

	@Test(priority=2,dataProvider="getAPQPTestData")
	public void validateCreateAPQPProject(String pgmName,String tCustomer,String busiUnit,String pgmType,String pgmDev,
			String pgmMgr,String partNo,String totalNoOfYears) throws InterruptedException
	{
		log.info("********* apqpProjectCreatePageTitleTest Execution Started *********");
		apqpprojectcreatepage.createAPQPProject(pgmName,tCustomer,busiUnit,pgmType,pgmDev,pgmMgr,partNo,totalNoOfYears);
		log.info("********* apqpProjectCreatePageTitleTest Execution Ends *********");
	}

	@AfterMethod
	public void tearDown()
	{
	  driver.quit();
	  log.info("********* Browser Closed *********");
	}
}
