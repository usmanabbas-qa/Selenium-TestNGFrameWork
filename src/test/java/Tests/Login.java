package Tests;

import Base.BaseTest;
import Pages.LoginPage;
import Pages.DashboardPage;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Login extends BaseTest {

    private DashboardPage dashboard;
    private LoginPage loginPage;

    @BeforeMethod
    public void setupLoginTest() {
        // Instantiate pages after driver is initialized
        dashboard = new DashboardPage(getDriver());
        loginPage = new LoginPage(getDriver());
    }

    @Test(description = "TC_LOGIN_001 - Verify Login with valid credentials")
    public void TC_LOGIN_001_verifyLoginWithValidCredentials() {
        System.out.println("Starting test: TC_LOGIN_001 - Valid Credentials");

        dashboard.navigateToLoginPage();
        dashboard.enterEmail("test15@t.com");
        dashboard.enterPassword("qwerty@123456");
        dashboard.clickLogin();

        String actualUrl = getDriver().getCurrentUrl();
        Assert.assertTrue(actualUrl.contains("https://demowebshop.tricentis.com"),
                "User is not on the expected site after login! Actual URL: " + actualUrl);
    }

    @Test(description = "TC_LOGIN_002 - Verify that login fails with an incorrect email.")
    public void TC_LOGIN_002_verifyLoginFailsWithInvalidEmail() {
        System.out.println("Starting test: TC_LOGIN_002 - Invalid Email");

        dashboard.navigateToLoginPage();
        dashboard.enterEmail("invalidcheck@.com");
        dashboard.enterPassword("Tester@123");
        dashboard.clickLogin();

        String actualError = loginPage.getEmailErrorMessage();
        System.out.println("Actual Error: " + actualError);

        Assert.assertTrue(actualError.contains("Please enter a valid email address."),
                "Expected validation message for invalid email was not shown!");
    }

    @Test(description = "TC_LOGIN_003 - Verify that login fails with an incorrect password.")
    public void TC_LOGIN_003_verifyLoginWithInvalidPassword() {
        System.out.println("Starting test: TC_LOGIN_003 - Invalid Password");

        dashboard.navigateToLoginPage();
        dashboard.enterEmail("autester78@gmail.com"); // Valid email
        dashboard.enterPassword("invalid");           // Invalid password
        dashboard.clickLogin();

        String actualError = loginPage.getPasswordErrorMessage();
        System.out.println("Actual Error: " + actualError);

        Assert.assertTrue(actualError.contains("The credentials provided are incorrect"),
                "Expected error message for invalid password was not shown!");
    }

    @Test(description = "TC_LOGIN_004 - Verify that login fails if the email field is left empty.")
    public void TC_LOGIN_004_verifyLoginWithEmptyEmail() {
        System.out.println("Starting test: TC_LOGIN_004 - Empty Email");

        dashboard.navigateToLoginPage();
        dashboard.enterEmail("");                  // Leave email empty
        dashboard.enterPassword("Tester@123");     // Valid password
        dashboard.clickLogin();

        String actualError = loginPage.getLoginErrorMessage();
        System.out.println("Actual Error: " + actualError);

        Assert.assertTrue(actualError.contains("Login was unsuccessful"),
                "Expected error message for empty email was not shown!");
    }

    @Test(description = "TC_LOGIN_005 - Verify that login fails if the password field is left empty.")
    public void TC_LOGIN_005_verifyLoginWithEmptyPassword() {
        System.out.println("Starting test: TC_LOGIN_005 - Empty Password");

        dashboard.navigateToLoginPage();
        dashboard.enterEmail("tester15@t.com"); // Valid email
        dashboard.enterPassword("");            // Empty password
        dashboard.clickLogin();

        String actualError = loginPage.getLoginErrorMessage();
        System.out.println("Actual Error: " + actualError);

        Assert.assertTrue(actualError.contains("Login was unsuccessful"),
                "Expected error message for empty password was not shown!");
    }
}
