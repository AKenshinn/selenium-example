package com.anat.selenium;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.google.common.base.Predicate;

public class DatePicker {

	public static void main(String[] args) throws InterruptedException {

		System.setProperty("webdriver.chrome.driver", "/Users/Kenshinn/bin/chromedriver"); //path to chrome or internet Explorer driver
		WebDriver driver = new ChromeDriver();
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS); // set timeout for load page
		driver.navigate().to("http://www.seleniumframework.com/practiceform/"); // url to web page
		
		// wait for load javascript
		WebDriverWait wait = new WebDriverWait(driver, 60);
		wait.until( new Predicate<WebDriver>() {
			public boolean apply(WebDriver driver) {
				return ((JavascriptExecutor)driver).executeScript("return document.readyState").equals("complete");
            }
		});
		
		// use datepicker to set textbox
		WebElement input = driver.findElement(By.name("vfb-8"));
		input.sendKeys(""); // open and focus calendar

		// go to Januray 1992
		while (true) {
			
			WebElement prev = driver.findElement(By.className("ui-icon-circle-triangle-w")); // previous button
			prev.click();
			
			// WebElement next = driver.findElement(By.className("ui-icon-circle-triangle-e")); // next button
			// next.click();
			
			WebElement month = driver.findElement(By.className("ui-datepicker-month"));
			WebElement year = driver.findElement(By.className("ui-datepicker-year"));
			
			if (month.getText().equals("July") && year.getText().equals("1992")) {
				break;
			}
			
		}

		// pick date in calander
		WebElement datepicker = driver.findElement(By.id("ui-datepicker-div"));
		List<WebElement> columns = datepicker.findElements(By.tagName("td"));
		for (WebElement cell : columns) {
			if (cell.getText().equals("23")) {
				cell.click();
				break;
			}
		}
		
		Thread.sleep(3000);
		driver.quit();
		
	}
	
}
