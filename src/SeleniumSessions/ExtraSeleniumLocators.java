package SeleniumSessions;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ByIdOrName;
import org.openqa.selenium.support.pagefactory.ByAll;
import org.openqa.selenium.support.pagefactory.ByChained;

public class ExtraSeleniumLocators
{

	public static void main(String[] args)
	{
		System.setProperty("webdriver.chrome.driver", "C:\\Back Up\\Project Work\\Learning Stuffs\\Selenium Training By Jitendra\\Self Study\\Tools\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		
		driver.get("https://www.facebook.com");
		
		
		//In the below code, for each By class implicit wait will be applicable separately
		// i.e. 5 seconds for name, 5 seconds for id, 5 seconds for sendKeys
		driver.findElement(new ByAll(By.name("firstname"), By.id("u_0_j"), By.xpath("//input[@name='firstname']"))).sendKeys("Test");
		driver.findElement(new ByIdOrName("firstname")).sendKeys("Test");
		driver.findElement(new ByChained(By.id("u_0_i"),
				By.xpath("//div[@class='uiStickyPlaceholderInput uiStickyPlaceholderEmptyInput']"),
				By.name("firstname"))).sendKeys("Test");

	}

}
