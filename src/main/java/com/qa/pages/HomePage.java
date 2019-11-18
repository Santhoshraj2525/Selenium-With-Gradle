package com.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.basetest.BaseTest;

public class HomePage extends BaseTest{
	
	@FindBy(xpath="//span[@class='user-display']")
	WebElement userID;
	@FindBy(xpath="//span[text()='Contacts']")
	WebElement contactsLink;
	
	
	public HomePage() throws Exception {
		PageFactory.initElements(driver, this);
	}

	public String verifyUserID() {
		return userID.getText();		
	}
	
	public ContactsPage clickContacts() throws Exception {
		contactsLink.click();
		return new ContactsPage();
	}
}
