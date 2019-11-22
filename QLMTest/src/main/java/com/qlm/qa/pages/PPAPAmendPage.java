package com.qlm.qa.pages;

import java.awt.AWTException;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qlm.qa.base.TestBase;
import com.qlm.qa.util.TestUtil;

public class PPAPAmendPage extends TestBase
{
	//Page Factory
	
	//Submit
	
	@FindBy(xpath = "(//button[@class='btn btn-sm btn-primary dropdown-toggle'][contains(.,'Action')])")
	List<WebElement> elementSubmitAction;
	
	@FindBy(xpath = "(//span[@class='text-warning'][contains(.,'Edit')])[1]")
	WebElement elementEdit;
	
	@FindBy(xpath = "(//span[@class='text-success-highlighted'][contains(.,'Assign Date')])[1]")
	WebElement elementAssignDate;
	
	@FindBy(xpath = "(//span[@class='text-primary'][contains(.,'Submit')])[1]")
	WebElement elementSubmit;
	
	@FindBy(xpath = "(//span[@class='text-success'][contains(.,'View')])[1]")
	WebElement elementView;
	
	@FindBy(xpath = "//button[@type='button'][contains(@id,'ELEMENT')][contains(.,'Add Document')]")
	WebElement addDocument;
	
	@FindBy(xpath="//input[@id='modal-new-file-upload-name']")
	WebElement documentName;
	
	@FindBy(xpath="//form[@id='dropzoneWorkflowRequestNewUploadForm']")
	WebElement singleElementSubmitFileUploadForm;
	
	@FindBy(xpath="//button[@id='modal-new-file-upload-ok']")
	WebElement documentUploadCreate;
	
	@FindBy(xpath = "//label[@for='cb-select-all-element-checklist'][contains(.,'All')]")
	WebElement RequirementChecklistSelect;
	
	@FindBy(xpath="//input[@id='btnSign']")
	WebElement signatureButton;
	
    @FindBy(xpath="//button[@id='modal-authoring-ok']")
    WebElement SubmitButton;
    
    @FindBy(xpath="//button[@id='btn-submit-elements']")
    WebElement submitElementsButton;

    @FindBy(xpath = "//span[@class='small'][contains(.,'Combined Submit')]")
    WebElement combinedSubmitButton;
    
    @FindBy(xpath = "(//span[contains(@class,'glyphicon glyphicon-upload text-primary')])[18]")
    WebElement combinedSubmitUploadFile;
    
    @FindBy(xpath="//form[@id='dropzoneWorkflowRequestBulkFileForm']")
    WebElement fileUpload;
    
    @FindBy(xpath = "//label[contains(@for,'checkbox-submit-all-bulk-elements')]")
    WebElement combinedSubmitChecklist;
    
    //Review
    
    @FindBy(xpath="//button[@id='btn-review-elements']")
    WebElement reviewButton;
    
    @FindBy(xpath = "//label[contains(@for,'checkbox-review-all-elements')]")
    WebElement reviewChecklist;
    
    @FindBy(xpath = "//label[@class='btn btn-success active'][contains(.,'Approve')]")
    WebElement reviewApproveButton;
    
    @FindBy(xpath = "//label[@class='btn btn-danger'][contains(.,'Reject')]")
    WebElement reviewRejectButton;
    
    //Approve
    
    @FindBy(xpath="//button[@id='btn-approve-request']")
    WebElement approveButton;
    
    

    //Actions
    
    public PPAPAmendPage()	
    {
    	PageFactory.initElements(driver, this);
    }
	
	public String ppapAmendPagePageTitle()
	{
		return driver.getTitle();
	}
    
    public void ppapSubmit() throws InterruptedException, AWTException
    {
    	Thread.sleep(500);
    	submitElementsButton.click();
    	Thread.sleep(4000);
    	combinedSubmitButton.click();
    	Thread.sleep(3000);
    	combinedSubmitUploadFile.click();
    	Thread.sleep(1000);
    	TestUtil.fileUpload(fileUpload);
    	Thread.sleep(1500);
    	combinedSubmitChecklist.click();
    	Thread.sleep(500);
    	TestUtil.moveAction(signatureButton);
    	Thread.sleep(500);
      	TestUtil.moveAction(SubmitButton);
    }
    
    public void ppapReview() throws InterruptedException
    {
    	Thread.sleep(500);
    	reviewButton.click();
    	Thread.sleep(3000);
    	reviewChecklist.click();
    	Thread.sleep(1500);
    	TestUtil.moveAction(reviewApproveButton);
    	Thread.sleep(500);
    	TestUtil.moveAction(signatureButton);
    	Thread.sleep(500);
      	TestUtil.moveAction(SubmitButton);
    }
    
    public void ppapApprove() throws InterruptedException
    {
    	Thread.sleep(500);
    	approveButton.click();
    	Thread.sleep(3000);
    	TestUtil.moveAction(signatureButton);
    	Thread.sleep(500);
      	TestUtil.moveAction(SubmitButton);

    }

}
