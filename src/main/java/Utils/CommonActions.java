package Utils; // IMPORTANT: Ensure this package name matches your setup (e.g., Utils)

import Config.ConfigReader; // IMPORTANT: Ensure this import matches your ConfigReader's package
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration; // For explicit waits in Selenium 4+
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * CommonActions class provides a set of reusable methods for common Selenium interactions.
 * This centralizes actions like clicking, typing, waiting for elements, etc.,
 * promoting code reusability and making tests more robust by incorporating explicit waits.
 */
public class CommonActions {

    private static final Logger logger = LogManager.getLogger(CommonActions.class);
    private WebDriver driver; // Instance of WebDriver

    /**
     * Constructor to initialize CommonActions with a WebDriver instance.
     *
     * @param driver The WebDriver instance to be used for interactions.
     */
    public CommonActions(WebDriver driver) {
        this.driver = driver;
    }

    /**
     * Clicks on a web element after waiting for it to be clickable.
     *
     * @param by The By locator of the element to click.
     */
    public void clickElement(By by) {
        try {
            WebElement element = waitForElementToBeClickable(by);
            element.click();
            logger.info("Clicked on element located by: " + by.toString());
        } catch (Exception e) {
            logger.error("Failed to click element located by " + by.toString() + ": " + e.getMessage());
            throw new RuntimeException("Failed to click element: " + by.toString(), e);
        }
    }

    /**
     * Enters text into a web element after waiting for it to be visible.
     *
     * @param by The By locator of the input field.
     * @param text The text to enter.
     */
    public void enterText(By by, String text) {
        try {
            WebElement element = waitForElementToBeVisible(by);
            element.clear(); // Clear existing text
            element.sendKeys(text);
            logger.info("Entered text '" + text + "' into element located by: " + by.toString());
        } catch (Exception e) {
            logger.error("Failed to enter text into element located by " + by.toString() + ": " + e.getMessage());
            throw new RuntimeException("Failed to enter text into element: " + by.toString(), e);
        }
    }

    /**
     * Retrieves the text from a web element after waiting for it to be visible.
     *
     * @param by The By locator of the element.
     * @return The text of the element.
     */
    public String getElementText(By by) {
        try {
            WebElement element = waitForElementToBeVisible(by);
            String text = element.getText();
            logger.info("Retrieved text '" + text + "' from element located by: " + by.toString());
            return text;
        } catch (Exception e) {
            logger.error("Failed to get text from element located by " + by.toString() + ": " + e.getMessage());
            throw new RuntimeException("Failed to get text from element: " + by.toString(), e);
        }
    }

    /**
     * Checks if a web element is displayed after waiting for it to be visible.
     *
     * @param by The By locator of the element.
     * @return true if the element is displayed, false otherwise.
     */
    public boolean isElementDisplayed(By by) {
        try {
            WebElement element = waitForElementToBeVisible(by);
            boolean isDisplayed = element.isDisplayed();
            logger.info("Element located by " + by.toString() + " is displayed: " + isDisplayed);
            return isDisplayed;
        } catch (Exception e) {
            logger.warn("Element located by " + by.toString() + " is not displayed or not found: " + e.getMessage());
            return false; // Element not found or not visible
        }
    }

    /**
     * Waits for a web element to be visible on the page.
     * Uses explicit wait based on the 'explicit.wait' property from config.
     *
     * @param by The By locator of the element to wait for.
     * @return The WebElement once it is visible.
     */
    public WebElement waitForElementToBeVisible(By by) {
        WebDriverWait wait = getWebDriverWait();
        logger.debug("Waiting for element to be visible: " + by.toString());
        return wait.until(ExpectedConditions.visibilityOfElementLocated(by));
    }

    /**
     * Waits for a web element to be clickable on the page.
     * Uses explicit wait based on the 'explicit.wait' property from config.
     *
     * @param by The By locator of the element to wait for.
     * @return The WebElement once it is clickable.
     */
    public WebElement waitForElementToBeClickable(By by) {
        WebDriverWait wait = getWebDriverWait();
        logger.debug("Waiting for element to be clickable: " + by.toString());
        return wait.until(ExpectedConditions.elementToBeClickable(by));
    }

    /**
     * Helper method to create a WebDriverWait instance with the configured explicit wait time.
     *
     * @return A new WebDriverWait instance.
     */
    private WebDriverWait getWebDriverWait() {
        int explicitWait = Integer.parseInt(ConfigReader.getProperty("explicit.wait"));
        return new WebDriverWait(driver, Duration.ofSeconds(explicitWait));
    }
}