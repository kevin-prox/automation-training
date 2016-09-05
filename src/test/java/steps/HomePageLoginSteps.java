package steps;

//import com.sun.xml.internal.ws.policy.AssertionValidationProcessor;
import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;
import org.jbehave.core.steps.Steps;
import org.springframework.util.Assert;
import page.HomePage;
import page.PageFactory;

import static org.junit.Assert.assertTrue;


/**
 * Created by developer on 9/5/16.
 */
public class HomePageLoginSteps extends Steps {

    private HomePage homePage = PageFactory.getHomePageInstance();

    @Given("I'm on the Home page")
    public void goToHomePage() { homePage.go(); }

    @When("I click on the Log In icon in the Primary Header Navigation of the page")
    public void getLoginLink() { homePage.getLoginlink().click(); }

    @Then("I see the Login dropdown opened")
    public void assertLoginDropdown(){ assertTrue(homePage.getLoginDropdown()); }

    @When("I enter $InvalidUser on the user field")
    public void getUsernameField(String InvalidUser){
        homePage.storeValue("InvalidUser", InvalidUser);
        homePage.getUsernameField().sendKeys("InvalidUser");
    }

    @When("I enter $InvalidPass on the password field")
    public void getPasswordField(String InvalidPass){
        homePage.storeValue("InvalidPass", InvalidPass);
        homePage.getPasswordField().sendKeys("InvalidPass");}

    @When("I click on Login button in the search dropdown")
    public void clickLogin(){homePage.getLoginButton().click();}

    @Then("I see the error message at the bottom of the dropdown")
    public void assertErrorMessage(){
        assertTrue(homePage.getErrorMessage());
    }




}
