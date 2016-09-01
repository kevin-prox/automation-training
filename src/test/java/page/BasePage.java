package page;

import org.openqa.selenium.By;
import org.openqa.selenium.By.*;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.HashMap;

public class BasePage {

    private static final ByTagName PAGE_BODY = new ByTagName("body");

    private FirefoxDriver driver;
    private static HashMap<String, String> storedData = new HashMap<String, String>();

    public BasePage(FirefoxDriver driver) {
        this.driver = driver;
    }

    public FirefoxDriver getDriver() {
        return driver;
    }

    public WebElement getBody() {
        return waitForElement(PAGE_BODY, 30);
    }

    public void storeValue(String key, String value) {
        storedData.put(key, value);
    }

    public String getStoredValue(String key) {
        return storedData.get(key);
    }

    public WebElement waitForElement(By element, long timeout) {
        WebElement myElement = null;

        try {
            myElement = new WebDriverWait(getDriver(), timeout).until(
                    ExpectedConditions.visibilityOfElementLocated(element));
        } catch (TimeoutException toe) {
        }

        return myElement;
    }

    public boolean elementExists(By element) {
        boolean elementExists = false;

        try {
            getDriver().findElement(element);
            elementExists = true;
        } catch (Exception e) {}

        return elementExists;
    }

    public void sleep() {
        try {
            Thread.sleep(4000);
        } catch (InterruptedException e) {
        }
    }
}
