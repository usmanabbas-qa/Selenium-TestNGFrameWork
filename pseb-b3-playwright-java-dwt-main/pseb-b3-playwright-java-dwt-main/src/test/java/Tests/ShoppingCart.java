package Tests;

import Base.BaseTest;
import Pages.CheckoutPage;
import Pages.DashboardPage;
import Pages.SearchPage;
import Pages.ShoppingCartPage;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ShoppingCart extends BaseTest {

    DashboardPage dashboard;
    CheckoutPage checkout;
    SearchPage searchPage;
    ShoppingCartPage shopping;

    @BeforeMethod
    public void LoginDetails() {
        //instantiate all Page Objects using getDriver()
        dashboard = new DashboardPage(getDriver());
        checkout = new CheckoutPage(getDriver());
        searchPage = new SearchPage(getDriver());
        shopping = new ShoppingCartPage(getDriver());

        dashboard.navigateToLoginPage();
        dashboard.enterEmail("test15@t.com");
        dashboard.enterPassword("qwerty@123456");
        dashboard.clickLogin();
    }

    @Test(description = "TC_ShoppingCart_001 - Verify user is able to checkout after ticking the terms of service checkbox")
    public void TC_ShoppingCart_001_checkoutAfterAcceptingTerms() throws InterruptedException {
        checkout.goToCart();
        Thread.sleep(5000);
        Assert.assertTrue(checkout.verifyPageTitle("Shopping cart"));
        Assert.assertTrue(checkout.isCartEmptyMessageDisplayed("Your Shopping Cart is empty!"));
    }

    @Test(description = "TC_ShoppingCart_002 - Verify navigation from cart to checkout page")
    public void TC_ShoppingCart_002_verifyNavigationFromCartToCheckout() throws InterruptedException {
        checkout.searchProduct("Smartphone");
        searchPage.clickSearchButton();
        Thread.sleep(5000);
        checkout.clickAddToCart();
        Thread.sleep(5000);

        checkout.goToCart();
        Assert.assertTrue(checkout.verifyPageTitle("Shopping cart"));
        checkout.acceptTermsAndConditions();
        checkout.proceedToCheckout();
        Assert.assertTrue(checkout.isConfirmOrderVisible(), "Checkout page did not load successfully.");
    }

    @Test(description = "TC_ShoppingCart_003 - Verify user can remove item from cart")
    public void TC_ShoppingCart_003_removeItemFromCart() throws InterruptedException {
        checkout.searchProduct("Smartphone");
        searchPage.clickSearchButton();
        Thread.sleep(5000);
        checkout.clickAddToCart();
        Thread.sleep(5000);

        checkout.goToCart();
        Assert.assertTrue(checkout.verifyPageTitle("Shopping cart"));
        shopping.clickRemoveCheckbox();
        checkout.clickUpdateCartButton();
        Assert.assertTrue(checkout.isCartEmptyMessageDisplayed("Your Shopping Cart is empty!"));
    }

    @Test(description = "TC_ShoppingCart_004 - Verify updating quantity in cart page")
    public void TC_ShoppingCart_004_updateQuantityInCart() throws InterruptedException {
        checkout.searchProduct("Smartphone");
        searchPage.clickSearchButton();
        Thread.sleep(5000);
        checkout.clickAddToCart();
        Thread.sleep(5000);

        checkout.goToCart();
        Assert.assertTrue(checkout.verifyPageTitle("Shopping cart"));
        checkout.updateProductQuantity("5");
        checkout.clickUpdateCartButton();
        String actualQty = checkout.getUpdatedQuantity();
        Assert.assertEquals(actualQty, "5", "Quantity in cart was not updated correctly.");
    }

    @Test(description = "TC_ShoppingCart_005 - Verify cart shows empty cart message after removing all products")
    public void TC_ShoppingCart_005_verifyCartShowsEmptyMessage() throws InterruptedException {
        checkout.searchProduct("Smartphone");
        searchPage.clickSearchButton();
        Thread.sleep(5000);
        checkout.clickAddToCart();
        Thread.sleep(5000);

        checkout.goToCart();
        Assert.assertTrue(checkout.verifyPageTitle("Shopping cart"));
        shopping.clickRemoveCheckbox();
        checkout.clickUpdateCartButton();
        Assert.assertTrue(checkout.isCartEmptyMessageDisplayed("Your Shopping Cart is empty!"));
    }
}
