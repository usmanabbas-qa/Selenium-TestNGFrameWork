package Locators;

import org.openqa.selenium.By;

public class RegisterLocators {

    public static By genderMale = By.cssSelector("#gender-male");
    public static By genderFemale = By.cssSelector("#gender-female");
    public static By firstName = By.cssSelector("#FirstName");
    public static By lastName = By.cssSelector("#LastName");
    public static By email = By.cssSelector("#Email");
    public static By password = By.cssSelector("#Password");
    public static By confirmPassword = By.cssSelector("#ConfirmPassword");
    public static By registerButton = By.cssSelector("#register-button");
    public static By registerationSuccessMessage = By.cssSelector(".result");
    public static By firstNameError = By.cssSelector(".field-validation-error[data-valmsg-for='FirstName']");
    public static By lastNameError = By.cssSelector("span[for='LastName']");
    public static By emailError = By.cssSelector("span[for='Email']");
    public static By passwordError = By.cssSelector("span[for='Password']");
    public static By confirmPasswordError = By.cssSelector("span[for='ConfirmPassword']");
    public static By emailExistError = By.cssSelector("div[class='validation-summary-errors'] ul li");

}
