package ObjectRepository;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ReadProprtyFile {

	static WebDriver driver;
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		Properties prop = new Properties();
		FileInputStream ip = new FileInputStream("C:\\Back Up\\Project Work\\Learning Stuffs\\Selenium Training By Jitendra\\Self Study\\Programs\\SeleniumSessions\\src\\ObjectRepository\\config.properties");
		prop.load(ip);
		
		System.out.println(prop.getProperty("name"));
		System.out.println(prop.getProperty("age"));
		
		String url = prop.getProperty("URL");
		System.out.println(prop.getProperty("URL"));
		
		String browsername = prop.getProperty("browser");
		System.out.println(prop.getProperty("browser"));
		
		if(browsername.equals("chrome"))
		{		
			System.setProperty("webdriver.chrome.driver", "C:\\Back Up\\Project Work\\Learning Stuffs\\Selenium Training By Jitendra\\Self Study\\Tools\\chromedriver_win32\\chromedriver.exe");
			driver = new ChromeDriver();
		}
		else if(browsername.equals("firefox"))
		{
			//firefox code
		}
		
		driver.get(url);
		driver.findElement(By.xpath(prop.getProperty("fName_xpath"))).sendKeys(prop.getProperty("firstName"));
	}

}