package com.qlm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qlm.qa.base.TestBase;

public class PPAPWorkFlowRequestPage extends TestBase
{
	//Page Factory
	
	@FindBy(xpath="//a[contains(text(),'Create New Request')]")
	WebElement createNewPPAPRequest;
	
	
	
	//Actions
	
	public PPAPWorkFlowRequestPage()
	{
		PageFactory.initElements(driver, this);
	}
	
	public String validatePPAPWorkflowRequestPageTitle()
	{
		return driver.getTitle();
	}

	public PPAPRequestCreatePage clickOnCreateNewPPAPRequestButton() throws InterruptedException
	{
		Thread.sleep(2100);
		createNewPPAPRequest.click();
		return new PPAPRequestCreatePage();
		
	}
	
	
	
	
}
