package S04.State;

import components.Door;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import service_center.ServiceCenter;
import state.DoorStateClosed;
import state.DoorStateOpened;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class StateStepdefs {

    Door door;
    ServiceCenter serviceCenter;

    @Given("I have a door class")
    public void iHaveADoorClass() {
        serviceCenter = new ServiceCenter();
        door = new Door(serviceCenter);
    }

    @Then("The door should be closed")
    public void theDoorShouldBeClosed() {
    assertTrue(door.getState() instanceof DoorStateClosed);
    }


    @When("I toggle the door state")
    public void iOpenTheDoor() {
        door.toggleDoorState();
    }

    @Then("The door should be open")
    public void theDoorShouldBeOpen() {
        assertTrue(door.getState() instanceof DoorStateOpened);
    }
}
