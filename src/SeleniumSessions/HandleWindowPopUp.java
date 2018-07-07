package SeleniumSessions;

import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import javax.naming.directory.DirContext;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class HandleWindowPopUp {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		//1. alerts pop up - javascript pop up -- use Alert API (accept, dismiss)
		//2. file upload pop up -- Browser button (type = file, sendKeys)
		//3. Browser window pop up -- WindowsHandler API (getWindowHandles())
		
		System.setProperty("webdriver.chrome.driver", "C:\\Back Up\\Project Work\\Learning Stuffs\\Selenium Training By Jitendra\\Self Study\\Tools\\chromedriver_win32\\chromedriver.exe");		
		
		ChromeOptions options = new ChromeOptions();
	    options.setExperimentalOption("useAutomationExtension", false);
	    
	    WebDriver driver = new ChromeDriver(options);
		
	    driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		
		driver.get("http://www.popuptest.com/goodpopups.html");
		
		driver.manage().timeouts().pageLoadTimeout(5000, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(5000, TimeUnit.SECONDS);

		driver.findElement(By.linkText("Good PopUp #3")).click();
		
		Set<String> handler = driver.getWindowHandles();//set doesn't store value on basis of index
		
		Iterator<String> it = handler.iterator();
		
		String parentwindowid = it.next();		
		System.out.println("Parent window id :"+parentwindowid);
		
		String childwindowid1 = it.next();		
		System.out.println("Child window id :"+childwindowid1);
		
		driver.switchTo().window(childwindowid1);
		
		System.out.println("Child window Title :"+driver.getTitle());
		
		Thread.sleep(3000);
		driver.close();
		
		driver.switchTo().window(parentwindowid);
		System.out.println("Parent window Title :"+driver.getTitle());
		
	}

}
