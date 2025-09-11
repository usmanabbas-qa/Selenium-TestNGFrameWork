package Pages;

import Locators.RegisterLocators;
import org.openqa.selenium.WebDriver;

/**
 * Page Object for the Register Page
 */
public class RegisterPage {

    private final WebDriver driver;

    public RegisterPage(WebDriver driver) {
        this.driver = driver;
    }

    public void navigateToRegisterPage() {
        driver.get("https://demowebshop.tricentis.com/register");
    }

    public void selectGender(String gender) {
        if (gender.equalsIgnoreCase("male")) {
            driver.findElement(RegisterLocators.genderMale).click();
        } else if (gender.equalsIgnoreCase("female")) {
            driver.findElement(RegisterLocators.genderFemale).click();
        }
    }

    public void enterFirstName(String fname) {
        driver.findElement(RegisterLocators.firstName).sendKeys(fname);
    }

    public void enterLastName(String lname) {
        driver.findElement(RegisterLocators.lastName).sendKeys(lname);
    }

    public void enterEmail(String email) {
        driver.findElement(RegisterLocators.email).sendKeys(email);
    }

    public void enterPassword(String password) {
        driver.findElement(RegisterLocators.password).sendKeys(password);
    }

    public void enterConfirmPassword(String confirmPassword) {
        driver.findElement(RegisterLocators.confirmPassword).sendKeys(confirmPassword);
    }

    public void clickRegisterButton() {
        driver.findElement(RegisterLocators.registerButton).click();
    }

    public String getSuccessMessage() {
        return driver.findElement(RegisterLocators.registerationSuccessMessage).getText().trim();
    }

    public String getFirstNameError() {
        return driver.findElement(RegisterLocators.firstNameError).getText().trim();
    }

    public String getLastNameError() {
        return driver.findElement(RegisterLocators.lastNameError).getText().trim();
    }

    public String getEmailError() {
        return driver.findElement(RegisterLocators.emailError).getText().trim();
    }

    public String getExistingEmailError() {
        return driver.findElement(RegisterLocators.emailExistError).getText().trim();
    }

    public String getPasswordError() {
        return driver.findElement(RegisterLocators.passwordError).getText().trim();
    }

    public String getConfirmPasswordError() {
        return driver.findElement(RegisterLocators.confirmPasswordError).getText().trim();
    }
}
