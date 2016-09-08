package page;

import org.openqa.selenium.By.*;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.List;

public class SelectFlightPage extends BasePage {

    private static final ByClassName FLIGHT_ROWS = new ByClassName("air-booking-select-detail");
    private static final ByClassName CONTINUE_BUTTON = new ByClassName("air-booking-select-continue-button");
    private static final ByClassName FARE_DETAIL_CONTAINER = new ByClassName("fare-detail--content");

    public SelectFlightPage(FirefoxDriver driver) {
        super(driver);
    }

    public List<WebElement> getFlightRows() {
        return waitForElements(FLIGHT_ROWS, 30);
    }

    public WebElement getContinueButton() {
        return waitForElement(CONTINUE_BUTTON, 30);
    }

    public boolean isFareFareDetailContainerDisplayed() {
        return waitForElement(FARE_DETAIL_CONTAINER, 30).isDisplayed();
    }
}
