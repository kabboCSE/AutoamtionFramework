package com.it.bd.tests;

import java.io.IOException;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.it.bd.drivers.BaseDriver;
import com.it.bd.drivers.PageDriver;
import com.it.bd.pages.DashboardPage;
import com.it.bd.utilities.ExtentFactory;


public class DashboardTest extends BaseDriver{
	ExtentReports report;
	ExtentTest parentTest;
	ExtentTest childTest;
	

	@Test(priority = 0)
	public void dashBoardTest() throws InterruptedException, IOException {
		report = ExtentFactory.getInstance();
		parentTest = report.createTest("<p style=\"color:#FF6000; font-size:20px\"><b>Dashboard</b></p>").assignAuthor("Dashboard Module").assignDevice("Windows 10");
		childTest = parentTest.createNode("<p style=\"color:#3E96E7; font-size:20px\"><b>DASHBOARD TEST</b></p>");
		DashboardPage dashboardPage = new DashboardPage(childTest);
		dashboardPage.clickAdmin();
	}
	@AfterClass
	public void afterClass() {
		report.flush();
	}
}
