package com.qa.test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class GmailValidationWithDifferentData_ExcelDemo {
	
	static WebDriver driver;
	
	@BeforeMethod
	public static void setUp() {
		System.setProperty("webdriver.chrome.driver", "E:\\Selenium\\Installation\\chromedriver.exe");
		driver = new ChromeDriver();	
		driver.get("http://www.gmail.com");
		driver.manage().window().maximize();
		//driver.manage().deleteAllCookies();
	}
	
	@Test (priority=0,dataProvider = "Auth", dataProviderClass=utilities.DataParameter.class)
	public static void emailValidation(String userName, String password) throws Exception {
		System.out.println(userName+ " and "+password);
		
		Thread.sleep(2000);		
		driver.findElement(By.xpath("//input[@type='email']")).click();
		driver.findElement(By.xpath("//input[@type='email']")).sendKeys(userName);
		driver.findElement(By.xpath("//span[text()='Next']")).click();
		/*driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);*/
		Thread.sleep(10000);
		driver.findElement(By.xpath("//input[@name='password']")).click();
		driver.findElement(By.xpath("//input[@name='password']")).sendKeys(password);
		driver.findElement(By.xpath("//span[text()='Next']")).click();
	}
	
	@Test (priority=2,dataProvider = "Auth", dataProviderClass=utilities.DataParameter.class)
	public void invalidEmailValidation(String userName, String password) throws Exception {
		Thread.sleep(2000);
		driver.findElement(By.xpath("//input[@type='email']")).click();
		driver.findElement(By.xpath("//input[@type='email']")).sendKeys(userName);
		driver.findElement(By.xpath("//span[text()='Next']")).click();
		/*driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);*/
		Thread.sleep(10000);
		driver.findElement(By.xpath("//input[@name='password']")).click();
		driver.findElement(By.xpath("//input[@name='password']")).sendKeys(password);
		driver.findElement(By.xpath("//span[text()='Next']")).click();
	}
	
	@AfterMethod
	public void tearDown() throws Exception {
		Thread.sleep(2000);
		driver.quit();
	}
}
