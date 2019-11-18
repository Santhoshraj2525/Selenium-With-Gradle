package com.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.basetest.BaseTest;

public class ContactsPage extends BaseTest {
	@FindBy(xpath="//div[@id='dashboard-toolbar']/div[text()='Contacts']")
	WebElement ContactsHeader;
	@FindBy(xpath="//button[text()='New']")
	WebElement btnNew;
	@FindBy(xpath="//input[@name='first_name']")
	WebElement txtFirstName;
	@FindBy(xpath="//input[@name='last_name']")
	WebElement txtLastName;
	@FindBy(xpath="(//label[text()='Email']/following::input[@name='value'])[1]")
	WebElement txtEmail;
	@FindBy(xpath="//textarea[@name='description']")
	WebElement txtDescription;
	@FindBy(xpath="//button[text()='Save']")
	WebElement btnSave;
	@FindBy(xpath="//label[text()='Access']/following::button[contains(text(),'Public')]")
	WebElement btnAccess;
	@FindBy(xpath="//div[text()='Select users allowed access']")
	WebElement drpUserAccess;
	
	//table/tbody/tr[1]/td[2]
	
	public ContactsPage() throws Exception {
		PageFactory.initElements(driver, this);
	}
	
	public String header() {
		return ContactsHeader.getText();
	}
	
	public void enteringDataInContacts(String User,String ftName,String ltName,String email,String description) {
		btnNew.click();
		txtFirstName.sendKeys(ftName);
		txtLastName.sendKeys(ltName);
		btnAccess.click();
		drpUserAccess.click();
		driver.findElement(By.xpath("//div[text()='Select users allowed access']/following::span[text()='"+User+"']")).click();
		txtEmail.sendKeys(email);
		txtDescription.sendKeys(description);		
	}
	
	public void clickSaving() {
		btnSave.click();
	}
	
	public boolean verificationOfContacts(String User,String ftName,String ltName,String email,String description) {
		String before="//table/tbody/tr[";
		String after="]/td[2]";
		for(int i=1;i<5;i++) {
			WebElement contacts=driver.findElement(By.xpath(before+i+after));
			String name=contacts.getText();
			if(name.contains(ftName)) {
				driver.findElement(By.xpath(before+i+after+"/preceding::td")).click();
				return contacts.isDisplayed();
			}
		}
		return false;
	}
	
	

}
