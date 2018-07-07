package SeleniumSessions;

import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class FreeCRMSignUp {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		System.setProperty("webdriver.chrome.driver", "C:\\Back Up\\Project Work\\Learning Stuffs\\Selenium Training By Jitendra\\Self Study\\Tools\\chromedriver_win32\\chromedriver.exe");
		
		ChromeOptions options = new ChromeOptions();
	    options.setExperimentalOption("useAutomationExtension", false);
	    WebDriver driver = new ChromeDriver(options);
		
		//WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.freecrm.com/index.html");
				
		Thread.sleep(6000);
		driver.findElement(By.xpath("//button[@type='button' and text()='Sign Up']")).click();
		//WebElement webelement = driver.findElement(By.xpath("//button[@type='button' and text()='Sign Up']"));
		//Actions actions = new Actions(driver);
		//actions.moveToElement(webelement).click().perform();
		
		Select select = new Select(driver.findElement(By.id("payment_plan_id")));
		select.selectByVisibleText("Free Edition");
		
		driver.findElement(By.name("first_name")).sendKeys("TestFname");
		driver.findElement(By.name("surname")).sendKeys("TestLname");
		driver.findElement(By.name("email")).sendKeys("Test@mail.com");
		driver.findElement(By.name("email_confirm")).sendKeys("Test@mail.com");
		driver.findElement(By.xpath("//input[@name='username']")).sendKeys("Test123");
		driver.findElement(By.xpath("//input[@name='password']")).sendKeys("Test@mail.com");
		driver.findElement(By.xpath("//input[@name='passwordconfirm']")).sendKeys("Test@mail.com");
		driver.findElement(By.xpath("//input[@name='agreeTerms']")).click();
		driver.findElement(By.xpath("//button[@id='submitButton']")).click();
		
		Alert alert = driver.switchTo().alert();
		String alerttext = driver.switchTo().alert().getText();
		alert.accept();
		
		/*if(alerttext.contains("This username is already in use by another user. Please select a different username."))
		{
			driver.findElement(By.xpath("//input[@name='username']")).sendKeys("Test123Yantra");
		}*/
		
		List<WebElement> elements = driver.findElements(By.tagName("input"));
		int totalfields = elements.size();
		System.out.println(totalfields);
		
		Iterator it = elements.iterator();
		

		for (int i = 0; i<elements.size(); i++)
		{
			System.out.println(elements.get(i).getText());
		}
		/*	int i = 0;
		 * while(it.hasNext())
		{
			System.out.println(elements.get(i).getText());
			i++;
		}*/
		
		//driver.findElement(By.xpath("//button[@id='submitButton']")).click();
		System.out.println("Script execution completed");
		
	}

}
