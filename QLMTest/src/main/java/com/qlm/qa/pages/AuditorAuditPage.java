package com.qlm.qa.pages;

import java.util.List;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qlm.qa.base.TestBase;

public class AuditorAuditPage extends TestBase
{
   // Page Factory
	
	@FindBy(xpath="//button[@id='modal-authoring-ok']")
	WebElement okBtn;
	
	@FindBy(xpath="//button[@id='modal-authoring-cancel']")
	WebElement cancelBtn;
	
	@FindBy(xpath="//input[@id='Submit_Auditor_Audit']")
	WebElement submitBtn;
	
	@FindBy(xpath = "//label[@class='btn btn-default active toggle-off'][contains(.,'No')]")
	WebElement responseVerifiedBtn;
	
	//Actions
	
	Actions act = new Actions(driver);
	
	public AuditorAuditPage()
	{
		PageFactory.initElements(driver, this);
	}
	
	public String validateAuditorAuditPageTitle()
	{
		return driver.getTitle();
	}
	
	public void auditorAuditResponseSubmit() throws InterruptedException
	{
	List<WebElement> actions = driver.findElements(By.xpath("//button[@class='btn btn-primary btn-sm dropdown-toggle']"));
	int esize=actions.size();
	for(int i=1;i<=esize;i++ )
	{
		Thread.sleep(1500);
		driver.findElement(By.xpath("(//button[@class='btn btn-primary btn-sm dropdown-toggle'])["+i+"]")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("(//span[contains(text(),' Response')])["+i+"]")).click();
		Thread.sleep(1500);
		driver.findElement(By.xpath("//button[@id='ratingControl']")).click();
		Thread.sleep(500);
		selectRandomProduct();
		Thread.sleep(1000);
		responseVerifiedBtn.click();
		Thread.sleep(1000);
		okBtn.click();
		Thread.sleep(1000);

	}
	act.moveToElement(submitBtn).click().perform();
	Thread.sleep(1000);
  }
	
	public static int selectRandomProduct()
	{
	    // Find and click on a random product
	    List<WebElement> allProducts = driver.findElements(By.xpath("//span[@class='badge label-success-highlighted']"));
	    Random rand = new Random();
	    int randomProduct = rand.nextInt(allProducts.size());
        allProducts.get(randomProduct).click();
	    System.out.println(randomProduct);
		return randomProduct;
	}
	
}
