package com.qlm.qa.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.qlm.qa.base.TestBase;

public class AuditTemplateCreatePage extends TestBase
{
	// Page Factory
	
	@FindBy(xpath="//input[@id='Name']")
	WebElement templateName;
	
	@FindBy(xpath="//select[@id='ddl-quesqroup']")
	WebElement questionnaireGroups;
	
	@FindBy(xpath="//input[@id='CreateTemplate']")
	WebElement createTemplateBtn;
	
	@FindBy(xpath = "//label[@class='btn btn-success toggle-on'][contains(.,'Weightage')]")
	WebElement averageScoreBtn;
	
	//Actions
	
	Actions act=new Actions(driver);
	
	public AuditTemplateCreatePage()
	{
		PageFactory.initElements(driver, this);
	}

	public String validateAuditTemplateCreatePageTitle()
	{
		return driver.getTitle();
	}
	
	public AuditTemplateAmendPage createNewAuditTemplate(String tempName, String questGroup) throws InterruptedException
	{
		Thread.sleep(1500);
		templateName.sendKeys(tempName);
		Thread.sleep(1000);
	    Select sel=new Select(questionnaireGroups);
	    sel.selectByVisibleText(questGroup);		
	    Thread.sleep(1500);
	    
	    List<WebElement> questTabs = driver.findElements(By.xpath("//h4[@role='tab']"));
	    int qsize=questTabs.size();
	    int j=1;
	    for(int i=1;i<=qsize;i++)
	    {
	    	WebElement questTabSource = driver.findElement(By.xpath("(//h4[@role='tab'])["+j+"]"));
	    	WebElement questTabDestination = driver.findElement(By.xpath("//div[@id='catalog2']"));
	    	questTabSource.click();
	    	Thread.sleep(1000);
	    	act.dragAndDrop(questTabSource, questTabDestination).build().perform();
	    	Thread.sleep(1000);
	    	j++;
	    }
	    act.moveToElement(createTemplateBtn).click().perform();
		Thread.sleep(1000);
		return new AuditTemplateAmendPage();
	}
	
	
}
