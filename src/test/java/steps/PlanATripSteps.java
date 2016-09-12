package steps;

import org.jbehave.core.annotations.*;
import org.jbehave.core.model.ExamplesTable;
import org.jbehave.core.steps.Steps;
import org.joda.time.*;
import org.openqa.selenium.Keys;
import page.PageFactory;
import page.PlanATripPage;

import java.util.Map;

public class PlanATripSteps extends Steps {

    private PlanATripPage planATripPage;

    public PlanATripSteps(PageFactory pageFactory) {
        this.planATripPage = pageFactory.getPlanATripInstance();
    }

    @Given("I am on the Plan a Trip page")
    public void goToPlanATripPage() {
        planATripPage.go();
    }

    @When("I fill the flight fields with the following itinerary data: $table")
    public void createBookingFlight(ExamplesTable table) {
        for (Map<String, String> row : table.getRows()) {
            String key = row.get("key");
            String value = row.get("value");

            switch(key) {
                case "flightType":
                    if ("ONE_WAY".equalsIgnoreCase(value)) {
                        planATripPage.getOneWayRadio().click();
                    }
                    break;
                case "departureCity":
                    planATripPage.storeValue("departureCity", value);
                    planATripPage.getDepartInput().sendKeys(value);
                    planATripPage.getDepartInput().sendKeys(Keys.TAB);
                    break;
                case "returnCity":
                    planATripPage.storeValue("returnCity", value);
                    planATripPage.getArriveInput().sendKeys(value);
                    planATripPage.getArriveInput().sendKeys(Keys.TAB);
                    break;
                case "departureDate":
                    planATripPage.getDepartureDateInput().sendKeys(getDate(Integer.valueOf(value)));
                    planATripPage.getDepartureDateInput().sendKeys(Keys.TAB);
                    break;
                case "returnDate":
                    planATripPage.getReturnDateInput().sendKeys(getDate(Integer.valueOf(value)));
                    planATripPage.getReturnDateInput().sendKeys(Keys.TAB);
                    break;
                default:
                    break;
            }
        }
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

    private String getDate(int daysToAdd) {
        LocalDate date = LocalDate.now();
        DateTime dateTime = new DateTime(date.toDate());

        dateTime = dateTime.plusDays(daysToAdd);

        return dateTime.toString("MM/dd");
    }
}
