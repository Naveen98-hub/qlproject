package com.qlm.qa.pages;

import java.awt.AWTException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qlm.qa.base.TestBase;
import com.qlm.qa.util.TestUtil;

public class EightDisciplineAmendPage extends TestBase
{
	//Page Factory
	
	
	//D1
	
	@FindBy(xpath="//input[@id='txt-cpc-name-line-1']")
	WebElement cpcName;
	
	@FindBy(xpath="//input[@id='txt-cpc-title-line-1']")
	WebElement cpctitle;
	
	@FindBy(xpath="//input[@id='txt-cpc-email-line-1']")
	WebElement cpcEmail;
	
	@FindBy(xpath="//input[@id='txt-cpc-phone-line-1']")
	WebElement cpcPhoneNUmber;
	
	@FindBy(xpath="//input[@id='txt-stc-name-line-1']")
	WebElement supTeamChampName;
	
	@FindBy(xpath="//input[@id='txt-stc-title-line-1']")
	WebElement supTeamChampTitle;
	
	@FindBy(xpath="//input[@id='txt-stc-email-line-1']")
	WebElement supTeamChampEmail;
	
	@FindBy(xpath="//input[@id='txt-stc-phone-line-1']")
	WebElement supTeamChampPhoneNumber;
	
	@FindBy(xpath="//input[@id='txt-stm-name-line-1']")
	WebElement supTeamAddlnMemberName;
	
	@FindBy(xpath="//input[@id='txt-stm-title-line-1']")
	WebElement supTeamAddlnMemberTitle;
	
	@FindBy(xpath="//input[@id='txt-stm-email-line-1']")
	WebElement supTeamAddlnMemberEmail;
	
	@FindBy(xpath="//input[@id='txt-stm-phone-line-1']")
	WebElement supTeamAddlnMemberPhoneNumber;

	@FindBy(xpath="//form[@id='dropzone-d1-documents']")	
	WebElement fileUploadD1;
		
	@FindBy(xpath = "//button[@id='btn-update-eight-discipline-step']")
	WebElement saveBtn;
	
	@FindBy(xpath="//button[@id='btn-eight-discipline-next-step']")
	WebElement nextBtn;
	
	@FindBy(xpath = "(//span[@aria-hidden='true'][contains(.,'×')])[1]")
	WebElement closePopUp;
	
	//D2
	
	@FindBy(xpath="//div[@id='cke_ImpactonCustomer']")
	WebElement iocTextArea;
	
	@FindBy(xpath="//form[@id='dropzoneProblemDescriptionPicture']")
	WebElement fileUploadD2;
	
	//D3 Supplier
	
    @FindBy(xpath="//form[@id='dropzone-d3-documents']")
    WebElement fileUploadD3;
		
    @FindBy(xpath = "//button[@id='btn-submit-eight-discipline-step']")
    WebElement submitStep;
    
    @FindBy(xpath = "//input[@id='btnSign']")
    WebElement signBtn;
    
    @FindBy(xpath = "//button[@id='modal-authoring-ok']")
    WebElement submitAuthStep;
    //Customer
    @FindBy(xpath = "//button[@id='btn-accept-eight-discipline-step']")
    WebElement D3CustmrAcceptBtn;
    
    @FindBy(xpath = "//button[@id='btn-reject-eight-discipline-step']")
    WebElement D3CustmrRejectBtn;
    
    //D4 Supplier
    
    @FindBy(xpath="//a[@id='step-3127_anchor']")
    WebElement analysisAnchor;
    
    @FindBy(xpath = "//a[contains(.,'Add Cause')]")
    WebElement addCauseBtn;
    
    @FindBy(xpath="//input[@id='form-field-name']")
    WebElement causeName;
    
    @FindBy(xpath = "//button[@id='modal-confirmation-ok']")
    WebElement causeSaveBtn;
    
    @FindBy(xpath = "//button[@id='modal-confirmation-cancel']")
    WebElement causeCancelBtn;
    
    @FindBy(xpath="//ul[@class='jstree-children']/li/a")
    WebElement selectCause;
    
