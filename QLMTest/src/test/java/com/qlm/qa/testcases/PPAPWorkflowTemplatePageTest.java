package com.qlm.qa.testcases;

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
	
	public PPAPWorkflowTemplatePageTest()
	{
		super();
	}
	
	@BeforeMethod
	public void setUp() throws InterruptedException
	{
		initialize();
		loginpage = new LoginPage();
		homePage = loginpage.login(prop.getProperty("username"), prop.getProperty("password"));
		ppapworkflowtemplatepage = homePage.clickOnPPAPTemplete();
		
	}

	@Test(priority=1)
	public void ppapTemplatePageTitleTest()
	{
		String pagetitle=ppapworkflowtemplatepage.validatePPAPWorkflowTemplatePageTitle();
		Assert.assertEquals(pagetitle, "PPAP Workflow Templates - QLM");
		System.out.println("PPAP template page title is:"+pagetitle);
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
		Thread.sleep(3000);
		ppapworkflowtemplatepage.clickOnCreateNewTemplateButton();
		ppapworkflowtemplatepage.createNewTemplate(tempName, subLevel);
	}
	
	@Test(priority=3)
	public void validateEditPPAPTemplate() throws InterruptedException
	{
		ppapworkflowtemplatepage.updateTemplate();
		
	}
	
	@Test(priority=4)
	public void validateViewTemplate() throws InterruptedException
	{
		ppapworkflowtemplatepage.viewTemplate();
	}

	 @AfterMethod
	 public void tearDown()
	 {
	   driver.quit();
	 }
	

}
