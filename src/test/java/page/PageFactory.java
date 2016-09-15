package page;

import org.jbehave.web.selenium.WebDriverProvider;
import org.openqa.selenium.firefox.FirefoxDriver;

public class PageFactory {
    private static FirefoxDriver driver;
    private static HomePage homePage;
    private static PlanATripPage planATripPage;
    private static SelectFlightPage selectFlightPage;
    private static SearchResultsPage searchResultsPage;
    private static PricePage pricePage;
    private static PurchasePage purchasePage;

    public PageFactory(FirefoxDriver firefoxDriver) {
        this.driver = firefoxDriver;
    }

    public HomePage getHomePageInstance() {
        if (homePage == null) {
            homePage = new HomePage(driver);
        }

        return homePage;
    }

    public PlanATripPage getPlanATripInstance() {
        if (planATripPage == null) {
            planATripPage = new PlanATripPage(driver);
        }

        return planATripPage;
    }

    public PurchasePage getPurchasePageInstance() {
        if (purchasePage == null) {
            purchasePage = new PurchasePage(driver);
        }

        return purchasePage;
    }

    public SelectFlightPage getSelectFlightPageInstance() {
        if (selectFlightPage == null) {
            selectFlightPage = new SelectFlightPage(driver);
        }

        return selectFlightPage;
    }

    public SearchResultsPage getSearchResultsPageInstance() {
        if (searchResultsPage == null) {
            searchResultsPage = new SearchResultsPage(driver);
        }

        return searchResultsPage;
    }

    public PricePage getPricePageInstance() {
        if (pricePage == null) {
            pricePage = new PricePage(driver);
        }

        return pricePage;
    }
}
