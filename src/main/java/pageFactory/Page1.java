package pageFactory;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

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
		public void LogIn_Action(String uName) throws InterruptedException{
			driver.get("https://www.google.com");
			txt_Search.sendKeys(uName);
			btn_search.click();
		}
		
		public void result(){
			System.out.println("******Thread name*********" + Thread.currentThread().getId());
		}
	}
