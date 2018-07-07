package SeleniumSessions;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class JavaScriptExecutorConcept {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		System.setProperty("webdriver.chrome.driver", "C:\\Back Up\\Project Work\\Learning Stuffs\\Selenium Training By Jitendra\\Self Study\\Tools\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();//launching chrome
		
		driver.get("https://www.freecrm.com");//entering url
				
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
			
		//driver.manage().timeouts().pageLoadTimeout(20000, TimeUnit.SECONDS);
		//driver.manage().timeouts().implicitlyWait(20000, TimeUnit.SECONDS);
		
		driver.findElement(By.xpath("//input[@name='username']")).sendKeys("satyarTest");
		driver.findElement(By.xpath("//input[@name='password']")).sendKeys("test1234");
				
		WebElement loginBtn = driver.findElement(By.xpath("//input[@type='submit']"));
		WebElement forgotpass = driver.findElement(By.xpath("//a[contains(text(),'Forgot Password')]"));
		
		//executeScript() is used to execute JavaScript Code
		//getCSSValue() will give the background color of any element
		
		flash(loginBtn, driver); //Highlight button
		drawBorder(loginBtn,driver);//Highlight Border
		
		//Take Screen-shot
		File src = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(src, new File("C:\\Back Up\\Google.png"));
        
        //Genrate Alert
        //generateAlert(driver,"There is an issue with log in button");
        
        //click on element by JavaScript
        //clickElementByJavaScript(loginBtn, driver);
        
        //driver.navigate().refresh();
        
        //Refreshing page by JS
        //refreshPageByJS(driver);
        
        //Return title
        System.out.println(getTitleByJS(driver));
        
        //Return Page Text
        System.out.println(getPageTextByJS(driver));
        
        //Scroll Down
        //scrollDownByJS(driver);
        
        //scroll until the element is visible
        scrollIntoVIew(forgotpass, driver);
	}
	
	public static void flash(WebElement element, WebDriver driver)
	{
		JavascriptExecutor js = ((JavascriptExecutor) driver);
		String bgcolor = element.getCssValue("backgroungColor");
		for(int i = 0; i<20; i++)
		{
			changeColor("rgb(0,200,0)",element, driver);
			changeColor(bgcolor,element, driver);
		}
	}
	public static void changeColor(String color, WebElement element, WebDriver driver)
	{
		JavascriptExecutor js = ((JavascriptExecutor) driver);
		js.executeScript("arguments[0].style.backgroundColor = '"+color+"'", element);
		
		try
		{
			Thread.sleep(20);
		}
		catch(InterruptedException e)
		{
			
		}
	}
	public static void drawBorder(WebElement element, WebDriver driver)
	{
		JavascriptExecutor js = ((JavascriptExecutor) driver);
		js.executeScript("arguments[0].style.border='3px solid red'", element);
	}
	public static void generateAlert(WebDriver driver, String message)
	{
		JavascriptExecutor js = ((JavascriptExecutor) driver);
		js.executeScript("alert('"+message+"')");
	}
	public static void clickElementByJavaScript(WebElement element, WebDriver driver)
	{
		JavascriptExecutor js = ((JavascriptExecutor) driver);
		js.executeScript("arguments[0].click();", element);
	}
	public static void refreshPageByJS(WebDriver driver)
	{
		JavascriptExecutor js = ((JavascriptExecutor) driver);
		js.executeScript("history.go(0)");
	}
	public static String getTitleByJS(WebDriver driver)
	{
		JavascriptExecutor js = ((JavascriptExecutor) driver);
		String title = js.executeScript("return document.title;").toString();
		return title;
	}
	public static String getPageTextByJS(WebDriver driver)
	{
		JavascriptExecutor js = ((JavascriptExecutor) driver);
		String pagetext = js.executeScript("return document.documentElement.innerText;").toString();
		return pagetext;
	}
	public static void scrollDownByJS(WebDriver driver)
	{
		JavascriptExecutor js = ((JavascriptExecutor) driver);
		js.executeScript("window.scrollTo(0,document.body.scrollHeight)");
	}
	public static void scrollIntoVIew(WebElement element,WebDriver driver)
	{
		JavascriptExecutor js = ((JavascriptExecutor) driver);
		js.executeScript("arguments[0].scrollIntoView(true);", element);
	}
}
