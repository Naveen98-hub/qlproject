package com.qlm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qlm.qa.base.TestBase;

public class AuditTemplateIndexPage extends TestBase
{
	//Page Factory
	
	@FindBy(xpath="//button[@id='btn-new-audit-template']")
	WebElement createNewAuditTemplateButton;
	
	@FindBy(xpath = "(//button[@class='btn btn-primary btn-sm dropdown-toggle'])[1]")
	WebElement templateListActionBtn;
	
	@FindBy(xpath = "(//span[@class='text-success'])[1]")
	WebElement templateAmendBtn;
       
     //Actions
	
	public AuditTemplateIndexPage()
	{
		PageFactory.initElements(driver, this);
	}
	
	public String validateAuditTemplateIndexPageTitle()
	{
		return driver.getTitle();
	}
	
	public AuditTemplateCreatePage createNewAuditTemplateBtn() throws InterruptedException
	{
		Thread.sleep(1500);
		createNewAuditTemplateButton.click();
		Thread.sleep(1000);
		return new AuditTemplateCreatePage();
	}
	
	  public AuditTemplateAmendPage navigateToAuditTemplateAmendScreen() throws InterruptedException
	  {
		  Thread.sleep(1500);
		  templateListActionBtn.click();
		  Thread.sleep(1000);
		  templateAmendBtn.click();
		  Thread.sleep(1000);
		  return new AuditTemplateAmendPage();
	  }
	
}
