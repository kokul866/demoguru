package com.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.base.testbase;

public class HomePage extends testbase {
	
	public HomePage() {
		PageFactory.initElements(driver,this);
	}
	
	@FindBy(xpath="//td[contains(text(),'Manger Id : mngr296110')]") WebElement managerid;
	@FindBy(xpath="//a[contains(text(),'New Customer')]") WebElement newcustomer;
	@FindBy(xpath="//a[contains(text(),'Edit Customer')]") WebElement editcustomer;
    @FindBy(xpath="//a[contains(text(),'Delete Customer')]") WebElement deletecustomer;
    @FindBy(xpath="//a[contains(text(),'New Account')]") WebElement newaccount;
    @FindBy(xpath="//a[contains(text(),'Edit Account')]") WebElement editaccount;
    @FindBy(xpath="//a[contains(text(),'Delete Account')]") WebElement deleteaccount;
    
    public NewCustomerPage getnewcustomer() {
    	utils.doclick(newcustomer);
    	return new NewCustomerPage();
    }
    
    public EditCustomerpage EditCustomerPage() {
    	utils.doclick(editcustomer);
    	return new EditCustomerpage();
    }
    
    public DeleteCustomerPage deletecustomerpage() {
    	utils.doclick(editcustomer);
    	return new DeleteCustomerPage();
    }
    
    public String getmanagerid() {
    	return managerid.getText();
    }
}
