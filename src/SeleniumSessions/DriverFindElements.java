package SeleniumSessions;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class DriverFindElements {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.setProperty("webdriver.chrome.driver", "C:\\Back Up\\Project Work\\Learning Stuffs\\Selenium Training By Jitendra\\Self Study\\Tools\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.freecrm.com");
		
		//get the total count of links on the page
		//get the text of each link of the page
		
		List<WebElement> totallinklist = driver.findElements(By.tagName("a"));
		System.out.println(totallinklist.size());
		
		for (int i = 0; i<totallinklist.size(); i++)
		{
			System.out.println(totallinklist.get(i).getText());
		}
	}

}
