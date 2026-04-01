package Tests;

import Base.BaseTest;
import Pages.CheckoutPage;
import Pages.DashboardPage;
import Pages.PdpPage;
import Pages.SearchPage;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Pdp extends BaseTest {

    DashboardPage dashboard;
    PdpPage pdp;
    CheckoutPage checkout;
    SearchPage searchPage;

    @BeforeMethod
    public void LoginDetails() {
        // Initialize Page Objects after WebDriver setup
        dashboard = new DashboardPage(getDriver());
        pdp = new PdpPage(getDriver());
        checkout = new CheckoutPage(getDriver());
        searchPage = new SearchPage(getDriver());

        // Login
        dashboard.navigateToLoginPage();
        dashboard.enterEmail("test15@t.com");
        dashboard.enterPassword("qwerty@123456");
        dashboard.clickLogin();
    }

    @Test(description = "TC_PDP_001 - Verify that product details are displayed correctly")
    public void TC_PDP_001_verifyProductDetailsVisible() throws InterruptedException {
        checkout.searchProduct("Smartphone");
        searchPage.clickSearchButton();
        pdp.clickProduct();
        pdp.productDetailsVisible();
    }

    @Test(description = "TC_PDP_002 - Verify that product can be added to the cart")
    public void TC_PDP_002_verifyAddToCartFunctionality() throws InterruptedException {
        checkout.searchProduct("Smartphone");
        searchPage.clickSearchButton();
        Thread.sleep(3000);
        checkout.clickAddToCart();
        System.out.println("Product added to Cart.");
    }

    @Test(description = "TC_PDP_003 - Verify Quantity Update in Cart")
    public void TC_PDP_003_verifyQuantityUpdate() throws InterruptedException {
        checkout.searchProduct("Smartphone");
        searchPage.clickSearchButton();
        Thread.sleep(3000);
        checkout.clickAddToCart();

        checkout.goToCart();
        Assert.assertTrue(checkout.verifyPageTitle("Shopping cart"), "Shopping cart page not loaded.");

        pdp.enterQuantity("5"); // Max 5 allowed
        pdp.updateShoppingCartButton();
        pdp.getTotalPrice(); // Optional: could be asserted or logged
    }

    @Test(description = "TC_PDP_004 - Verify that product reviews are visible")
    public void TC_PDP_004_verifyProductReviews() throws InterruptedException {
        checkout.searchProduct("Smartphone");
        searchPage.clickSearchButton();
        pdp.clickProduct();
        pdp.getProductReviews();
    }

    @Test(description = "TC_PDP_005 - Verify that price tags are displayed correctly")
    public void TC_PDP_005_verifyPriceTagsVisible() {
        checkout.searchProduct("Smartphone");
        searchPage.clickSearchButton();
        pdp.clickProduct();
        pdp.productPriceVisible();
    }
}
