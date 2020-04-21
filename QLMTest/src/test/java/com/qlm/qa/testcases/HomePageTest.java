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

@Listeners(CustomListener.class)
public class HomePageTest extends TestBase
{
	LoginPage loginpage;
	HomePage homePage;
	
	Logger log = Logger.getLogger(HomePageTest.class);
	
	public HomePageTest()
	{
		super();
	}

	@BeforeMethod
	public void setup() throws InterruptedException
	{
		log.info("***************** Test SetUp Started *****************");
		initialize();
		loginpage = new LoginPage();
		homePage = loginpage.login(prop.getProperty("username"), prop.getProperty("password"));
		
	}
	
	@Test(priority=1)
	public void homePageTitleTest()
	{
		log.info("********* homePageTitleTest Execution Started *********");
		String pagetitle=homePage.validateHomePageTitle();
		Assert.assertEquals(pagetitle, "Dashboard - Quality Lifecycle Management - QA");
		System.out.println("Home page title is:"+pagetitle);
		log.info("********* homePageTitleTest Execution Ends *********");
	}
	
	@Test(priority=2)
	public void verifyUserNameTest()
	{
		log.info("********* verifyUserNameTest Execution Started *********");
		Boolean flag=homePage.validateUserLable();
		Assert.assertTrue(flag);
		System.out.println("User Verified");
		log.info("********* verifyUserNameTest Execution Ends *********");
	}
	
	@Test(priority=3)
	public void clickOnPPAPTemplateTest() throws InterruptedException
	{
		log.info("********* clickOnPPAPTemplateTest Execution Started *********");
		homePage.clickOnPPAPTemplete();
		log.info("********* clickOnPPAPTemplateTest Execution Ends *********");
	}
	
	 @AfterMethod
	 public void tearDown()
	 {
	   driver.quit();
	   log.info("********* Browser Closed *********");   
	 }
	
}


  