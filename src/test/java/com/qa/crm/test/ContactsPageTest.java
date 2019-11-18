package com.qa.crm.test;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qa.basetest.BaseTest;
import com.qa.pages.ContactsPage;
import com.qa.pages.EntryPage;
import com.qa.pages.HomePage;
import com.qa.pages.LoginPage;

public class ContactsPageTest extends BaseTest{
		EntryPage entrypage;
		HomePage homepage;
		LoginPage loginpage;
		ContactsPage contactspage;

		public ContactsPageTest() throws Exception {
			super();
		}
		
		@BeforeMethod
		public void setUp() throws Exception {
			initialization();
			entrypage = new EntryPage();
			entrypage.clickLoginButton();
			loginpage=new LoginPage();
			homepage =loginpage.loginCrm();	
			contactspage=homepage.clickContacts();
		}
		
		@Test (dataProvider="TestData",dataProviderClass=utilities.DataParameter.class,enabled=true)
		public void verificationOfContactsPresentation(String userID, String FirstName, String LastName, String email, String Description) throws Exception {
			boolean flag=contactspage.verificationOfContacts(userID, FirstName, LastName, email, Description);
			Assert.assertEquals(flag, true, "The expected contacts are missing");
			Thread.sleep(10000);
		}
		
		@Test
		public void verificationOfHeader() {
			String header=contactspage.header();
			System.out.println(header);
			Assert.assertEquals("Contactser", header);
		}
		
		@Test (dataProvider="TestData",dataProviderClass=utilities.DataParameter.class,enabled=true)
		public void validationOfContactsCreation(String testMehod,String userID, String FirstName, String LastName, String email, String Description) throws Exception {
			contactspage.enteringDataInContacts(userID, FirstName, LastName, email, Description);
			Thread.sleep(5000);
			contactspage.clickSaving();
			homepage.clickContacts();
			Thread.sleep(5000);
		}
		
		
		
		
		@AfterMethod
		public static void tearDown() {
			driver.quit();
		}

}
