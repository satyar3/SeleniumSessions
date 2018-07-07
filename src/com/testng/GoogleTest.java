package com.testng;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class GoogleTest {
	
	WebDriver driver;
	
	@BeforeMethod
	public void setUp()
	{
		System.setProperty("webdriver.chrome.driver", "C:\\Back Up\\Project Work\\Learning Stuffs\\Selenium Training By Jitendra\\Self Study\\Tools\\chromedriver_win32\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
		driver.get("http://www.google.com");
	}
	
	@Test
	public void googleTitletest()
	{
		String title = driver.getTitle();
		System.out.println(title);
	}
	
	@Test
	public void googleLogoTest()
	{
		Boolean b = driver.findElement(By.xpath("//*[@id='hplogo']")).isDisplayed();
	}
	
	@Test
	public void mailLinkTest()
	{
		Boolean b = driver.findElement(By.linkText("Mail")).isDisplayed();
	}
	
	@AfterMethod
	public void tearDown()
	{
		driver.quit();
	}
	

}
