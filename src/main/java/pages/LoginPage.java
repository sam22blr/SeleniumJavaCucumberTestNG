package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import utilities.Common;

public class LoginPage {
	private WebDriver driver;

	@FindBy(how = How.CSS, using = "#userEmail")
	WebElement userEmail;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void enterUsername(String username) {
        Common.visibilityOf(driver, userEmail).sendKeys(username);
    }

    public void login(String username, String password) {
        enterUsername(username);      
    }
}
