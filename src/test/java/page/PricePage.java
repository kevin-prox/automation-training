package page;

import org.openqa.selenium.By.*;
import org.openqa.selenium.firefox.FirefoxDriver;

public class PricePage extends BasePage {

    private static final ByClassName PRICE_PAGE_CONTAINER = new ByClassName("checkout-price-page");

    public PricePage(FirefoxDriver driver) {
        super(driver);
    }

    public boolean isPricePageContainerDisplayed() {
        return waitForElement(PRICE_PAGE_CONTAINER, 30).isDisplayed();
    }
}
