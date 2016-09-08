package steps;

import org.jbehave.core.annotations.When;
import org.jbehave.core.steps.Steps;
import org.openqa.selenium.By.*;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import page.PageFactory;
import page.SelectFlightPage;

import java.util.List;

public class SelectFlightSteps extends Steps {

    private SelectFlightPage selectFlightPage;

    public SelectFlightSteps(PageFactory pageFactory) {
        this.selectFlightPage = pageFactory.getSelectFlightPageInstance();
    }

    @When("I select the first departure flight with an available WGA fare")
    public void selectFirstWGAAvailableFlight() {
        List<WebElement> flights = selectFlightPage.getFlightRows();

        for (WebElement flight : flights) {
            WebElement WGAButton = flight.findElement(new ByCssSelector(".select-detail--fares > .fare-button:nth-child(3) > button"));
            if (!WGAButton.getAttribute("class").contains("swa-g-disabled")) {
                WGAButton.sendKeys(Keys.ENTER);
                break;
            }
        }
    }

    @When("I continue to the Price page")
    public void clickOnContinueButton() {
        if (selectFlightPage.isFareFareDetailContainerDisplayed()) {
            selectFlightPage.getContinueButton().click();
        }
    }
}
