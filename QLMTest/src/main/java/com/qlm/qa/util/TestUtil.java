package com.qlm.qa.util;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import com.qlm.qa.base.TestBase;



public class TestUtil extends TestBase
{

	public static long PAGE_LOAD_TIMEOUT=60;
	public static long IMPLICIT_WAIT=60;
	
	
	static Workbook book;
	static Sheet sheet;
	public static DataFormatter formatter= new DataFormatter();
	
	public static String TESTDATA_SHEET_PATH="C:\\Users\\nk4.RGBSIGTC\\git\\qlproject\\QLMTest\\src\\"
			+ "main\\java\\com\\qlm\\qa\\testdata\\QLMTestData.xlsx";
	
	
	public static Object[][] getTestData(String sheetName)
	{
		FileInputStream file=null;
		try
		{
			file=new FileInputStream(TESTDATA_SHEET_PATH);
		}
		catch(FileNotFoundException e)
		{
			e.printStackTrace();
		}
		try
		{
			book=WorkbookFactory.create(file);
		}
		catch(InvalidFormatException e)
		{
			e.printStackTrace();
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}
		sheet = book.getSheet(sheetName);
		Object[][] data=new Object[sheet.getLastRowNum()][sheet.getRow(0).getLastCellNum()];
		for(int i=0;i<sheet.getLastRowNum();i++)
		{
			for(int j=0;j<sheet.getRow(0).getLastCellNum();j++)
			{
				data[i][j]=sheet.getRow(i+1).getCell(j).toString();
			}
				
		}
		return data;

	}	
	
	
	public static void fileUpload(WebElement fileUpload) throws InterruptedException, AWTException
	{ 
		fileUpload.click();
		//put path to your image in a clipboard
		StringSelection ss = new StringSelection("C:\\Users\\nk4.RGBSIGTC\\Documents\\sample.txt");
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(ss, null);
		
		//imitate KeyBoard/mouse events like ENTER, CTRL+C, CTRL+V
		Robot robot = new Robot();
		robot.delay(250);
		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);
		robot.keyPress(KeyEvent.VK_CONTROL);
		robot.keyPress(KeyEvent.VK_V);
		robot.keyRelease(KeyEvent.VK_V);
		robot.keyRelease(KeyEvent.VK_CONTROL);
		robot.keyPress(KeyEvent.VK_ENTER);
		robot.delay(50);
		robot.keyRelease(KeyEvent.VK_ENTER);
		
		System.out.println("File Uploaded");
	}
	
	public static void moveAction(WebElement element)
	 {

		 Actions action = new Actions(driver);

       action.moveToElement(element).click().perform();
	
	 }

    public static void failed(String testMethodName)
    {
    	File srcFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
    	try {
			FileUtils.copyFile(srcFile, new File("C:/Users/nk4.RGBSIGTC/git/qlproject/QLMTest/screenshots/"+testMethodName+"_"+".jpg"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
	
	
	
}
