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
	
	@FindBy(xpath = "//a[@href='#'][contains(.,'APQP')]")
	WebElement apqpSpan;
	
	@FindBy(xpath = "//a[contains(@title,'Navigate to APQP Templates')]")
	WebElement apqpTemplateLink;
	
	@FindBy(xpath = "//a[@title='Navigate to APQP Project']")
	WebElement apqpProjectLink;

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

	public PPAPWorkflowTemplatePage clickOnPPAPTemplete() throws InterruptedException
	{
		Thread.sleep(1000);
		ppapSpan.click();
		Thread.sleep(1000);
		ppapTempleteLink.click();	
		Thread.sleep(1000);
		return new PPAPWorkflowTemplatePage();
	}
	
	public PPAPWorkFlowRequestPage clickOnPPAPRequest() throws InterruptedException
	{
		Thread.sleep(1000);
		ppapSpan.click();
		Thread.sleep(1000);
		ppapRequestLink.click();
		return new PPAPWorkFlowRequestPage();
	}

	public APQPTemplateManagementPage clickOnAPQPTemplate() throws InterruptedException
	{
		Thread.sleep(1000);
		apqpSpan.click();
		Thread.sleep(1000);
		apqpTemplateLink.click();
		return new APQPTemplateManagementPage();
	}
	
	public APQPProjectManagementPage clickOnAPQPProject() throws InterruptedException
	{
		Thread.sleep(1000);
		apqpSpan.click();
		Thread.sleep(1000);
		apqpProjectLink.click();
		Thread.sleep(1000);
		return new APQPProjectManagementPage();
	}

}
