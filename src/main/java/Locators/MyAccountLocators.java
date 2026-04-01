package Locators;

import org.openqa.selenium.By;

public class MyAccountLocators {

    public static  By userAccountLink = By.cssSelector("div[class='header-links'] a[class='account']");
    public static  By ordersLink = By.cssSelector("a[href='/customer/orders']");
    public static  By accountHeadings = By.cssSelector("div[class='page-title'] h1");
    public static By noOrdersMessage = By.cssSelector(".order-list");
    public static By orderNumber = By.cssSelector("div[class='section order-item'] strong");
    public static By orderStatus = By.xpath("//li[normalize-space()='Order status: Pending']");
    public static By orderDate = By.xpath("//li[normalize-space()='Order Date: 7/24/2025 5:00:14 PM']");
    public static By orderTotal = By.xpath("//li[normalize-space()='Order Total: 57.00']");
    public static By orderContainer = By.cssSelector(".section.order-item");
    public static By detailsButton = By.cssSelector("input[value='Details']");
    public static By orderInfoHeading = By.cssSelector("div.page-title h1");
    public static By pdfInvoiceButton = By.cssSelector(".button-2.pdf-order-button");
}
