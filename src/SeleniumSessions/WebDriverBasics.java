package SeleniumSessions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class WebDriverBasics {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//1.firefox browser
		//gecko driver
		
		//crate object of gecko driver
		//to launch gecko driver we need firefox driver class
		
		//System.setProperty("webdriver.gecko.driver", "C:\\Back Up\\Project Work\\Learning Stuffs\\Selenium Training By Jitendra\\Self Study\\Tools\\geckodriver-v0.21.0-win64\\geckodriver.exe");
		//WebDriver firefoxdriver = new FirefoxDriver(); //firefox will be launched
		//firefoxdriver.get("http://www.google.com");
		
		//2.google chrome
		System.setProperty("webdriver.chrome.driver", "C:\\Back Up\\Project Work\\Learning Stuffs\\Selenium Training By Jitendra\\Self Study\\Tools\\chromedriver_win32\\chromedriver.exe");
		WebDriver chromedriver = new ChromeDriver();//launching chrome
		chromedriver.get("https://www.google.com");//entering url
		
		String webtitle = chromedriver.getTitle();//getting the title of the web page
		System.out.println(webtitle);
		
		System.out.println(chromedriver.getCurrentUrl());
		//System.out.println(chromedriver.getPageSource());
		
		//validating the title with expected title
		if(webtitle.equals("Google"))
		{
			System.out.println("Correct title");
		}
		else
		{
			System.out.println("incorrect title");
		}
		
		chromedriver.quit();//to quit the browser 
	}

}
