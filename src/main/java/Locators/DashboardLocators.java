package Locators;

import org.openqa.selenium.By;

public class DashboardLocators {
    public static By accountName = By.className("account");
    public static By logoutLink = By.className("ico-logout");

    public static By emailField = By.xpath("//input[@id='Email']");
    public static By passwordField = By.xpath("//input[@id='Password']");
    public static By LoginBtn = By.xpath("//input[@value='Log in']");
    public static By cartLink = By.className("ico-cart");
    public static By cartQuantityText = By.className("cart-qty");
    public static By books = By.linkText("Books");
    public static By computers = By.linkText("Computers");
    public static By electronics = By.linkText("Electronics");
    public static By apparelShoes = By.linkText("Apparel & Shoes");
    public static By digitalDownloads = By.linkText("Digital downloads");
    public static By jewelry = By.linkText("Jewelry");
    public static By giftCards = By.linkText("Gift Cards");

}


