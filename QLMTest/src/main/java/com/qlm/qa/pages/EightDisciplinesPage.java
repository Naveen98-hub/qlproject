package com.qlm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.qlm.qa.base.TestBase;

public class EightDisciplinesPage extends TestBase
{
	// Page Factory
	
	@FindBy(xpath = "//select[contains(@class,'form-control input-sm')]")
	WebElement selectIncidentFilter;
	
	@FindBy(xpath = "(//button[@class='btn btn-primary btn-sm dropdown-toggle'][contains(.,'Action')])[1]")
	WebElement incidentActionBtn;
	
	@FindBy(xpath = "(//span[@class='text-success'][contains(.,'View')])[1]")
	WebElement incidentViewBtn;
	
	//Actions
	
	public EightDisciplinesPage()
	{
		PageFactory.initElements(driver, this);
	}
	
	public String eightDisciplinesPageTitle()
	{
		return driver.getTitle();
	}
	
	public void selectIncident() throws InterruptedException
	{
		Thread.sleep(1000);
		Select sel = new Select(selectIncidentFilter);
		sel.selectByValue("30");
		Thread.sleep(1500);
	}
	
	public EightDisciplineAmendPage clickonEightDisciplineViewBtn() throws InterruptedException
	{
		Thread.sleep(1000);
		incidentActionBtn.click();
		Thread.sleep(1000);
		incidentViewBtn.click();
		Thread.sleep(1500);
		return new EightDisciplineAmendPage();
	}
	
}
