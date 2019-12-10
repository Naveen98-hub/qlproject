package com.qlm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qlm.qa.base.TestBase;

public class APQPProjectManagementPage extends TestBase
{
	//Page Factory
	
	@FindBy(xpath = "//a[@class='btn btn-sm btn-info'][contains(.,'Create New Project')]")
	WebElement createNewAPQPProject;
	
	@FindBy(xpath = "(//button[@class='btn btn-primary btn-sm dropdown-toggle'][contains(.,'Action')])[1]")
	WebElement apqpProjectListAction;
	
	@FindBy(xpath = "(//span[@class='text-success'][contains(.,'View')])[1]")
	WebElement apqpProjectListView;
	
	//Actions
	
	public APQPProjectManagementPage()
	{
		PageFactory.initElements(driver, this);
	}
	
	public String validateAPQPProjectManagementPageTitle()
	{
		return driver.getTitle();
	}

	public APQPProjectCreatePage createNewAPQPProjectButton() throws InterruptedException
	{
		Thread.sleep(1500);
		createNewAPQPProject.click();
		Thread.sleep(1000);
		return new APQPProjectCreatePage();		
	}
	
	public APQPProjectPlanPage viewAPQPProject() throws InterruptedException
	{
		Thread.sleep(1000);
		apqpProjectListAction.click();
		Thread.sleep(1000);
		apqpProjectListView.click();
		Thread.sleep(1000);
		return new APQPProjectPlanPage();
	}
}
