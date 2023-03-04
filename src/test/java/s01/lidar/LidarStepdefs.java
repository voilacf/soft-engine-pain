package s01.lidar;

import application.LidarComponentType;
import control_unit.LidarControlUnit;
import factories.ComponentFactory;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static org.junit.jupiter.api.Assertions.assertNotNull;

public class LidarStepdefs {
    private Object[] lidarPort = new Object[2];
    private LidarControlUnit controlUnit;

    @Given("My autonomous vehicle contains a lidar")
    public void myVehicleContainsABrakeLight(){
        lidarPort[0] = ComponentFactory.buildLidar(LidarComponentType.LIDAR_NG);
        lidarPort[1] = ComponentFactory.buildLidar(LidarComponentType.LIDAR_XG);
    }

    @Then("The lidar component should not be null")
    public void brakeLightComponentShouldNotBeNull(){
        assertNotNull(lidarPort[0]);
        assertNotNull(lidarPort[1]);
    }

    @Given("I have a lidar component and its control unit")
    public void iHaveABrakeLightAndItsControlUnit(){
        lidarPort[0] = ComponentFactory.buildLidar(LidarComponentType.LIDAR_NG);
        lidarPort[1] = ComponentFactory.buildLidar(LidarComponentType.LIDAR_XG);
        controlUnit = new LidarControlUnit(lidarPort);
    }

    //TODO: finish
    @When("The lidar control unit receives an on event")
    public void controlUnitReceivesAnOnEvent() {

    }

    @Then("The lidar turned on")
    public void brakeLightTurnedOn() {
        //assertEquals();
    }

    @When("The lidar control unit receives an off event")
    public void controlUnitReceivesAnOffEvent() {

    }

    @Then("The lidar turned off")
    public void brakeLightTurnedOff() {
        //assertEquals();
    }
}
