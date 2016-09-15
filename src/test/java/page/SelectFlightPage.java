package page;

import org.openqa.selenium.By.*;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.List;

public class SelectFlightPage extends BasePage {

    private static final ByClassName FLIGHT_ROWS = new ByClassName("air-booking-select-detail");
    private static final ByClassName CONTINUE_BUTTON = new ByClassName("air-booking-select-continue-button");
    private static final ByClassName FARE_DETAIL_CONTAINER = new ByClassName("fare-detail--content");
    private static final ByCssSelector PRICE_SORTING =  new ByCssSelector(" .listbox--flyout-content .menu--item-list > li:nth-child(3)");
    private static final ByCssSelector DROP_DOWN_SORTING =  new ByCssSelector("[aria-label*='Sort results by']");
    private static final ByClassName LOCK_HEADER = new ByClassName("header-control--sticky-toggle");
    private static final ByCssSelector DEPART_BUTTONS = new ByCssSelector("#air-booking-product-0 > div:last-child > ul > li.air-booking-select-detail_min-products > div.select-detail--fares > div.fare-button > button.fare-button--button");
    private static final ByCssSelector RETURN_BUTTONS = new ByCssSelector("#air-booking-product-1 > div:last-child > ul > li.air-booking-select-detail_min-products > div.select-detail--fares > div.fare-button > button.fare-button--button");
    private static final ByCssSelector fareDetailAnytime = new ByCssSelector(".fare-detail--content >  .fare-detail--info > .fare-detail--heading_anytime");
    private static final ByCssSelector UPGRADE_CONTINUE_BTN = new ByCssSelector("#upgradeToBusModal .upgrade-modal--actions button");

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



    public List<WebElement> getDropDownSorting() { return waitForElements(DROP_DOWN_SORTING,30); }

    public WebElement getPriceSorting() { return waitForElement(PRICE_SORTING, 30); }

    public WebElement getLockHeader() { return waitForElement(LOCK_HEADER, 30); }

    public List<WebElement> getDepartButtons() { return waitForElements(DEPART_BUTTONS, 30); }

    public List<WebElement> getReturnButtons() { return waitForElements(RETURN_BUTTONS, 30); }

    public WebElement getFareDetailAnytime() {return waitForElement(fareDetailAnytime, 30); }

    public WebElement getUpgradeContinueBtn() {return waitForElement( UPGRADE_CONTINUE_BTN,30);}
}
