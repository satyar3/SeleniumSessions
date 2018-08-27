package SeleniumSessions;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class BrokenLinkTest {

	public static void main(String[] args) throws InterruptedException, MalformedURLException, IOException {
		
		System.setProperty("webdriver.chrome.driver", "C:\\Back Up\\Project Work\\Learning Stuffs\\Selenium Training By Jitendra\\Self Study\\Tools\\chromedriver_win32\\chromedriver.exe");		
		WebDriver driver = new ChromeDriver();
		
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().deleteAllCookies();
		
		driver.get("https://www.freecrm.com");
		driver.findElement(By.name("username")).sendKeys("satyaRTest");
		driver.findElement(By.name("password")).sendKeys("test123");
		
		Thread.sleep(2000);
		
		driver.findElement(By.xpath("//input[@type='submit']")).click();
		driver.switchTo().frame(1);
		
		//1.Find all the <a> tag
		List<WebElement> linklist = driver.findElements(By.tagName("a"));
		linklist.addAll(driver.findElements(By.tagName("img")));		
		System.out.println(linklist.size());
		
		List<WebElement> activeelement = new ArrayList<WebElement>();
		
		
		//2. iterate through the list: exclude all the links /images - doesn't have any attribute
		for(int i = 0; i<linklist.size();i++)
		{
			if(linklist.get(i).getAttribute("href")!=null && (! linklist.get(i).getAttribute("href").contains("javascript")))
			{
				activeelement.add(linklist.get(i));
			}
		}
		
		//Get the size of activeelement
		System.out.println(activeelement.size());
		
		//3. Check the activeelement using httpurlconnection API
		for(int i = 0; i< activeelement.size();i++)
		{
			HttpURLConnection connection = (HttpURLConnection) new URL(activeelement.get(i).getAttribute("href")).openConnection();
			connection.connect();
			String response = connection.getResponseMessage();
			connection.disconnect();
			System.out.println(activeelement.get(i).getAttribute("href")+"--->"+response);
		}
	}

}
