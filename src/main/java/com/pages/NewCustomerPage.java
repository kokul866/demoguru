package com.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.base.testbase;

public class NewCustomerPage extends testbase {

	public NewCustomerPage() {
		PageFactory.initElements(driver,this);
	}
	@FindBy(xpath="//p[contains(text(),'Add New Customer')]") WebElement addnewcustomertitle;
	@FindBy(xpath="//input[@name='name']") WebElement customername;
	@FindBy(xpath="(//input[@type='radio'])[1]") WebElement maleradiobtn;
	@FindBy(xpath="//input[@name='dob']") WebElement dob;
	@FindBy(xpath="//textarea[@name='addr']") WebElement address;
	@FindBy(xpath="//input[@name='city']") WebElement city;
	@FindBy(xpath="//input[@name='state']") WebElement state;
	@FindBy(xpath="//input[@name='pinno']") WebElement pinno;
	@FindBy(xpath="//input[@name='telephoneno']") WebElement mobno;
	@FindBy(xpath="//input[@name='emailid']") WebElement emailid;
	@FindBy(xpath="//input[@name='password']") WebElement password;
	@FindBy(xpath="//input[@value='Submit']") WebElement submit;
	
	public boolean checkheader() {
		return addnewcustomertitle.isDisplayed();
	}
	
	public boolean checkrbtnclicked() {
		return maleradiobtn.isSelected();
	}
	
	public void addnewcustomer(String name,String birth,String adress,String cityname,String statename,String pin,String mob,String email,String pwd) {
		utils.dosendkeys(customername, name);
		utils.dosendkeys(dob, birth);
		utils.dosendkeys(address, adress);
		utils.dosendkeys(city, cityname);
		utils.dosendkeys(state, statename);
		utils.dosendkeys(pinno,pin);
		utils.dosendkeys(mobno,mob);
		utils.dosendkeys(emailid,email);
		utils.dosendkeys(password, pwd);
		utils.doclick(submit);
	}
}
