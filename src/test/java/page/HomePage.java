package page;

import static org.openqa.selenium.By.*;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class HomePage extends BasePage {

    private static final ByClassName SEARCH_BUTTON = new ByClassName("gsa-search-header");
    private static final ByClassName SEARCH_DROPDOWN_HEADER = new ByClassName("swa-header--search-overlay");
    private static final ById SEARCH_INPUT_FIELD = new ById("swa-header--search-input");
    private static final ByClassName SEARCH_DROPDOWN_BUTTON = new ByClassName("swa-header--search-button");
    private static final ById CLOSE_OVERLAY_BUTTON = new ById("elclose");


    private static final ByClassName LOGIN_LINK = new ByClassName("swa-header--login");
    private static final ByClassName ENROLL_LINK = new ByClassName("swa-header--login-enroll-text");
    private static final ById USERNAME_FIELD = new ById("username");
    private static final ById PASSWORD_FIELD = new ById("password");
    private static final ByClassName LOGIN_BUTTON = new ByClassName("swa-header--login-button\n");
    private static final ById ERROR_MESSAGE = new ById("password-error");



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




    public WebElement getLoginLink() { return waitForElement(LOGIN_LINK, 30); }


    public WebElement getPasswordField() { return waitForElement(PASSWORD_FIELD, 30); }

    public WebElement getLoginButton() { return waitForElement(LOGIN_BUTTON, 30); }


    public boolean validateLoginDropdownDisplayed() {
        return elementExists(ENROLL_LINK);
    }

    public WebElement getUsernameField() { return waitForElement(USERNAME_FIELD, 30); }

    

    public WebElement getInputFieldUserPassword() {
        return waitForElement(PASSWORD_FIELD, 30);
    }



    public WebElement getErrorMessage(){ return waitForElement(ERROR_MESSAGE, 30); }



    public boolean validateErrorMjeDisplayed() {
        return elementExists(ERROR_MESSAGE);
    }



    public void go() {
        getDriver().get("https://www.southwest.com/");
        getDriver().manage().window().maximize();
        sleep();
        getBody().sendKeys(Keys.ESCAPE);
        sleep();
    }
}

