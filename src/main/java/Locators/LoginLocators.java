package Locators;

import org.openqa.selenium.By;

public class LoginLocators {

    public static By emailErrorMessage = By.cssSelector("span[for='Email']");
    public static By loginErrorMessage = By.cssSelector("div[class='validation-summary-errors'] span");
    public static  By passwordErrorMessage = By.cssSelector("div[class='validation-summary-errors'] ul li");
}
