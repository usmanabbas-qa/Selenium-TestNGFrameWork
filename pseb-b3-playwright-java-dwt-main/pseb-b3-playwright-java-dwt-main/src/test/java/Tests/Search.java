package Tests;

import Base.BaseTest;
import Pages.SearchPage;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Search extends BaseTest {

    SearchPage searchPage;

    @BeforeMethod
    public void setUp() {
        // Instantiate SearchPage using initialized WebDriver from BaseTest
        searchPage = new SearchPage(getDriver());
        searchPage.navigateToHomePage(); // Optional if already starting at home
    }

    @Test(description = "TC_SEARCH_001 - Verify that the search bar is displayed on the homepage")
    public void TC_SEARCH_001_verifySearchBarIsVisible() {
        boolean isVisible = searchPage.isSearchBarVisible();
        System.out.println("Search bar visibility: " + isVisible);
        Assert.assertTrue(isVisible, "Search bar is not visible on the homepage!");
    }

    @Test(description = "TC_SEARCH_002 - Check input functionality in the search bar")
    public void TC_SEARCH_002_checkSearchInputFunctionality() {
        String keyword = "Test Search";
        searchPage.enterSearchText(keyword);
        String actualText = searchPage.getSearchInputValue();
        System.out.println("Entered search text: " + actualText);
        Assert.assertEquals(actualText, keyword, "Search input value does not match the expected text!");
    }

    @Test(description = "TC_SEARCH_003 - Verify that clicking the search button performs a search")
    public void TC_SEARCH_003_checkSearchByClickingButton() {
        String keyword = "Smartphone";
        searchPage.enterSearchText(keyword);
        searchPage.clickSearchButton();
        boolean resultsDisplayed = searchPage.isSearchResultsDisplayed(keyword);
        Assert.assertTrue(resultsDisplayed);
    }

    @Test(description = "TC_SEARCH_004 - Verify that pressing Enter in the search bar triggers the search")
    public void TC_SEARCH_004_checkSearchWithEnterKey() {
        String keyword = "Mouse";
        searchPage.enterSearchTextAndPressEnter(keyword);
        boolean resultsDisplayed = searchPage.isSearchResultsDisplayed(keyword);
        Assert.assertTrue(resultsDisplayed, "Search results are not displayed after pressing Enter for keyword: " + keyword);
    }

    @Test(description = "TC_SEARCH_005 - Verify search results for valid queries")
    public void TC_SEARCH_005_verifySearchResultsForValidQuery() {
        String keyword = "Laptop";
        searchPage.enterSearchText(keyword);
        searchPage.clickSearchButton();
        boolean resultsDisplayed = searchPage.isSearchResultsDisplayed(keyword);
        Assert.assertTrue(resultsDisplayed, "Search results are not displayed for valid keyword: " + keyword);
    }
}
