package com.anat.selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.safari.SafariDriver;

public class NameSelector {

	public static void main(String[] args) throws InterruptedException {
		
		// if using Google Chrome or Internet Explorer browser
		// System.setProperty("webdriver.chrome.driver", "/Users/Kenshinn/bin/chromedriver"); //path to chrome or internet Explorer driver
		// WebDriver driver = new ChromeDriver(); // or new InternetExplorerDriver();
		
		WebDriver driver = new SafariDriver(); // using Safari browser
		driver.navigate().to("http://testing.todorvachev.com/selectors/name/"); // url to web page 
		
		WebElement element = driver.findElement(By.name("myName")); // find element by name
		// check found or not found element
		if (element.isDisplayed()) { 
			System.out.println("Found element...");
			element.click();
			element.sendKeys("This is text field");
		} else {
			System.err.println("Not found element...");
		}
		
		
		Thread.sleep(3000); // delay 3 seconds
		driver.quit(); // quit browser
		
	}

}
