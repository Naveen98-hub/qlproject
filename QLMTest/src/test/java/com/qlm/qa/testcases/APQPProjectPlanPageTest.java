package com.qlm.qa.testcases;

import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.qlm.qa.base.TestBase;
import com.qlm.qa.pages.APQPProjectManagementPage;
import com.qlm.qa.pages.APQPProjectPlanPage;
import com.qlm.qa.pages.HomePage;
import com.qlm.qa.pages.LoginPage;
import com.qlm.qa.util.TestUtil;

public class APQPProjectPlanPageTest extends TestBase
{
	LoginPage loginpage;
	HomePage homePage;
	APQPProjectManagementPage apqpprojectmanagementpage;
	APQPProjectPlanPage apqpprojectplanpage;
	
	String sheetName="APQPTemplateSel";
	String sheetNameBomRoles="BOMRolesandMembers";
	
	Logger log = Logger.getLogger(APQPProjectManagementPageTest.class);
	
	public APQPProjectPlanPageTest()
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
		apqpprojectmanagementpage = homePage.clickOnAPQPProject();
		apqpprojectplanpage=apqpprojectmanagementpage.viewAPQPProject();
	}
	
    //@Test(priority=1)
	public void apqpAProjectCreatePageTitleTest()
	{
		log.info("********* apqpAProjectCreatePageTitleTest Execution Started *********");
		String pagetitle=apqpprojectplanpage .validateAPQPProjectPlanPageTitle();
		Assert.assertEquals(pagetitle, "Project Plan - Quality Lifecycle Management - QA");
		log.info("Page title is:"+pagetitle);
		log.info("********* apqpAProjectCreatePageTitleTest Execution Ends *********");
	}
	
	@DataProvider
	public Object[][] getAPQPTestData()
	{
		Object data[][]=TestUtil.getTestData(sheetName);
		return data;
	}
	
	//@Test(priority=2,dataProvider="getAPQPTestData")
	public void validateSelectAPQPTemplate(String templateName) throws InterruptedException
	{
		log.info("********* validateSelectAPQPTemplate Execution Started *********");
		apqpprojectplanpage.selectAPQPTemplate(templateName);
		log.info("********* validateSelectAPQPTemplate Execution Ends *********");
	}
 
	//@Test
	public void validateSelectTargetCloseDate() throws InterruptedException
	{
		log.info("********* validateSelectTargetCloseDate Execution Started *********");
		apqpprojectplanpage.selectTargetCloseDate();
		log.info("********* validateSelectTargetCloseDate Execution Ends *********");
	}

	@DataProvider
	public Object[][] getAPQPTestDataBOMRoles()
	{
		Object data[][]=TestUtil.getTestData(sheetNameBomRoles);
		return data;
	}
	
	@Test(priority=4,dataProvider="getAPQPTestDataBOMRoles")
	public void validateSelectRoles(String engRole,String purchRole) throws InterruptedException
	{
		log.info("********* validateSelectRoles Execution Started *********");
		apqpprojectplanpage.selectRoles(engRole,purchRole);
		log.info("********* validateSelectRoles Execution Ends *********");
	}
	
	@AfterMethod
	public void tearDown()
	{
	  driver.quit();
	  log.info("********* Browser Closed *********");
	}
	
}
