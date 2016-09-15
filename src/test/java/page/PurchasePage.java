package page;


import org.openqa.selenium.By.*;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

/**
 * Created by developer on 9/14/16.
 */
public class PurchasePage extends BasePage {

    public PurchasePage(FirefoxDriver driver) {
        super(driver);
    }



    private static final ByCssSelector BASE_CONTAINER = new ByCssSelector(".purchase--container-section");


    public boolean isBaseContainerDisplayed() {
        return waitForElement(BASE_CONTAINER, 30).isDisplayed();
    }

}