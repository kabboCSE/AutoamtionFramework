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

public class LoginPage extends CommonMethods{
	
	/*
	 * 1. PageFactory init
	 * 2. Locators
	 * 3. Function
	 */
	
	ExtentTest test;
	public LoginPage(ExtentTest test) {				
		PageFactory.initElements(PageDriver.getCurrentDriver(), this);
		this.test = test; 
	}
	
	@FindBys({
		@FindBy(xpath = "//input[@name='username']"),
		@FindBy(xpath = "//input[@placeholder='Username']"),
		@FindBy(xpath = "//body/div[@id='app']/div[1]/div[1]/div[1]/div[1]/div[2]/div[2]/form[1]/div[1]/div[1]/div[2]/input[1]")
	})	
	WebElement username;
	
	@FindBys({
		@FindBy(xpath="//input[@name='password']"),
	})
	WebElement password;
	
	@FindBys({
		@FindBy(xpath="//body[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[2]/form[1]/div[3]/button[1]")
	})
	WebElement login;
	
	public void login(String usernam, String pass) throws InterruptedException, IOException {
		timeout();   
		try {
			if(username.isDisplayed()) {
				username.sendKeys(usernam);
				timeout(); 
			}
		} catch (Exception e) {
			test.fail("<p style=\"color:#FF5353; font-size:13px\"><b>Username is not locateable.Please check the error message.</b></p>");
			Throwable t = new InterruptedException("Exception");
			test.fail(t);
			@SuppressWarnings("unused")
			String screenShotPath = GetScreenShot.capture(PageDriver.getCurrentDriver(), "usernameLocator");
			String dest = System.getProperty("user.dir") + "\\screenshots\\" + "usernameLocator.png";
			test.fail(MediaEntityBuilder.createScreenCaptureFromPath(dest).build());
			Assert.assertTrue(username.isDisplayed());
			PageDriver.getCurrentDriver().quit();
		}
		try {
			if(password.isDisplayed()) {
				password.sendKeys(pass);
				timeout();
			}
		} catch (Exception e) {
			test.fail("<p style=\"color:#FF5353; font-size:13px\"><b>Password is not locateable.Please check the error message.</b></p>");
			Throwable t = new InterruptedException("Exception");
			test.fail(t);
			@SuppressWarnings("unused")
			String screenShotPath = GetScreenShot.capture(PageDriver.getCurrentDriver(), "passwordLocator");
			String dest = System.getProperty("user.dir") + "\\screenshots\\" + "passwordLocator.png";
			test.fail(MediaEntityBuilder.createScreenCaptureFromPath(dest).build());
			Assert.assertTrue(password.isDisplayed());
			PageDriver.getCurrentDriver().quit();
		}
		
		try {
			if(login.isDisplayed()) {
				login.click();
				timeout();
				test.pass("<p style=\"color:#85BC63; font-size:13px\"><b>You have successfully logged in.</b></p>");
				@SuppressWarnings("unused")
				String screenShotPath = GetScreenShot.capture(PageDriver.getCurrentDriver(), "loginPass");
				String dest = System.getProperty("user.dir") + "\\screenshots\\" + "LoginPass.png";
				test.pass(MediaEntityBuilder.createScreenCaptureFromPath(dest).build());
			}
		} catch (Exception e) {
			test.fail("<p style=\"color:#FF5353; font-size:13px\"><b>Password is not locateable.Please check the error message.</b></p>");
			Throwable t = new InterruptedException("Exception");
			test.fail(t);
			@SuppressWarnings("unused")
			String screenShotPath = GetScreenShot.capture(PageDriver.getCurrentDriver(), "loginButtonLocator");
			String dest = System.getProperty("user.dir") + "\\screenshots\\" + "loginButtonLocator.png";
			test.fail(MediaEntityBuilder.createScreenCaptureFromPath(dest).build());
			Assert.assertTrue(login.isDisplayed());
			PageDriver.getCurrentDriver().quit();
		}
	}

}
