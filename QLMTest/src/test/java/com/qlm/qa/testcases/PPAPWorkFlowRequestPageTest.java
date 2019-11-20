package com.qlm.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qlm.qa.base.TestBase;
import com.qlm.qa.pages.HomePage;
import com.qlm.qa.pages.LoginPage;
import com.qlm.qa.pages.PPAPWorkFlowRequestPage;

public class PPAPWorkFlowRequestPageTest extends TestBase
{
	LoginPage loginpage;
	HomePage homePage;
	PPAPWorkFlowRequestPage ppapworkflowrequestpage;
	
	public PPAPWorkFlowRequestPageTest()
	{
		super();
	}
	
	@BeforeMethod
	public void setUp() throws InterruptedException
	{
		initialize();
		loginpage = new LoginPage();
		homePage = loginpage.login(prop.getProperty("username"), prop.getProperty("password"));
		ppapworkflowrequestpage=homePage.clickOnPPAPRequest();
	}
	
	@Test(priority=1)
	public void validatePPAPRequestPageTitleTest()
	{
		String pagetitle=ppapworkflowrequestpage.validatePPAPWorkflowRequestPageTitle();
		Assert.assertEquals(pagetitle, "PPAP Workflow Request - QLM");
		System.out.println("PPAP template page title is:"+pagetitle);
		
	}
	
	@Test(priority=2)
	public void validateCreateNewRequestButton() throws InterruptedException
	{
		ppapworkflowrequestpage.clickOnCreateNewPPAPRequestButton();
	}

	@AfterMethod
	public void tearDown()
	{
		//driver.quit();	
	}
	
	
}
