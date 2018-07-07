package com.testng;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TestNGBasics {
	
	//Each and every annotation should be associated with annotation
	
	/*1 - @BeforeSuite 
	2 - @BeforeTest
	3 - @BeforeClass
	4 - @BeforeMethod
	5 - @Test
	5 - @Test
	5 - @Test
	6 - @AfterMethod
	7 - @AfterClass
	8 - @AfterTest
	9 - @AfterSuite*/
	
	
	
	//Annotation starting with @Before are called prerequisite
	
	//Pre-conditions
	//1st
	@BeforeSuite 
	public void setUp()
	{
		System.out.println("Set up system property for chrome");
	}
	
	//2nd
	@BeforeTest
	public void launchBrowser()
	{
		System.out.println("Launch the Browser");
	}
	
	//3rd
	@BeforeClass
	public void logIn()
	{
		System.out.println("Log In to Chrome Browser");
	}
	
	//4th
	@BeforeMethod
	public void enterUrl()
	{
		System.out.println("Enter URL : ");
	}
	
	
	
	//Annotation starting with @Test are Test cases
	//Number of @Test annotations denotes number of test cases
	
	//5th
	//Test cases
	@Test
	public void googleTitleTest()
	{
		System.out.println("Google title");
	}
	
	@Test
	public void searchtest()
	{
		System.out.println("search test");
	}
	
	@Test
	public void googleLogoTest()
	{
		System.out.println("googleLogoTest");
	}
	//Annotations starting with @After are post conditions 	
	//Post-conditions
	
	//6th
	@AfterMethod
	public void logOut()
	{
		System.out.println("log out from app");
	}
	
	//7th
	@AfterClass
	public void closeBrowser()
	{
		System.out.println("Close browser");
	}
	
	//8th
	@AfterTest
	public void deleteAllCookies()
	{
		System.out.println("Delete all cookies");
	}
	
	//9th	
	@AfterSuite
	public void generateTestReport()
	{
		System.out.println("Generate Test report");
	}
	
	//Test case sequence
	//Test case will be picked up randomly but the execution sequence remains same
	
	/*@BeforeMethod
	@Test-1
	@AfterMethod
	
	@BeforeMethod
	@Test-2
	@AfterMethod*/
}
