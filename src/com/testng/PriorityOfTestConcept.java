package com.testng;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class PriorityOfTestConcept {

		WebDriver driver;
		
		@BeforeMethod
		public void setUp()
		{
			System.setProperty("webdriver.chrome.driver", "C:\\Back Up\\Project Work\\Learning Stuffs\\Selenium Training By Jitendra\\Self Study\\Tools\\chromedriver_win32\\chromedriver.exe");
			ChromeOptions options = new ChromeOptions();
		    options.setExperimentalOption("useAutomationExtension", false);
		    driver = new ChromeDriver(options);
			//driver = new ChromeDriver();
			driver.manage().window().maximize();
			driver.manage().deleteAllCookies();
			driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			driver.get("http://www.google.com");
		}
		
		@Test(priority=1,groups="Title")		// priority keyword is to define the priority of the test cases
		public void googleTitletest()
		{
			String title = driver.getTitle();
			System.out.println(title);
		}
		
		@Test(priority=3,groups="Logo Test")
		public void googleLogoTest()
		{
			Boolean b = driver.findElement(By.xpath("//*[@id='hplogo']")).isDisplayed();
		}
		
		@Test(priority=2,groups="Link Test")
		public void mailLinkTest()
		{
			Boolean b = driver.findElement(By.linkText("Mail")).isDisplayed();
		}
		
		@Test(priority=4,groups="Test")
		public void testCase1()
		{
			System.out.println("Test1");
		}
		@Test(priority=5,groups="Test")
		public void testCase2()
		{
			System.out.println("Test2");
		}@Test(priority=6,groups="Test")
		public void testCase3()
		{
			System.out.println("Test3");
		}
		
		@AfterMethod
		public void tearDown()
		{
			driver.quit();
		}
}
