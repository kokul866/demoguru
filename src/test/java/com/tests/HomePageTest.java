package com.tests;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.base.testbase;
import com.pages.LoginPage;

public class HomePageTest extends testbase{
	public WebDriver driver;
	@BeforeMethod
	public void initialize() throws IOException {
		driver=initialization();
		lp=new LoginPage();
		hp=lp.login(utils.prop("username"),utils.prop("password"));
	}
	
    @Test
    public void manageridcheck() throws IOException {
          Assert.assertEquals(hp.getmanagerid(),"Manger Id : mngr296110","managerid is not correct");
    }
    
    @Test
    public void newcustomer() {
    	hp.getnewcustomer();
    }
    
    @AfterMethod
	public void teardown() {
		driver.quit();
	} 
	
}
