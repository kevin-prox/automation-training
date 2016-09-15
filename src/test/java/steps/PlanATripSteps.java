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

    private DateTime DT = new DateTime();

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
                    if ("ONE_WAY".equalsIgnoreCase(value)) planATripPage.getOneWayRadio().click();
                    else planATripPage.getRoundTripRadio().click();
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
                case "departureDate": //al dia de hoy le sumo la cantidad de dias que me pasan por parametro
                    final String str = (DT.getMonthOfYear())+"/"+DT.plusDays(Integer.valueOf(value)).getDayOfMonth();
                    planATripPage.getDepartureDateInput().sendKeys(str);
                    //planATripPage.getDepartureDateInput().sendKeys(getDate(Integer.valueOf(value)));
                    planATripPage.getDepartureDateInput().sendKeys(Keys.TAB);
                    break;
                case "returnDate": //al dia de hoy le sumo la cantidad de dias que me pasan por parametro
                    //planATripPage.getReturnDateInput().sendKeys(getDate(Integer.valueOf(value)));
                    planATripPage.getReturnDateInput().sendKeys((DT.plusMonths(1).getMonthOfYear())+"/"+DT.plusDays(Integer.valueOf(value)).getDayOfMonth());
                    planATripPage.getReturnDateInput().sendKeys(Keys.TAB);
                    break;
                case "adultCounter":
                    planATripPage.getAdultCounter().click();
                    int actualAdultNumber = 1;
                    int adultsNumber = Integer.valueOf(planATripPage.getAdultNumber().getText());
                    while (adultsNumber == actualAdultNumber ) {
                        actualAdultNumber++;
                        planATripPage.getAdultCountrPlus().click();
                    }
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
