package page;

import org.openqa.selenium.firefox.FirefoxDriver;

public class PageFactory {
    private static FirefoxDriver driver;
    private static HomePage homePage;
    private static SearchResultsPage searchResultsPage;

    public static HomePage getHomePageInstance() {
        if (homePage == null) {
            homePage = new HomePage(getDriverInstance());
        }

        return homePage;
    }

    public static SearchResultsPage getSearchResultsPageInstance() {
        if (searchResultsPage == null) {
            searchResultsPage = new SearchResultsPage(getDriverInstance());
        }

        return searchResultsPage;
    }

    private static FirefoxDriver getDriverInstance() {
        if (driver == null) {
            driver = new FirefoxDriver();
        }

        return driver;
    }
}
