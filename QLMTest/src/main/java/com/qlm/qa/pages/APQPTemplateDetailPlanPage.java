package com.qlm.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qlm.qa.base.TestBase;

public class APQPTemplateDetailPlanPage extends TestBase
{
	//Page Factory
	
	   //Phase
	@FindBy(xpath="//button[@id='btn-phase-new']")
	WebElement addPhase;
	
	@FindBy(xpath="//input[@id='control-title']")
	WebElement titleOrName;
	
	@FindBy(xpath="//input[@id='SequenceNumber']")
	WebElement SequesnceNo;
	
	@FindBy(xpath="//button[@id='modal-authoring-ok']")
	WebElement commonSubmitForAll;
	
	@FindBy(xpath="//button[@id='modal-authoring-cancel']")
	WebElement commonCancelForAll;

	  // PreRequisites
	@FindBy(xpath="//button[@id='btn-prerequisite-action']")
	WebElement preRequisitesAction;
	
	@FindBy(xpath = "//button[@type='button'][contains(.,'Add Prerequisite Element')]")
	WebElement addPreRequisiteElement;

	  //PreReqActivity
	@FindBy(xpath = "//button[contains(@class,'btn btn-sm btn-link btn-prerequisite-activity-new')]")
	WebElement addPreReqActivity;

	@FindBy(xpath = "//label[@class='btn btn-default active toggle-off'][contains(.,'No')]")
	WebElement onButton;
	
	@FindBy(xpath="//input[@id='new-requirement-name']")
	WebElement newRequirementsName;
	
	@FindBy(xpath = "//input[contains(@class,'k-input k-readonly')]")
	WebElement preRequisiteRole;
	
       //TaskElements/Activities
	@FindBy(xpath="//button[@id='btn-element-action']")
	WebElement elementAction;
	
	@FindBy(xpath = "//button[@type='button'][contains(.,'Add Task Element')]")
	WebElement addTaskElement;
	
	   //AddTaskActivity
	@FindBy(xpath = "(//span[contains(@class,'glyphicon glyphicon-plus text-primary')])[2]")
	WebElement addActivity;
	
	@FindBy(xpath = "//input[contains(@aria-owns,'selectLeadResponsibility_taglist selectLeadResponsibility_listbox')]")
	WebElement leadRoles;
	
	@FindBy(xpath = "//input[contains(@aria-owns,'selectTeamResponsibility_taglist selectTeamResponsibility_listbox')]")
	WebElement teamRoles;
	
	@FindBy(xpath = "(//label[@class='btn btn-default active toggle-off'][contains(.,'No')])[3]")
	WebElement docSubmissionReq;
	
	   //Milestone
	@FindBy(xpath="//button[@id='btn-milestone-action']")
	WebElement milestoneGateAction;
	
	@FindBy(xpath = "//button[@type='button'][contains(.,'Add Gate Reviews')]")
	WebElement addGateReviews;

	@FindBy(xpath = "//div[contains(@class,'k-multiselect-wrap k-floatwrap')]")
	WebElement gateReviewAuthRole;
	
	   //BOMRoles
	@FindBy(xpath = "//a[contains(@aria-controls,'tab-content-bom-role')]")
	WebElement bomRolestab;
	
	@FindBy(xpath = "(//div[contains(@class,'k-multiselect-wrap k-floatwrap')])[2]")
	WebElement engineeringRole;
	
	@FindBy(xpath = "(//div[contains(@class,'k-multiselect-wrap k-floatwrap')])[3]")
	WebElement purchasingRole;
	
	@FindBy(xpath="//button[@id='btn-bom-role-update']")
	WebElement updateBOMRolesButton;
	
	//Actions
	
	Actions act= new Actions(driver);
	
	public APQPTemplateDetailPlanPage()
	{
		PageFactory.initElements(driver, this);
	}
	
	public String validateAPQPTemplateDetailPlanPageTitle()
	{
		return driver.getTitle();
	}

	public void createPhase(String pTitle,String pSequence) throws InterruptedException
	{
		String tpSequence = pSequence.substring(0, pSequence.indexOf('.'));
		addPhase.click();
		Thread.sleep(1500);
		titleOrName.sendKeys(pTitle);
		Thread.sleep(500);
		SequesnceNo.sendKeys(tpSequence);
		Thread.sleep(500);
		commonSubmitForAll.click();
		Thread.sleep(1000);
	}

