package com.qlm.qa.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.qlm.qa.base.TestBase;

public class APQPProjectPlanPage extends TestBase
{
	//Page Factory
	
	@FindBy(xpath="//select[@id='TemplateId']")
	WebElement templateAPQP;
	
	@FindBy(xpath="//input[@id='StartDate']")
	WebElement startDate;
	
	@FindBy(xpath="(//a[contains(text(),'27')])[1]")
	WebElement dateSelect;
	
	@FindBy(xpath="//button[@id='btn-project-amend-template']")
	WebElement proceddButton;
 
	@FindBy(xpath="(//a[contains(text(),'18')])[1]")
	WebElement targetCloseDateSelect;
	
	@FindBy(xpath="//button[@id='btn-phase-target-date-update']")
	WebElement updateTrgetCloseDate;
	
	@FindBy(xpath="//a[@id='member-tab']")
	WebElement membersTab;
	
	@FindBy(xpath = "(//div[contains(@class,'k-multiselect-wrap k-floatwrap')])[3]")
	WebElement engineeringRole;

	@FindBy(xpath = "(//div[contains(@class,'k-multiselect-wrap k-floatwrap')])[4]")
	WebElement purchasingRole;
	
	@FindBy(xpath="//button[@id='btn-bom-role-update']")
	WebElement bomRoleUpdate;
	
	

	//Actions
	
	public APQPProjectPlanPage()
	{
		PageFactory.initElements(driver, this);
	}
	
	public String validateAPQPProjectPlanPageTitle()
	{
		return driver.getTitle();
	}
	
	public void selectAPQPTemplate(String templateName) throws InterruptedException
	{
		Thread.sleep(1000);
		Select sel = new Select(templateAPQP);
		sel.selectByValue("2064");
		Thread.sleep(1000);
		startDate.click();
		Thread.sleep(1000);
		dateSelect.click();
		Thread.sleep(1000);
		proceddButton.click();
		Thread.sleep(1000);
	}
 
	public void selectTargetCloseDate() throws InterruptedException
	{
		List<WebElement> targetDates=driver.findElements(By.xpath("//input[@placeholder='Target Date']"));
		//targetDates.size();
		for(WebElement dates:targetDates)
		{
			Thread.sleep(1000);
			dates.click();
			Thread.sleep(1000);
			targetCloseDateSelect.click();
			Thread.sleep(1000);
		}
		updateTrgetCloseDate.click();
		Thread.sleep(1000);
	}
	
	public void selectRoles(String engRole,String purchRole) throws InterruptedException
	{
		Thread.sleep(1000);
		membersTab.click();
		Thread.sleep(1000);
		engineeringRole.click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("(//li[contains(text(),'"+engRole+"')])[1]")).click();
		Thread.sleep(1000);
		purchasingRole.click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("(//li[contains(text(),'"+purchRole+"')])[2]")).click();
		Thread.sleep(1000);
		bomRoleUpdate.click();
		Thread.sleep(1000);
	}
	
	
}
