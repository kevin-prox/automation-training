package page;

import org.openqa.selenium.By;
import org.openqa.selenium.By.*;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.w3c.dom.ls.LSException;

import java.util.List;

public class PricePage extends BasePage {

    private static final ByClassName PRICE_PAGE_CONTAINER = new ByClassName("checkout-price-page");
    private static final ByClassName PRICE_PAGE_SEGMENTS = new ByClassName("flight-segments--airport-code");
    private static final ByClassName SUBMIT_BUTTON = new ByClassName("checkout-price-continue-button");
    private static final ByCssSelector LBL_TRIP_TYPE = new ByCssSelector(".checkout-fare-type-descriptions >  .fare-type-descriptions--item  div.fare-button--title");




    private static final ByCssSelector TYPE_FLY_LABELS = new By.ByCssSelector(".fare-button--title");


    public PricePage(FirefoxDriver driver) {
        super(driver);
    }

    public boolean isPricePageContainerDisplayed() {
        return waitForElement(PRICE_PAGE_CONTAINER, 30).isDisplayed();
    }

    public List<WebElement> getPricePageSegments() {
        return waitForElements(PRICE_PAGE_SEGMENTS, 30);
    }



    public List<WebElement> getTipeFlyLabels() {
        return waitForElements(TYPE_FLY_LABELS, 30);
    }

    public List<WebElement> getSubmitButton() {
        return waitForElements( SUBMIT_BUTTON,30);
    }

    public  List<WebElement> getLblTripType() { return waitForElements(LBL_TRIP_TYPE,30); }
}