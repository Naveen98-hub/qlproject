package com.qlm.qa.testcases;

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
	public void loginPageTitle()
	{
		String pagetitle=loginpage.validateLoginPageTitle();
		Assert.assertEquals(pagetitle, "Log in - QLM");
		System.out.println("Page Title is:"+ pagetitle);
		
	}
	
	@Test(priority=2)
	public void empowerlogotest()
	{
		Boolean flag=loginpage.validateEmpowerLogo();
		Assert.assertTrue(flag);
		System.out.println("logo matching");
	}
	
	@Test(enabled=false)
	public void captchaTest()
	{
		loginpage.captcha();
	}
	
	@Test(priority=3)
	public void login() throws InterruptedException
	{
		homePage=loginpage.login(prop.getProperty("username"),prop.getProperty("password"));
	}
	
   @AfterMethod
   public void teardown()
   {
	   driver.quit();
	   
   }


}