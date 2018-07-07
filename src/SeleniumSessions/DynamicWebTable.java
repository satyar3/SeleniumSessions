package SeleniumSessions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class DynamicWebTable {
	
	public static void main(String...args) throws InterruptedException
	{
		System.setProperty("webdriver.chrome.driver", "C:\\Back Up\\Project Work\\Learning Stuffs\\Selenium Training By Jitendra\\Self Study\\Tools\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("http://www.freecrm.com");
		Thread.sleep(25000);
		driver.switchTo().frame("mainpanel");
		String namevalue = "Tom Peter";
		String namexpath = "//a[text()="+"\""+namevalue+"\""+"]";
		System.out.println(driver.findElement(By.xpath(namexpath)).getText());
		driver.findElement(By.xpath("//a[text()='"+namevalue+"']//preceding::td[1]//input[@type='checkbox' and @name='contact_id']")).click();
	}
	
}
