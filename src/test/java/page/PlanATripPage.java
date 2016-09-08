package page;

import org.openqa.selenium.By.*;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class PlanATripPage extends BasePage {

    private static final ByCssSelector ONE_WAY_RADIO = new ByCssSelector(".check-fares-search--flight .input-group--list > li:nth-child(2) span");
    private static final ById DEPART_INPUT = new ById("originationAirportCode");
    private static final ById DEPARTURE_DATE = new ById("departureDate");
    private static final ById ARRIVE_INPUT = new ById("destinationAirportCode");
    private static final ById SEARCH_BUTTON = new ById("form-mixin--submit-button");

    public PlanATripPage(FirefoxDriver driver) {
        super(driver);
    }

    public WebElement getOneWayRadio() {
        return waitForElement(ONE_WAY_RADIO, 30);
    }

    public WebElement getDepartInput() {
        return waitForElement(DEPART_INPUT, 30);
    }

    public WebElement getDepartureDateInput() {
        return waitForElement(DEPARTURE_DATE, 30);
    }

    public WebElement getArriveInput() {
        return waitForElement(ARRIVE_INPUT, 30);
    }

    public WebElement getSearchButton() {
        return waitForElement(SEARCH_BUTTON, 30);
    }

    public void go() {
        getDriver().get("https://southwest.dev1.southwest.com/air/booking/");
        getDriver().manage().window().maximize();
    }
}
