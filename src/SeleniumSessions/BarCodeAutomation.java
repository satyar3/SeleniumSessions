package SeleniumSessions;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;

import javax.imageio.ImageIO;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.google.zxing.BinaryBitmap;
import com.google.zxing.LuminanceSource;
import com.google.zxing.MultiFormatReader;
import com.google.zxing.NotFoundException;
import com.google.zxing.Result;
import com.google.zxing.client.j2se.BufferedImageLuminanceSource;
import com.google.zxing.common.HybridBinarizer;

public class BarCodeAutomation
{

	public static void main(String[] args) throws IOException, NotFoundException
	{
		// https://mvnrepository.com/artifact/com.google.zxing/javase
		
		System.setProperty("webdriver.chrome.driver", "C:\\Back Up\\Project Work\\Learning Stuffs\\Selenium Training By Jitendra\\Self Study\\Tools\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://barcode.tec-it.com/en");
		
		String barcodeURL = driver.findElement(By.tagName("img")).getAttribute("src");
		//System.out.println(barcodeURL);
		
		URL url = new URL(barcodeURL);
		
		BufferedImage buffIMG = ImageIO.read(url);
		
		LuminanceSource luminanceSource = new BufferedImageLuminanceSource(buffIMG);
		BinaryBitmap binaryBitmap = new BinaryBitmap(new HybridBinarizer(luminanceSource));
		
		Result result = new MultiFormatReader().decode(binaryBitmap);
		System.out.println(result.getText());
	}

	
	//captcha automation
	//image compare
	
	
}
