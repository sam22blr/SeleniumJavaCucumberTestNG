package steps;

import java.io.IOException;

import org.apache.commons.io.FileUtils;

import base.BaseTest;
import io.cucumber.java.Scenario;
import utilities.ScreenshotUtil;
import utilities.StepListener;

public class CommonSteps {
	
	public static void captureScreenshot(String stepDescription) throws IOException {
		Scenario scenario = StepListener.getCurrentScenario();

		byte[] fileContent = FileUtils
				.readFileToByteArray(ScreenshotUtil.takeScreenshot(BaseTest.getDriver(), stepDescription));
		scenario.attach(fileContent, "image/png", stepDescription);

	}

}
