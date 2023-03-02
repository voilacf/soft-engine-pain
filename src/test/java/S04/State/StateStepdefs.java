package S04.State;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import observer_S04.Door;
import service_center.ServiceCenter;
import state_S04.DoorStateClosed;
import state_S04.DoorStateOpened;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class StateStepdefs {

    Door door;
    ServiceCenter serviceCenter;

    @Given("I have a door class")
    public void iHaveADoorClass() {
        serviceCenter = new ServiceCenter();
        door = new Door(serviceCenter);
    }

    @When("I toggle the door state door currently {string}")
    public void iToggleTheDoorStateDoor(String state) {
        if (state.equals("opened")) {
            assertTrue(door.getState() instanceof DoorStateOpened);
            door.toggleDoorState();
        } else if (state.equals("closed")) {
            assertTrue(door.getState() instanceof DoorStateClosed);
            door.toggleDoorState();
        } else {
            throw new IllegalArgumentException("Invalid state");
        }
    }

    @Then("The door should be {string}")
    public void theDoorShouldBe(String state) {
        if (state.equals("opened")) {
            assertTrue(door.getState() instanceof DoorStateOpened);
        } else if (state.equals("closed")) {
            assertTrue(door.getState() instanceof DoorStateClosed);
        } else {
            throw new IllegalArgumentException("Invalid state");
        }
    }
}
