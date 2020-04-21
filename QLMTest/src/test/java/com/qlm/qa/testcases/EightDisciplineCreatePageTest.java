package com.qlm.qa.testcases;

import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.qlm.qa.base.TestBase;
import com.qlm.qa.listener.CustomListener;
import com.qlm.qa.pages.EightDisciplineCreatePage;
import com.qlm.qa.pages.HomePage;
import com.qlm.qa.pages.LoginPage;
import com.qlm.qa.pages.NonConformityPage;
import com.qlm.qa.pages.NonConformityViewPage;

@Listeners(CustomListener.class)
public class EightDisciplineCreatePageTest extends TestBase
{
	LoginPage loginpage;
	HomePage homepage;
	NonConformityPage nonconformitypage;
	NonConformityViewPage nonconformityviewpage;
	EightDisciplineCreatePage eightdisciplinecreatepage;
	
	Logger log = Logger.getLogger(EightDisciplineCreatePageTest.class);
	
	public EightDisciplineCreatePageTest()
	{
		super();
	}
	
	@BeforeMethod 
	public void setUp() throws InterruptedException
	{ 
		log.info("***************** Test SetUp Started *****************");
		initialize();
		loginpage = new LoginPage();
		homepage = loginpage.login(prop.getProperty("username"), prop.getProperty("password"));
		nonconformitypage = homepage.clickOnNonConformitylink();
		log.info("Admin Login Successfull");
		nonconformityviewpage=nonconformitypage.clickOnNonConformityViewBtn();
		eightdisciplinecreatepage=nonconformityviewpage.clickOn8DBtn();
	}
	
	@Test(priority=1)
	public void validateEightDisciplinePageTitleTest()
	{
		log.info("********* validateEightDisciplinePageTitleTest Execution Started *********");
		String pagetitle=eightdisciplinecreatepage.validateEightDisciplinePageTitle();
		Assert.assertEquals(pagetitle, "Eight Discipline - Create - Quality Lifecycle Management - QA");
		log.info("Page title is:"+pagetitle);
		log.info("********* validateEightDisciplinePageTitleTest Execution Ends *********");
	}
	 	
	@Test(priority=2)
	public void validateClickOnCreate8DBtnTest() throws InterruptedException
	{
		log.info("********* validateClickOnCreate8DBtnTest Execution Started *********");
		eightdisciplinecreatepage.clickOnCreate8DBtn();
		log.info("********* validateClickOnCreate8DBtnTest Execution Ends *********");
	}
	
	@AfterMethod
	public void tearDown()
	{
	  driver.quit();
	  log.info("********* Browser Closed *********");
	}
	

}
