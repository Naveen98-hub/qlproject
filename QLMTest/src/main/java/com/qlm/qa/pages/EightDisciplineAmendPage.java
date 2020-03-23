package com.qlm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qlm.qa.base.TestBase;

public class EightDisciplineAmendPage extends TestBase
{
	//Page Factory
	
	@FindBy(xpath="//input[@id='txt-cpc-name-line-1']")
	WebElement cpcName;
	
	@FindBy(xpath="//input[@id='txt-cpc-title-line-1']")
	WebElement cpctitle;
	
	@FindBy(xpath="//input[@id='txt-cpc-email-line-1']")
	WebElement cpcEmail;
	
	@FindBy(xpath="//input[@id='txt-cpc-phone-line-1']")
	WebElement cpcPhoneNUmber;
	
	@FindBy(xpath="//input[@id='txt-stc-name-line-1']")
	WebElement supTeamChampName;
	
	@FindBy(xpath="//input[@id='txt-stc-title-line-1']")
	WebElement supTeamChampTitle;
	
	@FindBy(xpath="//input[@id='txt-stc-email-line-1']")
	WebElement supTeamChampEmail;
	
	@FindBy(xpath="//input[@id='txt-stc-phone-line-1']")
	WebElement supTeamChampPhoneNumber;
	
	@FindBy(xpath="//input[@id='txt-stm-name-line-1']")
	WebElement supTeamAddlnMemberName;
	
	@FindBy(xpath="//input[@id='txt-stm-title-line-1']")
	WebElement supTeamAddlnMemberTitle;
	
	@FindBy(xpath="//input[@id='txt-stm-email-line-1']")
	WebElement supTeamAddlnMemberEmail;
	
	@FindBy(xpath="//input[@id='txt-stm-phone-line-1']")
	WebElement supTeamAddlnMemberPhoneNumber;
	
	@FindBy(xpath="//form[@id='dropzone-d1-documents']")	
	WebElement documentUploadD1;
	
	//Actions
	
	public EightDisciplineAmendPage()
	{
		PageFactory.initElements(driver, this);
	}
	
	public String eightDisciplineAmendPageTitle()
	{
		return driver.getTitle();
	}
	
	public void d1d2d3Submit(String tcpcName,String tcpctitle,String tcpcEmail,String tcpcPhoneNUmber,String tsupTeamChampName) throws InterruptedException
	{
		Thread.sleep(1000);
		cpcName.sendKeys(tcpcName);
		Thread.sleep(1000);
		cpctitle.sendKeys(tcpctitle);
		Thread.sleep(1000);
		cpcEmail.sendKeys(tcpcEmail);
		Thread.sleep(1000);
		cpcPhoneNUmber.sendKeys(tcpcPhoneNUmber);
		Thread.sleep(1000);
		supTeamChampName.sendKeys(tsupTeamChampName);
	
	}
	
	
	
}
