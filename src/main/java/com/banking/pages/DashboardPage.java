package com.banking.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class DashboardPage {

	WebDriver driver;

	By welcomeMessage = By.id("welcomeText");

	public DashboardPage(WebDriver driver) {
		this.driver = driver;
	}

	public String getWelcomeMessage() {
		return driver.findElement(welcomeMessage).getText();
	}
}
