package SeleniumSessions;

import java.io.File;
import java.util.concurrent.TimeUnit;

import javax.imageio.ImageIO;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.Screenshot;
import ru.yandex.qatools.ashot.shooting.ShootingStrategies;


//<!-- https://mvnrepository.com/artifact/ru.yandex.qatools.ashot/ashot -->
//<dependency>
//    <groupId>ru.yandex.qatools.ashot</groupId>
//    <artifactId>ashot</artifactId>
//    <version>1.5.3</version>
//</dependency>


class FullPageScreenshot 
{
	public static void main(String args[]) throws Exception{
		System.setProperty("webdriver.chrome.driver","D://Chrome Driver 2.38//chromedriver_win32//chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);  
		driver.manage().window().maximize(); 
		driver.get("https://www.amazon.com");
		Thread.sleep(2000);
		Screenshot fpScreenshot = new AShot().shootingStrategy(ShootingStrategies.viewportPasting(1000)).takeScreenshot(driver);
		ImageIO.write(fpScreenshot.getImage(),"PNG",new File("D://Screen//FullPageScreenshot.png"));
		driver.quit();
	}
}