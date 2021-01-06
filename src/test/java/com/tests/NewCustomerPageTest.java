package com.tests;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.base.testbase;
import com.pages.LoginPage;

public class NewCustomerPageTest extends testbase{
	WebDriver driver;
	@BeforeMethod
	public void initialize() throws IOException {
		driver=initialization();
		lp=new LoginPage();
		hp=lp.login(utils.prop("username"),utils.prop("password"));
		ncp=hp.getnewcustomer();
	}
	@Test(priority=1)
	public void headercheck() {
		Assert.assertTrue(ncp.checkheader(),"NOT DISPLAYED");
	}
	
	@Test(priority=2)
	public void radiobtncheck() {
		Assert.assertTrue(ncp.checkrbtnclicked());
	}
	
	@Test(priority=3,dataProvider="testdata")
	public void addnewcustomercheck(String name,String birth,String adress,String cityname,String statename,String pin,String mob,String email,String pwd) 
	{
		
		ncp.addnewcustomer(name, birth, adress, cityname, statename, pin, mob, email, pwd);
		System.out.println("customer added");
	}
	
	
	@DataProvider(name="testdata")
	public Object[][] data() throws IOException {
	  Object[][] data=utils.gettestdata("Sheet1");
	  return data;
		
	}
	
	@AfterMethod
	public void teardown() {
		driver.quit();
	}

}
