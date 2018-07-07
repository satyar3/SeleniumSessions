package SeleniumSessions;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class ImplicitWaitConcept {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.setProperty("webdriver.chrome.driver", "C:\\Back Up\\Project Work\\Learning Stuffs\\Selenium Training By Jitendra\\Self Study\\Tools\\chromedriver_win32\\chromedriver.exe");
		
		ChromeOptions options = new ChromeOptions();
	    options.setExperimentalOption("useAutomationExtension", false);
	    WebDriver driver = new ChromeDriver(options);
		driver.get("https://jqueryui.com/droppable/");
		
		//WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		
		
		//Dynamic wait and not static in nature like Thread.sleep(1000) --- hard wait
		driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS); //page timeout time
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS); //applicable for all the elements available on the page
		
	}

}
