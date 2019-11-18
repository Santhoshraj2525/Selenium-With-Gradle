package com.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.qa.basetest.BaseTest;

public class EntryPage extends BaseTest {
	@FindBy(xpath="(//li/a[text()='Sign Up']/preceding::a[@class='brand-name'])[1]")
	WebElement imgFreeCrmLogo;
	@FindBy(xpath="//span[text()='Log In']")
	WebElement btnLogIn;
	@FindBy(xpath="//span[text()=' sign up']")
	WebElement btnSignUp;
	@FindBy(xpath="//input[@name='email']")
	WebElement txtEmail;
	
	public EntryPage() throws Exception {
		PageFactory.initElements(driver, this);
	}
	
	public String validateLoginTitle() {
		return driver.getTitle();		
	}
	
	public boolean loginButtonValidaion() {
		return btnLogIn.isDisplayed();
	}
	
	public LoginPage clickLoginButton() throws Exception {
		btnLogIn.click();
		Thread.sleep(10000);
		return new LoginPage();
	}
	
	public void clickSignUpButton() {
		btnSignUp.click();
		WebDriverWait wait = new WebDriverWait(driver, 25);
		wait.until(ExpectedConditions.elementToBeClickable(txtEmail));
	}
}
