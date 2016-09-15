package steps;

import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;
import org.jbehave.core.steps.Steps;
import org.openqa.selenium.WebElement;
import page.PageFactory;
import page.PricePage;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class PricePageSteps extends Steps {

    private PricePage pricePage;

    public PricePageSteps(PageFactory pageFactory) {
        this.pricePage = pageFactory.getPricePageInstance();
    }

    @Then("I validate I am on the Price page")
    public void validatePricePageRedirection() {
        assertTrue(pricePage.isPricePageContainerDisplayed());

        assertEquals(pricePage.getTipeFlyLabels().get(0).getText(), "Anytime");
        assertEquals(pricePage.getTipeFlyLabels().get(1).getText(), "Business Select");
    }

    @Then("I validate the departure and return stations are the ones selected in the Plan a Trip page")
    public void validatePricePageStations() {
        String expectedDepartureCity = pricePage.getStoredValue("departureCity");
        String expectedReturnCity = pricePage.getStoredValue("returnCity");
        List<WebElement> segments = pricePage.getPricePageSegments();

        assertEquals(expectedDepartureCity, segments.get(0).getText());
        assertEquals(expectedReturnCity, segments.get(segments.size() - 1).getText());
    }

    @Then("I continue to the Purchase Page")
    public void continueToPurchase(){


        pricePage.getSubmitButton().get(0).click();

    }

  }
