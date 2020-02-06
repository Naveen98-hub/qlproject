package com.qlm.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qlm.qa.base.TestBase;

public class AuditsPage extends TestBase
{
	//Page Factory
	
	@FindBy(xpath="//a[contains(text(),'Create New Audit')]")
	WebElement createNewAuditBtn;
	
	@FindBy(xpath = "(//button[@class='btn btn-primary btn-sm dropdown-toggle'])[1]")
	WebElement auditsListActionBtn;
	
	@FindBy(xpath = "(//span[@class='text-success '][contains(.,'Self Assessment')])[1]")
	WebElement selfAssessmentBtn;
	
	@FindBy(xpath = "(//span[@class='text-success '][contains(.,'Assessment')])[1]")
	WebElement assessmentBtn;
	
	
	
	//Actions
	
	public AuditsPage()
	{
		PageFactory.initElements(driver, this);
	}

	public String validateAuditsPageTitle()
	{
		return driver.getTitle();
	}
	
	public AuditCreatePage createNewAuditBtn() throws InterruptedException
	{
		Thread.sleep(3000);
		createNewAuditBtn.click();
		Thread.sleep(1000);
		return new AuditCreatePage();
	}
	
	public SelfAuditPage clickOnselfAssessment() throws InterruptedException
	{
		Thread.sleep(3000);
		auditsListActionBtn.click();
		Thread.sleep(1000);
		selfAssessmentBtn.click();
		Thread.sleep(1000);
		return new SelfAuditPage();
	}
	
	public AuditorAuditPage clickOnAssessment() throws InterruptedException
	{
		Thread.sleep(1000);
		auditsListActionBtn.click();
		Thread.sleep(1000);
		assessmentBtn.click();
		Thread.sleep(1000);
		return new AuditorAuditPage();
	}
	
	public void scrollPage() throws InterruptedException
	{
		Thread.sleep(3000);
		
		JavascriptExecutor js = (JavascriptExecutor) driver;
		 WebElement myElement=driver.findElement(By.xpath("(//button[@class='btn btn-primary btn-sm dropdown-toggle'])[1]"));

	        //This will scroll the page Horizontally till the element is found		
	        js.executeScript("arguments[0].scrollIntoView();", myElement);
	        Thread.sleep(1000);
	}

}
