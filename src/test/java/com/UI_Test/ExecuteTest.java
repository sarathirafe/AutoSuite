package com.UI_Test;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import com.UI_Automation.DriverFactory;
import pageFactory.Page1;
import pageFactory.Page2;

public class ExecuteTest extends DriverFactory {
		
	@Test(invocationCount = 1,threadPoolSize = 4)
	public void searchTest1() throws InterruptedException, IOException {
		Page1 p = PageFactory.initElements(getDriver(), Page1.class);
		p.LogIn_Action("partha");
		p.PDFTextRead();
	}	

	//@Test
	public void searchTest2() throws InterruptedException {		
		Page2 p = new Page2(getDriver());
		p.LogIn_Action("Raje");
		p.result();
	}
	

	//@Test
	public void searchTest3() throws InterruptedException {		
		getDriver().get("https://www.google.com");
		getDriver().manage().window().maximize();
		getDriver().findElement(By.name("q")).sendKeys("UFT Training");
		getDriver().findElement(By.name("q")).sendKeys(Keys.ENTER);
		Thread.sleep(5000);		
	}
	
	//@Test
	public void searchTest4() throws InterruptedException {	
		getDriver().get("https://www.google.com");
		getDriver().manage().window().maximize();
		getDriver().findElement(By.name("q")).sendKeys("Jenkins Training");
		getDriver().findElement(By.name("q")).sendKeys(Keys.ENTER);
		Thread.sleep(5000);	
	}

}
