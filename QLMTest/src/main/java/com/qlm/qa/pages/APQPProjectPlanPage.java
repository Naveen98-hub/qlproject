package com.qlm.qa.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
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
	WebElement bomRolesUpdate;
	
	@FindBy(xpath="//tr[4]/td[3]/div/div")
	WebElement roleUsers;
	
	@FindBy(xpath="//button[@id='btn-role-update']")
	WebElement bomRoleUserUpdate;

	@FindBy(xpath="//a[@id='activity-tab']")
	WebElement tasksTab;

	@FindBy(xpath = "//label[@class='btn btn-default  '][contains(.,'100 %')]")
	WebElement label100;
	
	@FindBy(xpath="//button[@id='modal-confirmation-ok']")
	WebElement taskSubmitButton;
	
	@FindBy(xpath="//button[@id='modal-confirmation-cancel']")
	WebElement taskCancelButton;
	
	@FindBy(xpath="(//button[@id='btn-milestone-action'])[2]")
	WebElement btnMilestineAction;
	
	@FindBy(xpath = "//span[@class='text-warning'][contains(.,'Edit Milestone')]")
	WebElement editMilestone;

	//Actions
	//boolean staleElement = true; 
	Actions act=new Actions(driver);
		
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
		Thread.sleep(1500);
		Select sel = new Select(templateAPQP);
		sel.selectByValue("2064");
		Thread.sleep(1500);
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
		bomRolesUpdate.click();
		Thread.sleep(1000);
	}
	
	public void selectRoleUsers(String roleUser) throws InterruptedException
	{

		Thread.sleep(2500);
		act.moveToElement(roleUsers).click().perform();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//h3[contains(text(),'"+roleUser+"')]")).click();
		Thread.sleep(1000);
		act.moveToElement(bomRoleUserUpdate).click().perform();
		Thread.sleep(1000);
	}
	
	public void phaseTaskActivity() throws InterruptedException
	{
		APQPPhaseGateReviewPage apqpphasegatereviewpage= new APQPPhaseGateReviewPage();
		tasksTab.click();
		Thread.sleep(1000);
		List<WebElement> phases=driver.findElements(By.xpath("//a[@class='btn-activities-phase-detail ']"));
		int phase=phases.size();
		for(int k=1;k<=phase;k++)
		{
		Thread.sleep(1000);
 		List<WebElement> actions= driver.findElements(By.xpath("//button[@id='btn-task-action']"));
		int esize=actions.size();
		int j=1;
		for(int i=1;i<=esize;i++)
		{
			Thread.sleep(1500);
			//action.click();
            driver.findElement(By.xpath("(//button[@id='btn-task-action'])["+j+"]")).click();
			Thread.sleep(1000);
			WebElement actual=driver.findElement(By.xpath("(//span[@class='text-primary-highlighted'][contains(.,'Add Actuals')])["+i+"]"));
			act.moveToElement(actual).click().perform();
			Thread.sleep(1500);
			act.moveToElement(label100).click().perform();
			Thread.sleep(1000);
			act.moveToElement(taskSubmitButton).click().perform();
			Thread.sleep(1000);
			j++;
		}
		act.moveToElement(btnMilestineAction).click().perform();
		Thread.sleep(1000);
		act.moveToElement(editMilestone).click().perform();
		Thread.sleep(1000);
		apqpphasegatereviewpage.milestoneSignature();
		Thread.sleep(4000);
		tasksTab.click();
	  }
   }	
}
