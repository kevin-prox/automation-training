package steps;

import org.jbehave.core.annotations.*;
import org.jbehave.core.steps.Steps;
import org.openqa.selenium.Keys;
import page.PageFactory;
import page.PlanATripPage;

public class PlanATripSteps extends Steps {

    private PlanATripPage planATripPage;

    public PlanATripSteps(PageFactory pageFactory) {
        this.planATripPage = pageFactory.getPlanATripInstance();
    }

    @Given("I am on the Plan a Trip page")
    public void goToPlanATripPage() {
        planATripPage.go();
    }

    @When("I select the one way flight type on the Plan a Trip Page")
    public void selectOneWayFlightType() {
        planATripPage.getOneWayRadio().click();
    }

    @When("I enter $departure into depart input field on the Plan a Trip Page")
    public void enterDepartureInput(String departure) {
        planATripPage.getDepartInput().sendKeys(departure);
        planATripPage.getDepartInput().sendKeys(Keys.TAB);
    }

    @When("I enter $date date into depart day input field on the Plan a Trip Page")
    public void enterDepartureDateInput(String date) {
        planATripPage.getDepartureDateInput().sendKeys(date);
        planATripPage.getDepartureDateInput().sendKeys(Keys.TAB);
    }

    @When("I enter $arrival into arrive input field on the Plan a Trip Page")
    public void enterArriveInput(String arrival) {
        planATripPage.getArriveInput().sendKeys(arrival);
        planATripPage.getArriveInput().sendKeys(Keys.TAB);
    }

    @When("I search a flight")
    public void clickOnSearchButton() {
        planATripPage.getSearchButton().click();
    }
}
