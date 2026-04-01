package Pages;

import Locators.DashboardLocators;
import Utils.CommonActions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class DashboardPage {

    private final WebDriver driver;
    private final CommonActions commonActions;

    public DashboardPage(WebDriver driver) {
        this.driver = driver;
        this.commonActions = new CommonActions(driver);
    }

    // ---------------- LOGIN FUNCTIONALITY ----------------
    public void navigateToLoginPage() {
        driver.get("https://demowebshop.tricentis.com/login");
    }

    public void enterEmail(String email) {
        WebElement emailField = driver.findElement(DashboardLocators.emailField);
        emailField.clear();
        emailField.sendKeys(email);
    }

    public void enterPassword(String password) {
        WebElement passwordField = driver.findElement(DashboardLocators.passwordField);
        passwordField.clear();
        passwordField.sendKeys(password);
    }

    public void clickLogin() {
        driver.findElement(DashboardLocators.LoginBtn).click();
    }

    public boolean isLogoutVisible() {
        return driver.findElement(DashboardLocators.logoutLink).isDisplayed();
    }

    public void clickLogout() {
        commonActions.clickElement(DashboardLocators.logoutLink);
    }

    public boolean isOnLoginPage() {
        return commonActions.isElementDisplayed(DashboardLocators.LoginBtn);
    }

    public String getAccountNameText() {
        return driver.findElement(DashboardLocators.accountName).getText();
    }

    // ---------------- CART FUNCTIONALITY ----------------
    public void goToShoppingCart() {
        commonActions.clickElement(DashboardLocators.cartLink);
    }

    public int getNumberOfCartItems() {
        String qtyText = commonActions.getElementText(DashboardLocators.cartQuantityText);
        return Integer.parseInt(qtyText.replaceAll("[^0-9]", ""));
    }

    // ---------------- CATEGORY NAVIGATION ----------------
    public void clickAndVerifyCategory(By categoryLocator, String categoryName) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        try {
            System.out.println("Waiting for category: " + categoryName + " to be clickable.");
            WebElement categoryElement = wait.until(ExpectedConditions.elementToBeClickable(categoryLocator));

            System.out.println("Clicking on category: " + categoryName);
            categoryElement.click();

            wait.until(ExpectedConditions.presenceOfElementLocated(By.tagName("h1")));

        } catch (Exception e) {
            System.out.println("Error while clicking category: " + categoryName);
            e.printStackTrace();
        }

        System.out.println("Navigating back to homepage...");
        driver.navigate().back();

        try {
            System.out.println("Waiting for homepage to reload.");
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".header-logo")));
        } catch (Exception e) {
            System.out.println("Homepage did not load properly.");
            e.printStackTrace();
        }
    }
}
