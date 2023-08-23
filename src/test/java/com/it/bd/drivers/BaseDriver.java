package com.it.bd.drivers;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import io.github.bonigarcia.wdm.WebDriverManager;
	
public class BaseDriver {
	public static String url = "https://opensource-demo.orangehrmlive.com/web/index.php/auth/login";
	WebDriver driver = null;

	@BeforeSuite
	public void Start() {
		String browser = System.getProperty("browser", "chrome");
		

		if (browser.contains("edge")) {
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
		} else if (browser.contains("chrome")) {
			//To use your local chrome session
//			ChromeOptions options = new ChromeOptions();	       
//	        options.addArguments("--user-data-dir=C:\\Kabbo\\USER\\AppData\\Local\\Google\\Chrome for Testing\\User Data");
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		} else {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		}
		
		PageDriver.getInstance().setDriver(driver);
	}

	@AfterSuite
	public void close() {
		PageDriver.getCurrentDriver().quit();
	}

}
