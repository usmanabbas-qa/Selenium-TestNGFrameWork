package Tests;

import Base.BaseTest;
import Pages.CheckoutPage;
import Pages.DashboardPage;
import Pages.PlpPage;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Plp extends BaseTest {

    PlpPage plp;
    DashboardPage dashboard;
    CheckoutPage checkout;

    @BeforeMethod
    public void setUp() {
        // Instantiate page objects after WebDriver is initialized
        plp = new PlpPage(getDriver());
        dashboard = new DashboardPage(getDriver());
        checkout = new CheckoutPage(getDriver());

        // Login
        dashboard.navigateToLoginPage();
        dashboard.enterEmail("test15@t.com");
        dashboard.enterPassword("qwerty@123456");
        dashboard.clickLogin();
    }

    @Test(description = "TC_PLP_001 - Verify Book Category")
    public void TC_PLP_001_verifyBookCategory() {
        plp.clickOnCategory("Books");
        Assert.assertTrue(checkout.verifyPageTitle("Books"), "Books page not displayed.");
    }

    @Test(description = "TC_PLP_002: Verify Computers category displays desktops, notebooks, and accessories")
    public void TC_PLP_002_verifyComputersCategoryWithSubCategories() {
        plp.clickOnCategory("Computers");
        Assert.assertTrue(checkout.verifyPageTitle("Computers"), "Computers page not displayed.");

        plp.clickOnCategory("Desktops");
        Assert.assertTrue(checkout.verifyPageTitle("Desktops"), "Desktops page not displayed.");

        plp.clickOnCategory("Notebooks");
        Assert.assertTrue(checkout.verifyPageTitle("Notebooks"), "Notebooks page not displayed.");

        plp.clickOnCategory("Accessories");
        Assert.assertTrue(checkout.verifyPageTitle("Accessories"), "Accessories page not displayed.");
    }

    @Test(description = "TC_PLP_003: Verify Desktops category displays desktop items")
    public void TC_PLP_003_verifyDesktopsCategory() {
        plp.clickOnCategory("Computers");
        plp.clickOnCategory("Desktops");
        Assert.assertTrue(checkout.verifyPageTitle("Desktops"), "Desktops page not displayed.");
    }

    @Test(description = "TC_PLP_004: Verify Notebooks category displays notebook items")
    public void TC_PLP_004_verifyNotebooksCategory() {
        plp.clickOnCategory("Computers");
        plp.clickOnCategory("Notebooks");
        Assert.assertTrue(checkout.verifyPageTitle("Notebooks"), "Notebooks page not displayed.");
    }

    @Test(description = "TC_PLP_005: Verify Accessories category displays accessory items")
    public void TC_PLP_005_verifyAccessoriesCategory() {
        plp.clickOnCategory("Computers");
        plp.clickOnCategory("Accessories");
        Assert.assertTrue(checkout.verifyPageTitle("Accessories"), "Accessories page not displayed.");
    }
}
