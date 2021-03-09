package com.qlm.qa.testcases;

import java.awt.AWTException;

import org.apache.log4j.Logger;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.qlm.qa.base.TestBase;
import com.qlm.qa.listener.CustomListener;
import com.qlm.qa.pages.EightDisciplineAmendPage;
import com.qlm.qa.pages.EightDisciplinesPage;
import com.qlm.qa.pages.HomePage;
import com.qlm.qa.pages.LoginPage;
import com.qlm.qa.util.TestUtil;

@Listeners(CustomListener.class)
public class EightDisciplineAmendPageTest extends TestBase
{
	LoginPage loginpage;
	HomePage homepage;
	EightDisciplinesPage eightdisciplinespage;
	EightDisciplineAmendPage eightdisciplineamendpage;
	
	String sheetName="8DSubmit";
	
	Logger log = Logger.getLogger(EightDisciplineAmendPageTest.class);
	
	public  EightDisciplineAmendPageTest()
	{
		super();
	}
	
	@BeforeMethod
	public void setUp()
	{
		initialize();
	}
	
	void beforeMethodForSupplier() throws InterruptedException
	{
		loginpage = new LoginPage();
		homepage = loginpage.login(prop.getProperty("supplierusername"), prop.getProperty("supplierpassword"));
		eightdisciplinespage = homepage.clickOnEightDisciplinesLink();
		eightdisciplinespage.selectIncident();
		eightdisciplineamendpage = eightdisciplinespage.clickonEightDisciplineViewBtn();
	}
		
	@DataProvider
	public Object[][] get8DTestData()
	{
		Object data[][]=TestUtil.getTestData(sheetName);
		return data;
	}
	
//	@Test(priority=1,dataProvider="get8DTestData")
	public void validated1d2d3Submit(String tcpcName,String tcpctitle,String tcpcEmail,String tcpcPhoneNumber,String tsupTeamChampName,String tsupTeamChampTitle
                                     ,String tsupTeamChampEmail,String tsupTeamChampPhoneNumber,String tsupTeamAddlnMemberName,String tsupTeamAddlnMemberTitle,
                                      String tsupTeamAddlnMemberEmail,String tsupTeamAddlnMemberPhoneNumber) throws InterruptedException, AWTException
	{
		beforeMethodForSupplier();
		eightdisciplineamendpage.d1d2d3SupplierSubmit(tcpcName, tcpctitle, tcpcEmail, tcpcPhoneNumber, tsupTeamChampName, tsupTeamChampTitle, tsupTeamChampEmail,
				                               tsupTeamChampPhoneNumber, tsupTeamAddlnMemberName, tsupTeamAddlnMemberTitle, tsupTeamAddlnMemberEmail,
				                               tsupTeamAddlnMemberPhoneNumber);
			
	}

	void beforeMethodForCustomer() throws InterruptedException
	{
		loginpage = new LoginPage();
		homepage = loginpage.login(prop.getProperty("username"), prop.getProperty("password"));
		eightdisciplinespage = homepage.clickOnEightDisciplinesLink();
		eightdisciplinespage.selectIncident();
		eightdisciplineamendpage = eightdisciplinespage.clickonEightDisciplineViewBtn();
			
	}
		
//	@Test(priority=2)
	public void validateD3CustmrAcceptorRejectStep() throws InterruptedException
	{
		beforeMethodForCustomer();
		eightdisciplineamendpage.custmrAcceptorRejectStep();
	}
	
//	@Test(priority=3)
	public void validateD4SupplierSubmit() throws InterruptedException
	{
		beforeMethodForSupplier();
		eightdisciplineamendpage.D4SupplierSubmit();
	}
	
	@Test(priority=4)
	public void validateD4CustmrAcceptorRejectStep() throws InterruptedException
	{
		beforeMethodForCustomer();
		eightdisciplineamendpage.custmrAcceptorRejectStep();
	}
	
	
	
	
	@AfterMethod
	public void tearDown()
	{
	//  driver.quit();
	  log.info("********* Browser Closed *********");
	}
	
	
	
	
}
