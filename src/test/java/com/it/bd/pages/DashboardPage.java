package com.it.bd.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;

import com.it.bd.drivers.PageDriver;
import com.it.bd.utilities.CommonMethods;

public class DashboardPage extends CommonMethods {
	
	public DashboardPage() {
		
		PageFactory.initElements(PageDriver.getCurrentDriver(), this);
	}
	
	@FindBys({
		@FindBy(xpath = "//body/div[@id='app']/div[1]/div[1]/aside[1]/nav[1]/div[2]/ul[1]/li[1]/a[1]/span[1]")
	})
	WebElement adminOption;
	
	public void clickAdmin() {
		try {
			if(adminOption.isDisplayed()) {
				adminOption.click();
				timeout();
			}
		} catch (Exception e) {
			System.out.println(e);
		}
	}
	

}
