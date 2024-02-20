package com.UI_Automation;
import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.ie.InternetExplorerOptions;
import org.openqa.selenium.remote.RemoteWebDriver;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.opentelemetry.exporter.logging.SystemOutLogExporter;

public class BrowserUtility {
	public static WebDriver createDriverInstance(String browserType) throws MalformedURLException {
		WebDriver driver = null;
		//private WebDriver driver = null; - this wwill error as Illegal modifier for Parameter, only final is permitted.
		// The error is because, public and static cannot be used inside a method definition, but outside of method.
		if(browserType.equals("chrome")) {
			WebDriverManager.chromedriver().clearDriverCache().setup();
			  ChromeOptions options = new ChromeOptions();
			  options.addArguments("--remote-allow-origins=*");
			  driver = new ChromeDriver(options);
			  System.out.println(WebDriverManager.chromedriver().getBrowserPath().toString());
		}else if(browserType.equals("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			FirefoxOptions options = new FirefoxOptions();
			driver = new FirefoxDriver(options);
		}else if(browserType.equals("ie")) {
			WebDriverManager.iedriver().setup();
			InternetExplorerOptions options = new InternetExplorerOptions();
			options.introduceFlakinessByIgnoringSecurityDomains();
			options.ignoreZoomSettings();
			driver = new InternetExplorerDriver(options);
		}else if(browserType.equals("edge")) {
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
		}		
		driver.manage().deleteAllCookies();
		return driver;

	}

}