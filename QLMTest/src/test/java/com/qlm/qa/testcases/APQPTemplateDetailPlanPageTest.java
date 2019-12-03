package com.qlm.qa.testcases;

import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.qlm.qa.base.TestBase;
import com.qlm.qa.pages.APQPTemplateDetailPlanPage;
import com.qlm.qa.pages.APQPTemplateManagementPage;
import com.qlm.qa.pages.HomePage;
import com.qlm.qa.pages.LoginPage;
import com.qlm.qa.util.TestUtil;

public class APQPTemplateDetailPlanPageTest extends TestBase
{
	LoginPage loginpage;
	HomePage homePage;
	APQPTemplateManagementPage apqptemplatemanagementpage;
	APQPTemplateDetailPlanPage apqptemplatedetailplanpage;
	
	String sheetName="APQPTempPlanData";
	
	Logger log = Logger.getLogger(APQPTemplateDetailPlanPageTest.class);
			
	public APQPTemplateDetailPlanPageTest()
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
		apqptemplatemanagementpage = homePage.clickOnAPQPTemplate();
		apqptemplatedetailplanpage=apqptemplatemanagementpage.viewAPQPTemplate();
		
	}
	
	@Test(priority=1)
	public void apqpTemplateDetailPlanPageTitleTest()
	{
		log.info("********* apqpTemplateDetailPlanPageTitleTest Execution Started *********");
		String pagetitle=apqptemplatedetailplanpage.validateAPQPTemplateDetailPlanPageTitle();
		Assert.assertEquals(pagetitle, "Template Detail Plan - Quality Lifecycle Management - QA");
		log.info("Page title is:"+pagetitle);
		log.info("********* apqpTemplateDetailPlanPageTitleTest Execution Ends *********");
	}
	
	@DataProvider
	public Object[][] getAPQPTestData()
	{
		Object data[][]=TestUtil.getTestData(sheetName);
		return data;
	}

	@Test(priority=2,dataProvider="getAPQPTestData")
	public void createAPQPTemplateTest(String pTitle,String pSequence,String preElem,String preSequence,String preReqActName,String preReqSeqNo,
			String PreReqRole,String taskElement,String tSeqNo,String tActivity,String tSequence,String leadRole,String teamRole,
			String mileStName,String mileStSeq) throws InterruptedException
	{
		log.info("********* createAPQPTemplateTest Execution Started *********");
		
		apqptemplatedetailplanpage.createPhase(pTitle, pSequence);
		apqptemplatedetailplanpage.createPrerequisities(preElem, preSequence);
		apqptemplatedetailplanpage.createPreReqActivity(preReqActName, preReqSeqNo,PreReqRole);
		apqptemplatedetailplanpage.createTaskElement(taskElement, tSeqNo);
		apqptemplatedetailplanpage.createTaskActivity(tActivity, tSequence, leadRole,teamRole);
		apqptemplatedetailplanpage.createMilestoneGateReview(mileStName, mileStSeq);
		
		log.info("********* createAPQPTemplateTest Execution Ends *********");
	}
	
	@AfterMethod
	public void tearDown()
	{
	  driver.quit();
	  log.info("********* Browser Closed *********");
	}

}
