package Tests;

import Base.BaseTest;
import Pages.CheckoutPage;
import Pages.DashboardPage;
import Pages.SearchPage;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Checkout extends BaseTest {


    DashboardPage dashboard;
    CheckoutPage checkout;
    SearchPage searchPage;

    @BeforeMethod
    public void LoginDetails() {
        dashboard = new DashboardPage(getDriver());
        checkout = new CheckoutPage(getDriver());
        searchPage = new SearchPage(getDriver());
        dashboard.navigateToLoginPage();
        dashboard.enterEmail("test15@t.com");
        dashboard.enterPassword("qwerty@123456");
        dashboard.clickLogin();
    }

    @Test(description = "TC_CHECKOUT_001 - Verify that a user can complete the checkout process successfully")
    public void TC_CHECKOUT_001_verifyUserCanCheckoutSuccessfully() throws InterruptedException {
        // Search & Add to Cart
        checkout.searchProduct("Smartphone");
        searchPage.clickSearchButton();
        Thread.sleep(5000);
        checkout.clickAddToCart();
        Thread.sleep(5000);
        // Go to Cart
        checkout.goToCart();
        Assert.assertTrue(checkout.verifyPageTitle("Shopping cart"));
        // Terms and Checkout
        checkout.acceptTermsAndConditions();
        checkout.proceedToCheckout();
        checkout.clickContinueBilling();
        // Shipping Address
        checkout.clickContinueShippingSave();
        Assert.assertTrue(checkout.isConfirmOrderVisible());
        // Shipping Method
        checkout.selectShippingMethod("Ground (0.00)");
        checkout.clickContinueShippingMethod();
        // Payment Method
        checkout.selectPaymentMethod("Cash On Delivery");
        checkout.clickContinuePaymentMethod();
        // Payment Details
        checkout.clickContinuePaymentInfo();
        // Confirm Order
        checkout.clickConfirmOrder();
        Assert.assertTrue(checkout.isOrderConfirmationDisplayed());
        // Final Continue
        checkout.clickFinalContinueButton();
    }

    @Test(description = "TC_CHECKOUT_002 - Verify the behavior when trying to checkout with an empty cart")
    public void TC_CHECKOUT_002_verifyCheckoutWithEmptyCart() throws InterruptedException {
        // Navigate to Cart
        checkout.goToCart();
        Thread.sleep(5000); // Optional wait if needed for cart to load
        Assert.assertTrue(checkout.verifyPageTitle("Shopping cart"));
        // Verify cart is empty
        Assert.assertTrue(checkout.isCartEmptyMessageDisplayed("Your Shopping Cart is empty!"));
    }

    @Test(description = "TC_CHECKOUT_003 - Verify that user can update quantity during checkout")
    public void TC_CHECKOUT_003_verifyQuantityUpdateDuringCheckout() throws InterruptedException {
        // Step 1: Search and add a book to cart
        checkout.searchProduct("Smartphone");
        searchPage.clickSearchButton();
        checkout.clickAddToCart();
        Thread.sleep(5000);
        // Step 2: Go to cart and verify
        checkout.goToCart();
        Assert.assertTrue(checkout.verifyPageTitle("Shopping cart"), "Shopping cart page not loaded.");
        // Step 3: Update quantity in the cart
        checkout.updateProductQuantity("2");
        checkout.clickUpdateCartButton();
        Thread.sleep(5000);
        // Step 4: Verify quantity updated
        Assert.assertEquals(checkout.getUpdatedQuantity(), "2", "Quantity was not updated correctly.");
        // Step 5: Proceed to checkout
        checkout.acceptTermsAndConditions();
        checkout.proceedToCheckout();
    }

    @Test(description = "TC_CHECKOUT_004 - Verify that an error message is displayed for an invalid promo code")
    public void TC_CHECKOUT_004_verifyInvalidPromoCodeMessage() throws InterruptedException {
        // Step 1: Search and add a product to cart
        checkout.searchProduct("Smartphone");
        searchPage.clickSearchButton();
        checkout.clickAddToCart();
        Thread.sleep(5000);
        // Step 2: Go to cart
        checkout.goToCart();
        Assert.assertTrue(checkout.verifyPageTitle("Shopping cart"), "Shopping cart page not loaded.");
        // Step 3: Enter invalid promo code
        checkout.enterCouponCode("XYZ123");
        // Step 4: Click apply
        checkout.clickApplyCouponCode();
        // Step 5: Verify error message
        Assert.assertTrue(checkout.isInvalidCouponCodeMessageDisplayed(), "Invalid promo code message was not shown.");
    }

    @Test(description = "Verify that user can select a payment method")
    public void TC_CHECKOUT_005_selectPaymentMethod() throws InterruptedException {
        // Step 1: Search and add product to cart
        checkout.searchProduct("Smartphone");
        searchPage.clickSearchButton();
        checkout.clickAddToCart();
        Thread.sleep(5000);
        // Step 2: Go to cart
        checkout.goToCart();
        checkout.acceptTermsAndConditions();
        Assert.assertTrue(checkout.verifyPageTitle("Shopping cart"));
        // Terms and Checkout
        checkout.proceedToCheckout();
        checkout.clickContinueBilling();
        // Step 4: Continue shipping info
        checkout.clickContinueShippingSave();
        // Step 5: Select shipping method
        checkout.selectShippingMethod("Ground (0.00)");
        checkout.clickContinueShippingMethod();
        // Step 6: Select payment method as Credit Card
        checkout.selectPaymentMethod("Credit Card");
        checkout.clickContinuePaymentMethod();
        // Step 7: Enter credit card details
        checkout.enterCreditCardDetails("Visa", "Maan", "4111111111111111", "12", "2030", "123");
        checkout.clickContinueViaCard();
        // Step 8: Confirm "Confirm Order" page is visible
        Assert.assertTrue(checkout.isConfirmOrderVisible(), "Confirm Order section not visible!");
        // Step 9: Place order and verify confirmation
        checkout.clickConfirmOrder();
        Assert.assertTrue(checkout.isOrderConfirmationDisplayed(), "Order was not successfully placed!");
        // Step 10: Final continue
        checkout.clickFinalContinueButton();
    }
}

