package com.qlm.qa.testcases;

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
	
	public APQPTemplateManagementPageTest()
	{
		super();
	}
	
	@BeforeMethod
	public void setUp() throws InterruptedException
	{
		initialize();
		loginpage = new LoginPage();
		homePage = loginpage.login(prop.getProperty("username"), prop.getProperty("password"));
		apqptemplatemanagementpage = homePage.clickOnAPQPTemplate();
	}
	
	@Test(priority=1)
	public void apqpTemplatePageTitleTest()
	{
		String pagetitle=apqptemplatemanagementpage.validateAPQPTemplateManagementPageTitle();
		Assert.assertEquals(pagetitle, "Template Management - Quality Lifecycle Management - QA");
		System.out.println("PPAP template page title is:"+pagetitle);
	}
	
	@DataProvider
	public Object[][] getAPQPTestData()
	{
		Object data[][]=TestUtil.getTestData(sheetName);
		return data;
	}
	
	@Test(priority=2,dataProvider="getAPQPTestData")
	public void validateCreateAPQPTemplate(String tempName) throws InterruptedException
	{
		apqptemplatemanagementpage.clickOnCreateNewTemplateButton();
		apqptemplatemanagementpage.createNewAPQPTemplate(tempName);
	}
	
	@Test(priority=3)
	public void validateEditAPQPTemplate() throws InterruptedException
	{
		apqptemplatemanagementpage.editAPQPTemplate();
	}
	
	@Test(priority=4)
	public void validateViewAPQPTemplate() throws InterruptedException
	{
		apqptemplatemanagementpage.viewAPQPTemplate();
	}
	
	@AfterMethod
	public void tearDown()
	{
	  driver.quit();
	}

}
