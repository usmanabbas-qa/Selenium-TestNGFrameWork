package Pages;

import Locators.PdpLocators;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.util.List;

public class PdpPage {
    private final WebDriver driver;

    public PdpPage(WebDriver driver) {
        this.driver = driver;
    }

    public void productDetailsVisible() {
        Assert.assertTrue(driver.findElement(PdpLocators.productDetails).isDisplayed(),
                "Product details section is not visible!");
    }

    public void enterQuantity(String quantity) {
        WebElement qtyInput = driver.findElement(PdpLocators.itemQuantity);
        qtyInput.clear();
        qtyInput.sendKeys(quantity);
    }

    public void updateShoppingCartButton() {
        driver.findElement(PdpLocators.updateShoppingCartBtn).click();
    }

    public String getTotalPrice() {
        return driver.findElement(PdpLocators.totalPrice).getText();
    }

    public void getProductReviews() {
        List<WebElement> reviews = driver.findElements(PdpLocators.productReviews);
        for (WebElement review : reviews) {
            System.out.println("Review: " + review.getText());
        }
    }

    public void productPriceVisible() {
        Assert.assertTrue(driver.findElement(PdpLocators.productPrices).isDisplayed(),
                "Product price is not visible!");
    }

    public void clickProduct() {
        driver.findElement(PdpLocators.productName).click();
    }
}
