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
	
	//Actions
	
	public NonConformityPage()
	{
		PageFactory.initElements(driver, this);
	}
	
	public String validateNonConformityPageTitle()
	{
		return driver.getTitle();
	}

	public void clickOnCreateNewNonConformityBtn() throws InterruptedException
	{
		Thread.sleep(1900);
		createNewNonConformityBtn.click();
		Thread.sleep(1000);
	}
	

}
