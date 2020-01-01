package com.qlm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qlm.qa.base.TestBase;

public class AuditsPage extends TestBase
{
	//Page Factory
	
	@FindBy(xpath="//a[contains(text(),'Create New Audit')]")
	WebElement createNewAuditBtn;
	
	//Actions
	
	public AuditsPage()
	{
		PageFactory.initElements(driver, this);
	}

	public String validateAuditsPageTitle()
	{
		return driver.getTitle();
	}
	
	public AuditCreatePage createNewAuditBtn() throws InterruptedException
	{
		Thread.sleep(1500);
		createNewAuditBtn.click();
		Thread.sleep(1000);
		return new AuditCreatePage();
		
		
	}
}
