package com.anat.selenium;

import static org.junit.Assert.*;

import java.util.concurrent.TimeUnit;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class OpenBrowserTest {
	
	private static WebDriver driver;
	
	@BeforeClass
	public static void setupBrowser() throws Exception {
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "/driver/chromedriver"); //path to chrome or internet Explorer driver
		driver = new ChromeDriver(); // or new InternetExplorerDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS); // set timeout for load page
	}
	
	@Test
	public void testLoadPage() throws Exception {
		driver.navigate().to("http://www.google.com"); // url to web page

		//run your javascript and alert code for handle window
		((JavascriptExecutor)driver).executeScript("alert('Test')"); 
		driver.switchTo().alert().accept();
		
		WebElement element = driver.findElement(By.name("q"));
		
		assertNotNull(element);
	}
	
	@AfterClass
	public static void closeBrowser() throws Exception {
		Thread.sleep(3000);
		driver.quit();
	}
	
}
