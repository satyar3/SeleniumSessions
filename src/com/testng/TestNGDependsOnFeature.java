package com.testng;

import org.testng.annotations.Test;

public class TestNGDependsOnFeature {
	
	@Test(dependsOnMethods="registrationPageTest")
	public void loginTest()
	{
		System.out.println("log in test");
		//int i = 9/0;
	}
	@Test(dependsOnMethods="loginTest")
	public void homePageTest()
	{
		System.out.println("log in test");
	}
	@Test(dependsOnMethods="loginTest")
	public void searchPageTest()
	{
		System.out.println("log in test");
	}
	@Test(dependsOnMethods="loginTest")
	public void registrationPageTest()
	{
		System.out.println("log in test");
	}
	
}
