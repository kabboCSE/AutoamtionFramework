package com.it.bd.utilities;

import org.testng.annotations.DataProvider;

public class DataSet {

//	@DataProvider(name = "invalidCredentials")
//	public static Object invalidLoginData() {
//		Object[][] objects = {{"admin1","admin123"},{"admin","admin23"},{"admin34","ad546"}};		
//		return objects;		
//	}
	
	@DataProvider(name = "invalidLoginDataFromExcel")
	public static Object invalidLoginDataFromExcel() {
		ExcelReader excelReader = new ExcelReader("src\\invalidCredentials.xlsx",0);		
		return excelReader.getAllData();	  				
	}
}
