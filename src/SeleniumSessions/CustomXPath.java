package SeleniumSessions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class CustomXPath {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//Absolute xpath is not recommended
		//1.performce is slow
		//2.not reliable
		//3.developer can change it anytime
		
		System.setProperty("webdriver.chrome.driver", "C:\\Back Up\\Project Work\\Learning Stuffs\\Selenium Training By Jitendra\\Self Study\\Tools\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.freecrm.com");
		
		//driver.findElement(By.xpath("//button[@class='btn']")).click();
		driver.findElement(By.xpath("//button[contains(@class,'btn'])")).click();
		
		//Dynamic ID will be handled by contains ID_ i.e. matching text
		driver.findElement(By.xpath("//button[contains(@class,'btn'])")).click();
		//driver.findElement(By.xpath("//button[starts-with(@class,'btn'])")).click();
		//driver.findElement(By.xpath("//button[ends-with(@class,'btn'])")).click();
		
		//Specially for links
		//all the liks starts with <a> tab
		driver.findElement(By.xpath("//a[contains(text(),'My Account')")).click();;
	}

}