package utilities;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Common {

	public static WebElement visibilityOfElementLocated(WebDriver driver, By by){
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		return wait.until(ExpectedConditions.visibilityOfElementLocated(by));
	}
		
	public static WebElement visibilityOf(WebDriver driver, WebElement ele){
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		return wait.until(ExpectedConditions.visibilityOf(ele));
	}
	
	public static Boolean invisibilityOf(WebDriver driver, WebElement ele){
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		return wait.until(ExpectedConditions.invisibilityOf(ele));
	}
	
	public static Boolean invisibilityOfElementLocated(WebDriver driver, By by){
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		return wait.until(ExpectedConditions.invisibilityOfElementLocated(by));
	}
	
	public static List<WebElement> visibilityOfAllElementsLocatedBy(WebDriver driver, By by){
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		return wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(by));
	}
	
	public static void goToUrl(WebDriver driver) {
		String url = ConfigReader.getProperty("url");
		driver.get(url);
	}
	
	
}
