package com.qa.test;

import org.testng.annotations.Test;

import utilities.ExcelReader;

public class DataDrivenExcelDemo {
	
	@Test
	public void Data() throws Exception {
		ExcelReader reader = new ExcelReader("C:\\Users\\hp\\Desktop\\DataFW\\TestData.xlsx");
		int totalRow = reader.getRowCount("GmailData");
		System.out.println("total no of rows present in that sheet = " +totalRow);
		for(int rowNum=2;rowNum<=totalRow;rowNum++) {
			String userName = reader.getCellData("GmailData", "UserName", rowNum);
			System.out.println(userName);
			String Password = reader.getCellData("GmailData", "Password", rowNum);
			System.out.println(Password);	
		}
		
	}

}
