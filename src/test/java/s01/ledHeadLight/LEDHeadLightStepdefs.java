package s01.ledHeadLight;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import s01components.ComponentFactory;
import s01components.control_units.HeadlightControlUnit;

import static org.junit.jupiter.api.Assertions.assertNotNull;

public class LEDHeadLightStepdefs {
    private final Object[] ledPort = new Object[1]; //TODO: change to two?
    private HeadlightControlUnit controlUnit;

    @Given("My autonomous vehicle contains a led component")
    public void myVehicleContainsALedHeadLight() {
        ledPort[0] = ComponentFactory.buildLED();
    }

    @Then("The led component should not be null")
    public void ledHeadLightComponentShouldNotBeNull() {
        assertNotNull(ledPort[0]);
    }

    @Given("I have a led component and its control unit")
    public void iHaveALedHeadLightAndItsControlUnit() {
        ledPort[0] = ComponentFactory.buildLED();
        controlUnit = new HeadlightControlUnit(ledPort);
    }

    //TODO: finish
    @When("The led control unit receives an on event")
    public void ledControlUnitReceivesAnOnEvent() {

    }

    @Then("The led turned on")
    public void ledTurnedOn() {
        //assertEquals();
    }

    @When("The led control unit receives an off event")
    public void ledControlUnitReceivesAnOffEvent() {

    }

    @Then("The led turned off")
    public void ledTurnedOff() {
        //assertEquals();
    }

    @When("The led control unit receives a high beam event")
    public void ledControlUnitReceivesAHighBeamEvent() {

    }

    @Then("The led activated its high beam")
    public void ledActivatedHighBeam() {
        //assertEquals();
    }

    @When("The led control unit receives a dimm event")
    public void ledControlUnitReceivesADimmEvent() {

    }

    @Then("The led light is dimmed")
    public void ledIsDimmed() {
        //assertEquals();
    }
}
