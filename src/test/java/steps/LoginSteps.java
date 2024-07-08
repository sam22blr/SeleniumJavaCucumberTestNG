package steps;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import base.BaseTest;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.LoginPage;
import utilities.Common;

public class LoginSteps {

	private WebDriver driver = BaseTest.getDriver();
	private LoginPage loginPage = new LoginPage(driver);

	@Given("I am on the login page")
	public void the_user_is_on_the_login_page() throws IOException {
		Common.goToUrl(driver);
		CommonSteps.captureScreenshot("After navigating to Url");  
	}

	@When("^I enter (.*) and (.*)$")
	public void i_enter_abc321_abcd_com_and_a_a(String userName, String password) throws IOException {
		loginPage.enterUsername(userName);
		loginPage.enterPassword(password);
		CommonSteps.captureScreenshot("User entered login information");
	}

	@When("^I click on login button$")
	public void i_click_on_login_button() throws IOException {
		loginPage.clickLogin();
        CommonSteps.captureScreenshot("Clicked on login button");
	}

	@Then("^I see the (.*)$")
	public void i_see_the_message(String messagetext) throws IOException {
		String message = loginPage.waitForMessage();
		CommonSteps.captureScreenshot("Got login message");
		Assert.assertEquals(message, messagetext);
		loginPage.waitForMessageToDisappear();
	}
}
