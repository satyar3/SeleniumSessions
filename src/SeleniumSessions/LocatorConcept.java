package SeleniumSessions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class LocatorConcept {
	
	public static void main(String...args) throws InterruptedException
	{
		System.setProperty("webdriver.chrome.driver","C:\\Back Up\\Project Work\\Learning Stuffs\\Selenium Training By Jitendra\\Self Study\\Tools\\chromedriver_win32\\chromedriver.exe");
		WebDriver wd = new ChromeDriver();
		wd.get("https://reg.ebay.com/reg/PartialReg?siteid=0&UsingSSL=1&co_partnerId=2&errmsg=&src=&ru=https%3A%2F%2Fwww.ebay.com%2F&signInUrl=https%3A%2F%2Fwww.ebay.com%3A443%2Fws%2FeBayISAPI.dll%3FSignIn%26ru%3Dhttps%253A%252F%252Fwww.ebay.com%252F&rv4=1");
		
		//total 8 locators present
		
		//1.xPath locator --2 shouldn't come in heirarchy based i.e absolute path
		wd.findElement(By.xpath("//*[@id='firstname']")).sendKeys("Tom"); //example of relative xpath
		wd.findElement(By.xpath("//*[@id='lastname']")).sendKeys("Peter");
		wd.findElement(By.xpath("//*[@id='email']")).sendKeys("testmail@test.com");
		wd.findElement(By.xpath("//*[@id='PASSWORD']")).sendKeys("testmail@test.com");
		
		//2.ID locator	(1st Priority)
		/*wd.findElement(By.id("firstname")).sendKeys("Tom");;
		wd.findElement(By.id("lastname")).sendKeys("Peter");*/
		
		//3.Name locator -- 3
		//wd.findElement(By.name("firstname")).sendKeys("Tom");
		//wd.findElement(By.name("lastname")).sendKeys("Peter");
		
		//4.LinkText -- only for links
		//wd.findElement(By.linkText("User Privacy Notice")).click();
		
		//5.PartialLinkText  >>> Not useful
		//wd.findElement(By.partialLinkText("Privacy")).click();
		
		//6.CSSSelector locator -- 2
		//if id is there  -- #{id}
		//if class is there -- #{class}
		//wd.findElement(By.cssSelector("#lastname")).sendKeys("testmail@test.com");
		//wd.findElement(By.cssSelector("#lastname")).sendKeys("testmail@test.com");
		//wd.findElement(By.cssSelector("#suggestion")).sendKeys("testmail@test.com");
		
		//7.Classname locator >> Not useful as class name can be duplicate
		//wd.findElement(By.className("test")).click();
		
		//8.Tagname locator
		
	}

}
