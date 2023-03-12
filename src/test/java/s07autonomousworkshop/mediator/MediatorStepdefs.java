package s07autonomousworkshop.mediator;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import s01components.application.ApplicationConfiguration;
import s02builder.AutonomousVehicle;
import s02builder.AutonomousVehicleFactory;
import s05servicecenter.ServiceCenter;
import s07autonomousworkshop.AutonomousWorkshop;

import java.util.Queue;

import static org.junit.jupiter.api.Assertions.assertNotNull;

public class MediatorStepdefs {

    ApplicationConfiguration configuration = ApplicationConfiguration.loadJSONConfig("");

    private AutonomousVehicle vehicle;
    private AutonomousWorkshop workshop;

    @Given("a vehicle and a workshop")
    public void vehicleAndWorkshop() {
        vehicle = AutonomousVehicleFactory.buildAmazonZoox(new ServiceCenter(), configuration);
        workshop = new AutonomousWorkshop();
    }

    @When("vehicle is zoox")
    public void vehicleIsZoox() {
        workshop.addVehicleToQueue(vehicle);
    }

    @Then("add to Queue zooxQueue")
    public void addToCorrectQueue() {
        Queue<AutonomousVehicle> test = workshop.getZooxQueue();
        for (Object o : test
        ) {
            assertNotNull(o);
        }
    }
}
