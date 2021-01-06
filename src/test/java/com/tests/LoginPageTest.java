package com.tests;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.base.testbase;
import com.pages.LoginPage;

public class LoginPageTest extends testbase {
	WebDriver driver;
	@BeforeMethod
	public void initialize() throws IOException {
		driver=initialization();
		lp=new LoginPage();
	}
	@Test(priority=1)
	public void titlevalidation() throws IOException {
	Assert.assertTrue(lp.validatetitle(),"title is not correct");
	}
	@Test(priority=2)
	public void logintest() throws IOException {
		lp.login(utils.prop("username"),utils.prop("password")); 
		
	}
	
	@AfterMethod
	public void teardown() {
		driver.quit();
	} 
	

}
