package com.qlm.qa.testcases;

import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qlm.qa.base.TestBase;
import com.qlm.qa.pages.HomePage;
import com.qlm.qa.pages.LoginPage;

public class LoginPageTest extends TestBase
{
	LoginPage loginpage;
	HomePage homePage;
	
	Logger log = Logger.getLogger(LoginPageTest.class);
	
	public LoginPageTest()
	{
		super();
	}
		
	@BeforeMethod
    public void setup()
    {
	   initialize();
	   loginpage = new LoginPage();
	   
    }
	
	@Test(priority=1)
	public void loginPageTitleTest()
	{
		log.info("********* loginPageTitleTest Execution Started *********");
		String pagetitle=loginpage.validateLoginPageTitle();
		Assert.assertEquals(pagetitle, "Log in - Quality Lifecycle Management - QA");
		System.out.println("Page Title is:"+ pagetitle);
		log.info("********* loginPageTitleTest Execution Ends *********");
	}
	
	@Test(priority=2)
	public void empowerLogoTest()
	{
		log.info("********* empowerLogoTest Execution Started *********");
		Boolean flag=loginpage.validateEmpowerLogo();
		Assert.assertTrue(flag);
		System.out.println("logo matching");
		log.info("********* empowerLogoTest Execution Ends *********");
	}
	
	@Test(priority=3)
	public void loginTest() throws InterruptedException
	{
		log.info("********* loginTest Execution Started *********");
		homePage=loginpage.login(prop.getProperty("username"),prop.getProperty("password"));
		log.info("********* loginTest Execution Ends *********");
	}
	
   @AfterMethod
   public void tearDown()
   {
	   driver.quit();
	   log.info("********* Browser Closed *********");
   }


}
