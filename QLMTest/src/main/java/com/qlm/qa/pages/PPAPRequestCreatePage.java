package com.qlm.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qlm.qa.base.TestBase;

public class PPAPRequestCreatePage extends TestBase
{
	//Page Factory

	@FindBy(xpath = "(//div[contains(@class,'k-multiselect-wrap k-floatwrap')])[1]")
	WebElement part;
			
	@FindBy(xpath = "(//div[contains(@class,'k-multiselect-wrap k-floatwrap')])[2]")
	WebElement oemCustomer;
	
	@FindBy(xpath = "(//div[contains(@class,'k-multiselect-wrap k-floatwrap')])[3]")
	WebElement ppapReason;
	
	@FindBy(xpath = "(//div[contains(@class,'k-multiselect-wrap k-floatwrap')])[4]")
	WebElement location;
	
	@FindBy(xpath = "(//div[contains(@class,'k-multiselect-wrap k-floatwrap')])[5]")
	WebElement plant;
	
	@FindBy(xpath = "(//div[contains(@class,'k-multiselect-wrap k-floatwrap')])[7]")
	WebElement program;
	
	@FindBy(xpath = "(//div[contains(@class,'k-multiselect-wrap k-floatwrap')])[8]")
	WebElement businessUnit;
	
	@FindBy(xpath = "//input[contains(@name,'DrawingNumber')]")
	WebElement drawingNumber;
	
	@FindBy(xpath = "//input[contains(@name,'DrawingRevision')]")
	WebElement drawingRevision;
	
	@FindBy(xpath = "(//div[contains(@class,'k-multiselect-wrap k-floatwrap')])[9]")
	WebElement ppapReviewer;
	
	@FindBy(xpath = "(//div[contains(@class,'k-multiselect-wrap k-floatwrap')])[10]")
	WebElement ppapApprover;
	
	@FindBy(xpath = "(//div[contains(@class,'k-multiselect-wrap k-floatwrap')])[11]")
	WebElement supplier;
	
	@FindBy(xpath = "(//div[contains(@class,'k-multiselect-wrap k-floatwrap')])[12]")
	WebElement supplierCoordinator;
	
	@FindBy(xpath = "(//div[contains(@class,'k-multiselect-wrap k-floatwrap')])[13]")
	WebElement supplierLocation;
	
	@FindBy(xpath = "(//div[contains(@class,'k-multiselect-wrap k-floatwrap')])[14]")
	WebElement supplierPlant;
	
	@FindBy(xpath = "(//span[@unselectable='on'][contains(.,'Select Template')])[3]")
	WebElement template;
	
	@FindBy(xpath = "//input[contains(@value,'Submit Request')]")
	WebElement submitRequest;
	
	//Actions
	
	public PPAPRequestCreatePage()
	{
		PageFactory.initElements(driver, this);
	}
	
	public String validatePPAPRequestCreatePageTitle()
	{
		return driver.getTitle();
	}
	
	public void ppapRequestCreate(String pNo,String oCstmr,String ppapR) throws InterruptedException
	{
		String tpNo = pNo.substring(0, pNo.indexOf('.'));
		part.click();
		Thread.sleep(5000);
		driver.findElement(By.xpath("//li[contains(text(),'"+tpNo+"')]")).click();
		Thread.sleep(1000);
		oemCustomer.click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//li[contains(text(),'"+oCstmr+"')]")).click();
		Thread.sleep(1000);
		ppapReason.click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//li[contains(text(),'"+ppapR+"')]")).click();
		
	}
	
	
	
}
