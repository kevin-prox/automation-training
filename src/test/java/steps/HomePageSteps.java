package steps;

import org.jbehave.core.annotations.*;
import org.jbehave.core.steps.Steps;
import page.HomePage;
import page.PageFactory;

import static org.junit.Assert.*;

public class HomePageSteps extends Steps {

    private HomePage homePage = PageFactory.getHomePageInstance();

    @Given("I am on the Home page")
    public void goToHomePage() {
        homePage.go();
    }

    @When("I click on the Search icon in the Primary Header Navigation of the page")
    public void clickOnSearchButton() {
        homePage.getSearchButtonFromSearchDropdown().click();
    }

    @Then("I see the Search dropdown opened")
    public void validateSearchDropdownIsOpened() {
        assertTrue(homePage.validateSearchDropdownDisplayed());
    }

    @When("I enter $searchText value in the search field")
    public void enterTextIntoSearchField(String searchText) {
        homePage.storeValue("searchText", searchText);
        homePage.getSearchInputField().sendKeys(searchText);
    }

    @When("I click on Search button in the search dropdown")
    public void clickOnSearchDropdownButton() {
        homePage.getSearchDropdownButton().click();
    }
}
