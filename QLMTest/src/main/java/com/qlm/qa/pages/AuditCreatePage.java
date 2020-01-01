package com.qlm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qlm.qa.base.TestBase;

public class AuditCreatePage extends TestBase
{
	// Page Factory
	
	@FindBy(xpath = "(//div[contains(@class,'k-multiselect-wrap k-floatwrap')])[1]")
	WebElement auditType;
	
	@FindBy(xpath = "(//div[contains(@class,'k-multiselect-wrap k-floatwrap')])[2]")
	WebElement auditReason;
	
	@FindBy(xpath = "(//div[contains(@class,'k-multiselect-wrap k-floatwrap')])[3]")
	WebElement supplier;
	
	@FindBy(xpath = "(//div[contains(@class,'k-multiselect-wrap k-floatwrap')])[4]")
	WebElement supplierLocation;
	
	@FindBy(xpath="//input[@id='Name']")
	WebElement name;
	
	@FindBy(xpath = "(//div[contains(@class,'k-multiselect-wrap k-floatwrap')])[10]")
	WebElement coordinator;
	
	@FindBy(xpath = "(//div[contains(@class,'k-multiselect-wrap k-floatwrap')])[11]")
	WebElement supplierCoordinator;
	
	@FindBy(xpath = "(//div[contains(@class,'k-multiselect-wrap k-floatwrap')])[12]")
	WebElement template;
	
	@FindBy(xpath = "(//div[contains(@class,'k-multiselect-wrap k-floatwrap')])[13]")
	WebElement auditors;
	
	@FindBy(xpath = "(//div[contains(@class,'k-multiselect-wrap k-floatwrap')])[14]")
	WebElement reviewers;
	
	//Actions
	
	public AuditCreatePage()
	{
		PageFactory.initElements(driver, this);
	}
	
	public String validateAuditCreatePage()
	{
		return driver.getTitle();
	}
	
	public void internalAuditCreate()
	{
		auditType.click();
		
	}

}
