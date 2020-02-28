package com.qlm.qa.pages;

import java.awt.AWTException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qlm.qa.base.TestBase;
import com.qlm.qa.util.TestUtil;

public class ExternalDocumentUploadPage extends TestBase
{
	// Page Factory
	
	@FindBy(xpath = "//div[@action='/FileUpload/SaveUploadedFile'][contains(.,'Drop files here to upload')]")
	WebElement auditorUploadFile;
	
	@FindBy(xpath="//input[@id='btn-submit-document']")
	WebElement uploadBtn;
	
	@FindBy(xpath = "//a[@class='btn btn-default'][contains(.,'Back')]")
	WebElement ackBtn;
	
	//Actions
	
	public ExternalDocumentUploadPage()
	{
		PageFactory.initElements(driver, this);
	}
	
	public String validateExternalDocumentUploadPageTitle()
	{
		return driver.getTitle();
	}
	
	public void auditorDocUpload() throws InterruptedException, AWTException
	{
		Thread.sleep(1000);
		TestUtil.fileUpload(auditorUploadFile);
    	Thread.sleep(1500);
    	uploadBtn.click();
    	Thread.sleep(1000);
	}
	
	
	
	
	
}
