
package com.qlm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qlm.qa.base.TestBase;

public class HomePage extends TestBase
{	
	// Page Factory
	
	@FindBy(xpath="(//span[contains(text(),'PPAP')])[1]")
	WebElement ppapSpan;
	
    @FindBy(xpath="//a[contains(text(),'Norman Hemmings(admin)')]")
    WebElement userNameLable;
    
	@FindBy(xpath="//a[@title='Navigate to PPAP Workflow Template']")
	WebElement ppapTempleteLink;
	
	@FindBy(xpath="//a[@title='Navigate to PPAP Workflow']")
	WebElement ppapRequestLink;
	
	@FindBy(xpath = "//a[@href='#'][contains(.,'APQP')]")
	WebElement apqpSpan;
	
	@FindBy(xpath = "//a[contains(@title,'Navigate to APQP Templates')]")
	WebElement apqpTemplateLink;
	
	@FindBy(xpath = "//a[@title='Navigate to APQP Project']")
	WebElement apqpProjectLink;
	
	@FindBy(xpath="(//span[contains(text(),'Assessment')])[1]")
	WebElement assessmentLink;
	
	@FindBy(xpath="//span[@class='menu-item-title submenu_tree' and contains(text(),'Audit')]")
	WebElement auditLink;
	
	@FindBy(xpath="(//span[contains(text(),'Template')])[4]")
	WebElement auditTemplateLink;
	
	@FindBy(xpath="(//span[contains(text(),'Element')])[6]")
	WebElement auditElementLink;
	
	@FindBy(xpath = "(//span[contains(.,'Supplier')])[1]")
	WebElement supplierManagement;
	
	@FindBy(xpath="//span[@class='submenu_tree' and contains(text(),'Audit')]")
	WebElement supplierAuditLink;
	
	@FindBy(xpath = "//span[@class='menu-item-title'][contains(.,'Plant Quality')]")
	WebElement plantQualitySpan;
	
	@FindBy(xpath = "//a[@class='link-item-menu'][contains(.,'Non Conformity')]")
	WebElement nonConformityLink;
	
	@FindBy(xpath = "//span[@class='submenu_tree'][contains(.,'Eight Disciplines')]")
	WebElement eightDisciplinesLink;
	
	

	//Actions
	
	public HomePage()
	{
		PageFactory.initElements(driver, this);
	}
	
	public String validateHomePageTitle()
	{
		return driver.getTitle();
    }
	
	public boolean validateUserLable()
	{
		return userNameLable.isDisplayed();
	}

	public PPAPWorkflowTemplatePage clickOnPPAPTemplete() throws InterruptedException
	{
		Thread.sleep(1000);
		ppapSpan.click();
		Thread.sleep(1000);
		ppapTempleteLink.click();	
		Thread.sleep(1000);
		return new PPAPWorkflowTemplatePage();
	}
	
	public PPAPWorkFlowRequestPage clickOnPPAPRequest() throws InterruptedException
	{
		Thread.sleep(1000);
		ppapSpan.click();
		Thread.sleep(1000);
		ppapRequestLink.click();
		return new PPAPWorkFlowRequestPage();
	}

	public APQPTemplateManagementPage clickOnAPQPTemplate() throws InterruptedException
	{
		Thread.sleep(1000);
		apqpSpan.click();
		Thread.sleep(1000);
		apqpTemplateLink.click();
		return new APQPTemplateManagementPage();
	}
	
	public APQPProjectManagementPage clickOnAPQPProject() throws InterruptedException
	{
		Thread.sleep(1000);
		apqpSpan.click();
		Thread.sleep(1000);
		apqpProjectLink.click();
		Thread.sleep(1000);
		return new APQPProjectManagementPage();
	}
	
	public AuditTemplateIndexPage clickOnAuditTemplate() throws InterruptedException
	{
		Thread.sleep(1000);
		assessmentLink.click();
		Thread.sleep(1000);
		auditLink.click();
		Thread.sleep(1000);
		auditTemplateLink.click();
		Thread.sleep(1000);
		return new AuditTemplateIndexPage();
	}

	public AuditsPage clickOnAuditElement() throws InterruptedException
	{
		Thread.sleep(1900);
		assessmentLink.click();
		Thread.sleep(1000);
		auditLink.click();
		Thread.sleep(1000);
		auditElementLink.click();
		Thread.sleep(1000);
		return new AuditsPage();
	}
	
	public AuditsPage clickOnSupplierAuditLink() throws InterruptedException
	{
		Thread.sleep(1900);
		supplierManagement.click();
		Thread.sleep(1000);
		supplierAuditLink.click();
		Thread.sleep(1000);
		return new AuditsPage();
	}
	
	public NonConformityPage clickOnNonConformitylink() throws InterruptedException
	{
		Thread.sleep(1900);
		plantQualitySpan.click();
		Thread.sleep(1000);
		nonConformityLink.click();
		Thread.sleep(1000);
		return new NonConformityPage();
	}
	
	public EightDisciplinesPage clickOnEightDisciplinesLink() throws InterruptedException
	{
		Thread.sleep(1900);
		plantQualitySpan.click();
		Thread.sleep(1000);
		eightDisciplinesLink.click();
		Thread.sleep(1000);
		return new EightDisciplinesPage();
	}
	
}
