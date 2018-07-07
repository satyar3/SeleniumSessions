package SeleniumSessions;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;

public class HTMLUnitDriverConcept {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.setProperty("webdriver.chrome.driver", "C:\\Back Up\\Project Work\\Learning Stuffs\\Selenium Training By Jitendra\\Self Study\\Tools\\chromedriver_win32\\chromedriver.exe");
		
		//HtmlUnitDriver is not part of Selenium 3.X
		//To use this we need to download HtmlUnitDriver JAR file.
		
		//Advantages
		//1. Testing is happening behind the scene i.e no browser launching
		//2. Very fast i.e. execution if test cases is very fast
		//3. Not suitable for action class i.e mouse movement, clicks, drag and drop
		//4. Ghost driver -- Headless browser
			//HtmlUnitDriver with JAVA
			//Phantom JS -- with JavaScript
		
		WebDriver driver = new HtmlUnitDriver();
		//WebDriver driver = new ChromeDriver();//launching chrome
		
		driver.get("https://www.freecrm.com");//entering url
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		
		driver.manage().timeouts().pageLoadTimeout(20000, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(20000, TimeUnit.SECONDS);
		
		System.out.println("Before Login page title is : "+driver.getTitle());
		
		driver.findElement(By.xpath("//input[@name='username']")).sendKeys("satyarTest");
		driver.findElement(By.xpath("//input[@name='password']")).sendKeys("test123");
		
		driver.findElement(By.xpath("//input[@type='submit']")).click();
		
		System.out.println("After login page title is : "+driver.getTitle());
		
		

	}

}
