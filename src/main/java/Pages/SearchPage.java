package Pages;

import Locators.SearchLocators;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SearchPage {

    private final WebDriver driver;

    public SearchPage(WebDriver driver) {
        this.driver = driver;
    }

    public void navigateToHomePage() {
        driver.get("https://demowebshop.tricentis.com/");
    }

    public boolean isSearchBarVisible() {
        return driver.findElement(SearchLocators.searchBarField).isDisplayed();
    }

    public void enterSearchText(String text) {
        WebElement input = driver.findElement(SearchLocators.searchBarField);
        input.clear();
        input.sendKeys(text);
    }

    public String getSearchInputValue() {
        return driver.findElement(SearchLocators.searchBarField).getAttribute("value");
    }

    public void clickSearchButton() {
        driver.findElement(SearchLocators.searchButton).click();
    }

    public boolean isSearchResultsDisplayed(String keyword) {
        return driver.getPageSource().toLowerCase().contains(keyword.toLowerCase());
    }

    public void enterSearchTextAndPressEnter(String text) {
        WebElement input = driver.findElement(SearchLocators.searchBarField);
        input.clear();
        input.sendKeys(text + Keys.ENTER);
    }
}
