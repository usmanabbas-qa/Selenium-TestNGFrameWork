package Tests;

import Base.BaseTest;
import Locators.DashboardLocators;
import Pages.CheckoutPage;
import Pages.DashboardPage;
import Pages.SearchPage;
import Pages.WishlistPage;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Dashboard extends BaseTest {

    private DashboardPage dashboard;
    private CheckoutPage checkout;
    private SearchPage searchPage;
    private WishlistPage wishlist;

    @BeforeMethod
    public void LoginDetails() {
        // Initialize page objects using driver
        dashboard = new DashboardPage(getDriver());
        checkout = new CheckoutPage(getDriver());
        searchPage = new SearchPage(getDriver());
        wishlist = new WishlistPage(getDriver());

        // Login
        dashboard.navigateToLoginPage();
        dashboard.enterEmail("test15@t.com");
        dashboard.enterPassword("qwerty@123456");
        dashboard.clickLogin();

        // Assert login successful
        Assert.assertTrue(dashboard.isLogoutVisible(), "Login failed - Logout button not visible.");
    }

    @Test(description = "TC_DASHBOARD_001 - Verify User Info")
    public void TC_DASHBOARD_001_verifyUserInfo() {
        String actualUsername = dashboard.getAccountNameText();
        Assert.assertEquals(actualUsername, "test15@t.com", "Displayed username does not match expected.");
        Assert.assertTrue(dashboard.isLogoutVisible(), "Logout link should be visible after login.");
    }

    @Test(description = "TC_DASHBOARD_002 - Verify Logout")
    public void TC_DASHBOARD_002_verifyLogoutFunctionality() {
        dashboard.clickLogout();
        String currentUrl = getDriver().getCurrentUrl();
        Assert.assertTrue(currentUrl.contains("/login") || currentUrl.contains("/"),
                "User should be redirected to login or home after logout. Actual URL: " + currentUrl);
    }

    @Test(description = "TC_DASHBOARD_003 - Check Shopping Cart")
    public void TC_DASHBOARD_003_checkShoppingCartItemCount() {
        dashboard.goToShoppingCart();
        int itemCount = dashboard.getNumberOfCartItems();
        System.out.println("Number of items in cart: " + itemCount);
        Assert.assertTrue(itemCount > 0, "Shopping cart should have at least one item.");
    }

    @Test(description = "TC_DASHBOARD_004 - Wishlist Count")
    public void TC_DASHBOARD_004_verifyWishlistCount() {
        wishlist.openWishlist();
        getDriver().navigate().back();
        int badgeCount = wishlist.getWishlistBadgeCount();
        System.out.println("Wishlist Badge Count: " + badgeCount);
        Assert.assertTrue(badgeCount >= 0, "Wishlist badge count should not be negative.");
    }

    @Test(description = "TC_DASHBOARD_005 - Verify category navigation")
    public void TC_DASHBOARD_005_verifyCategoryNavigation() {
        dashboard.clickAndVerifyCategory(DashboardLocators.books, "Books");
        dashboard.clickAndVerifyCategory(DashboardLocators.computers, "Computers");
        dashboard.clickAndVerifyCategory(DashboardLocators.electronics, "Electronics");
        dashboard.clickAndVerifyCategory(DashboardLocators.apparelShoes, "Apparel & Shoes");
        dashboard.clickAndVerifyCategory(DashboardLocators.digitalDownloads, "Digital downloads");
        dashboard.clickAndVerifyCategory(DashboardLocators.jewelry, "Jewelry");
        dashboard.clickAndVerifyCategory(DashboardLocators.giftCards, "Gift Cards");
    }
}
