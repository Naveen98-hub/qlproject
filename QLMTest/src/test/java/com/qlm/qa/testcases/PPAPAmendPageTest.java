package com.qlm.qa.testcases;

import java.awt.AWTException;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qlm.qa.base.TestBase;
import com.qlm.qa.pages.HomePage;
import com.qlm.qa.pages.LoginPage;
import com.qlm.qa.pages.PPAPAmendPage;
import com.qlm.qa.pages.PPAPWorkFlowRequestPage;

public class PPAPAmendPageTest extends TestBase
{
	LoginPage loginpage;
	HomePage homePage;
	PPAPWorkFlowRequestPage ppapworkflowrequestpage;
	PPAPAmendPage ppapamendpage;
	
	public PPAPAmendPageTest()
	{
		super();
	}

	@BeforeMethod
	public void setUp()
	{
		initialize();
		
	}
	
	void beforeMethodForSupplier() throws InterruptedException
	{
		loginpage = new LoginPage();
		homePage = loginpage.login(prop.getProperty("supplierusername"), prop.getProperty("supplierpassword"));
		ppapworkflowrequestpage=homePage.clickOnPPAPRequest();
		ppapamendpage=ppapworkflowrequestpage.ppapAmend();
	}

	@Test(priority=1)
	public void validatePPAPSubmit() throws InterruptedException, AWTException
	{
		beforeMethodForSupplier();
		ppapamendpage.ppapSubmit();
	}
	
	void beforeMethodForReviewer() throws InterruptedException
	{
		loginpage = new LoginPage();
		homePage = loginpage.login(prop.getProperty("revieweruser"), prop.getProperty("reviewerpassword"));
		ppapworkflowrequestpage=homePage.clickOnPPAPRequest();
		ppapamendpage=ppapworkflowrequestpage.ppapAmend();
	}
	
	@Test(priority=2)
	public void validatePPAPReview() throws InterruptedException, AWTException
	{
		beforeMethodForReviewer();
		ppapamendpage.ppapReview();
	}
	
	void beforeMethodForApprover() throws InterruptedException
	{
		loginpage = new LoginPage();
		homePage = loginpage.login(prop.getProperty("approveruser"), prop.getProperty("approverpassword"));
		ppapworkflowrequestpage=homePage.clickOnPPAPRequest();
		ppapamendpage=ppapworkflowrequestpage.ppapAmend();
	}
	
	@Test(priority=3)
	public void validatePPAPApprove() throws InterruptedException, AWTException
	{
		beforeMethodForApprover();
		ppapamendpage.ppapApprove();
	}
	
	@AfterMethod
	public void teardown()
	 {
	   driver.quit();
	   
	 }
	
}
