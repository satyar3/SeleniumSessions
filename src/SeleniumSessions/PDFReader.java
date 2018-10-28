package SeleniumSessions;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;

public class PDFReader
{

	public static void main(String[] args) throws IOException
	{
		// https://mvnrepository.com/artifact/org.apache.pdfbox/pdfbox/2.0.12
		// https://mvnrepository.com/artifact/org.apache.pdfbox/fontbox/2.0.2
		
		URL url = new URL("https://www.antennahouse.com/XSLsample/pdf/sample-link_1.pdf");
		InputStream is = url.openStream();
		BufferedInputStream bufferedInputStream = new BufferedInputStream(is);
		PDDocument document = null;
		
		document =  PDDocument.load(bufferedInputStream);
		String text  = new PDFTextStripper().getText(document);
		
		System.out.println(text);
	}

}
