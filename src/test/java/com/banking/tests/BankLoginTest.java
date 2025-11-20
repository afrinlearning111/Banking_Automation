package com.banking.tests;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;


public class BankLoginTest {
	
	
	@Test
	public void logintoBankApplication()
	{
		 // Setup Chrome driver
		
        WebDriver driver = new ChromeDriver();
	
	    //Step1 - Open Banking site
        driver.get("https://demo.applitools.com/");
        driver.manage().window().maximize();

        //Step2 - Enter Username
        driver.findElement(By.id("username")).sendKeys("Test111");
        
        //Step3- Enter Password
        driver.findElement(By.id("password")).sendKeys("TesterTestTesting");
        
        //Step4 - Click Login Button
        driver.findElement(By.xpath("//*[@id=\"log-in\"]")).click();
        
        //Step5 - Validate Title
       String title = driver.getTitle();
       System.out.println("Dashboard title is :" + title);
       
       //Step6 -Close Browser
       driver.quit();
        
	
	
	
	
	
	
	}

}
