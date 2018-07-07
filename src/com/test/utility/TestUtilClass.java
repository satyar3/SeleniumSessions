package com.test.utility;

import java.util.ArrayList;

import org.testng.annotations.Test;

import com.excel.utility.Xls_Reader;

public class TestUtilClass {
	
	static Xls_Reader reader;
	
	@Test
	public static ArrayList<Object[]> getDataFromExcel()
	{
		ArrayList<Object[]> mydata = new ArrayList<Object[]>();
		reader = new Xls_Reader("C:\\Back Up\\Project Work\\Learning Stuffs\\Selenium Training By Jitendra\\Self Study\\Programs\\SeleniumSessions\\src\\com\\test\\freecrm\\testdata\\FreeCRMRegPage_Test_Data.xlsx");
		
		int rowcount = reader.getRowCount("RegTestData");
		
		/*reader.getCellData("RegTestData", "payment_plan", 2);
		reader.getCellData("RegTestData", "first_name", 2);
		reader.getCellData("RegTestData", "surname", 2);
		reader.getCellData("RegTestData", "email", 2);
		reader.getCellData("RegTestData", "email_confirm", 2);
		reader.getCellData("RegTestData", "username", 2);
		reader.getCellData("RegTestData", "password", 2);
		reader.getCellData("RegTestData", "passwordconfirm", 2);*/
		
		if(!reader.isSheetExist("TestResult")) //To verify is sheet exists
		{
			reader.addSheet("TestResult");//add a new sheet to existing file
		}
		reader.addColumn("TestResult", "Status");
				
		for (int row = 2; row <= rowcount; row++)
		{
			String payment_plan = reader.getCellData("RegTestData", "payment_plan", row);
			String first_name = reader.getCellData("RegTestData", "first_name", row);
			String surname = reader.getCellData("RegTestData", "surname", row);
			String email = reader.getCellData("RegTestData", "email", row);
			String email_confirm = reader.getCellData("RegTestData", "email_confirm", row);
			String username = reader.getCellData("RegTestData", "username", row);
			String password = reader.getCellData("RegTestData", "password", row);
			String passwordconfirm = reader.getCellData("RegTestData", "passwordconfirm", row);
			
			reader.setCellData("TestResult", "Status", row, "Pass");
			reader.getCellRowNum("RegTestData", "first_name", "user fn 1"); //It will return the row number of user fn 1 under firstname cell
			
			
			//Object ob = new Object();
			Object ob[] = {payment_plan,first_name,surname,email,email_confirm,username,password,passwordconfirm};
			mydata.add(ob);
		}
		
		return mydata;
		
	}
	
}
