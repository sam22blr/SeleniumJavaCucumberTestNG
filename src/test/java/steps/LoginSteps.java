package steps;

import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.WebDriver;

import base.BaseTest;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.Given;
import pages.LoginPage;
import utilities.Common;
import utilities.ScreenshotUtil;
import utilities.StepListener;

public class LoginSteps {

	private WebDriver driver = BaseTest.getDriver();
	private LoginPage loginPage = new LoginPage(driver);

	@Given("I am on the login page")
	public void the_user_is_on_the_login_page() throws IOException {
		Common.goToUrl(driver);
		captureScreenshot("After navigating to Url");
		loginPage.login("asda@asd.asd", "");
		captureScreenshot("After entering login info");
	}

	private void captureScreenshot(String stepDescription) throws IOException {
		Scenario scenario = StepListener.getCurrentScenario();

		byte[] fileContent = FileUtils
				.readFileToByteArray(ScreenshotUtil.takeScreenshot(BaseTest.getDriver(), stepDescription));
		scenario.attach(fileContent, "image/png", stepDescription);

	}
}
