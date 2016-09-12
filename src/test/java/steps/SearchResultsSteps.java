package steps;

import org.jbehave.core.annotations.Then;
import org.jbehave.core.steps.Steps;
import page.PageFactory;
import page.SearchResultsPage;

import static org.junit.Assert.*;

public class SearchResultsSteps extends Steps {

    private SearchResultsPage searchResultsPage;

    public SearchResultsSteps(PageFactory pageFactory) {
        this.searchResultsPage = pageFactory.getSearchResultsPageInstance();
    }

    @Then("I see the search keyword in the Search title")
    public void validateSearchResultPageTitle() {
        String expectedResults = "“" + searchResultsPage.getStoredValue("searchText") + "”";
        String actualResults = searchResultsPage.getSearchTitle().getText();

        assertEquals(expectedResults, actualResults);
    }
}
