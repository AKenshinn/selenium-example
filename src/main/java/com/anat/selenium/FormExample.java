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

public class FormExample {
	
	public static void main(String[] args) throws InterruptedException {
		
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "/driver/chromedriver"); //path to chrome or internet Explorer driver
		WebDriver driver = new ChromeDriver();
		
		// focus window
		((JavascriptExecutor) driver).executeScript("alert('Focus window')");
		driver.switchTo().alert().accept();
		
		driver.manage().window().maximize(); // use maximum window size
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS); // set timeout for load page
		driver.navigate().to("http://www.seleniumframework.com/practiceform/"); // url to web page
		
		// wait for load javascript
		WebDriverWait wait = new WebDriverWait(driver, 60);
		wait.until( new Predicate<WebDriver>() {
			public boolean apply(WebDriver driver) {
				return ((JavascriptExecutor)driver).executeScript("return document.readyState").equals("complete");
            }
		});
		
		// text area
		WebElement textArea = driver.findElement(By.name("vfb-10"));
		if (textArea.isEnabled()) {
			System.out.println("textarea : Found textarea");
			textArea.click();
			textArea.clear();
			textArea.sendKeys("This is textarea from selenium");
		} else {
			System.out.println("textarea : Not found textarea");
		}
		
		// text box
		WebElement textbox = driver.findElement(By.name("vfb-9"));
		if (textbox.isEnabled()) {
			System.out.println("textbox : Found textbox");
			textbox.click();
			textbox.clear();
			textbox.sendKeys("This is textbox from selenium");
		} else {
			System.out.println("textbox : Not found textbox");
		}
		
		// checkbox
		List<WebElement> checkboxes = driver.findElements(By.name("vfb-6[]"));
		for (WebElement element : checkboxes) {
			if (element.getAttribute("value").equals("Option 2")) {
				element.click();
			}
			
			System.out.println("Checkbox : " + element.getAttribute("value"));
		}
		
		// radio
		List<WebElement> radios = driver.findElements(By.name("vfb-7"));
		for (WebElement element : radios) {
			if (element.getAttribute("value").equals("Option 3")) {
				element.click();
			}
			
			System.out.println("Radio : " + element.getAttribute("value"));
		}
		
		// datepicker
		WebElement datepicker = driver.findElement(By.name("vfb-8"));
		datepicker.sendKeys("07/23/1992"); // send date to textbox
		driver.findElement(By.linkText("23")).click(); // click day for hide datepicker
		System.out.println("DatePicker : " + datepicker.getAttribute("value"));
		
		// select (dropdown)
		WebElement select = driver.findElement(By.id("vfb-12"));
		System.out.println("Select");
		List<WebElement> options = select.findElements(By.tagName("option"));
		for (WebElement element : options) {
			if (element.getAttribute("value").equals("Option 2")) {
				element.click();
			}
			
			System.out.println("Option : " + element.getAttribute("value"));
		}
		
		Thread.sleep(3000);
		driver.quit();
		
	}
	
}
