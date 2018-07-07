package SeleniumSessions;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class BootstrapDropBoxHandle {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.setProperty("webdriver.chrome.driver", "C:\\Back Up\\Project Work\\Learning Stuffs\\Selenium Training By Jitendra\\Self Study\\Tools\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.jquery-az.com/boots/demo.php?ex=63.0_2");
		driver.manage().window().maximize();
		
		driver.findElement(By.xpath("//button[@class='multiselect dropdown-toggle btn btn-default']")).click();
		List<WebElement> elements = driver.findElements(By.xpath("//ul[@class='multiselect-container dropdown-menu']//li//a//label"));
		int elementssize = elements.size();
		
		//boolean flag = false;
		for(int i = 0; i<elementssize ; i++)
		{
			String value = elements.get(i).getText();
			
			if(value.equals("Angular"))
			{	
				String before_xpath = "//ul[@class='multiselect-container dropdown-menu']//li//a//label//input[@value='";
				String after_xpath = "']";
				System.out.println(before_xpath+value+after_xpath);
				driver.findElement(By.xpath(before_xpath+value+after_xpath)).click();				
				//flag = true;
				break;
			}
		}

	}

}
