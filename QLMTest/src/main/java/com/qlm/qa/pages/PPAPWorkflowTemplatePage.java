package com.qlm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.qlm.qa.base.TestBase;

public class PPAPWorkflowTemplatePage extends TestBase
{
	
	//Page Factory
	
   @FindBy(xpath="//button[@id='btn-new-template']")
   WebElement createNewTemplateButton;
   
   @FindBy(xpath="//input[@class='form-control text-box single-line']")
   WebElement templateName;
	
   @FindBy(xpath="//select[@id='form-field-submission-level']")
   WebElement submissionLevel;
   
   @FindBy(id="//button[@id='modal-confirmation-ok']")
   WebElement templateCreateButton;
	
   @FindBy(id="modal-confirmation-cancel")
   WebElement templateCreatecancelButton;
   
   
   
   
   
   
   //Actions
	
   public PPAPWorkflowTemplatePage()
   {
	   PageFactory.initElements(driver, this);
   }
   
   public String validatePPAPWorkflowTemplatePageTitle()
   {
	  return driver.getTitle();
   }
      
   public void clickOnCreateNewTemplateButton()
   {
	   createNewTemplateButton.click();
   }

   public void createNewTemplate(String tempName, String subLevel)
   {
	   //Thread.sleep(1500);
	   templateName.sendKeys(tempName);
	   Select sel = new Select(submissionLevel);
	   sel.selectByVisibleText(subLevel);
	   //templateCreateButton.click();
	   
   }
   
   
   
   
   
}
