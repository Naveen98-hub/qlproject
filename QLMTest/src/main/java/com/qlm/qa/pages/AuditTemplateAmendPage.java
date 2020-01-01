package com.qlm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qlm.qa.base.TestBase;

public class AuditTemplateAmendPage extends TestBase
{
	// Page Factory
	
	@FindBy(xpath="//input[@id='Submit_Template_Questions_Weightage']")
	WebElement submitBtn;
	
	//Action
	
	public AuditTemplateAmendPage()
	{
		PageFactory.initElements(driver, this);
	}
	
	public String validateAuditTemplateAmendPage()
	{
		return driver.getTitle();
	}
	
	public void submitAuditTemplate() throws InterruptedException
	{
		Thread.sleep(1500);
		Actions act = new Actions(driver);
		act.moveToElement(submitBtn).click().perform();
		Thread.sleep(1000);
	}
	
	
	
}
