package com.qa.test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class GoogleTitleTest {
	
	@Test
	public  void googleTitleValidation() {
		System.setProperty("webdriver.chrome.driver", "E:\\Selenium\\Installation\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();	
		driver.get("http://www.google.com");
		String title= driver.getTitle();
		System.out.println(title);
		Assert.assertEquals(title, "Google");
		driver.quit();
	}

}
