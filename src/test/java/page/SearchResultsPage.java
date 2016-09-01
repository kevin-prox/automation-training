package page;

import static org.openqa.selenium.By.*;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class SearchResultsPage extends BasePage {

    private static final ByClassName SEARCH_RESULTS_TITLE = new ByClassName("search_results_searchTitle");

    public SearchResultsPage(FirefoxDriver driver) {
        super(driver);
    }

    public WebElement getSearchTitle() {
        return waitForElement(SEARCH_RESULTS_TITLE, 30);
    }
}
