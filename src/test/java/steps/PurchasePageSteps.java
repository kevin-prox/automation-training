package steps;

import org.jbehave.core.annotations.Then;
import org.jbehave.core.steps.Steps;
import page.PageFactory;
import page.PurchasePage;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * Created by developer on 9/14/16.
 */
public class PurchasePageSteps extends Steps {

    private PurchasePage purchasePage;

    public PurchasePageSteps (PageFactory pageFactory) {
        this.purchasePage = pageFactory.getPurchasePageInstance();
    }


    @Then("I validate I am on the Purchase Page")
    public void validatePricePageContainer() {
        assertTrue(purchasePage.isBaseContainerDisplayed());

    }

}
