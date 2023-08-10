package com.it.bd.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;

import com.it.bd.drivers.PageDriver;
import com.it.bd.utilities.CommonMethods;

public class LoginPage extends CommonMethods{
	
	public LoginPage() {
		
		/*
		 * 1. PageFactory init
		 * 2. Locators
		 * 3. Function
		 */
		PageFactory.initElements(PageDriver.getCurrentDriver(), this);
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
	
	public void login() throws InterruptedException {
		timeout();   
		try {
			if(username.isDisplayed()) {
				username.sendKeys("Admin");
				timeout();
			}
		} catch (Exception e) {
			System.out.println(e);
		}
		try {
			if(password.isDisplayed()) {
				password.sendKeys("admin123");
				timeout();
			}
		} catch (Exception e) {
			System.out.println(e);
		}
		
		try {
			if(login.isDisplayed()) {
				login.click();
				timeout();
			}
		} catch (Exception e) {
			System.out.println(e);
		}
	}

}
