package com.UI_Automation;

import java.net.MalformedURLException;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

public class DriverFactory {

	
	  protected static ThreadLocal<WebDriver> threadLocalDriver = new ThreadLocal<WebDriver>();
	  
	  @Parameters({"browser"})
	  @BeforeMethod 
	  public static void setDriver(@Optional("firefox") String browserType)throws MalformedURLException 
	  {
		  WebDriver driver = BrowserUtility.createDriverInstance(browserType);
		  threadLocalDriver.set(driver);
	  }
	  
	  public static WebDriver getDriver() 
	  {
		  return threadLocalDriver.get();
	  }
	  
	  @AfterMethod public void removeDriver() 
	  { 
		  getDriver().quit();
	      threadLocalDriver.remove(); }
	 

}
