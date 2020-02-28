package com.qlm.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qlm.qa.base.TestBase;

public class AuditCreatePage extends TestBase
{
	// Page Factory
	
	@FindBy(xpath = "(//div[contains(@class,'k-multiselect-wrap k-floatwrap')])[1]")
	WebElement auditType;
	
	@FindBy(xpath = "(//div[contains(@class,'k-multiselect-wrap k-floatwrap')])[2]")
	WebElement auditReason;
	
	@FindBy(xpath = "(//div[contains(@class,'k-multiselect-wrap k-floatwrap')])[3]")
	WebElement supplier;
	
	@FindBy(xpath = "(//div[contains(@class,'k-multiselect-wrap k-floatwrap')])[4]")
	WebElement supplierLocation;
	
	@FindBy(xpath="//input[@id='Name']")
	WebElement name;
	
	@FindBy(xpath = "(//div[contains(@class,'k-multiselect-wrap k-floatwrap')])[7]")
	WebElement coordinator;
	
	@FindBy(xpath = "(//div[contains(@class,'k-multiselect-wrap k-floatwrap')])[5]")
	WebElement supplierCoordinator;
	
	@FindBy(xpath = "(//div[contains(@class,'k-multiselect-wrap k-floatwrap')])[13]")
	WebElement template;
	
	@FindBy(xpath = "(//div[contains(@class,'k-multiselect-wrap k-floatwrap')])[12]")
	WebElement auditors; 
	
	@FindBy(xpath = "(//div[contains(@class,'k-multiselect-wrap k-floatwrap')])[14]")
	WebElement reviewers;
	
	@FindBy(xpath = "//label[@class='btn btn-success active toggle-off']")
	WebElement internalOrExternalSelectBtn;
	
	@FindBy(xpath = "(//label[@class='btn btn-default active toggle-off'][contains(.,'Off')])[1]")
	WebElement selfAuditBtn;
	
	@FindBy(xpath = "(//label[@class='btn btn-default active toggle-off'][contains(.,'Off')])[2]")
	WebElement offSiteAuditBtn;
	
	@FindBy(xpath = "(//label[@class='btn btn-default active toggle-off'][contains(.,'Off')])[3]")
	WebElement onSiteAuditBtn;
	
	@FindBy(xpath="//input[@id='btn-submit-audit']")
	WebElement createBtn;
	
	@FindBy(xpath="//input[@id='NormalizationMinimumValue']")
	WebElement minmumValue;
	
	@FindBy(xpath="//input[@id='NormalizationMaximumValue']")
	WebElement maximimValue;
	
	// Self Audit
	
	@FindBy(xpath="//input[@id='ProposedSelfAuditStartDate']")
	WebElement inp_SelfAuditStartDate;
	
	@FindBy(xpath="(//a[contains(text(),'21')])[1]")
	WebElement date_SelfAuditStartDate;
	
	@FindBy(xpath="//input[@id='ProposedSelfAuditEndDate']")
	WebElement inp_AuditEndDate;
	
	@FindBy(xpath="(//a[contains(text(),'28')])[1]")
	WebElement date_AuditEndDate;
	
	@FindBy(xpath="//input[@id='ProposedSelfSubmissionDate']")
	WebElement inp_SelfAuditSubmissionDate;
	
	@FindBy(xpath="(//a[contains(text(),'26')])[1]")
	WebElement date_SelfAuditSubmissionDate;
	
	@FindBy(xpath="//input[@id='ProposedSelfReviewStartDate']")
	WebElement inp_ReviewStartDate;
	
	@FindBy(xpath="(//a[contains(text(),'26')])[1]")
	WebElement date_ReviewStartDate;
	
	@FindBy(xpath="//input[@id='ProposedSelfReviewEndDate']")
	WebElement inp_ReviewEndDate;
	
	@FindBy(xpath="(//a[contains(text(),'27')])[1]")
	WebElement date_ReviewEndDate;
	
	//OffSite Audit
	
	@FindBy(xpath="//input[@id='ProposedOffsideAuditStartDate']")
	WebElement inp_OffSiteAuditStartDate;
	
	@FindBy(xpath="(//a[contains(text(),'26')])[1]")
	WebElement date_OffSiteAuditStartDate;
	
	@FindBy(xpath="//input[@id='ProposedOffsideAuditEndDate']")
	WebElement inp_OffSiteAuditSubmissionDate;
	
	@FindBy(xpath="(//a[contains(text(),'26')])[1]")
	WebElement date_OffSiteAuditSubmissionDate;
	
	//OnSite Audit
	
	@FindBy(xpath="//input[@id='ProposedOnsideAuditStartDate']")
	WebElement inp_OnSiteAuditStartDate;
	
	@FindBy(xpath="(//a[contains(text(),'26')])[1]")
	WebElement date_OnSiteAuditStartDate;
	
	@FindBy(xpath="//input[@id='ProposedOnsideAuditEndDate']")
	WebElement inp_OnSiteAuditSubmissionDate;
	
	@FindBy(xpath="(//a[contains(text(),'26')])[1]")
	WebElement date_OnSiteAuditSubmissionDate;
	
	
	//Actions
	
 	Actions act=new Actions(driver);
	
	public AuditCreatePage()
	{
		PageFactory.initElements(driver, this);
	}
	
