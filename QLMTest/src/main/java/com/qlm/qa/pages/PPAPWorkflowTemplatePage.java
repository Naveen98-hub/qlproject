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
   
   @FindBy(xpath = "(//button[contains(.,'Action')])[1]")
   WebElement templateListPageActionButton;
   
   @FindBy(xpath="//html/body/div[1]/div/div[3]/div/div/table/tbody/tr[1]/td[4]/div/ul/li[1]/a/span")
   WebElement editTemplateButton;
   
   @FindBy(xpath="//html/body/div[1]/div/div[3]/div/div/table/tbody/tr[1]/td[4]/div/ul/li[2]/a/span")
   WebElement viewTemplateButton;
   
   @FindBy(xpath = "//button[@id='modal-confirmation-ok' and @class='btn btn-primary']")
   WebElement templateUpdateButton;

   
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
   
   public void updateTemplate() throws InterruptedException
   {
	   Thread.sleep(2500);
	   templateListPageActionButton.click();
	   Thread.sleep(2500);
	   editTemplateButton.click();
	   Thread.sleep(2500);
	  templateUpdateButton.click();
   }
   
   public PPAPSingleTemplatePage viewTemplate() throws InterruptedException
   {
	   Thread.sleep(2500);
	   templateListPageActionButton.click();
	   Thread.sleep(2500);
	   viewTemplateButton.click();
	   return new PPAPSingleTemplatePage();
	   
   }
   
   
   
   
}
