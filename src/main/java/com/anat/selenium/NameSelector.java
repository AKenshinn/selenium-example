package com.anat.selenium;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.google.common.base.Predicate;

public class NameSelector {

	public static void main(String[] args) throws InterruptedException {
		
		// if using Google Chrome or Internet Explorer browser
		System.setProperty("webdriver.chrome.driver", "/Users/Kenshinn/bin/chromedriver"); //path to chrome or internet Explorer driver
		WebDriver driver = new ChromeDriver(); // or new InternetExplorerDriver();
		
		// focus window
		((JavascriptExecutor) driver).executeScript("alert('Focus window')");
		driver.switchTo().alert().accept();
		
		driver.manage().window().maximize(); // use maximum window size
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS); // set timeout for load page
		driver.navigate().to("http://testing.todorvachev.com/selectors/name"); // url to web page
		
		// wait for load javascript
		WebDriverWait wait = new WebDriverWait(driver, 60);
		wait.until( new Predicate<WebDriver>() {
			public boolean apply(WebDriver driver) {
				return ((JavascriptExecutor)driver).executeScript("return document.readyState").equals("complete");
            }
		});
		
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