    @FindBy(xpath = "//a[contains(.,'Add as Root Cause?')]")
    WebElement addAsRootCause;
    
	//D5
    
    @FindBy(xpath="//textarea[@id='action_Action']")
    WebElement txtSelectVerificationAction;
    
    @FindBy(xpath = "//div[@class='k-widget k-multiselect k-header form-control k-state-hover']"
                    +"[contains(.,'TestCauseSelect Root Cause...')]")
    WebElement drpdnRootCause;
    
    @FindBy(xpath="//input[@id='target-date-1']")
    WebElement txtTargetDate;
    
    @FindBy(xpath="(//a[contains(text(),'27')])[1]")
    WebElement dateTargetDate;
    
    @FindBy(xpath = "(//div[contains(@class,'k-multiselect-wrap k-floatwrap')])[2]")
    WebElement drpdnResponsibility;
    
    @FindBy(xpath = "//h3[contains(.,'Naveen Naveen')]")
    WebElement responsibilityUser;
    
    @FindBy(xpath = "//textarea[contains(@id,'action_PermanetCorrectiveAction')]")
    WebElement permanentCorrectiveAction;
    
    
    
    
	//Actions
	
	Actions act = new Actions(driver);
	
	public EightDisciplineAmendPage()
	{
		PageFactory.initElements(driver, this);
	}
	
	public String eightDisciplineAmendPageTitle()
	{
		return driver.getTitle();
	}
	
