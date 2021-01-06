package com.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.base.testbase;

public class LoginPage extends testbase{
	
	public LoginPage() {
		PageFactory.initElements(driver,this);
	}
	
	@FindBy(xpath="//input[@name='uid']") WebElement username;
	@FindBy(xpath="//input[@name='password']") WebElement password;
	@FindBy(xpath="//input[@name='btnLogin']") WebElement login;
	@FindBy(xpath="//input[@name='btnReset']") WebElement reset;
	@FindBy(xpath="//h2[contains(text(),'Guru99 Bank')]") WebElement title;
	
	public boolean validatetitle() {
		return title.isDisplayed();
	}
	
	public HomePage login(String un,String pwd) {
		utils.dosendkeys(username,un);
		utils.dosendkeys(password, pwd);
		utils.doclick(login);
		return new HomePage();
	}

}
