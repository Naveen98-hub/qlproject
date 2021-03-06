package com.qlm.qa.testcases;

import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.qlm.qa.base.TestBase;
import com.qlm.qa.listener.CustomListener;
import com.qlm.qa.pages.APQPProjectManagementPage;
import com.qlm.qa.pages.HomePage;
import com.qlm.qa.pages.LoginPage;

@Listeners(CustomListener.class)
public class APQPProjectManagementPageTest extends TestBase
{
	LoginPage loginpage;
	HomePage homePage;
	APQPProjectManagementPage apqpprojectmanagementpage;

	Logger log = Logger.getLogger(APQPProjectManagementPageTest.class);

	public APQPProjectManagementPageTest()
	{
		super();
	}
	
	@BeforeMethod 
	public void setUp() throws InterruptedException
	{ 
		log.info("***************** Test SetUp Started *****************");
		initialize();
		loginpage = new LoginPage();
		homePage = loginpage.login(prop.getProperty("username"), prop.getProperty("password"));
		log.info("Admin Login Successfull");
		apqpprojectmanagementpage = homePage.clickOnAPQPProject();
	}
	
	@Test(priority=1)
	public void apqpProjectManagementPageTitleTest()
	{
		log.info("********* apqpProjectManagementPageTitleTest Execution Started *********");
		String pagetitle=apqpprojectmanagementpage.validateAPQPProjectManagementPageTitle();
		Assert.assertEquals(pagetitle, "Project Management - Quality Lifecycle Management - QA");
		log.info("Page title is:"+pagetitle);
		log.info("********* apqpProjectManagementPageTitleTest Execution Ends *********");
	}
	
	@Test(priority=2)
	public void validateCreateNewAPQPProjectButton() throws InterruptedException
	{
		log.info("********* validateCreateNewAPQPProjectButton Execution Started *********");
		apqpprojectmanagementpage.createNewAPQPProjectButton();
		log.info("********* validateCreateNewAPQPProjectButton Execution Ends *********");
	}
	
	@AfterMethod
	public void tearDown()
	{
	  driver.quit();
	  log.info("********* Browser Closed *********");
	}

}
