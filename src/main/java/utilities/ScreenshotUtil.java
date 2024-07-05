package utilities;

import java.io.File;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class ScreenshotUtil {
	
	public static File takeScreenshot(WebDriver driver, String screenshotName) {

		/*String timestamp = new SimpleDateFormat("yyyyMMddHHmmss").format(new Date());
		String destinationPath = System.getProperty("user.dir") + "/screenshots/" + screenshotName + "_" + timestamp + ".png";
		*/
		return ((TakesScreenshot) driver ).getScreenshotAs(OutputType.FILE);
		
		/*try {
			FileUtils.copyFile(srcFile, new File(destinationPath));
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return destinationPath;
		*/
	}
	
	public static File takeScreenshot(String screenshotName) {
		return takeScreenshot(DriverGuard.getDriver(), screenshotName);
	}

}
