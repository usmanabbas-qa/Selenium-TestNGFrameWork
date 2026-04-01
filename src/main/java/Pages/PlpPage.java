package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class PlpPage {

    private final WebDriver driver;

    public PlpPage(WebDriver driver) {
        this.driver = driver;
    }

    public void clickOnCategory(String categoryName) {
        By categoryLocator = By.xpath("//div[@class='block block-category-navigation']//a[normalize-space(text())='" + categoryName + "']");
        driver.findElement(categoryLocator).click();
    }
}
