package Pages;

import Locators.CheckoutLocators;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

public class CheckoutPage {
    private WebDriver driver;

    public CheckoutPage(WebDriver driver) {
        this.driver = driver;
    }

    // ----------- Cart Actions -----------
    public void clickAddToCart() {
        driver.findElement(CheckoutLocators.addToCartBtn).click();
    }

    public void goToCart() {
        driver.findElement(CheckoutLocators.shoppingCartButton).click();
    }

    public void searchProduct(String productName) {
        driver.findElement(CheckoutLocators.searchBoxText).sendKeys(productName);
    }

    public void updateProductQuantity(String quantity) {
        driver.findElement(CheckoutLocators.quantityInput).clear();
        driver.findElement(CheckoutLocators.quantityInput).sendKeys(quantity);
    }

    public void clickUpdateCartButton() {
        driver.findElement(CheckoutLocators.updateCartButton).click();
    }

    public String getUpdatedQuantity() {
        return driver.findElement(CheckoutLocators.quantityInput).getAttribute("value");
    }

    public boolean isCartEmptyMessageDisplayed(String expectedMessage) {
        String actualMessage = driver.findElement(CheckoutLocators.cartEmptyMessage).getText();
        return actualMessage.equals(expectedMessage);
    }

    public boolean verifyPageTitle(String expectedTitle) {
        return driver.findElement(CheckoutLocators.pageHeading).getText().equals(expectedTitle);
    }

    // ----------- Checkout Process -----------
    public void acceptTermsAndConditions() {
        driver.findElement(CheckoutLocators.termsAndCondition).click();
    }

    public void proceedToCheckout() {
        driver.findElement(CheckoutLocators.checkOut).click();
    }

    public void clickContinueBilling() {
        driver.findElement(CheckoutLocators.continueButton).click();
    }

    public void clickContinueShippingSave() {
        driver.findElement(CheckoutLocators.continueShippingsaveBtn).click();
    }

    public void selectShippingMethod(String method) {
        switch (method) {
            case "Ground (0.00)":
                driver.findElement(CheckoutLocators.groundShippingOption).click();
                break;
            case "Next Day Air (0.00)":
                driver.findElement(CheckoutLocators.nextDayShippingOption).click();
                break;
            case "2nd Day Air (0.00)":
                driver.findElement(CheckoutLocators.secondDayShippingOption).click();
                break;
        }
    }

    public void clickContinueShippingMethod() {
        driver.findElement(CheckoutLocators.continueShippingMethod).click();
    }

    public void selectPaymentMethod(String method) {
        switch (method) {
            case "Cash On Delivery (COD) (7.00)":
                driver.findElement(CheckoutLocators.COD).click();
                break;
            case "Check / Money Order (5.00)":
                driver.findElement(CheckoutLocators.Check_MoneyOrder).click();
                break;
            case "Credit Card":
                driver.findElement(CheckoutLocators.creditCard).click();
                break;
            case "Purchase Order":
                driver.findElement(CheckoutLocators.purchaseOrder).click();
                break;
        }
    }

    public void clickContinuePaymentMethod() {
        driver.findElement(CheckoutLocators.continuePayment).click();
    }

    public void clickContinuePaymentInfo() {
        driver.findElement(CheckoutLocators.continuePaymentInfo).click();
    }

    public void enterCreditCardDetails(String cardTypeValue, String holderName, String number,
                                       String month, String year, String code) {
        new Select(driver.findElement(CheckoutLocators.cardType)).selectByVisibleText(cardTypeValue);
        driver.findElement(CheckoutLocators.cardHolderName).sendKeys(holderName);
        driver.findElement(CheckoutLocators.cardNumber).sendKeys(number);
        new Select(driver.findElement(CheckoutLocators.expireMonth)).selectByVisibleText(month);
        new Select(driver.findElement(CheckoutLocators.expireYear)).selectByVisibleText(year);
        driver.findElement(CheckoutLocators.cardCode).sendKeys(code);
    }

    public void clickContinueViaCard() {
        driver.findElement(CheckoutLocators.continuePaymentViaCard).click();
    }

    public boolean isConfirmOrderVisible() {
        return driver.findElement(CheckoutLocators.assertConfirmOrder).isDisplayed();
    }

    public void clickConfirmOrder() {
        driver.findElement(CheckoutLocators.confirmBtn).click();
    }

    public boolean isOrderConfirmationDisplayed() {
        return driver.findElement(CheckoutLocators.assertOrderConfirmation)
                .getText().contains("successfully processed");
    }

    public void clickFinalContinueButton() {
        driver.findElement(CheckoutLocators.lastBtn).click();
    }

    // ----------- Promo Code -----------
    public void enterCouponCode(String code) {
        driver.findElement(CheckoutLocators.couponCodeField).clear();
        driver.findElement(CheckoutLocators.couponCodeField).sendKeys(code);
    }

    public void clickApplyCouponCode() {
        driver.findElement(CheckoutLocators.applyCouponButton).click();
    }

    public boolean isInvalidCouponCodeMessageDisplayed() {
        return driver.findElement(CheckoutLocators.invalidCouponMessage).isDisplayed();
    }
}
