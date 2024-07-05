package utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

public class DriverGuard {

	private static ThreadLocal<WebDriver> driver = ThreadLocal.withInitial(() -> {

		String browser = ConfigReader.getProperty("browser").toLowerCase();

		switch (browser) {
		
		case "chrome":
			return new ChromeDriver();
		case "firefox":
			return new FirefoxDriver();
		case "safari":
			return new SafariDriver();
		default:
			throw new IllegalArgumentException("Unsupported browser : " + browser);
		}

	});
	
	public static WebDriver getDriver() {
		return driver.get();
	}
	
	public static void quitDriver() {
		getDriver().quit();
		driver.remove();
	}

}
