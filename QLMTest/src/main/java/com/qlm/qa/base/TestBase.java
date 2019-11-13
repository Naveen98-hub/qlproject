package com.qlm.qa.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.qlm.qa.util.TestUtil;

public class TestBase 
{
	 public static WebDriver driver;  
	 public static Properties prop;
	 
	 
	   public TestBase()
	   {	   
		   try
		   {
		       prop =new Properties();
		       FileInputStream ip= new FileInputStream("C:\\Users\\nk4.RGBSIGTC\\git\\qlproject\\QLMTest\\src\\main\\java"
		       		+ "\\com\\qlm\\qa\\config\\config.properties");
		   
		       prop.load(ip);
		   
	       }
		   catch (FileNotFoundException e) {
			e.printStackTrace();
		   }
		   
		   catch (IOException e){
			  e.printStackTrace();
	    	}
		   
	   }
	   
	   public static void initialize()
	   {
		   
		   String browsername=prop.getProperty("browser");
		   
		   if(browsername.equals("chrome"))
		   {
			   System.setProperty("webdriver.chrome.driver", "D:\\EclipseNew\\Browser\\chromedriver.exe");
			   driver = new ChromeDriver();
		   }
		   
		   driver.manage().window().maximize();
		   driver.manage().deleteAllCookies();
		   driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
		   driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
		   
		   driver.get(prop.getProperty("url"));
		   
	   }
	
}
