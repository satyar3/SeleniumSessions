package fileDownloader;

import java.io.File;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class DownloadFileConcept {
	
	WebDriver driver;
	File folder;

	
	@SuppressWarnings("deprecation")
	@BeforeMethod
	public void setUp()
	{
		folder = new File(UUID.randomUUID().toString()); //File will have random id
		folder.mkdir();
		
		//chrome:		
		System.setProperty("webdriver.chrome.driver", "C:\\Back Up\\Project Work\\Learning Stuffs\\Selenium Training By Jitendra\\Self Study\\Tools\\chromedriver_win32\\chromedriver.exe");
		ChromeOptions options = new ChromeOptions();
		
		Map<String, Object> prefs = new HashMap<String, Object>();		
		prefs.put("profile.default_content_settings.popups",0); //Means blocking the pop up
		prefs.put("download.default_directory", folder.getAbsolutePath());		
		
		options.setExperimentalOption("prefs", prefs);
		
		DesiredCapabilities cap = DesiredCapabilities.chrome();
		cap.setCapability(ChromeOptions.CAPABILITY, options);		
		
		driver = new ChromeDriver(cap);
	}
	
	@SuppressWarnings("unused")
	@Test
	public void downloadFileTest() throws InterruptedException
	{
		driver.get("http://the-internet.herokuapp.com/download");
		driver.findElement(By.linkText("some-file.txt")).click();
		
		//Wait for 2 seconds to download the file
		Thread.sleep(2000);
		File listOfFiles[] = folder.listFiles();
		//make sure that directory is not empty
		//Assert.assertEquals(listOfFiles.length, is(not(0)));
		Assert.assertTrue(listOfFiles.length>0);
		
		for(File file : listOfFiles)
		{
			//make sure that downloaded file is not empty
			//Assert.assertEquals(file.length(), is(not((long) 0)));
			Assert.assertTrue(listOfFiles.length>0);
		}
	}
	
	@AfterMethod
	public void tearDown()
	{
		driver.quit();
		for(File file: folder.listFiles())
		{
			file.delete();
		}
		folder.delete();
	}
}
