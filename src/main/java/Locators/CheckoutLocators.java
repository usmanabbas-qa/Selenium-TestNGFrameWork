package Locators;

import org.openqa.selenium.By;

public class CheckoutLocators {
    // Cart
    public static By shoppingCartButton = By.cssSelector("a[class='ico-cart'] span[class='cart-label']");
    public static By addToCartBtn = By.cssSelector("input[value='Add to cart']");
    public static By searchBoxText = By.id("small-searchterms");
    public static By pageHeading = By.cssSelector("div[class='page-title'] h1");
    public static By cartEmptyMessage = By.cssSelector(".order-summary-content");
    public static By quantityInput = By.cssSelector("input.qty-input");
    public static By updateCartButton = By.cssSelector("input[value='Update shopping cart']");
    public static By couponCodeField = By.cssSelector("input[name='discountcouponcode']"); // Adjust if different
    public static By applyCouponButton = By.cssSelector("input[value='Apply coupon']"); // Adjust if different
    public static By invalidCouponMessage = By.cssSelector(".message"); // Adjust selector to match actual error display


    // Estimate Shipping
    public static By termsAndCondition = By.id("termsofservice");
    public static By checkOut = By.id("checkout");

    // Billing Address
    public static By billingAddressDropdown = By.id("billing-address-select");
    public static By continueButton = By.cssSelector("input[onclick='Billing.save()']");

    // Shipping Method
    public static By continueShippingsaveBtn = By.cssSelector("input[onclick='Shipping.save()']");
    public static By groundShippingOption = By.id("shippingoption_0");
    public static By nextDayShippingOption = By.id("shippingoption_1");
    public static By secondDayShippingOption = By.id("shippingoption_2");
    public static By continueShippingMethod = By.cssSelector("input.button-1.shipping-method-next-step-button");

    // Payment Method
    public static By COD = By.cssSelector("input#paymentmethod_0");
    public static By Check_MoneyOrder = By.cssSelector("input#paymentmethod_1");
    public static By creditCard = By.cssSelector("input#paymentmethod_2");
    public static By purchaseOrder = By.cssSelector("input#paymentmethod_03"); // Check this ID (likely typo)
    public static By continuePayment = By.cssSelector("input.button-1.payment-method-next-step-button");

    // Payment Info
    public static By paymentConfirmationText_COD = By.xpath("//p[normalize-space()='You will pay by COD']");
    public static By continuePaymentInfo = By.cssSelector("input.button-1.payment-info-next-step-button");
    public static By cardType = By.id("CreditCardType");
    public static By cardHolderName = By.id("CardholderName");
    public static By cardNumber = By.id("CardNumber");
    public static By expireMonth = By.id("ExpireMonth");
    public static By expireYear = By.id("ExpireYear");
    public static By cardCode = By.id("CardCode");
    public static By continuePaymentViaCard = By.cssSelector("input.button-1.payment-info-next-step-button");

    // Confirm Order
    public static By assertConfirmOrder = By.xpath("//h2[normalize-space()='Confirm order']");
    public static By confirmBtn = By.cssSelector("input[value='Confirm']");
    public static By assertOrderConfirmation = By.cssSelector(".section.order-completed");
    public static By lastBtn = By.cssSelector("input[value='Continue']");



}
