package steps;

import org.jbehave.core.annotations.Then;
import org.jbehave.core.steps.Steps;
import page.PageFactory;
import page.PricePage;

import static org.junit.Assert.assertTrue;

public class PricePageSteps extends Steps {

    private PricePage pricePage;

    public PricePageSteps(PageFactory pageFactory) {
        this.pricePage = pageFactory.getPricePageInstance();
    }

    @Then("I validate I am on the Price page")
    public void validatePricePageRedirection() {
        assertTrue(pricePage.isPricePageContainerDisplayed());
    }
}
