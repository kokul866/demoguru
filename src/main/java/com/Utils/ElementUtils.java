package com.Utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class ElementUtils {
	public WebDriver driver;
	public ElementUtils(WebDriver driver) {
		this.driver=driver;
	}public ElementUtils() {
		// TODO Auto-generated constructor stub
	}
	public static String prop(String value) throws IOException {
		Properties p=new Properties();
		FileInputStream file=new FileInputStream(Constants.configpath);
		p.load(file);
		String val=p.getProperty(value);
		return val;
	}
	
	
	
	
	
	public void dosendkeys(WebElement element,String value) {
		element.sendKeys(value);
		
	}
	
	public void doclick(WebElement element) {
		element.click();
	}
	
	public void dodropdownbyindex(WebElement element,int num)
	{
		Select s=new Select(element);
		s.selectByIndex(num);
	}
	
	public void dodropdownbyvisibletext(WebElement element,String text)
	{
		Select s=new Select(element);
		s.selectByVisibleText(text);
	}
	
	public void domovetoelement(WebElement element)
	{
		Actions a=new Actions(driver);
		a.moveToElement(element).build().perform();
	}
	
	public String getscreenshot(String testcasename,WebDriver driver) throws IOException {
		File src=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		String dest=Constants.projectpath+"//screenshots//"+testcasename+".png";
		FileUtils.copyFile(src,new File(dest));
		return dest;
		
	}
	
	public Object[][] gettestdata(String sheetname) throws IOException {
		FileInputStream file=new FileInputStream(Constants.testdatapath);
		XSSFWorkbook book=new XSSFWorkbook(file);
		XSSFSheet sheet=book.getSheet(sheetname);
		Object[][] data=new String[sheet.getLastRowNum()][sheet.getRow(1).getLastCellNum()];
		for(int i=0;i<sheet.getLastRowNum();i++)
		{
			for(int j=0;j<sheet.getRow(1).getLastCellNum();j++)
			{
				data[i][j]=sheet.getRow(i+1).getCell(j).toString();
			}
		}
		return data;
		
	}

	

}
