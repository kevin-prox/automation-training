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

    @When("I Sort By Price")
    public void sortByPrice(){
        WebElement departureDropDown = selectFlightPage.getDropDownSorting().get(0);//el primero ordena los vuelos q salen
        WebElement returnDropDown = selectFlightPage.getDropDownSorting().get(1);//el segundo ordena los vuelos q vuelven
        selectFlightPage.getLockHeader().click();
        departureDropDown.click();
        selectFlightPage.getPriceSorting().click();
    }


    @When("I chose the first departure flight with an available Anytime fare")
    public void choseAnytimeFlight(){
        List<WebElement> departFares = selectFlightPage.getDepartButtons();

        WebElement selectedCukero;

        for(int i = 0 ; i<departFares.size(); i++){
            selectedCukero = departFares.get(i);
            if( selectedCukero.getAttribute("aria-label").contains("Anytime")){
                selectedCukero.click();
                break;
            }

        }
    }

    @When("I chose the first return flight with an available Business select fare")
    public void choseBsFlight(){

        List<WebElement> returnFares = selectFlightPage.getReturnButtons();

        WebElement selectedCukeroTwo;

        for(int i = 0 ; i<returnFares.size(); i++){
            selectedCukeroTwo = returnFares.get(i);
            if( selectedCukeroTwo.getAttribute("aria-label").contains("Business Select")){
                selectedCukeroTwo.click();
                break;
            }

        }
    }

    @When("I continue to the Price Page")
    public void clickOnContinueToPriceButton() {
        if (selectFlightPage.isFareFareDetailContainerDisplayed()) {
            selectFlightPage.getContinueButton().click();
            if (selectFlightPage.getUpgradeContinueBtn().isDisplayed()){
                selectFlightPage.getUpgradeContinueBtn().click();
            }
        }
    }




}
