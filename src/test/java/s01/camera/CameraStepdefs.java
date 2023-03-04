package s01.camera;

import application.CameraComponentType;
import control_unit.CameraControlUnit;
import factories.ComponentFactory;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static org.junit.jupiter.api.Assertions.assertNotNull;

public class CameraStepdefs {
    private Object[] cameraPort = new Object[2];
    private CameraControlUnit controlUnit;

    @Given("My autonomous vehicle contains a camera")
    public void myVehicleContainsABrakeLight(){
        cameraPort[0] = ComponentFactory.buildCamera(CameraComponentType.CAMERA_V1);
        cameraPort[1] = ComponentFactory.buildCamera(CameraComponentType.CAMERA_V2);
    }

    @Then("The camera component should not be null")
    public void brakeLightComponentShouldNotBeNull(){
        assertNotNull(cameraPort[0]);
        assertNotNull(cameraPort[1]);
    }

    @Given("I have a camera component and its control unit")
    public void iHaveABrakeLightAndItsControlUnit(){
        cameraPort[0] = ComponentFactory.buildCamera(CameraComponentType.CAMERA_V1);
        cameraPort[1] = ComponentFactory.buildCamera(CameraComponentType.CAMERA_V2);
        controlUnit = new CameraControlUnit(cameraPort);
    }

    //TODO: finish
    @When("The camera control unit receives an on event")
    public void brakeLightControlUnitReceivesAnOnEvent() {

    }

    @Then("The camera turned on")
    public void brakeLightTurnedOn() {
        //assertEquals();
    }

    @When("The camera control unit receives an off event")
    public void controlUnitReceivesAnOffEvent() {

    }

    @Then("The camera turned off")
    public void brakeLightTurnedOff() {
        //assertEquals();
    }
}