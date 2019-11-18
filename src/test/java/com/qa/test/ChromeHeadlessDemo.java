package com.qa.test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;

public class ChromeHeadlessDemo {

	public static void main(String[] args) throws Exception {
		System.setProperty("webdriver.chrome.driver", "E:\\Selenium\\Installation\\chromedriver.exe");
		
		ChromeOptions options = new ChromeOptions();
		options.addArguments("window-size=1400,800");
		options.addArguments("headless");
		
		WebDriver driver = new ChromeDriver(options);	
		driver.get("http://www.google.com");
		Thread.sleep(2000);
		String title= driver.getTitle();
		System.out.println(title);
		Assert.assertEquals(title, "Google");
		driver.quit();

	}

}