	public void d1d2d3SupplierSubmit(String tcpcName,String tcpctitle,String tcpcEmail,String tcpcPhoneNumber,String tsupTeamChampName,String tsupTeamChampTitle
			                 ,String tsupTeamChampEmail,String tsupTeamChampPhoneNumber,String tsupTeamAddlnMemberName,String tsupTeamAddlnMemberTitle,
			                  String tsupTeamAddlnMemberEmail,String tsupTeamAddlnMemberPhoneNumber) throws InterruptedException, AWTException
	{
		String tecpcPhoneNumber = tcpcPhoneNumber.substring(0, tcpcPhoneNumber.indexOf('.'));
		String tesupTeamChampPhoneNumber = tsupTeamChampPhoneNumber.substring(0, tsupTeamChampPhoneNumber.indexOf('.'));
		String tesupTeamAddlnMemberPhoneNumber = tsupTeamAddlnMemberPhoneNumber.substring(0, tsupTeamAddlnMemberPhoneNumber.indexOf('.'));
		Thread.sleep(1000);
		cpcName.sendKeys(tcpcName);
		Thread.sleep(1000);
		cpctitle.sendKeys(tcpctitle);
		Thread.sleep(1000);
		cpcEmail.sendKeys(tcpcEmail);
		Thread.sleep(1000);
		cpcPhoneNUmber.sendKeys(tecpcPhoneNumber);
		Thread.sleep(1000);
		supTeamChampName.sendKeys(tsupTeamChampName);
		Thread.sleep(1000);
		supTeamChampTitle.sendKeys(tsupTeamChampTitle);
		Thread.sleep(1000);
		supTeamChampEmail.sendKeys(tsupTeamChampEmail);
		Thread.sleep(1000);
		supTeamChampPhoneNumber.sendKeys(tesupTeamChampPhoneNumber);
		Thread.sleep(1000);
		supTeamAddlnMemberName.sendKeys(tsupTeamAddlnMemberName);
		Thread.sleep(1000);
		supTeamAddlnMemberTitle.sendKeys(tsupTeamAddlnMemberTitle);
		Thread.sleep(1000);
		supTeamAddlnMemberEmail.sendKeys(tsupTeamAddlnMemberEmail);
		Thread.sleep(1000);
		supTeamAddlnMemberPhoneNumber.sendKeys(tesupTeamAddlnMemberPhoneNumber );
		Thread.sleep(1000);
		//TestUtil.fileUpload(fileUploadD1);
		Thread.sleep(1000);
		saveBtn.click();
		Thread.sleep(1500);
		closePopUp.click();
		Thread.sleep(1900);
		nextBtn.click();
		Thread.sleep(1000);
		
		//D2
		
		Thread.sleep(500);
		act.moveToElement(iocTextArea).perform();
		//iocTextArea.sendKeys("Test");
		Thread.sleep(1000);
		//TestUtil.fileUpload(fileUploadD2);
		Thread.sleep(1000);
		saveBtn.click();
		Thread.sleep(1500);
		closePopUp.click();
		Thread.sleep(1900);
		nextBtn.click();
		Thread.sleep(1000);
		
	    //D3
			
		for(int i=1;i<=7;i++)
		{
			Thread.sleep(1500);
			WebElement respUser=driver.findElement(By.xpath("(//div[contains(@class,'k-multiselect-wrap k-floatwrap')])["+i+"]"));
			act.moveToElement(respUser).click().perform();
			Thread.sleep(3000);
			driver.findElement(By.xpath("(//h3[contains(text(),'Naveen Naveen')])["+i+"]")).click();
			Thread.sleep(1000);
			WebElement cdChkQty = driver.findElement(By.xpath("(//input[@id='containment_CheckedQuantity'])["+i+"]"));
			cdChkQty.clear();
			cdChkQty.sendKeys("10");
			Thread.sleep(1000);
			WebElement cdOkQty = driver.findElement(By.xpath("(//input[@id='containment_OkQuantity'])["+i+"]"));
			cdOkQty.clear();
			cdOkQty.sendKeys("7");
			Thread.sleep(1000);
			WebElement cdNotOkQty = driver.findElement(By.xpath("(//input[@id='containment_NotOkQuantity'])["+i+"]"));
			cdNotOkQty.clear();
			cdNotOkQty.sendKeys("3");
			WebElement cdDueDate1 = driver.findElement(By.xpath("(//input[@id='target-date-"+i+"'])"));
			cdDueDate1.click();
			Thread.sleep(1000);
			driver.findElement(By.xpath("(//a[contains(text(),'27')])[1]")).click();
			Thread.sleep(1000);
			driver.findElement(By.xpath("(//textarea[@id='containment_Results'])["+i+"]")).sendKeys("Test");
			Thread.sleep(1000);
		}
		
		//TestUtil.fileUpload(fileUploadD3);
		Thread.sleep(1000);
		act.moveToElement(saveBtn).click().perform();
		Thread.sleep(1900);
		closePopUp.click();
		Thread.sleep(1900);
		submitStep.click();
		Thread.sleep(2500);
		signBtn.click();
		Thread.sleep(1000);
		submitAuthStep.click();
		Thread.sleep(1500);
		
	}
		
	public void custmrAcceptorRejectStep() throws InterruptedException
	{
		Thread.sleep(1000);
        act.moveToElement(D3CustmrAcceptBtn).click().perform();
		Thread.sleep(2500);
		signBtn.click();
		Thread.sleep(1000);
		submitAuthStep.click();
	}
	
	public void D4SupplierSubmit() throws InterruptedException
	{
		Thread.sleep(1000);
		act.contextClick(analysisAnchor).perform();
		Thread.sleep(1500);
		addCauseBtn.click();
		Thread.sleep(1000);
		causeName.sendKeys("TestCause");
		Thread.sleep(1000);
		causeSaveBtn.click();
		Thread.sleep(2500);
		act.contextClick(selectCause).perform();
		Thread.sleep(1500);
		addAsRootCause.click();
		Thread.sleep(1500);
		act.moveToElement(saveBtn).click().perform();
		Thread.sleep(1900);
		closePopUp.click();
		Thread.sleep(1900);
		submitStep.click();
		Thread.sleep(3100);
		signBtn.click();
		Thread.sleep(1000);
		submitAuthStep.click();
		Thread.sleep(1500);
	}
	
	public void D5SupplierSubmit() throws InterruptedException
	{
		Thread.sleep(1000);
		txtSelectVerificationAction.sendKeys("Test");
		Thread.sleep(1000);
		
		
		
	}
	
}
