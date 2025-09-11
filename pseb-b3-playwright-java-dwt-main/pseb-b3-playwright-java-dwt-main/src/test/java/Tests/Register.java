package Tests;

import Base.BaseTest;
import Pages.RegisterPage;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Register extends BaseTest {

    RegisterPage registerPage;

    @BeforeMethod
    public void setup() {
        registerPage = new RegisterPage(getDriver());
    }

    @Test(description = "TC_REGISTER_001 - Verify that a new user can register with valid details.")
    public void TC_REGISTER_001_verifyValidRegistration() {
        System.out.println("Navigating to Registration Page...");
        registerPage.navigateToRegisterPage();

        System.out.println("Filling registration form with valid data...");
        registerPage.selectGender("male");
        registerPage.enterFirstName("danyal");
        registerPage.enterLastName("tester");
        registerPage.enterEmail("danyaltester8445@gmail.com");
        registerPage.enterPassword("123456");
        registerPage.enterConfirmPassword("123456");

        System.out.println("Submitting the registration form...");
        registerPage.clickRegisterButton();

        System.out.println("Verifying success message...");
        Assert.assertTrue(registerPage.getSuccessMessage().contains("Your registration completed"),
                "Expected registration success message not found!");
    }

    @Test(description = "TC_REGISTER_002 - Verify that registration fails if required fields are left empty.")
    public void TC_REGISTER_002_verifyRegistrationWithEmptyFields() {
        System.out.println("Navigating to Registration Page...");
        registerPage.navigateToRegisterPage();
        registerPage.selectGender("Male");  // Only gender selected
        registerPage.clickRegisterButton();

        Assert.assertTrue(registerPage.getFirstNameError().contains("First name is required."));
        Assert.assertTrue(registerPage.getLastNameError().contains("Last name is required."));
        Assert.assertTrue(registerPage.getEmailError().contains("Email is required."));
        Assert.assertTrue(registerPage.getPasswordError().contains("Password is required."));
        Assert.assertTrue(registerPage.getConfirmPasswordError().contains("Password is required."));
    }

    @Test(description = "TC_REGISTER_003 - Verify that registration fails if passwords do not match.")
    public void TC_REGISTER_003_verifyRegistrationWithMismatchedPasswords() {
        System.out.println("Navigating to Registration Page...");
        registerPage.navigateToRegisterPage();

        registerPage.selectGender("Male");
        registerPage.enterFirstName("danyal");
        registerPage.enterLastName("tester");
        registerPage.enterEmail("danyaltester@gmail.com");
        registerPage.enterPassword("tester12345");
        registerPage.enterConfirmPassword("Password125"); // mismatched

        registerPage.clickRegisterButton();

        String errorMsg = registerPage.getConfirmPasswordError();
        System.out.println("Password : " + errorMsg);

        Assert.assertTrue(errorMsg.contains("The password and confirmation password do not match."));
    }

    @Test(description = "TC_REGISTER_004 - Verify that registration fails if the email format is invalid.")
    public void TC_REGISTER_004_verifyRegistrationWithInvalidEmailFormat() {
        System.out.println("Navigating to Registration Page...");
        registerPage.navigateToRegisterPage();

        registerPage.selectGender("Male");
        registerPage.enterFirstName("danyal");
        registerPage.enterLastName("tester");
        registerPage.enterEmail("danyaltester@"); // invalid
        registerPage.enterPassword("tester12345");
        registerPage.enterConfirmPassword("tester12345");

        registerPage.clickRegisterButton();

        String emailFormatError = registerPage.getEmailError();
        System.out.println("Error message: " + emailFormatError);

        Assert.assertTrue(emailFormatError.contains("Wrong email"),
                "Expected error message for invalid email format not displayed!");
    }

    @Test(description = "TC_REGISTER_005 - Verify that registration fails if the email is already in use.")
    public void TC_REGISTER_005_verifyRegistrationWithExistingEmail() {
        System.out.println("Navigating to Registration Page...");
        registerPage.navigateToRegisterPage();

        registerPage.selectGender("Male");
        registerPage.enterFirstName("danyal");
        registerPage.enterLastName("tester");
        registerPage.enterEmail("danyaltester@gmail.com"); // already used
        registerPage.enterPassword("tester12345");
        registerPage.enterConfirmPassword("tester12345");

        registerPage.clickRegisterButton();

        String existingEmailError = registerPage.getExistingEmailError();
        System.out.println("Error message: " + existingEmailError);

        Assert.assertTrue(existingEmailError.contains("The specified email already exists"),
                "Expected error message for existing email not displayed!");
    }
}
