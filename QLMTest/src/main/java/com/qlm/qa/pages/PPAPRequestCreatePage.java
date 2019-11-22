package com.qlm.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qlm.qa.base.TestBase;
import com.qlm.qa.util.TestUtil;

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
	
	@FindBy(xpath = "//input[@id='btn-submit-form']")
	WebElement submitRequest;
	
	@FindBy(xpath="//input[@id='btn-draft-form']")
	WebElement saveDraft;
	
	@FindBy(xpath="//a[@class='btn btn-default'][contains(.,'Back')]")
	WebElement backButton;
	
	//Actions
	
	public PPAPRequestCreatePage()
	{
		PageFactory.initElements(driver, this);
	}
	
	public String ppapRequestCreatePageTitle()
	{
		return driver.getTitle();
	}
	
	public PPAPWorkFlowRequestPage ppapRequestCreate(String pNo,String oCstmr,String ppapR,String tLocn,String tPlant,String tPgm,String tBsUnit,
			String tPPAPRev,String tPPAPApr,String tSupplier,String tSupCoord,String tSupLoc,String tTemplate) throws InterruptedException
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
		Thread.sleep(1000);
		location.click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//li[contains(text(),'"+tLocn+"')]")).click();
		Thread.sleep(1000);
		plant.click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//li[contains(text(),'"+tPlant+"')]")).click();
		Thread.sleep(1000);
		program.click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//li[contains(text(),'"+tPgm+"')]")).click();
		Thread.sleep(1000);
		businessUnit.click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//li[contains(text(),'"+tBsUnit+"')]")).click();
		Thread.sleep(1000);
		ppapReviewer.click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//h3[contains(text(),'"+tPPAPRev+"')]")).click();
		Thread.sleep(1000);
		ppapApprover.click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("(//h3[contains(text(),'"+tPPAPApr+"')])[2]")).click();
		Thread.sleep(1000);
		supplier.click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//li[contains(text(),'"+tSupplier+"')]")).click();
		Thread.sleep(1000);
		supplierCoordinator.click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//li[contains(text(),'"+tSupCoord+"')]")).click();
		Thread.sleep(1000);
		supplierLocation.click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//li[contains(text(),'"+tSupLoc+"')]")).click();
		Thread.sleep(1000);
		template.click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//li[contains(text(),'"+tTemplate+"')]")).click();
		Thread.sleep(3000);
		TestUtil.moveAction(submitRequest);
		Thread.sleep(1500);
		
		return new PPAPWorkFlowRequestPage();
	}
	
	
	
}
