package Tests;

import Base.BaseTest;
import Locators.WishlistLocators;
import Pages.DashboardPage;
import Pages.WishlistPage;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Wishlist extends BaseTest {

    DashboardPage dashboard;
    WishlistPage wishlist;

    @BeforeMethod
    public void LoginDetails() {
        dashboard = new DashboardPage(getDriver());
        wishlist = new WishlistPage(getDriver());

        dashboard.navigateToLoginPage();
        dashboard.enterEmail("test15@t.com");
        dashboard.enterPassword("qwerty@123456");
        dashboard.clickLogin();
    }

    @Test(description = "TC_WISHLIST_001 - Verify WishList Hyperlink")
    public void TC_WISHLIST_001_WishlistLinkNavigation() {
        wishlist.wishListLink();
        // assertion verify that URL or title confirms wishlist page loaded
        String title = getDriver().getTitle();
        Assert.assertTrue(title.contains("Wishlist"), "Wishlist page did not load as expected.");
    }

    @Test(description = "TC_WISHLIST_002 - Remove an item from Wishlist")
    public void TC_WISHLIST_002_RemoveItemFromWishlist() {
        wishlist.addtoWishListItem();
        wishlist.wishListLink();
        wishlist.removeItemWishlist();
    }

    @Test(description = "TC_WISHLIST_003 - Add item to Wishlist and verify")
    public void TC_WISHLIST_003_AddItemAndVerifyInWishlist() {
        wishlist.addtoWishListItem();
        wishlist.wishListLink();
        wishlist.verifyItemIsVisibleInWishlist(); // Assert included inside method
    }

    @Test(description = "TC_WISHLIST_004 - Share item(s) in Wishlist via Email")
    public void TC_WISHLIST_004_ShareWishlistViaEmail() {
        wishlist.addtoWishListItem();
        wishlist.friendWishlistEmail();
        // Assert success message is shown
        Assert.assertTrue(getDriver().findElement(WishlistLocators.wishlistMessage).isDisplayed(),
                "Wishlist share confirmation message is not displayed.");
    }

    @Test(description = "TC_WISHLIST_005 - View item(s) using the Wishlist link")
    public void TC_WISHLIST_005_ViewWishlistItems() {
        wishlist.wishListLink();
        wishlist.verifyItemIsVisibleInWishlist(); // Assert included inside method
    }
}
