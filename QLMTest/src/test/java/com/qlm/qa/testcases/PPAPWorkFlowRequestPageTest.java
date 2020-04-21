package com.qlm.qa.testcases;

import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.qlm.qa.base.TestBase;
import com.qlm.qa.listener.CustomListener;
import com.qlm.qa.pages.HomePage;
import com.qlm.qa.pages.LoginPage;
import com.qlm.qa.pages.PPAPWorkFlowRequestPage;

@Listeners(CustomListener.class)
public class PPAPWorkFlowRequestPageTest extends TestBase
{
	LoginPage loginpage;
	HomePage homePage;
	PPAPWorkFlowRequestPage ppapworkflowrequestpage;
	
	Logger log = Logger.getLogger(PPAPWorkFlowRequestPageTest.class);
	
	public PPAPWorkFlowRequestPageTest()
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
		ppapworkflowrequestpage=homePage.clickOnPPAPRequest();
	}
	
	@Test(priority=1)
	public void validatePPAPRequestPageTitleTest()
	{
		log.info("********* validatePPAPRequestPageTitleTest Execution Started *********");
		String pagetitle=ppapworkflowrequestpage.validatePPAPWorkflowRequestPageTitle();
		Assert.assertEquals(pagetitle, "PPAP Workflow Request - Quality Lifecycle Management - QA");
		System.out.println("PPAP template page title is:"+pagetitle);
		log.info("********* validatePPAPRequestPageTitleTest Execution Ends *********");
	}
	
	@Test(priority=2)
	public void validateCreateNewRequestButton() throws InterruptedException
	{
		log.info("********* validateCreateNewRequestButton Execution Started *********");
		ppapworkflowrequestpage.clickOnCreateNewPPAPRequestButton();
		log.info("********* validateCreateNewRequestButton Execution Ends *********");
	}

	@AfterMethod
	public void tearDown()
	{
		driver.quit();	
	}
	
	
}
