package com.qlm.qa.testcases;



import java.awt.AWTException;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.qlm.qa.base.TestBase;
import com.qlm.qa.pages.HomePage;
import com.qlm.qa.pages.LoginPage;
import com.qlm.qa.pages.PPAPSingleTemplatePage;
import com.qlm.qa.pages.PPAPWorkflowTemplatePage;
import com.qlm.qa.util.TestUtil;

public class PPAPSingleTemplatePageTest extends TestBase
{
	LoginPage loginpage;
	HomePage homePage;
	PPAPWorkflowTemplatePage ppapworkflowtemplatepage;
	PPAPSingleTemplatePage ppapsingletemplatepage;
	
	String sheetName="Elementdata";
	
	public PPAPSingleTemplatePageTest()
	{
		super();
	}
	
	
	@BeforeMethod
	public void setup() throws InterruptedException
	{
		initialize();
		loginpage = new LoginPage();
		homePage = loginpage.login(prop.getProperty("username"), prop.getProperty("password"));
		ppapworkflowtemplatepage = homePage.clickOnPPAPTemplete();
		ppapsingletemplatepage=ppapworkflowtemplatepage.viewTemplate();
		
	}
	
	@Test(priority=1)
	public void validatePPAPSingleTemplatePageTitleTest()
	{
		String pagetitle=ppapsingletemplatepage.ppapSingleTemplatePageTitle();
		Assert.assertEquals(pagetitle, "Template : PPAPTemplate - QLM");
		System.out.println("PPAP template page title is:"+pagetitle);
	}
		
	@DataProvider
	public Object[][] getPPAPTestData()
	{
		Object data[][]=TestUtil.getTestData(sheetName);
		return data;
	}
	
	@Test(priority=2,dataProvider="getPPAPTestData")
    public void validatePPAPTemplateElementCreate(String ppapElementNo, String ppapElementName, String ppapElementAbbreviation) throws InterruptedException, AWTException
    {
		Thread.sleep(3000);
		ppapsingletemplatepage.clickOnCreateNewElementButton();
    	ppapsingletemplatepage.createNewElement(ppapElementNo, ppapElementName, ppapElementAbbreviation);
    }

	@Test(priority=3)
	public void validatePPAPTemplateElementEditTest() throws InterruptedException
	{
		ppapsingletemplatepage.editElement();
	}
	
	@Test(priority=4)
	public void validateviewElementChecklistTest() throws InterruptedException
	{
		ppapsingletemplatepage.viewElementChecklist();

	}
	
	@AfterMethod
	public void tearDown()
	{
	  driver.quit();
	}
}
