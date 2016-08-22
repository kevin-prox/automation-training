package steps;

import model.Example;
import org.jbehave.core.annotations.*;
import org.jbehave.core.steps.Steps;

import static org.junit.Assert.*;

public class ExampleSteps extends Steps {

    private Example example;


    @Given("I create a new Example Object without any name")
    public void createNewExampleObject() {
        example = new Example();
    }

    @When("I set its name as $name")
    public void setExampleName(String name) {
        example.setName(name);
    }

    @Then("I validate its name is $name")
    public void validateExampleName(String name) {
        assertEquals(name, example.getName());
    }
}
