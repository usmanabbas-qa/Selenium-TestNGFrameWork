package Locators;

import org.openqa.selenium.By;

public class WishlistLocators {
    public static By wishlistLink = By.className("ico-wishlist");
    public static By wishlistItems = By.cssSelector(".wishlist-content .cart-item-row");
    public static By wishlistCountBadge = By.cssSelector("span.wishlist-qty"); // Shows as (2), (3) etc.
    public static By remove_checkbox = By.cssSelector(".remove-from-cart > input");
    public static By updateWishlist_button = By.cssSelector(".button-2.update-wishlist-button");
    public static By giftCardImage = By.cssSelector("img[title='Show details for $25 Virtual Gift Card']");
    public static By ATWbutton = By.id("add-to-wishlist-button-2");
    public static By recipientName_textbox = By.id("giftcard_2_RecipientName");
    public static By recipientEmail_textbox = By.id("giftcard_2_RecipientEmail");
    public static By friendWishlistButton = By.cssSelector(".email-a-friend > .button-2");
    public static By friendEmail_textbox = By.id("FriendEmail");
    public static By sendEmailButton = By.cssSelector("form > .buttons > .button-1");
    public static By wishlistProduct = By.cssSelector("td[class='product']");
    public static By wishlistMessage = By.cssSelector(".result");
}
