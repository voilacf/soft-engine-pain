package s07autonomousworkshop.Command;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import s01components.application.ApplicationConfiguration;
import s02builder.AutonomousVehicle;
import s02builder.AutonomousVehicleFactory;
import s05servicecenter.ServiceCenter;
import s07autonomousworkshop.CommandDriveToLiftingPlatform;
import s07autonomousworkshop.LiftingPlatform;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CommandStepdefs {
    ApplicationConfiguration configuration = ApplicationConfiguration.loadJSONConfig("");
    AutonomousVehicle zoox;
    private CommandDriveToLiftingPlatform command;
    private LiftingPlatform liftingPlatform;

    @Given("A vehicle and a lifting platform")
    public void liftingPlatformCommand() {
        zoox = AutonomousVehicleFactory.buildAmazonZoox(new ServiceCenter(), configuration);
        liftingPlatform = new LiftingPlatform();
    }

    @When("Executing the drive to lifting platform command")
    public void executeCommand() {
        command = new CommandDriveToLiftingPlatform(zoox, liftingPlatform);
        command.execute();
    }

    @Then("The vehicle is on the lifting platform")
    public void vehicleIsOnLiftingPlatform() {
        assertEquals(zoox, liftingPlatform.getVehicle());
    }
}
