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
	
	@FindBy(how = How.CSS, using = "#userPassword")
	WebElement userPassword;
	
	@FindBy(how = How.CSS, using = "#login")
	WebElement loginBtn;
	
	
	@FindBy(how = How.CSS, using = "#toast-container")
	WebElement toastContainer;
	

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void enterUsername(String username) {
        Common.visibilityOf(driver, userEmail).sendKeys(username);
    }

    
    public void enterPassword(String password) {
        Common.visibilityOf(driver, userPassword).sendKeys(password);
    }
    
    public void clickLogin() {
        Common.visibilityOf(driver, loginBtn).click();;
    }
    
    public String waitForMessage() {
        return Common.visibilityOf(driver, toastContainer).getText();
    }
    
    public Boolean waitForMessageToDisappear() {
        return Common.invisibilityOf(driver, toastContainer);
    }
    
    public void login(String username, String password) {
        enterUsername(username);  
        enterPassword(password);
        clickLogin();
    }
}
