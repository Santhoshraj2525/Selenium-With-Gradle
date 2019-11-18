package com.qa.crm.test;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qa.basetest.BaseTest;
import com.qa.pages.EntryPage;
import com.qa.pages.HomePage;
import com.qa.pages.LoginPage;

public class LoginPageTest extends BaseTest {
	EntryPage entryPage;
	LoginPage loginpage;
	HomePage homePage;
	public LoginPageTest() throws Exception {
		super();
	}
	
	@BeforeMethod
	public void setUp() throws Exception {
		initialization();
		entryPage = new EntryPage();
		loginpage = entryPage.clickLoginButton();
	}
	
	@Test (priority=1)
	public void loginPageTitleTest() {
		String title = loginpage.loginTitle();
		Assert.assertEquals(title, "Cogmen CRM", "Title is not expected");
	}
	
	@Test (priority=2)
	public void loginCRMTest() throws Exception {
		homePage=loginpage.loginCrm();
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
}
