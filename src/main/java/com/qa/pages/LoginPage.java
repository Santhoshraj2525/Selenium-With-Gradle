package com.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.basetest.BaseTest;

public class LoginPage extends BaseTest {
	
	@FindBy(xpath="//input[@name='email']")
	WebElement edtEmailAddress;
	@FindBy(xpath="//input[@name='password']")
	WebElement edtPassword;
	@FindBy(xpath="//div[@class='ui fluid large blue submit button']")
	WebElement btnLogin;
	@FindBy(xpath="//a[contains(text(),'Forgot your password?')]")
	WebElement lnkForgot;
	
	public LoginPage() throws Exception {
		PageFactory.initElements(driver, this);
	}
	
	public String loginTitle() {
		return driver.getTitle();
	}
	
	public HomePage loginCrm() throws Exception {
		edtEmailAddress.sendKeys(prop.getProperty("userName"));
		edtPassword.sendKeys(prop.getProperty("Password"));
		btnLogin.click();
		return new HomePage();		
	}

}
