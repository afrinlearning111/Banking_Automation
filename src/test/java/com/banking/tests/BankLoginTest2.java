package com.banking.tests;

import Base.Basetest;
import Reports.ExtentTestManager;
import com.aventstack.extentreports.Status;
import org.testng.Assert;
import org.testng.annotations.Test;
import com.banking.pages.LoginPage;
import com.banking.pages.DashboardPage;

public class BankLoginTest2 extends Basetest {

	@Test
	public void verifyBankLogin() {
		LoginPage login = new LoginPage(driver);
		
		try {
			driver.wait(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

	    ExtentTestManager.getTest().log(Status.INFO, "Entering username");
	    ExtentTestManager.getTest().log(Status.INFO, "Entering password");
		

		DashboardPage dashboard = login.login("testuser", "password123");
		
		try {
			driver.wait(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		String actualMsg = dashboard.getWelcomeMessage();

		Assert.assertEquals(actualMsg, "Welcome Test User", "Login verification failed!");
		
	    ExtentTestManager.getTest().log(Status.INFO, "Login verified successfully");

	}
}
