package com.base;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import com.Utils.Constants;
import com.Utils.ElementUtils;
import com.listeners.webdriverfireevent;
import com.pages.HomePage;
import com.pages.LoginPage;
import com.pages.NewCustomerPage;

public class testbase {
	public HomePage hp;
	public LoginPage lp;
	public NewCustomerPage ncp;
	public static WebDriver driver;
	public ElementUtils utils=new ElementUtils(driver);
	public static EventFiringWebDriver e_driver;
    public static webdriverfireevent event=new webdriverfireevent();
	public WebDriver initialization() throws IOException {
	String browsername=utils.prop("browser");
	if(browsername.equals("chrome"))
	{
		System.setProperty("webdriver.chrome.driver",Constants.driverpath);
		driver=new ChromeDriver();
	}
	  e_driver=new EventFiringWebDriver(driver);
	  e_driver.register(event);
	  driver=e_driver;
	  driver.manage().window().maximize();
	  driver.manage().deleteAllCookies();
	  driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	  driver.get(utils.prop("url"));
	  return driver;
	  
}
}