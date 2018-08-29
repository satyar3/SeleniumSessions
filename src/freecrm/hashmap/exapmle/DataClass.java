package freecrm.hashmap.exapmle;

import java.util.HashMap;

public class DataClass
{
	public static HashMap<String, String> getUserLoginInfo()
	{
		HashMap<String, String> usermap = new HashMap<>();
		
		usermap.put("customer", "naveenkTest_test123");
		usermap.put("admin", "admin_test123");
		
		return usermap;
	}
	
	public static HashMap<Integer, String> monthMap()
	{
		HashMap<Integer, String> monthmap = new HashMap<>();
		
		monthmap.put(1, "January");
		monthmap.put(2, "February");
		monthmap.put(3, "March");
		monthmap.put(4, "April");
		monthmap.put(5, "May");
		monthmap.put(6, "June");
		monthmap.put(7, "July");
		monthmap.put(8, "August");
		monthmap.put(9, "Septmber");
		monthmap.put(10, "October");
		monthmap.put(11, "November");
		monthmap.put(12, "December");
		
		return monthmap;
	}
}
