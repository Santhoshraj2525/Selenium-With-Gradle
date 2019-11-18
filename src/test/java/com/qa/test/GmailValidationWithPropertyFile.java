package com.qa.test;

import java.io.FileInputStream;
import java.util.Properties;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class GmailValidationWithPropertyFile {
	
static WebDriver driver;
static Properties properties;

	@BeforeClass
	public static void beforeclass() throws Exception {
		properties = new Properties();
		FileInputStream fis = new FileInputStream("C:\\Users\\hp\\eclipse-workspace\\CoreJavaAutomation\\src\\main\\resources\\Utilities\\config.properties");
		properties.load(fis);
	}
	
	@BeforeMethod
	public static void setUp() {
		System.setProperty("webdriver.chrome.driver", "E:\\Selenium\\Installation\\chromedriver.exe");
		driver = new ChromeDriver();	
		driver.get("http://www.gmail.com");
		driver.manage().window().maximize();
		//driver.manage().deleteAllCookies();
	}
	
	@Test ()
	public static void emailValidation() throws Exception {		
		Thread.sleep(2000);		
		driver.findElement(By.xpath("//input[@type='email']")).click();
		driver.findElement(By.xpath("//input[@type='email']")).sendKeys(properties.getProperty("userName"));
		driver.findElement(By.xpath("//span[text()='Next']")).click();
		/*driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);*/
		Thread.sleep(10000);
		driver.findElement(By.xpath("//input[@name='password']")).click();
		driver.findElement(By.xpath("//input[@name='password']")).sendKeys(properties.getProperty("Password"));
		driver.findElement(By.xpath("//span[text()='Next']")).click();
	}
	
	@AfterMethod
	public void tearDown() throws Exception {
		Thread.sleep(2000);
		driver.quit();
	}

}
