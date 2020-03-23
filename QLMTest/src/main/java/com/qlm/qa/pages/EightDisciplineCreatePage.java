package com.qlm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qlm.qa.base.TestBase;

public class EightDisciplineCreatePage extends TestBase
{
	// Page Factory
	
	@FindBy(xpath="//input[@id='btn-submit-form']")
	WebElement eightDCreateBtn;
	
	
	//Actions
	
	Actions act=new Actions(driver);
	
	public EightDisciplineCreatePage()
	{
		PageFactory.initElements(driver, this);
	}
	
	public String validateEightDisciplinePageTitle()
	{
		return driver.getTitle();
	}
	
	public void clickOnCreate8DBtn() throws InterruptedException
	{
		Thread.sleep(1000);
		act.moveToElement(eightDCreateBtn).click().perform();
		Thread.sleep(1500);
	}

}
