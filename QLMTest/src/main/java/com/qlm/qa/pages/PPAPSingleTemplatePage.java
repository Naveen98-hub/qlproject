package com.qlm.qa.pages;

import java.awt.AWTException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qlm.qa.base.TestBase;
import com.qlm.qa.util.TestUtil;

public class PPAPSingleTemplatePage extends TestBase
{

	//Page Factory 
	
	@FindBy(xpath="//button[@id='btn-new-template']")
	WebElement createNewElementButton;
	
	@FindBy(xpath="//input[@id='DisplayOrder']")
	WebElement elementNumber;
	
	@FindBy(xpath="//input[@id='Name']")
	WebElement elementName;
	
	@FindBy(xpath="//input[@id='Abbreviation']")
	WebElement elementAbbreviation;
	
	@FindBy(xpath = "(//label[@class='btn btn-default active toggle-off'][contains(.,'Off')])[1]")	
	WebElement isSpecialbutton;
	
	@FindBy(xpath="//div[@id='dropzoneUploadedFileNewUploadForm']")
	WebElement fileUpload;
	
	@FindBy(xpath="//button[@id='modal-confirmation-ok']")   //button[@id='modal-confirmation-ok']
	WebElement elementCreateButton;
	
	@FindBy(xpath="//button[@id='modal-confirmation-cancel']") 
	WebElement elementCancelButton;
	
	@FindBy(xpath = "(//span[contains(@class,'glyphicon glyphicon-pencil text-warning')])[1]")
	WebElement editElementButton;
	
	@FindBy(xpath = "//button[@type='button'][contains(.,'Update')]")
	WebElement updateElementButton;
	
	@FindBy(xpath = "(//span[@class='glyphicon glyphicon-eye-open text-primary'])[1]")
	WebElement viewElementChecklistDetails;
	
	@FindBy(xpath="//button[@id='btn-template-element-checklist-summary-slide-out']")
	WebElement closeElementChecklistDetails;
	
	//Actions
	
	Actions act= new Actions(driver);
	
	public PPAPSingleTemplatePage()
	{
		PageFactory.initElements(driver, this);
	}
	
	public String ppapSingleTemplatePageTitle()
	{
		return driver.getTitle();
						
	}
	
	public void clickOnCreateNewElementButton()
	{
		createNewElementButton.click();
	}
	 
	public void createNewElement(String ppapElementNo, String ppapElementName, String ppapElementAbbreviation) throws InterruptedException, AWTException
	{
		String elementNo = ppapElementNo.substring(0, ppapElementNo.indexOf('.'));
		Thread.sleep(1500);
		elementNumber.click();
		Thread.sleep(500);
		elementNumber.clear();
		Thread.sleep(500);
		elementNumber.sendKeys(elementNo);
		Thread.sleep(500);
		elementName.sendKeys(ppapElementName);
		Thread.sleep(500);
		elementAbbreviation.sendKeys(ppapElementAbbreviation);
		Thread.sleep(1000);
		TestUtil.fileUpload(fileUpload);
		//Actions act= new Actions(driver);
		//act.moveToElement(elementCreateButton).click().perform();
				
	}
	
	public void editElement() throws InterruptedException
	{
		editElementButton.click();
		Thread.sleep(1500);
		//Actions act= new Actions(driver);
		act.moveToElement(updateElementButton).click().perform();
	 }
	
	public void viewElementChecklist() throws InterruptedException
	{
		
		viewElementChecklistDetails.click();
		Thread.sleep(1500);
		closeElementChecklistDetails.click();
	}
	
	
	
}
