package com.qa.crm.test;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import com.qa.basetest.BaseTest;
import com.qa.pages.EntryPage;
import com.qa.pages.HomePage;
import com.qa.pages.LoginPage;


public class HomePageTest extends BaseTest {
	EntryPage entrypage;
	HomePage homepage;
	LoginPage loginpage;

	public HomePageTest() throws Exception {
		super();
	}
	
	@BeforeMethod
	public void setUp() throws Exception {
		initialization();
		entrypage = new EntryPage();
		entrypage.clickLoginButton();
		loginpage=new LoginPage();
		homepage =loginpage.loginCrm();		
	}
	
	@Test
	public void verificationOfUserID() {
		String userID=homepage.verifyUserID();
		System.out.println(userID);
		Assert.assertEquals(prop.getProperty("userID"), userID);
	}
	
	@AfterMethod
	public static void tearDown() {
		driver.quit();
	}
}