package page;

import org.openqa.selenium.By.*;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.List;

public class PricePage extends BasePage {

    private static final ByClassName PRICE_PAGE_CONTAINER = new ByClassName("checkout-price-page");
    private static final ByClassName PRICE_PAGE_SEGMENTS = new ByClassName("flight-segments--airport-code");

    public PricePage(FirefoxDriver driver) {
        super(driver);
    }

    public boolean isPricePageContainerDisplayed() {
        return waitForElement(PRICE_PAGE_CONTAINER, 30).isDisplayed();
    }

    public List<WebElement> getPricePageSegments() {
        return waitForElements(PRICE_PAGE_SEGMENTS, 30);
    }
}