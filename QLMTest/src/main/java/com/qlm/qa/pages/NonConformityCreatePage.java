package com.qlm.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qlm.qa.base.TestBase;

public class NonConformityCreatePage extends TestBase
{
	//Page Factory
	
	@FindBy(xpath = "//input[@id='Name']")
	WebElement nameNC;
	
	@FindBy(xpath = "//input[@id='ProductLine']")
	WebElement productLineNC;
	
	@FindBy(xpath = "(//div[contains(@class,'k-multiselect-wrap k-floatwrap')])[1]")
	WebElement ncCatagory;
	
	@FindBy(xpath = "(//div[contains(@class,'k-multiselect-wrap k-floatwrap')])[2]")
	WebElement ncType;
	
	@FindBy(xpath = "(//div[contains(@class,'k-multiselect-wrap k-floatwrap')])[3]")
	WebElement partNumber;
	
	@FindBy(xpath = "(//div[contains(@class,'k-multiselect-wrap k-floatwrap')])[4]")
	WebElement defect;
	
	@FindBy(xpath = "(//div[contains(@class,'k-multiselect-wrap k-floatwrap')])[13]")
	WebElement reviewer;
	
	@FindBy(xpath = "(//div[contains(@class,'k-multiselect-wrap k-floatwrap')])[16]")
	WebElement supplier;
	
	@FindBy(xpath = "(//div[contains(@class,'k-multiselect-wrap k-floatwrap')])[17]")
	WebElement supplierCoordinator;
	
	@FindBy(xpath = "(//div[contains(@class,'k-multiselect-wrap k-floatwrap')])[18]")
	WebElement supplierLocation;
	
	@FindBy(xpath = "(//div[contains(@class,'k-multiselect-wrap k-floatwrap')])[19]")
	WebElement supplierPlant;
	
	@FindBy(xpath="//div[@id='cke_1_contents']")
	WebElement description;
	
	@FindBy(xpath="//div[@id='cke_3_contents']")
	WebElement reworkContainment;
	
	@FindBy(xpath="//input[@id='btn-submit-form-create']")
	WebElement createBtn;
	
	@FindBy(xpath = "//a[@class='btn btn-default'][contains(.,'Back')]")
	WebElement backBtn;
	
	//Actions
	
	Actions act=new Actions(driver);
	
	public NonConformityCreatePage()
	{
		PageFactory.initElements(driver, this);
	}
	
	public String validateNonConformityCreatePageTitle()
	{
		return driver.getTitle();
	}
	
	public void createNonConformity(String tName,String tProductLine,String tNCCategory,String tNCType,String tPartNumber,String tDefect,
			                        String tReviewer,String tSupplier,String tSupplierCoordinator,String tSupplierLocation,String tSupplierPlant) throws InterruptedException
	{
		String tePartNumber = tPartNumber.substring(0, tPartNumber.indexOf('.'));
		String teDefect = tDefect.substring(0, tDefect.indexOf('.'));
		Thread.sleep(1000);
		nameNC.sendKeys(tName);
		Thread.sleep(500);
		productLineNC.sendKeys(tProductLine);
		Thread.sleep(500);
		ncCatagory.click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//li[contains(text(),'"+tNCCategory+"')]")).click();
		Thread.sleep(1000);
		ncType.click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("(//li[contains(text(),'"+tNCType+"')])[2]")).click();
		Thread.sleep(1000);
		partNumber.click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("(//li[contains(text(),'"+tePartNumber+"')])[1]")).click();
		Thread.sleep(1000);
		defect.click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("(//li[contains(text(),'"+teDefect+"')])[207]")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//a[@class='accordion-toggle'][contains(.,'Non Conformity (Other Details) :')]")).click();
		Thread.sleep(1000);
		reviewer.click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//h3[contains(text(),'"+tReviewer+"')]")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//a[@class='accordion-toggle collapsed'][contains(.,'Supplier Details :')]")).click();
		Thread.sleep(1000);
		supplier.click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//li[contains(text(),'"+tSupplier+"')]")).click();
		Thread.sleep(1000);
		supplierCoordinator.click();
		Thread.sleep(1500);
		driver.findElement(By.xpath("//li[contains(text(),'"+tSupplierCoordinator+"')]")).click();
		Thread.sleep(1000);
		supplierLocation.click();
		Thread.sleep(1500);
		driver.findElement(By.xpath("//li[contains(text(),'"+tSupplierLocation+"')]")).click();
		Thread.sleep(1000);
		supplierPlant.click();
		Thread.sleep(1500);
		driver.findElement(By.xpath("//li[contains(text(),'"+tSupplierPlant+"')]")).click();
		Thread.sleep(1000);
		//driver.findElement(By.xpath("//a[@class='accordion-toggle collapsed'][contains(.,'Details :')]")).click();
		//Thread.sleep(1000);
		//description.sendKeys(tDescription);
		//Thread.sleep(1000);
		//reworkContainment.sendKeys(tReworkContainment);
		Thread.sleep(1000);
		act.moveToElement(createBtn).click().perform();
		Thread.sleep(1500);

	}

}
