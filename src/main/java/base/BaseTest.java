package base;

import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterSuite;

import io.cucumber.java.BeforeAll;
import utilities.DriverGuard;

public class BaseTest {

	@BeforeAll
	public static void setupSuite() {
		
	}

	public void setup() {
		WebDriver driver = DriverGuard.getDriver();
		driver.manage().window().maximize();
	}

	public static void tearDown(ITestResult result) {

		DriverGuard.quitDriver();
	}

	@AfterSuite
	public void afterSuite() {

	}

	public static WebDriver getDriver() {
		return DriverGuard.getDriver();
	}

	
}
