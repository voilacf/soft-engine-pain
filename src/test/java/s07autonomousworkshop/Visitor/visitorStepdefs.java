package s07autonomousworkshop.Visitor;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import s01components.application.ApplicationConfiguration;
import s02builder.AutonomousVehicle;
import s02builder.AutonomousVehicleFactory;
import s05servicecenter.ServiceCenter;
import s07autonomousworkshop.WorkshopRoboter;

import static org.junit.jupiter.api.Assertions.assertNotNull;


public class visitorStepdefs {
    private AutonomousVehicle vehicle;
    private WorkshopRoboter roboter;

    @Given("A vehicle and a roboter")
    public void vehicleAndRoboter() {
        ApplicationConfiguration configuration = ApplicationConfiguration.loadJSONConfig("");
        vehicle = AutonomousVehicleFactory.buildAmazonZoox(new ServiceCenter(), configuration);
        roboter = new WorkshopRoboter(true);
    }

    @When("roboter visits components")
    public void visitComponents() {
        roboter.visitIndicator(vehicle.getIndicators());
        roboter.visitBrake(vehicle.getBrakes());
        roboter.visitLed(vehicle.getHeadlights());
        roboter.visitGps(vehicle.getGps());
        roboter.visitCamera(vehicle.getCameras());
        roboter.visitLidar(vehicle.getLidars());
    }


    @Then("components are functional")
    public void componentsAreFunctional() {
        Object[] indicators = vehicle.getIndicators();
        for (Object indicator : indicators
        ) {
            assertNotNull(indicators);
        }
        Object[] lidars = vehicle.getLidars();
        for (Object lidar : lidars
        ) {
            assertNotNull(lidar);
        }
        Object[] brakes = vehicle.getBrakes();
        for (Object brake : brakes
        ) {
            assertNotNull(brake);
        }
        Object[] leds = vehicle.getHeadlights();
        for (Object led : leds
        ) {
            assertNotNull(led);
        }
        Object[] gps = vehicle.getGps();
        for (Object g : gps
        ) {
            assertNotNull(g);
        }
        Object[] cameras = vehicle.getCameras();
        for (Object camera : cameras
        ) {
            assertNotNull(camera);
        }
    }
}
