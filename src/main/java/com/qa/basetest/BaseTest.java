package com.qa.basetest;

import java.io.FileInputStream;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import utilities.WebEventListener;

public class BaseTest {
	
	public static WebDriver driver;
	public static Properties prop;
	
	public BaseTest() throws Exception {
		FileInputStream fis = new FileInputStream("C:\\Users\\hp\\eclipse-workspace\\SeleniumWithGradleFramework\\src\\test\\resources\\com\\qa\\config\\config.properties");
		prop = new Properties();
		prop.load(fis);
	}
	
	public static void initialization() throws Exception {
		String browserName = prop.getProperty("browser");
		if(browserName.equals("Chrome")) {
			System.setProperty("webdriver.chrome.driver", "C:\\Users\\hp\\eclipse-workspace\\SeleniumWithGradleFramework\\src\\main\\resources\\com\\qa\\drivers\\chromedriver_win32 (2)\\chromedriver.exe");
			driver = new ChromeDriver();
		}else if(browserName.equals("IE")) {
			System.setProperty("webdriver.ie.driver", "C:\\Users\\hp\\eclipse-workspace\\SeleniumWithGradleFramework\\src\\main\\resources\\com\\qa\\drivers\\IEDriverServer.exe");
			driver = new InternetExplorerDriver();
		}else if(browserName.equals("Firefox")) {
			System.setProperty("webdriver.gecko.driver", "C:\\Users\\hp\\eclipse-workspace\\SeleniumWithGradleFramework\\src\\main\\resources\\com\\qa\\drivers\\geckodriver.exe");
			driver = new FirefoxDriver();
		}
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get(prop.getProperty("url"));
	}

}
