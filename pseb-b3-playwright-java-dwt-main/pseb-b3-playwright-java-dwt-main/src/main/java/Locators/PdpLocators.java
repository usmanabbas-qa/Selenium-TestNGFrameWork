package Locators;

import org.openqa.selenium.By;

public class PdpLocators {

    public static By productDetails = By.cssSelector(".full-description");
    public static By itemQuantity = By.cssSelector("input.qty-input");
    public static By updateShoppingCartBtn = By.name("updatecart");
    public static By totalPrice = By.cssSelector(".product-subtotal");
    public static By productReviews = By.xpath("//a[contains(text(),'1830')]");
    public static By productPrices = By.cssSelector(".product-price");
    public static By productName = By.cssSelector("h2[class='product-title'] a");
}
