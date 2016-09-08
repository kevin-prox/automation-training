package steps;

import org.jbehave.core.annotations.*;
import org.jbehave.core.steps.Steps;
import page.HomePage;
import page.PageFactory;

import static org.junit.Assert.*;

public class HomePageSteps extends Steps {

    private HomePage homePage;

    public HomePageSteps(PageFactory pageFactory) {
        this.homePage = pageFactory.getHomePageInstance();
    }

    @Given("I am on the Home page")
    public void goToHomePage() {
        homePage.go();
    }

    @When("I click on the Search icon in the Primary Header Navigation of the page")
    public void clickOnSearchButton() {
        homePage.getSearchButtonFromSearchDropdown().click();
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

    @When("I click on the Log In link in the Primary header navigation of the page")
    public void clickOnLogInLink() {
        homePage.getLogInLink().click();
    }

    @When("I enter $text in the ACCOUNT NUMBER OR USERNAME field in the Log In dropdown")
    public void enterDataInUsernameField(String text) {
        homePage.getUsernameField().sendKeys(text);
    }

    @When("I enter $text in the PASSWORD field in the Log In dropdown")
    public void enterDataInPasswordField(String text) {
        homePage.getPasswordField().sendKeys(text);
    }

    @When("I click on Log In button")
    public void clickOnLogInButton() {
        homePage.getLogInButton().click();
    }

    @Then("I see $errorText error message")
    public void validateLogInErrorText(String errorText){
        String actualErrorText = homePage.getLogInError().getText();

        assertEquals(errorText, actualErrorText);
    }

    @Then("I see the Log In fields empty")
    public void validateLogInFieldsAreEmpty(){
        String actualUsernameText = homePage.getUsernameField().getAttribute("value");
        String actualPasswordText = homePage.getPasswordField().getAttribute("value");

        assertEquals(actualUsernameText, "");
        assertEquals(actualPasswordText, "");
    }

    @Then("I see the Search dropdown opened")
    public void validateSearchDropdownIsOpened() {
        assertTrue(homePage.validateSearchDropdownDisplayed());
    }
}
