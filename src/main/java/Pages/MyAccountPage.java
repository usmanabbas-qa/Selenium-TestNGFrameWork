package Pages;

import Locators.MyAccountLocators;
import org.openqa.selenium.WebDriver;

public class MyAccountPage {

    private final WebDriver driver;

    public MyAccountPage(WebDriver driver) {
        this.driver = driver;
    }

    public void clickOnUserAccount() {
        driver.findElement(MyAccountLocators.userAccountLink).click();
    }

    public void clickOnOrderslink() {
        driver.findElement(MyAccountLocators.ordersLink).click();
    }

    public String getAccountHeadingText() {
        return driver.findElement(MyAccountLocators.accountHeadings).getText();
    }

    public String getNoOrdersMessage() {
        return driver.findElement(MyAccountLocators.noOrdersMessage).getText();
    }

    public boolean isOrderPresent() {
        return !driver.findElements(MyAccountLocators.orderContainer).isEmpty();
    }

    public boolean isOrderNumberVisible() {
        return driver.findElement(MyAccountLocators.orderNumber).isDisplayed();
    }

    public boolean isOrderStatusVisible() {
        return driver.findElement(MyAccountLocators.orderStatus).isDisplayed();
    }

    public boolean isOrderDateVisible() {
        return driver.findElement(MyAccountLocators.orderDate).isDisplayed();
    }

    public boolean isOrderTotalVisible() {
        return driver.findElement(MyAccountLocators.orderTotal).isDisplayed();
    }

    public void clickDetailsButton() {
        driver.findElement(MyAccountLocators.detailsButton).click();
    }

    public boolean isOrderInformationPageDisplayed() {
        String heading = driver.findElement(MyAccountLocators.orderInfoHeading).getText();
        return heading.equalsIgnoreCase("Order Information");
    }

    public void clickPDFInvoiceButton() {
        driver.findElement(MyAccountLocators.pdfInvoiceButton).click();
    }
}
