package s01.brake;

import s01components.control_units.BrakeControlUnit;
import s01components.ComponentFactory;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;

import static org.junit.jupiter.api.Assertions.*;

public class BrakeStepdefs {
    private Object[] brakePort = new Object[1];
    private BrakeControlUnit controlUnit;

    @Given("My autonomous vehicle contains a brake")
    public void myVehicleContainsABrake(){
        brakePort[0] = ComponentFactory.buildBrake();
    }

    @Then("The brake component should not be null")
    public void brakeComponentShouldNotBeNull(){
        assertNotNull(brakePort[0]);
    }

    @Given("I have a brake component and its control unit")
    public void iHaveBrakeAndItsControlUnit(){
        brakePort[0] = ComponentFactory.buildBrake();
        controlUnit = new BrakeControlUnit(brakePort);
    }

    //TODO: finish
    @When("The brake control unit receives a BrakeSetEvent")
    public void brakeControlUnitReceivesAnEvent() {

    }

    @Then("The brake percentage has changed")
    public void brakePercentageHasChanged() {
        //assertEquals();
    }
}
