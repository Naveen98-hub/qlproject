package com.qlm.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qlm.qa.base.TestBase;
import com.qlm.qa.pages.LoginPage;

public class LoginPageTest extends TestBase
{
	LoginPage loginpage;
	
	
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
	
	@Test
	public void loginPageTitle()
	{
		String pagetitle=loginpage.validateLoginPageTitle();
		Assert.assertEquals(pagetitle, "Log in - QLM");
		
	}
	
	
	
   @AfterMethod
   public void teardown()
   {
	   driver.quit();
	   
   }


}
