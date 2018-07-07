package SeleniumSessions;

import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;

public class HandlingCalenderConcept {
	
	public static void main(String...args) throws InterruptedException
	{
		System.setProperty("webdriver.chrome.driver", "C:\\Back Up\\Project Work\\Learning Stuffs\\Selenium Training By Jitendra\\Self Study\\Tools\\chromedriver_win32\\chromedriver.exe");
		
		ChromeOptions options = new ChromeOptions();
	    options.setExperimentalOption("useAutomationExtension", false);
	    WebDriver driver = new ChromeDriver(options);
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("https://www.freecrm.com/index.html");
		
		driver.findElement(By.name("username")).sendKeys("satyarTest");
		driver.findElement(By.name("password")).sendKeys("test123");
		
		Thread.sleep(1000);
		driver.findElement(By.xpath("//input[@type='submit']")).click();
		
		driver.switchTo().frame("mainpanel");
		
		String date = "31-September-2017";
		String datearray[] = date.split("-");
		String date_day = datearray[0];
		String date_month = datearray[1];
		String date_year = datearray[2];
		
		WebElement elementmonth = driver.findElement(By.name("slctMonth"));				
		Select month = new Select(elementmonth);
		month.selectByVisibleText(date_month);
		
		WebElement elementyear = driver.findElement(By.name("slctYear"));
		Select year = new Select(elementyear);
		year.selectByVisibleText(date_year);
		
		//*[@id='crmcalendar']/table/tbody/tr[2]/td/table/tbody/tr[2]/td[1]
		//*[@id='crmcalendar']/table/tbody/tr[2]/td/table/tbody/tr[2]/td[2]
		//*[@id='crmcalendar']/table/tbody/tr[2]/td/table/tbody/tr[2]/td[7]
		
		
		//*[@id='crmcalendar']/table/tbody/tr[2]/td/table/tbody/tr[3]/td[1]
		//*[@id='crmcalendar']/table/tbody/tr[2]/td/table/tbody/tr[3]/td[7]
		
		//*[@id='crmcalendar']/table/tbody/tr[2]/td/table/tbody/tr[6]/td[1]
		//*[@id='crmcalendar']/table/tbody/tr[2]/td/table/tbody/tr[6]/td[7]
		
		String beforexpath = "//*[@id='crmcalendar']/table/tbody/tr[2]/td/table/tbody/tr[";
		String afterxpath = "]/td[";
		boolean flag = false;
		String datefound = null;
		
		for(int row = 2; row <=7 ; row++)
		{
			for(int col = 1; col<=7; col++)			
			{	
				if(row == 7)
				{
					System.out.println("wait maddi");
				}
				
				try
				{
					datefound = driver.findElement(By.xpath(beforexpath+row+afterxpath+col+"]")).getText();
				}
				catch(org.openqa.selenium.NoSuchElementException e)
				{
					System.out.println("Enter correct date");
					flag = true;
					break;
				}
				System.out.println(datefound);
				if(datefound.equals(date_day))
				{
					System.out.println("data found");
					driver.findElement(By.xpath(beforexpath+row+afterxpath+col+"]")).click();
					flag = true;
					break;
				}				
			}
			if(flag == true)
			{
				break;
			}
		}
	}

}
