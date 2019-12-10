package com.qlm.qa.testcases;

import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.qlm.qa.base.TestBase;
import com.qlm.qa.pages.HomePage;
import com.qlm.qa.pages.LoginPage;
import com.qlm.qa.pages.PPAPWorkflowTemplatePage;
import com.qlm.qa.util.TestUtil;

public class PPAPWorkflowTemplatePageTest extends TestBase
{
	LoginPage loginpage;
	HomePage homePage;
	PPAPWorkflowTemplatePage ppapworkflowtemplatepage;
	
	String sheetName="PPAPTemplate";
	
	Logger log = Logger.getLogger(PPAPWorkflowTemplatePageTest.class);
	
	public PPAPWorkflowTemplatePageTest()
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
		ppapworkflowtemplatepage = homePage.clickOnPPAPTemplete();
		
	}

	@Test(priority=1)
	public void ppapTemplatePageTitleTest()
	{
		log.info("********* ppapTemplatePageTitleTest Execution Started *********");
		String pagetitle=ppapworkflowtemplatepage.validatePPAPWorkflowTemplatePageTitle();
		Assert.assertEquals(pagetitle, "PPAP Workflow Templates - Quality Lifecycle Management - QA");
		System.out.println("PPAP template page title is:"+pagetitle);
		log.info("********* ppapTemplatePageTitleTest Execution Ends *********");
	}

	@DataProvider
	public Object[][] getPPAPTestData()
	{
		Object data[][]=TestUtil.getTestData(sheetName);
		return data;
	}

	@Test(priority=2,dataProvider="getPPAPTestData")
	public void validateCreatePPAPTemplate(String tempName,String subLevel) throws InterruptedException
	{
		log.info("********* validateCreatePPAPTemplate Execution Started *********");
		Thread.sleep(3000);
		ppapworkflowtemplatepage.clickOnCreateNewTemplateButton();
		ppapworkflowtemplatepage.createNewTemplate(tempName, subLevel);
		log.info("********* validateCreatePPAPTemplate Execution Ends *********");
	}
	
	@Test(priority=3)
	public void validateEditPPAPTemplate() throws InterruptedException
	{
		log.info("********* validateEditPPAPTemplate Execution Started *********");
		ppapworkflowtemplatepage.updateTemplate();
		log.info("********* validateEditPPAPTemplate Execution Ends *********");
	}
	
	@Test(priority=4)
	public void validateViewTemplate() throws InterruptedException
	{
		log.info("********* validateViewTemplate Execution Started *********");
		ppapworkflowtemplatepage.viewTemplate();
		log.info("********* validateViewTemplate Execution Ends *********");
	}

	@AfterMethod
	public void tearDown()
	{
	   driver.quit();
	   log.info("********* Browser Closed *********");
	}
	

}
