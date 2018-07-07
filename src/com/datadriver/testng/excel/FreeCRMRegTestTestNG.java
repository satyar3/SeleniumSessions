package com.datadriver.testng.excel;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.test.utility.TestUtilClass;

public class FreeCRMRegTestTestNG {

	WebDriver driver;
	
	@BeforeMethod
	public void setUp() throws InterruptedException
	{
		System.setProperty("webdriver.chrome.driver", "C:\\Back Up\\Project Work\\Learning Stuffs\\Selenium Training By Jitendra\\Self Study\\Tools\\chromedriver_win32\\chromedriver.exe");
		ChromeOptions options = new ChromeOptions();
	    options.setExperimentalOption("useAutomationExtension", false);
	    driver = new ChromeDriver(options);
	    
	    driver.manage().window().maximize();
	    driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
	    driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	    driver.get("https://www.freecrm.com");
	    Thread.sleep(3000);
		driver.findElement(By.xpath("//button[@type='button' and text()='Sign Up']")).click();
		
	}
	
	@DataProvider
	public Iterator<Object[]> getTestData()
	{
		ArrayList<Object[]> testdata = TestUtilClass.getDataFromExcel();
		return testdata.iterator();
	}
	
	//Make a connection between @Test and @DataProvider
	@Test(dataProvider="getTestData") //provide the method name of data provider
	public void testRegPage(String payment_plan, String first_name, String surname, String email, String email_confirm, 
			String username, String password, String passwordconfirm)
	{
		Select select = new Select(driver.findElement(By.id("payment_plan_id")));
		select.selectByVisibleText(payment_plan);
		
		driver.findElement(By.name("first_name")).sendKeys(first_name);
		driver.findElement(By.name("surname")).sendKeys(surname);
		driver.findElement(By.name("email")).sendKeys(email);
		driver.findElement(By.name("email_confirm")).sendKeys(email_confirm);
		driver.findElement(By.xpath("//input[@name='username']")).sendKeys(username);
		driver.findElement(By.xpath("//input[@name='password']")).sendKeys(password);
		driver.findElement(By.xpath("//input[@name='passwordconfirm']")).sendKeys(passwordconfirm);
		
		driver.findElement(By.xpath("//input[@name='agreeTerms']")).click();
		driver.findElement(By.xpath("//button[@id='submitButton']")).click();
		
		Alert alert = driver.switchTo().alert();
		//String alerttext = driver.switchTo().alert().getText();
		alert.accept();
	}
	
	@AfterMethod
	public void tearDown()
	{
		driver.quit();
	}
	

}
