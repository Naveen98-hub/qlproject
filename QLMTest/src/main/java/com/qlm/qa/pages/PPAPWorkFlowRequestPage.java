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
	
	@FindBy(xpath = "(//button[@class='btn btn-primary btn-sm dropdown-toggle'][contains(.,'Action')])[1]")
	WebElement actionButton;
	
	@FindBy(xpath = "(//span[@class='text-success'][contains(.,'View')])[1]")
	WebElement viewButton;
	
	@FindBy(xpath = "(//span[contains(@class,'k-icon k-i-filter')])[1]")
	WebElement partNumberFilter;
	
	@FindBy(xpath = "//input[@placeholder='Search']")
	WebElement partNumberSearch;
	
/*	@FindBy(xpath = "//input[contains(@value,'18135')]")
	WebElement selectPartNumberCheckBox;*/
	
	
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
	
	public PPAPAmendPage ppapAmend() throws InterruptedException
	{
	/*	partNumberFilter.click();
		Thread.sleep(500);
		partNumberSearch.sendKeys(pNo);
		Thread.sleep(500);
		driver.findElement(By.xpath("//input[contains(@value,'"+pNo+"')]")).click();*/
		Thread.sleep(1000);
		actionButton.click();
		Thread.sleep(500);
		viewButton.click();
		return new PPAPAmendPage();
	}
	
	
}
