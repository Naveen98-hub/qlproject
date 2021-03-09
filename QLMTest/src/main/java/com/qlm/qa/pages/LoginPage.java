package com.qlm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qlm.qa.base.TestBase;

public class LoginPage extends TestBase
{
	//Page Factory 
	
	@FindBy(id="Email")
	WebElement username;
	
	@FindBy(id="Password")
	WebElement password;
	
	@FindBy(id="mainCaptcha")
	WebElement captchamain;
	
	@FindBy(id="txtInput") 
	WebElement captchainput;
	
	@FindBy(xpath="//img[@class='img-responsive login_imglogo']")
	WebElement logoimg;
	
	@FindBy(id="btn-login")
	WebElement signin;
	
	//Actions
	
	public LoginPage()
	{
		PageFactory.initElements(driver, this);
	}
	
	public String validateLoginPageTitle()
	{
		return driver.getTitle();
	}
	
	public boolean validateEmpowerLogo()
	{
		return logoimg.isDisplayed();
		
	}
	
	public void captcha()
	{
		String capt=captchamain.getText();
		System.out.println(capt);
		captchainput.sendKeys("1234");	
	
	}
	
	public HomePage login(String user, String pass) throws InterruptedException
	{
		username.sendKeys(user);
		password.sendKeys(pass);
		Thread.sleep(10000);
		signin.click();
		
		return new HomePage();
		
	}

}
