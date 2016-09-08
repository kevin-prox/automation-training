package page;

import static org.openqa.selenium.By.*;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class HomePage extends BasePage {

    private static final ByClassName LOG_IN_BUTTON = new ByClassName("swa-header--login-button");
    private static final ByClassName LOG_IN_LINK = new ByClassName("js-swa-header--login");
    private static final ByClassName SEARCH_BUTTON = new ByClassName("gsa-search-header");
    private static final ByClassName SEARCH_DROPDOWN_BUTTON = new ByClassName("swa-header--search-button");
    private static final ByClassName SEARCH_DROPDOWN_HEADER = new ByClassName("swa-header--search-overlay");
    private static final ById CLOSE_OVERLAY_BUTTON = new ById("elclose");
    private static final ById LOG_IN_ERROR = new ById("username-error");
    private static final ById PASSWORD_FIELD = new ById("password");
    private static final ById SEARCH_INPUT_FIELD = new ById("swa-header--search-input");
    private static final ById USERNAME_FIELD = new ById("username");

    public HomePage(FirefoxDriver driver) {
        super(driver);
    }

    public WebElement getSearchButtonFromSearchDropdown() {
        return waitForElement(SEARCH_BUTTON, 30);
    }

    public boolean validateSearchDropdownDisplayed() {
        return elementExists(SEARCH_DROPDOWN_HEADER);
    }

    public WebElement getSearchInputField() {
        return waitForElement(SEARCH_INPUT_FIELD, 30);
    }

    public WebElement getSearchDropdownButton() {
        return waitForElement(SEARCH_DROPDOWN_BUTTON, 30);
    }

    public WebElement getCloseButton() {
        return waitForElement(CLOSE_OVERLAY_BUTTON, 30);
    }

    public WebElement getLogInLink() {
        return waitForElement(LOG_IN_LINK, 30);
    }

    public WebElement getUsernameField() {
        return waitForElement(USERNAME_FIELD, 30);
    }

    public WebElement getPasswordField() {
        return waitForElement(PASSWORD_FIELD, 30);
    }

    public WebElement getLogInButton() {
        return waitForElement(LOG_IN_BUTTON, 30);
    }

    public WebElement getLogInError() {
        return waitForElement(LOG_IN_ERROR, 30);
    }

    public void go() {
        getDriver().get("https://southwest.dev1.southwest.com/");
        getDriver().manage().window().maximize();
        sleep();
        getBody().sendKeys(Keys.ESCAPE);
        sleep();
    }
}

