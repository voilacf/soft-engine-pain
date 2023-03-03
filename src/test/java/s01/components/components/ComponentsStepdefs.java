package s01.components.components;

import application.CameraComponentType;
import application.EngineComponentType;
import application.LidarComponentType;
import control_unit.BrakeControlUnit;
import factories.ComponentFactory;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static org.junit.jupiter.api.Assertions.*;

public class ComponentsStepdefs {
    Object[] brakePort = new Object[1];
    Object[] brakeLightPort = new Object[1];
    Object[] cameraPort = new Object[2];
    Object[] enginePort = new Object[2];
    Object[] gpsPort = new Object[1];
    Object[] indicatorPort = new Object[1];
    Object[] ledPort = new Object[1];
    Object[] lidarPort = new Object[2];
    BrakeControlUnit brakeControlUnit;


    @Given("I have a autonomous vehicle made of several components")
    public void iHaveAConfigurationMemento() {
        brakePort[0] = ComponentFactory.buildBrake();
        brakeLightPort[0] = ComponentFactory.buildBrakeLight();
        cameraPort[0] = ComponentFactory.buildCamera(CameraComponentType.CAMERA_V1);
        cameraPort[1] = ComponentFactory.buildCamera(CameraComponentType.CAMERA_V2);
        enginePort[0] = ComponentFactory.buildEngine(EngineComponentType.ENGINE_NG);
        enginePort[1] = ComponentFactory.buildEngine(EngineComponentType.ENGINE_X);
        gpsPort[0] = ComponentFactory.buildGPS();
        indicatorPort[0] = ComponentFactory.buildIndicator();
        ledPort[0] = ComponentFactory.buildLED();
        lidarPort[0] = ComponentFactory.buildLidar(LidarComponentType.LIDAR_NG);
        lidarPort[1] = ComponentFactory.buildLidar(LidarComponentType.LIDAR_XG);
    }

    @Then("The components should not be null")
    public void theMementoShouldHaveTheDefaultSettings() {
        assertNotNull(brakePort[0]);
        assertNotNull(brakeLightPort[0]);
        assertNotNull(cameraPort[0]);
        assertNotNull(cameraPort[1]);
        assertNotNull(enginePort[0]);
        assertNotNull(enginePort[1]);
        assertNotNull(gpsPort[0]);
        assertNotNull(indicatorPort[0]);
        assertNotNull(ledPort[0]);
        assertNotNull(lidarPort[0]);
        assertNotNull(lidarPort[1]);
    }


    @Given("I have a brake control unit in my vehicle")
    public void iHaveAVehicleConfiguration() {
        brakeControlUnit = new BrakeControlUnit(brakePort);
    }

    @When("I load the settings from the json file")
    public void iLoadTheSettingsFromTheJsonFile() {

    }
}
