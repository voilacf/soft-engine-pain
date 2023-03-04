package s01.brakeLight;

import s01components.control_units.BrakeLightControlUnit;
import s01components.ComponentFactory;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static org.junit.jupiter.api.Assertions.assertNotNull;

public class BrakeLightStepdefs {
    private Object[] brakeLightPort = new Object[1];
    private BrakeLightControlUnit controlUnit;

    @Given("My autonomous vehicle contains a brake light")
    public void myVehicleContainsABrakeLight(){
        brakeLightPort[0] = ComponentFactory.buildBrakeLight();
    }

    @Then("The brake light component should not be null")
    public void brakeLightComponentShouldNotBeNull(){
        assertNotNull(brakeLightPort[0]);
    }

    @Given("I have a brake light component and its control unit")
    public void iHaveABrakeLightAndItsControlUnit(){
        brakeLightPort[0] = ComponentFactory.buildBrakeLight();
        controlUnit = new BrakeLightControlUnit(brakeLightPort);
    }

    //TODO: finish
    @When("The brake light control unit receives an on Event")
    public void brakeLightControlUnitReceivesAnOnEvent() {

    }

    @Then("The brake light turned on")
    public void brakeLightTurnedOn() {
        //assertEquals();
    }

    @When("The brake light control unit receives an off Event")
    public void controlUnitReceivesAnOffEvent() {

    }

    @Then("The brake light turned off")
    public void brakeLightTurnedOff() {
        //assertEquals();
    }
}
