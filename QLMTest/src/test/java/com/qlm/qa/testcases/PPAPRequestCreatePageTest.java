package com.qlm.qa.testcases;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.qlm.qa.base.TestBase;
import com.qlm.qa.pages.HomePage;
import com.qlm.qa.pages.LoginPage;
import com.qlm.qa.pages.PPAPRequestCreatePage;
import com.qlm.qa.pages.PPAPWorkFlowRequestPage;
import com.qlm.qa.util.TestUtil;

public class PPAPRequestCreatePageTest extends TestBase 
{
	LoginPage loginpage;
	HomePage homePage;
	PPAPWorkFlowRequestPage ppapworkflowrequestpage;
	PPAPRequestCreatePage ppaprequestcreatepage;
	
	String sheetName="PPAP";
	
	public PPAPRequestCreatePageTest()
	{
		super();
	}
	
	@BeforeMethod
	public void setUp() throws InterruptedException
	{
		initialize();
		loginpage = new LoginPage();
		homePage = loginpage.login(prop.getProperty("username"), prop.getProperty("password"));
		ppapworkflowrequestpage=homePage.clickOnPPAPRequest();
		ppaprequestcreatepage=ppapworkflowrequestpage.clickOnCreateNewPPAPRequestButton();
	}
	
	@DataProvider
	public Object[][] getPPAPTestData()
	{
		Object data[][]=TestUtil.getTestData(sheetName);
		return data;
	}
	
	@Test(dataProvider="getPPAPTestData")
	public void validatePPAPRequestCreate(String pNo, String oCstmr,String ppapR ) throws InterruptedException
	{
		ppaprequestcreatepage.ppapRequestCreate(pNo,oCstmr,ppapR);
		
	}
	
	
	
	
}
