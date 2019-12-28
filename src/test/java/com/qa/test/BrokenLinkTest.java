package com.qa.test;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class BrokenLinkTest {

	public static void main(String[] args) throws Exception, IOException {
		System.setProperty("webdriver.chrome.driver", "E:\\Selenium\\Installation\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.amazon.in/");
		//driver.manage().window().maximize();
		List<WebElement> links = driver.findElements(By.tagName("a"));
		
		for(int i=0;i<links.size();i++) {
			if((links.get(i).getAttribute("href")==null)  || (links.get(i).getAttribute("href").contains("javascript")) || (links.get(i).getAttribute("href").contains("null"))) {
				links.remove(i);
			}
		}
		System.out.println("total links are "+links.size());
		
		for(int j=1;j<links.size();j++) {
			String hrefe = links.get(j).getAttribute("href");
			if(!hrefe.equals(null)) {
			HttpURLConnection connection = (HttpURLConnection) new URL(links.get(j).getAttribute("href")).openConnection();
			connection.connect();
			String response = connection.getResponseMessage();
			connection.disconnect();
			System.out.println(links.get(j).getAttribute("href")+ "---->" +response);
			}
		}
		
		driver.quit();
	}
}