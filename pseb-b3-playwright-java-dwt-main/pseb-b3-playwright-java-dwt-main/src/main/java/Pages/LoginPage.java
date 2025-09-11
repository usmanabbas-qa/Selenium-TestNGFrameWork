package Pages;

import Locators.LoginLocators;
import org.openqa.selenium.WebDriver;

public class LoginPage {

    private final WebDriver driver;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    public String getEmailErrorMessage() {
        return driver.findElement(LoginLocators.emailErrorMessage).getText().trim();
    }

    public String getPasswordErrorMessage() {
        return driver.findElement(LoginLocators.passwordErrorMessage).getText().trim();
    }

    public String getLoginErrorMessage() {
        return driver.findElement(LoginLocators.loginErrorMessage).getText().trim();
    }
}
