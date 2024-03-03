package pageFactory;


import java.awt.image.BufferedImage;
import java.awt.image.RenderedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.imageio.ImageIO;

import org.apache.pdfbox.Loader;
import org.apache.pdfbox.cos.COSName;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.graphics.PDXObject;
import org.apache.pdfbox.pdmodel.graphics.form.PDFormXObject;
import org.apache.pdfbox.rendering.ImageType;
import org.apache.pdfbox.rendering.PDFRenderer;
import org.apache.pdfbox.text.PDFTextStripper;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import io.opentelemetry.exporter.logging.SystemOutLogExporter;

public class Page1 {
	final WebDriver driver;
		//Constructor, as every page needs a Webdriver to find elements
		public Page1(WebDriver driver){
				this.driver=driver;
			
		}
		//Locating the password text box
		@FindBy(xpath="(//input[@name='btnK'])[2]")
		WebElement btn_search;
		
		@FindBy(css="textarea[name=q]")
		WebElement txt_Search;
		
		@FindBy(xpath="//span[text()=\"Top stories\"]")
		WebElement res_text;
		
		
		//Method that performs login action using the web elements
		public void LogIn_Action(String uName) {
			driver.get("https://www.google.com");
			txt_Search.sendKeys(uName);
			btn_search.click();
		}

		public void PDFTextRead() throws IOException{
			File f = new File ("C:\\Users\\Admin\\Desktop\\text-and-images.pdf");
			PDDocument doc= Loader.loadPDF(f);
			PDFTextStripper strip = new PDFTextStripper();
			strip.setSortByPosition(true);
			strip.setStartPage(1);
			strip.setEndPage(2);
			String text = strip.getText(doc); // Reading the entire PDF text
			String lines[] = text.split("\r\n|\r|\n");
			int counter =0;
			for (String x : lines) {
				System.out.println( "count  " + counter + "    " + x ); //Reading line by line
				counter++;
			}

			doc.close();
			System.out.println(text);
//Final

		}
	}
