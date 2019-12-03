package com.qlm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qlm.qa.base.TestBase;

public class APQPTemplateManagementPage extends TestBase
{
	//Page Factory
	
	@FindBy(xpath="//button[@id='btn-new-template']")
	WebElement createNewTemplateButton;
	
	@FindBy(xpath="//input[@id='control-title']")
	WebElement templateName;
	
	@FindBy(xpath="//button[@id='modal-authoring-ok']")
	WebElement submitButtonTemplate;
	
	@FindBy(xpath="//button[@id='modal-authoring-cancel']")
	WebElement cancelButtonTemplate;
	
	@FindBy(xpath = "(//button[@class='btn btn-primary btn-sm dropdown-toggle'][contains(.,'Action')])[1]")
	WebElement templateListActionButton;
	
	@FindBy(xpath = "(//span[@class='text-warning'][contains(.,'Edit')])[1]")
	WebElement templateEdit;
	
	@FindBy(xpath="//button[@id='modal-authoring-ok']")
	WebElement templateUpdate;
	
	@FindBy(xpath = "(//span[@class='text-success'][contains(.,'View')])[1]")
	WebElement templateView;

	//Actions
	
	public APQPTemplateManagementPage()
	{
		PageFactory.initElements(driver, this);
	}
	
	public String validateAPQPTemplateManagementPageTitle()
	{
	  return driver.getTitle();
	}
	
	public void clickOnCreateNewTemplateButton() throws InterruptedException
	{
	  Thread.sleep(1000);
	  createNewTemplateButton.click();
	}
	
	public void createNewAPQPTemplate(String tempName ) throws InterruptedException
	{
		Thread.sleep(1000);
		templateName.sendKeys(tempName);
		Thread.sleep(1500);
		submitButtonTemplate.click();
		Thread.sleep(1000);
	}

	public void editAPQPTemplate() throws InterruptedException
	{
		Thread.sleep(4000);
		templateListActionButton.click();
		Thread.sleep(1000);
		templateEdit.click();
		Thread.sleep(1000);
		templateUpdate.click();
	}
	
	public APQPTemplateDetailPlanPage viewAPQPTemplate() throws InterruptedException
	{
		Thread.sleep(1000);
		templateListActionButton.click();
		Thread.sleep(1000);
		templateView.click();	
        return new APQPTemplateDetailPlanPage();
	}

}
