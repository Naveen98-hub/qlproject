package com.qlm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qlm.qa.base.TestBase;

public class NonConformityViewPage  extends TestBase
{
	// Page Factory
	
	@FindBy(xpath="//input[@id='btn-sorting-requested']")
	WebElement requestSortingBtn;
	
	@FindBy(xpath="//input[@id='btnSign']")
	WebElement signBtn;
	
	@FindBy(xpath="//button[@id='modal-authoring-ok']")
	WebElement submitBtn;
	
	@FindBy(xpath="//input[@id='btn-sorting-acknowlege']")
	WebElement acknowledgeSortingBtn;
	
	@FindBy(xpath = "//a[@class='btn btn-sm btn-info cancel-close'][contains(.,'Process 8D')]")
	WebElement process8DBtn;
		
	
	//Actions
	
	Actions act=new Actions(driver);
	
	public NonConformityViewPage()
	{
		PageFactory.initElements(driver, this);
	}
	
	public String validateNonConformityViewPageTitle()
	{
		return driver.getTitle();
	}
	
	public void clickOnRequestSortingBtn() throws InterruptedException
	{
		Thread.sleep(1000);
		act.moveToElement(requestSortingBtn).click().perform();
		Thread.sleep(1000);
	}
	
	public void submitRequestSorting() throws InterruptedException
	{
		Thread.sleep(1000);
		signBtn.click();
		Thread.sleep(1000);
		submitBtn.click();
		Thread.sleep(1000);
	}
	
	public void clickOnAcknowledgeSortingBtn() throws InterruptedException
	{
		Thread.sleep(1000);
		acknowledgeSortingBtn.click();
		Thread.sleep(1000);
	}
	
	public void submitAcknowledgeSorting() throws InterruptedException
	{
		Thread.sleep(1000);
		signBtn.click();
		Thread.sleep(1000);
		submitBtn.click();
		Thread.sleep(1500);
	}
	
	public EightDisciplineCreatePage clickOn8DBtn() throws InterruptedException
	{
		Thread.sleep(1000);
		process8DBtn.click();
		Thread.sleep(1000);
		return new EightDisciplineCreatePage();
	}
	
	

}