	public String validateAuditCreatePageTitle()
	{
		return driver.getTitle();
	}
	
	public void auditCreate(String aType,String aReason,String aSupplier,String aName,String approvers) throws InterruptedException
	{
		Thread.sleep(1500);
		auditType.click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//li[contains(text(),'"+aType+"')]")).click();
		Thread.sleep(1000);
		auditReason.click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//li[contains(text(),'"+aReason+"')]")).click();
		Thread.sleep(1000);
		name.sendKeys(aName);
		Thread.sleep(1000);	
		supplier.click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//li[contains(text(),'"+aSupplier+"')]")).click();
		Thread.sleep(1000);
		supplierLocation.click();
		Thread.sleep(2100);
		driver.findElement(By.xpath("//li[contains(text(),'Bangalore ()')]")).click();
		Thread.sleep(1000);
		supplierCoordinator.click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//li[contains(text(),'Naveen Naveen (suppliernaveen)')]")).click();
		Thread.sleep(1000);
		coordinator.click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//li[contains(text(),'Norman Hemmings (admin)')]")).click();
		Thread.sleep(1000);
		act.moveToElement(auditors).click().perform();
		Thread.sleep(3000);
		driver.findElement(By.xpath("(//li[contains(text(),'"+approvers+"')])[2]")).click();
		Thread.sleep(1000);

	}
	
	public void internalAuditSelect(String tmpltName) throws InterruptedException
	{
     	act.moveToElement(template).click().perform();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//li[contains(text(),'"+tmpltName+"')]")).click();
		Thread.sleep(1000);
		minmumValue.sendKeys("1");
		Thread.sleep(500);
		maximimValue.sendKeys("8");
		Thread.sleep(500);
	}
	
	public void externalAuditSelect() throws InterruptedException
	{
		internalOrExternalSelectBtn.click();
		Thread.sleep(1000);
	}

	public void selfAudit(String aReviewers) throws InterruptedException
	{
		act.moveToElement(selfAuditBtn).click().perform();
		Thread.sleep(1000);
		reviewers.click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("(//li[contains(text(),'"+aReviewers+"')])[3]")).click();
		Thread.sleep(1000);
		inp_ReviewStartDate.click();
		Thread.sleep(1000);
		date_ReviewStartDate.click();
		Thread.sleep(1000);
		inp_ReviewEndDate.click();
		Thread.sleep(1000);
		date_ReviewEndDate.click();
		Thread.sleep(1000);
		inp_SelfAuditStartDate.click();
		Thread.sleep(1000);
		date_SelfAuditStartDate.click();
		Thread.sleep(1000);
		inp_SelfAuditSubmissionDate.click();
		Thread.sleep(1000);
		date_SelfAuditSubmissionDate.click();
		Thread.sleep(1500);
		act.moveToElement(createBtn).click().perform();
		Thread.sleep(1000);
	}
	
	public void offSiteAudit(String aReviewers) throws InterruptedException
	{
		act.moveToElement(offSiteAuditBtn).click().perform();
		Thread.sleep(1000);
		reviewers.click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("(//li[contains(text(),'"+aReviewers+"')])[3]")).click();
		Thread.sleep(1000);
		inp_ReviewStartDate.click();
		Thread.sleep(1000);
		date_ReviewStartDate.click();
		Thread.sleep(1000);
		inp_ReviewEndDate.click();
		Thread.sleep(1000);
		date_ReviewEndDate.click();
		Thread.sleep(1000);
		inp_OffSiteAuditStartDate.click();
		Thread.sleep(1000);
		date_OffSiteAuditStartDate.click();
		Thread.sleep(1000);
		inp_OffSiteAuditSubmissionDate.click();
		Thread.sleep(1000);
		date_OffSiteAuditSubmissionDate.click();
		Thread.sleep(1500);
		act.moveToElement(createBtn).click().perform();
		Thread.sleep(1000);
	}
	
	public void onSiteAudit(String aReviewers) throws InterruptedException
	{
		act.moveToElement(onSiteAuditBtn).click().perform();
		Thread.sleep(1000);
		reviewers.click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("(//li[contains(text(),'"+aReviewers+"')])[3]")).click();
		Thread.sleep(1000);
		inp_ReviewStartDate.click();
		Thread.sleep(1000);
		date_ReviewStartDate.click();
		Thread.sleep(1000);
		inp_ReviewEndDate.click();
		Thread.sleep(1000);
		date_ReviewEndDate.click();
		Thread.sleep(1000);
		inp_OnSiteAuditStartDate.click();
		Thread.sleep(1000);
		date_OnSiteAuditStartDate.click();
		Thread.sleep(1000);
		inp_OnSiteAuditSubmissionDate.click();
		Thread.sleep(1000);
		date_OnSiteAuditSubmissionDate.click();
		Thread.sleep(1500);
		act.moveToElement(createBtn).click().perform();
		Thread.sleep(1000);
	}

/*	public static int selectRandomProduct()
	{
	    // Find and click on a random product
	    List<WebElement> allProducts = driver.findElements(By.xpath("//label[@class='btn btn-default active toggle-off']"));
	    Random rand = new Random();
	    int randomProduct = rand.nextInt(allProducts.size());
        allProducts.get(randomProduct).click();
	    System.out.println(randomProduct);
		return randomProduct;
	}*/
}
