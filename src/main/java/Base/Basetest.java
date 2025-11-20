package Base;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import java.io.File;
import java.lang.reflect.Method;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import Reports.ExtentManager;
import Reports.ExtentTestManager;

public class Basetest {

	public WebDriver driver;

	@BeforeMethod
	public void setup(Method method) {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://demo.applitools.com");

		// Create a test node inside Extent Report
		ExtentTest test = ExtentManager.getInstance().createTest(method.getName());
		ExtentTestManager.setTest(test);
	}

	@AfterMethod
	public void teardown(ITestResult result) {

		if (result.getStatus() == ITestResult.FAILURE) {
			String screenshotPath = takeScreenshot(result.getName());
			ExtentTestManager.getTest().log(Status.FAIL, "Test Failed");
			ExtentTestManager.getTest().addScreenCaptureFromPath(screenshotPath);
		} else if (result.getStatus() == ITestResult.SUCCESS) {
			ExtentTestManager.getTest().log(Status.PASS, "Test Passed");
		} else {
			ExtentTestManager.getTest().log(Status.SKIP, "Test Skipped");
		}

		driver.quit();
		ExtentManager.getInstance().flush();
	}

	public String takeScreenshot(String testName) {
		try {
			TakesScreenshot ts = (TakesScreenshot) driver;
			String path = "test-output/screenshots/" + testName + ".png";
			File src = ts.getScreenshotAs(OutputType.FILE);
			File dest = new File(path);
			src.renameTo(dest);
			return path;
		} catch (Exception e) {
			return null;
		}
	}
}
