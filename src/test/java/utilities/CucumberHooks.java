package utilities;

import io.cucumber.java.After;
import io.cucumber.java.AfterAll;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.BeforeStep;
import io.cucumber.java.Scenario;

public class CucumberHooks {

	@AfterAll
	public static void before_or_after_all() {

	}

	@Before
	public void beforeScenario(Scenario scenario) {
        StepListener.setCurrentScenario(scenario); // Set the current scenario

	}

	@After
	public void afterScenario(Scenario scenario) {
		DriverGuard.quitDriver();
	}

	@BeforeStep
	public void beforeStep(Scenario scenario) {
		
	}
	

	@AfterStep
	public void afterStep(Scenario scenario) {
		
	}
}
