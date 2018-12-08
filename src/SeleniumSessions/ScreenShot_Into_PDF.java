package SeleniumSessions;

import java.io.FileOutputStream;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import com.itextpdf.text.Document;
import com.itextpdf.text.Image;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;

//<!-- https://mvnrepository.com/artifact/com.itextpdf/itextpdf -->
//<dependency>
//	<groupId>com.itextpdf</groupId>
//	<artifactId>itextpdf</artifactId>
//	<version>5.0.6</version>
//</dependency>

//v  Capturing the screenshot and store it in byte[] array format.
//v  Initiate and open PDF writer.
//v  Process and set the size of image
//v  Add Image to PDF and close the File.

class GenerateScreenShotPDF
{
	public static void main(String[] args) throws Exception 
	{
		System.setProperty("webdriver.chrome.driver","D://Chrome Driver 2.38//chromedriver_win32//chromedriver.exe");	
		WebDriver driver = new ChromeDriver(); 
		driver.manage().window().maximize();
		driver.get("https://www.google.com");

		// Capture screenshot and store it in byte[] array format
		byte[] input = ((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES);
		Document document = new Document();
		String output = "D://Googel" + "Image" + ".pdf";
		FileOutputStream fos = new FileOutputStream(output);

		// Instantiate the PDF writer
		PdfWriter writer = PdfWriter.getInstance(document, fos);

		// open the pdf for writing
		writer.open();
		document.open();

		// process content into image
		Image im = Image.getInstance(input);

		//set the size of the image
		im.scaleToFit(PageSize.A4.getWidth()/2, PageSize.A4.getHeight()/2);

		// add the captured image to PDF
		document.add(im);
		document.add(new Paragraph(" "));

		//close the files and write to local system
		document.close();
		writer.close();
	}
}