	public void createPrerequisities(String preElem,String preSequence,String phaseNo) throws InterruptedException
	{   
		Thread.sleep(1000);
		driver.findElement(By.xpath("//a/b[contains(text(),'"+phaseNo+"')]")).click();
		String tpreSequence = preSequence.substring(0, preSequence.indexOf('.'));
		Thread.sleep(2100);
		preRequisitesAction.click();
		Thread.sleep(1000);
		addPreRequisiteElement.click();
		Thread.sleep(1500);
		titleOrName.sendKeys(preElem);
		Thread.sleep(1000);
		SequesnceNo.sendKeys(tpreSequence);
		Thread.sleep(500);
		commonSubmitForAll.click();
		Thread.sleep(1000);
	}
	
	public void createPreReqActivity(String preReqActName,String preReqSeqNo,String PreReqRole) throws InterruptedException
	{
		String tpreReqSeqNo = preReqSeqNo.substring(0, preReqSeqNo.indexOf('.'));
		Thread.sleep(1000);
		addPreReqActivity.click();
		Thread.sleep(1000);
		titleOrName.sendKeys(preReqActName);
		Thread.sleep(1000);
		SequesnceNo.sendKeys(tpreReqSeqNo);
		Thread.sleep(500);
		preRequisiteRole.click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//li[@tabindex='-1'][contains(.,'"+PreReqRole+"')]")).click();
		Thread.sleep(1000);
		commonSubmitForAll.click();
		Thread.sleep(1000);
	}
	
	public void createTaskElement(String taskElement,String tSeqNo) throws InterruptedException
	{
		String taskSeqNo = tSeqNo.substring(0, tSeqNo.indexOf('.'));
		Thread.sleep(1000);
		elementAction.click();
		Thread.sleep(500);
		addTaskElement.click();
		Thread.sleep(1000);
		titleOrName.sendKeys(taskElement );
		Thread.sleep(500);
		SequesnceNo.sendKeys(taskSeqNo);
		Thread.sleep(500);
		commonSubmitForAll.click();
		Thread.sleep(1000);
	}
	
	public void createTaskActivity(String tActivity,String tSequence,String leadRole,String teamRole) throws InterruptedException
	{
		String taskSequence = tSequence.substring(0, tSequence.indexOf('.'));
		Thread.sleep(1000);	
		addActivity.click();
		Thread.sleep(1000);	
		titleOrName.sendKeys(tActivity);
		SequesnceNo.sendKeys(taskSequence);
		leadRoles.click();
		Thread.sleep(3000);	
		driver.findElement(By.xpath("(//li[contains(text(),'"+leadRole+"')])[2]")).click();
		Thread.sleep(1000);	
		teamRoles.click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("(//li[contains(text(),'"+teamRole+"')])[3]")).click();
		Thread.sleep(500);
		commonSubmitForAll.click();
		Thread.sleep(1000);
	}
	
	public void createMilestoneGateReview(String mileStName,String mileStSeq) throws InterruptedException
	{
		String tmileStSeq = mileStSeq.substring(0, mileStSeq.indexOf('.'));
		Thread.sleep(1000);	
		act.moveToElement(milestoneGateAction).click().perform();
		Thread.sleep(1000);	
		addGateReviews.click();
		Thread.sleep(1000);	
		titleOrName.sendKeys(mileStName);
		SequesnceNo.sendKeys(tmileStSeq);
		Thread.sleep(500);
		commonSubmitForAll.click();
		Thread.sleep(1000);
	}
	
	public void editMilestoneGateReview(String mileStAuthRole,String eNo) throws InterruptedException
	{
		Thread.sleep(1000);
		WebElement editGatReview= driver.findElement(By.xpath("(//span[contains(@class,'glyphicon glyphicon-pencil text-warning')])["+eNo+"]"));
		act.moveToElement(editGatReview).click().perform();
		Thread.sleep(3000);
		gateReviewAuthRole.click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("(//li[contains(text(),'"+mileStAuthRole+"')])[4]")).click();
		Thread.sleep(500);
		commonSubmitForAll.click();
		Thread.sleep(1000);
	}
	
	public void addBOMRoles(String engRole,String purchRole ) throws InterruptedException
	{
		Thread.sleep(1000);
		bomRolestab.click();
		Thread.sleep(3000);
		engineeringRole.click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("(//li[contains(text(),'"+engRole+"')])[1]")).click();
		Thread.sleep(1000);
		purchasingRole.click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("(//li[contains(text(),'"+purchRole+"')])[2]")).click();
		Thread.sleep(1000);
		updateBOMRolesButton.click();
		Thread.sleep(1000);
	}
}
