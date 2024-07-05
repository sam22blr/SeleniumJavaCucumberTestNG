package runners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features = "src/test/resources/features/Login.feature", 
		glue = {"steps", "utilities", "base"}, 
				plugin = {
				        "pretty",
				        "html:reports/cucumber-reports.html",
				        "json:reports/cucumber.json",
				        "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter::",
				        "utilities.StepListener"
				    })
public class TestRunner extends AbstractTestNGCucumberTests {

	
}
