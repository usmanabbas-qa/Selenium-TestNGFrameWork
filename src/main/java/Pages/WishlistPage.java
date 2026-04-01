package Pages;

import Locators.WishlistLocators;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import java.util.List;

public class WishlistPage {

    private final WebDriver driver;

    public WishlistPage(WebDriver driver) {
        this.driver = driver;
    }

    public void openWishlist() {
        driver.findElement(WishlistLocators.wishlistLink).click();
    }

    public int getWishlistItemsCount() {
        List<WebElement> items = driver.findElements(WishlistLocators.wishlistItems);
        return items.size();
    }

    public int getWishlistBadgeCount() {
        String text = driver.findElement(WishlistLocators.wishlistCountBadge).getText(); // e.g., "(2)"
        return Integer.parseInt(text.replaceAll("[^0-9]", ""));
    }

    public void wishListLink() {
        driver.findElement(WishlistLocators.wishlistLink).click();
        String currentUrl = driver.getCurrentUrl();
        if (!currentUrl.contains("/wishlist")) {
            throw new AssertionError("URL does not contain /wishlist");
        }
        System.out.println("Navigated to Wishlist page.");
    }

    public void addtoWishListItem() {
        driver.findElement(WishlistLocators.giftCardImage).click();
        driver.findElement(WishlistLocators.recipientName_textbox).sendKeys("john");
        driver.findElement(WishlistLocators.recipientEmail_textbox).sendKeys("john@example.com");
        driver.findElement(WishlistLocators.ATWbutton).click();
        System.out.println("Item added to Wishlist.");
    }

    public void removeItemWishlist() {
        driver.findElement(WishlistLocators.remove_checkbox).click();
        driver.findElement(WishlistLocators.updateWishlist_button).click();
        System.out.println("Item removed from Wishlist.");
    }

    public void friendWishlistEmail() {
        driver.findElement(WishlistLocators.friendWishlistButton).click();
        driver.findElement(WishlistLocators.friendEmail_textbox).sendKeys("john@example.com");
        driver.findElement(WishlistLocators.sendEmailButton).click();
        System.out.println("Wishlist shared with friend.");
    }

    public void verifyItemIsVisibleInWishlist() {
        boolean isVisible = driver.findElement(WishlistLocators.wishlistProduct).isDisplayed();
        Assert.assertTrue(isVisible, "Item is NOT visible in the wishlist!");
        System.out.println("Item is visible in the wishlist.");
    }
}
