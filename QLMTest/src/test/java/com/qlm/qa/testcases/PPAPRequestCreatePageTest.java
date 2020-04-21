package com.qlm.qa.testcases;

import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.qlm.qa.base.TestBase;
import com.qlm.qa.listener.CustomListener;
import com.qlm.qa.pages.HomePage;
import com.qlm.qa.pages.LoginPage;
import com.qlm.qa.pages.PPAPRequestCreatePage;
import com.qlm.qa.pages.PPAPWorkFlowRequestPage;
import com.qlm.qa.util.TestUtil;

@Listeners(CustomListener.class)
public class PPAPRequestCreatePageTest extends TestBase 
{
	LoginPage loginpage;
	HomePage homePage;
	PPAPWorkFlowRequestPage ppapworkflowrequestpage;
	PPAPRequestCreatePage ppaprequestcreatepage;
	
	String sheetName="PPAP";
	
	Logger log = Logger.getLogger(PPAPRequestCreatePageTest.class);
	
	public PPAPRequestCreatePageTest()
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
		ppapworkflowrequestpage=homePage.clickOnPPAPRequest();
		ppaprequestcreatepage=ppapworkflowrequestpage.clickOnCreateNewPPAPRequestButton();
	}
	
	@Test(priority=1)
	public void validatePPAPRequestCreatePageTitleTest()
	{
		log.info("********* validatePPAPRequestCreatePageTitleTest Execution Started *********");
		String pagetitle=ppaprequestcreatepage.ppapRequestCreatePageTitle();
		Assert.assertEquals(pagetitle, "PPAP Request Create - Quality Lifecycle Management - QA");
		System.out.println("PPAP template page title is:"+pagetitle);
		log.info("********* validatePPAPRequestCreatePageTitleTest Execution Ends *********");
	}
	
	
	@DataProvider
	public Object[][] getPPAPTestData()
	{
		Object data[][]=TestUtil.getTestData(sheetName);
		return data;
	}
	
	@Test(priority=2,dataProvider="getPPAPTestData")
	public void validatePPAPRequestCreate(String pNo, String oCstmr,String ppapR,String tLocn,String tPlant,String tPgm,String tBsUnit,
			String tPPAPRev,String tPPAPApr,String tSupplier,String tSupCoord,String tSupLoc,String tTemplate) throws InterruptedException
	{
		log.info("********* validatePPAPRequestCreate Execution Started *********");
		ppaprequestcreatepage.ppapRequestCreate(pNo,oCstmr,ppapR,tLocn,tPlant,tPgm,tBsUnit,tPPAPRev,tPPAPApr,tSupplier,tSupCoord,tSupLoc,tTemplate);
		log.info("********* validatePPAPRequestCreate Execution Ends *********");
	}
	
	@AfterMethod
	public void tearDown()
	 {
	   driver.quit();
	   log.info("********* Browser Closed *********");
	 }
	
	
}
