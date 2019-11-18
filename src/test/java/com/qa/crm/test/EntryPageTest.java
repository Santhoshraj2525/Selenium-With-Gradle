package com.qa.crm.test;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qa.basetest.BaseTest;
import com.qa.pages.EntryPage;
import com.qa.pages.LoginPage;

public class EntryPageTest extends BaseTest{
	
	EntryPage entryPage;
	LoginPage loginPage;
	
	public EntryPageTest() throws Exception {
		super();
	}
	
	@BeforeMethod()
	public void setUp() throws Exception {
		initialization();
		entryPage= new EntryPage();
	}
	
	@Test (priority =1)
	public void entryPageTitleTest() {
		String title =entryPage.validateLoginTitle();
		Assert.assertEquals(title, "Free CRM #1 cloud software for any business large or small");
	}
	
	@Test (priority =2)
	public void loginButtonTest() {
		boolean flag =entryPage.loginButtonValidaion();
		Assert.assertTrue(flag);
	}
	
	@Test (priority =3)
	public void loginButtonClickTest() throws Exception {
		loginPage = entryPage.clickLoginButton();
	}
	
	@AfterMethod()
	public void tearDown() {
		driver.quit();
	}
	

}
