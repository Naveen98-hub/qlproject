package com.qlm.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qlm.qa.base.TestBase;

public class APQPProjectCreatePage extends TestBase
{
	  //Page Factory
	 
	@FindBy(xpath="//button[@id='btn-Generate-ID']")
	WebElement generatePgmId;
	
	@FindBy(xpath="//input[@id='ProjectName']")
	WebElement programName;
	
	@FindBy(xpath = "(//div[contains(@class,'k-multiselect-wrap k-floatwrap')])[1]")
	WebElement customer;
	
	@FindBy(xpath = "(//div[contains(@class,'k-multiselect-wrap k-floatwrap')])[2]")
	WebElement businessUnit;
	
	@FindBy(xpath = "(//div[contains(@class,'k-multiselect-wrap k-floatwrap')])[3]")
	WebElement programType;
	
	@FindBy(xpath = "(//div[contains(@class,'k-multiselect-wrap k-floatwrap')])[4]")
	WebElement pgmDevelopment;
	
	@FindBy(xpath = "(//div[contains(@class,'k-multiselect-wrap k-floatwrap')])[5]")
	WebElement pgmManager;
	
	@FindBy(xpath = "(//div[contains(@class,'k-multiselect-wrap k-floatwrap')])[6]")
	WebElement partNumber;
	
	@FindBy(xpath = "//a[@class='accordion-toggle'][contains(.,'Production Details:')]")
	WebElement productionDetailsTab;
	
	@FindBy(xpath="//input[@id='NumberOfPartsPerYear']")
	WebElement totalNoofPartsPerYear;
	
	@FindBy(xpath="//input[@id='btnCreateAPQP']")
	WebElement apqpCreateButton;
	
	  //Actions
	
	public APQPProjectCreatePage()
	{
		PageFactory.initElements(driver, this);
	}
	
	public String validateAPQPProjectCreatePageTitle()
	{
		return driver.getTitle();
	}

	public APQPProjectPlanPage createAPQPProject(String pgmName,String tCustomer,String busiUnit,String pgmType,String pgmDev,
			String pgmMgr,String partNo,String totalNoOfYears) throws InterruptedException
	{
		String tTotalNoOfYears = totalNoOfYears.substring(0, totalNoOfYears.indexOf('.'));
		Thread.sleep(1000);
		generatePgmId.click();
		Thread.sleep(1000);
		programName.sendKeys(pgmName);
		Thread.sleep(500);
		customer.click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//li[contains(text(),'"+tCustomer+"')]")).click();
		Thread.sleep(1000);
		businessUnit.click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//li[contains(text(),'"+busiUnit+"')]")).click();
		Thread.sleep(1000);
		programType.click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//li[contains(text(),'"+pgmType+"')]")).click();
		Thread.sleep(1000);
		pgmDevelopment.click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//li[contains(text(),'"+pgmDev+"')]")).click();
		Thread.sleep(1000);
		pgmManager.click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//h3[contains(text(),'"+pgmMgr+"')]")).click();
		Thread.sleep(1000);
		partNumber.click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//li[contains(text(),'"+partNo+"')]")).click();
		Thread.sleep(1000);
		productionDetailsTab.click();
		Thread.sleep(1000);
		totalNoofPartsPerYear.sendKeys(tTotalNoOfYears);
		Thread.sleep(1000);
		apqpCreateButton.click();
		Thread.sleep(2100);
		return new APQPProjectPlanPage();
	}

}
