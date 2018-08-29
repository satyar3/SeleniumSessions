package freecrm.hashmap.exapmle;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class FreeCRMTestClass
{
	static WebDriver driver;

	@BeforeMethod
	public void setUp()
	{
		System.setProperty("webdriver.chrome.driver", "C:\\Back Up\\Project Work\\Learning Stuffs\\Selenium Training By Jitendra\\Self Study\\Tools\\chromedriver_win32\\chromedriver.exe");
		ChromeOptions options = new ChromeOptions();
		options.setExperimentalOption("useAutomationExtension", false);
		driver = new ChromeDriver(options);
		driver.get("https://www.freecrm.com");
		// WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();

	}

	@Test
	public static void loginWithAdminUser()
	{

		String[] credentials = DataClass.getUserLoginInfo().get("admin").split("_");

		driver.findElement(By.name("username")).sendKeys(credentials[0]);
		driver.findElement(By.name("password")).sendKeys(credentials[1]);

		driver.findElement(By.xpath("//input[@type=''Submit]")).click();
	}

	@Test
	public static void loginWithCustomerUser()
	{
		String[] credentials = DataClass.getUserLoginInfo().get("customer").split("_");

		driver.findElement(By.name("username")).sendKeys(credentials[0]);
		driver.findElement(By.name("password")).sendKeys(credentials[1]);

		driver.findElement(By.xpath("//input[@type=''Submit]")).click();
	}

	@AfterMethod
	public void tearDown()
	{
		driver.quit();
	}

}
