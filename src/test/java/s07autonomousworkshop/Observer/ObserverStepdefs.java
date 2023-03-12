package s07autonomousworkshop.Observer;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import s01components.application.ApplicationConfiguration;
import s02builder.AutonomousVehicle;
import s02builder.AutonomousVehicleFactory;
import s05servicecenter.ServiceCenter;
import s07autonomousworkshop.AutonomousWorkshop;
import s07autonomousworkshop.CommandDriveToLiftingPlatform;
import s07autonomousworkshop.LiftingPlatform;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class ObserverStepdefs {
    ApplicationConfiguration configuration = ApplicationConfiguration.loadJSONConfig("");
    private AutonomousVehicle vehicle;
    private AutonomousWorkshop listener;
    private LiftingPlatform liftingPlatform;
    private CommandDriveToLiftingPlatform command;

    @Given("A vehicle a Sensor")
    public void vehicleAndSensor() {
        listener = new AutonomousWorkshop();
        vehicle = AutonomousVehicleFactory.buildAmazonZoox(new ServiceCenter(), configuration);
        liftingPlatform = listener.getLiftingPlatform();
        command = new CommandDriveToLiftingPlatform(vehicle, liftingPlatform);
    }

    @When("vehicle is correct on the lifting platform")
    public void vehicleCorrectOnPlatform() {
        command.execute();
    }

    @Then("activate lifting platform")
    public void activateLiftingPlatform() {
        assertTrue(listener.getSuccessful());
    }
}
