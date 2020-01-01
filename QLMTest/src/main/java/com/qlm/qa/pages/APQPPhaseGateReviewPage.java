package com.qlm.qa.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qlm.qa.base.TestBase;

public class APQPPhaseGateReviewPage extends TestBase
{
   //Page Factory
	
	
	@FindBy(xpath="//button[@id='btn-initiate-milestone']")
	WebElement initiateMilestone;
	
	@FindBy(xpath="//button[@id='modal-confirmation-ok']")
	WebElement confirmButton;
	
	@FindBy(xpath="//button[@id='modal-confirmation-cancel']")
	WebElement cancelButton;

    @FindBy(xpath="//label[@id='btn-authorization-status-passed']")
    WebElement passedButton;
    
    @FindBy(xpath="//input[@id='btnSign']")
    WebElement signButton;
    
    @FindBy(xpath="//button[@id='modal-authoring-ok']")
    WebElement submitButton;
    
    @FindBy(xpath="//input[@id='btn-update-milestone']")
    WebElement updateMilestoneBtn;
    
	//Actions
	
    Actions act=new Actions(driver);
    
	public APQPPhaseGateReviewPage()
	{
		PageFactory.initElements(driver, this);
	}
    
	public APQPProjectPlanPage milestoneSignature() throws InterruptedException
	{
		Thread.sleep(3000);
		act.moveToElement(initiateMilestone).click().perform();
		Thread.sleep(1000);
		confirmButton.click();
		Thread.sleep(1500);
		
		List<WebElement> signButtons=driver.findElements(By.xpath("//span[@class='text-success'][contains(.,'Sign')]"));
		int sSize=signButtons.size();
		for(int i=1;i<=sSize;i++)
		{
			Thread.sleep(1000);
			WebElement sButton= driver.findElement(By.xpath("(//span[@class='text-success'][contains(.,'Sign')])[1]"));
			act.moveToElement(sButton).click().perform();
			Thread.sleep(1500);
			passedButton.click();
			Thread.sleep(1000);
			act.moveToElement(signButton).click().perform();
			//act.moveToElement(signButton).click().perform();
			Thread.sleep(2100);
			act.moveToElement(submitButton).click().perform();
			Thread.sleep(1000);
					
		}
		act.moveToElement(updateMilestoneBtn).click().perform();
		Thread.sleep(1000);
		return new APQPProjectPlanPage();
	}
	
}
