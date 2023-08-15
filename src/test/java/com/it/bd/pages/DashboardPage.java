package com.it.bd.pages;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.it.bd.drivers.PageDriver;
import com.it.bd.utilities.CommonMethods;
import com.it.bd.utilities.GetScreenShot;

import junit.framework.Assert;

public class DashboardPage extends CommonMethods {
	
	ExtentTest test;
	public DashboardPage(ExtentTest test) {		
		PageFactory.initElements(PageDriver.getCurrentDriver(), this);
		this.test = test; 
	}
	
	@FindBys({
		@FindBy(xpath = "//body/div[@id='app']/div[1]/div[1]/aside[1]/nav[1]/div[2]/ul[1]/li[1]/a[1]"),
		@FindBy(xpath = "//body/div[@id='app']/div[1]/div[1]/aside[1]/nav[1]/div[2]/ul[1]/li[1]"),
		@FindBy(xpath = "//body/div[@id='app']/div[1]/div[1]/aside[1]/nav[1]/div[2]/ul[1]/li[1]/a[1]/*[1]")
		
	})
	WebElement adminOption;
	
	public void clickAdmin() throws IOException {
		try {
			if(adminOption.isDisplayed()) {
				adminOption.click();
				timeout();
				test.pass("<p style=\"color:#85BC63; font-size:13px\"><b>successfully Clicked on AdminOption.</b></p>");
				@SuppressWarnings("unused")
				String screenShotPath = GetScreenShot.capture(PageDriver.getCurrentDriver(), "AdminOptionSuccess");
				String dest = System.getProperty("user.dir") + "\\screenshots\\" + "AdminOptionSuccess.png";
				test.pass(MediaEntityBuilder.createScreenCaptureFromPath(dest).build());
				timeout();
				
			}
		} catch (Exception e) {
			test.fail("<p style=\"color:#FF5353; font-size:13px\"><b>Dashboard is not locateable.Please check the error message.</b></p>");
			Throwable t = new InterruptedException("Exception");
			test.fail(t);
			@SuppressWarnings("unused")
			String screenShotPath = GetScreenShot.capture(PageDriver.getCurrentDriver(), "DashboardPass");
			String dest = System.getProperty("user.dir") + "\\screenshots\\" + "DashboardLocator.png";
			test.fail(MediaEntityBuilder.createScreenCaptureFromPath(dest).build());
			Assert.assertTrue(adminOption.isDisplayed());
			PageDriver.getCurrentDriver().quit();
		}
	}
	

}
