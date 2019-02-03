package SeleniumSessions;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class HandleDropBox {

	public static void main(String[] args) 
	{		
		System.setProperty("webdriver.chrome.driver", "C:\\Back Up\\Project Work\\Learning Stuffs\\Selenium Training By Jitendra\\Self Study\\Tools\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("http://facebook.com");
		
		Select select = new Select(driver.findElement(By.xpath("//*[@id='day']")));
		select.selectByVisibleText("4");
		//driver.findElement(By.xpath("//*[@id='day']")).click();	
		
		//Tells if the list is multiselect or not
		select.isMultiple();
		
		//Get all the options from the dropdown
		List<WebElement> allOptions = select.getOptions();
		
		//Get all the selected options from the dropdown
		List<WebElement> selOptions = select.getAllSelectedOptions();
	}

}
