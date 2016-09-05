package steps;

/**
 * Created by developer on 9/5/16.
 */


import org.jbehave.core.annotations.*;
import org.jbehave.core.steps.Steps;
import page.HomePage;
import page.PageFactory;

import static org.junit.Assert.assertTrue;


public class HomePageLoginSteps extends Steps {

    private HomePage homePage = PageFactory.getHomePageInstance();

    @Given("I am on the Home page")
    public void goToHomePage() {
        homePage.go();
    }

    @When("I click on the Log In icon in the Primary Header Navigation of the page")
    public void clickOnLoginDropdown() { homePage.getLoginLink().click();
    }

    @Then("I see the Login dropdown opened")
    public void validateSearchLoginDisplayed() {
        assertTrue(homePage.validateLoginDropdownDisplayed());
    }



    @When("I enter $InvalidUser on the user field")
    public void getUsernameField(String InvalidUser){
        homePage.storeValue("InvalidUser", InvalidUser);
        homePage.getUsernameField().sendKeys("InvalidUser");
    }




    @When("I enter $Password value on the password field")
    public void enterTextIntoPasswordField(String Password) {
        homePage.storeValue("Password", Password);
        homePage.getInputFieldUserPassword().sendKeys(Password);
    }


    @When("I click on Login Button button in the search dropdown")
    public void clickOnLoginButton() {
        homePage.getLoginButton().click();
    }


    @Then("I see the error message at the bottom of the dropdown")
    public void validateErrorMjeDisplayed() {

    }
}



