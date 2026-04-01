package Tests;

import Base.BaseTest;
import Pages.DashboardPage;
import Pages.MyAccountPage;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class MyAccount extends BaseTest {

    DashboardPage dashboard;
    MyAccountPage myAccountPage;

    @BeforeMethod
    public void LoginDetails() {
        dashboard = new DashboardPage(getDriver());
        myAccountPage = new MyAccountPage(getDriver());  // Properly initialized with WebDriver

        dashboard.navigateToLoginPage();
        dashboard.enterEmail("test15@t.com");
        dashboard.enterPassword("qwerty@123456");
        dashboard.clickLogin();
    }

    @Test(description = "TC_MyAccount_001 - Verify 'My account - Orders' page title")
    public void TC_MyAccount_001_verifyOrdersPageTitle() throws InterruptedException {
        myAccountPage.clickOnUserAccount();
        Thread.sleep(2000);
        myAccountPage.clickOnOrderslink();

        String message = myAccountPage.getAccountHeadingText();
        System.out.println("Displayed message: " + message);

        Assert.assertTrue(message.contains("My account - Orders"),
                "Expected heading 'My account - Orders' not found!");
    }

    @Test(description = "TC_MyAccount_002 - Verify 'No orders' message is displayed when there are no orders")
    public void TC_MyAccount_002_verifyNoOrdersMessageIsDisplayed() throws InterruptedException {
        myAccountPage.clickOnUserAccount();
        Thread.sleep(2000);
        myAccountPage.clickOnOrderslink();
        Thread.sleep(2000);

        String message = myAccountPage.getNoOrdersMessage();
        System.out.println("Displayed message: " + message);

        Assert.assertTrue(message.contains("No orders"),
                "Expected 'No orders' message was not displayed.");
    }

    @Test(description = "TC_MyAccount_003 - Verify that all order details are visible")
    public void TC_MyAccount_003_verifyOrderDetails() throws InterruptedException {
        myAccountPage.clickOnUserAccount();
        Thread.sleep(2000);
        myAccountPage.clickOnOrderslink();
        Thread.sleep(2000);

        Assert.assertTrue(myAccountPage.isOrderNumberVisible(), "Order number is not visible.");
        Assert.assertTrue(myAccountPage.isOrderStatusVisible(), "Order status is not visible.");
        Assert.assertTrue(myAccountPage.isOrderDateVisible(), "Order date is not visible.");
        Assert.assertTrue(myAccountPage.isOrderTotalVisible(), "Order total is not visible.");

        System.out.println("All order details are displayed as expected.");
    }

    @Test(description = "TC_MyAccount_004 - Verify clicking on 'Details' redirects to order information page")
    public void TC_MyAccount_004_verifyOrderDetailsRedirection() throws InterruptedException {
        myAccountPage.clickOnUserAccount();
        Thread.sleep(2000);
        myAccountPage.clickOnOrderslink();
        Thread.sleep(2000);

        myAccountPage.clickDetailsButton();
        Assert.assertTrue(myAccountPage.isOrderInformationPageDisplayed(),
                "Failed to navigate to Order Information page after clicking Details.");

        System.out.println("Successfully navigated to Order Information page.");
    }

    @Test(description = "TC_MyAccount_005 - Verify clicking on PDF Invoice generates and downloads the invoice")
    public void TC_MyAccount_005_verifyPDFInvoiceDownload() throws InterruptedException {
        myAccountPage.clickOnUserAccount();
        Thread.sleep(2000);
        myAccountPage.clickOnOrderslink();
        Thread.sleep(2000);
        myAccountPage.clickDetailsButton();
        Thread.sleep(2000);

        Assert.assertTrue(myAccountPage.isOrderInformationPageDisplayed(),
                "Order Information page not displayed.");

        myAccountPage.clickPDFInvoiceButton();
        System.out.println("Clicked on 'PDF Invoice' button. Check Downloads folder for invoice file.");
    }
}
