package com.qlm.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qlm.qa.base.TestBase;
import com.qlm.qa.pages.HomePage;
import com.qlm.qa.pages.LoginPage;

public class HomePageTest extends TestBase
{
	LoginPage loginpage;
	HomePage homePage;
	
	
	public HomePageTest()
	{
		super();
	}

	@BeforeMethod
	public void setup() throws InterruptedException
	{
		initialize();
		loginpage = new LoginPage();
		homePage = loginpage.login(prop.getProperty("username"), prop.getProperty("password"));
		
	}
	
	@Test(priority=1)
	public void homePageTitleTest()
	{
		String pagetitle=homePage.validateHomePageTitle();
		Assert.assertEquals(pagetitle, "Dashboard - QLM");
		System.out.println("Home page title is:"+pagetitle);
	}
	
	@Test(priority=2)
	public void verifyUserNameTest()
	{
		Boolean flag=homePage.validateUserLable();
		Assert.assertTrue(flag);
		System.out.println("User Verified");
		
	}
	
	@Test(priority=3)
	public void clickOnPPAPTemplateTest()
	{
		homePage.clickOnPPAPTemplete();
	}
	
	 @AfterMethod
	 public void tearDown()
	 {
		  
	   driver.quit();
		   
	 }
	
}


  