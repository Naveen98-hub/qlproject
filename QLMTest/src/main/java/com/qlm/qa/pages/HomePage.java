package com.qlm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qlm.qa.base.TestBase;

public class HomePage extends TestBase
{	
	// Page Factory
	
	@FindBy(xpath="(//span[contains(text(),'PPAP')])[1]")
	WebElement ppapSpan;
	
    @FindBy(xpath="//a[contains(text(),'Norman Hemmings(admin)')]")
    WebElement userNameLable;
    
	@FindBy(xpath="//a[@title='Navigate to PPAP Workflow Template']")
	WebElement ppapTempleteLink;
	
	@FindBy(xpath="//a[@title='Navigate to PPAP Workflow']")
	WebElement ppapRequestLink;
	
	
    
	
	//Actions
	
	public HomePage()
	{
		PageFactory.initElements(driver, this);
	}
	
	public String validateHomePageTitle()
	{
		return driver.getTitle();
    }
	
	public boolean validateUserLable()
	{
		return userNameLable.isDisplayed();
	}

	public PPAPWorkflowTemplatePage clickOnPPAPTemplete()
	{
		ppapSpan.click();
		ppapTempleteLink.click();		
		return new PPAPWorkflowTemplatePage();
	}
	
	public PPAPWorkFlowRequestPage clickOnPPAPRequest() throws InterruptedException
	{
		ppapSpan.click();
		Thread.sleep(1000);
		ppapRequestLink.click();
		return new PPAPWorkFlowRequestPage();
	}

	
	
	
}
