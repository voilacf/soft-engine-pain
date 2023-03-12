package s01components.brake;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import s01components.ComponentFactory;
import s01components.control_units.BrakeControlUnit;
import s01components.events.EventBrakeSet;

import java.lang.reflect.Method;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class BrakeStepdefs {
    private final Object[] brakePort = new Object[1];
    private BrakeControlUnit controlUnit;
    private EventBrakeSet event;

    @Given("My autonomous vehicle contains a brake")
    public void myVehicleContainsABrake() {
        brakePort[0] = ComponentFactory.buildBrake();
    }

    @Then("The brake component should not be null")
    public void brakeComponentShouldNotBeNull() {
        assertNotNull(brakePort[0]);
    }

    @Given("I have a brake component and its control unit")
    public void iHaveBrakeAndItsControlUnit() {
        brakePort[0] = ComponentFactory.buildBrake();
        controlUnit = new BrakeControlUnit(brakePort);
    }

    @When("The brake control unit receives a BrakeSetEvent")
    public void brakeControlUnitReceivesBrakeSetEvent() {
        event = new EventBrakeSet(20.0);
        controlUnit.receive(event);
    }

    @Then("The brake percentage has changed")
    public void brakePercentageHasChanged() {
        for (Object brake : brakePort
        ) {
            try {
                Method getState = brake.getClass().getDeclaredMethod("getPercentage");
                assertEquals(event.getPercentage(), getState.invoke(brake));
            } catch (Exception e) {
                e.getStackTrace();
            }
        }
    }
}
