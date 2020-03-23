package com.qlm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qlm.qa.base.TestBase;

public class NonConformityPage extends TestBase
{
	// Page Factory
	
	@FindBy(xpath = "//a[@class='btn btn-sm btn-info'][contains(.,'Create New Non Conformity')]")
	WebElement createNewNonConformityBtn;
	
	@FindBy(xpath = "(//button[@class='btn btn-primary btn-sm dropdown-toggle'][contains(.,'Action')])[1]")
	WebElement ncActionBtn;
	
	@FindBy(xpath = "(//span[@class='text-success'][contains(.,'View')])[1]")
	WebElement ncViewBtn;
	
	
	//Actions
	
	public NonConformityPage()
	{
		PageFactory.initElements(driver, this);
	}
	
	public String validateNonConformityPageTitle()
	{
		return driver.getTitle();
	}

	public NonConformityCreatePage clickOnCreateNewNonConformityBtn() throws InterruptedException
	{
		Thread.sleep(1900);
		createNewNonConformityBtn.click();
		Thread.sleep(1000);
		return new NonConformityCreatePage();
	}
	
	public NonConformityViewPage clickOnNonConformityViewBtn() throws InterruptedException
	{
		Thread.sleep(1000);
		ncActionBtn.click();
		Thread.sleep(1000);
		ncViewBtn.click();
		Thread.sleep(1000);
		return new NonConformityViewPage();
	}
	
	
	

}
