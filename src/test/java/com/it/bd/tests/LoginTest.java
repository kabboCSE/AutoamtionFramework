package com.it.bd.tests;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.it.bd.drivers.BaseDriver;
import com.it.bd.drivers.PageDriver;
import com.it.bd.pages.LoginPage;

public class LoginTest extends BaseDriver{

	@BeforeClass
	public void openUrl() {
		PageDriver.getCurrentDriver().manage().window().maximize();
		PageDriver.getCurrentDriver().get(url);
		
	}
	
	@Test(priority = 0)
	public void loginTest() throws InterruptedException {
		LoginPage loginPage = new LoginPage();
		loginPage.login();
	}
}
