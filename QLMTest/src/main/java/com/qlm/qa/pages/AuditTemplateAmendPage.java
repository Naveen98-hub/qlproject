package com.qlm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qlm.qa.base.TestBase;

public class AuditTemplateAmendPage extends TestBase
{
	// Page Factory
	
	@FindBy(xpath="//input[@id='Submit_Template_Questions_Weightage']")
	WebElement submitBtn;
	
	@FindBy(xpath = "//label[@class='btn btn-success toggle-on'][contains(.,'Weightage')]")
	WebElement averageScoreBtn;
	
	//Action
	
	public AuditTemplateAmendPage()
	{
		PageFactory.initElements(driver, this);
	}
	
	public String validateAuditTemplateAmendPageTitle()
	{
		return driver.getTitle();
	}
	
	public void submitAuditTemplate() throws InterruptedException
	{
		Thread.sleep(1500);
		averageScoreBtn.click();
		//Actions act = new Actions(driver);
		//act.moveToElement(submitBtn).click().perform();
		Thread.sleep(1000);
	}
	
	
	
}
