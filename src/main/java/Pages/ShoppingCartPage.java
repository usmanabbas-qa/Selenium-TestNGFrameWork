package Pages;

import Locators.ShoppingCartLocators;
import org.openqa.selenium.WebDriver;

public class ShoppingCartPage {
    private final WebDriver driver;

    public ShoppingCartPage(WebDriver driver) {
        this.driver = driver;
    }

    public void clickRemoveCheckbox() {
        driver.findElement(ShoppingCartLocators.removeCheckBox).click();
    }
}
