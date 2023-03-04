package s01components.camera;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import s01components.ComponentFactory;
import s01components.application.CameraComponentType;

import java.lang.reflect.Method;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class CameraStepdefs {
    private final Object[] cameraPort = new Object[2];

    @Given("My autonomous vehicle contains a camera")
    public void myVehicleContainsABrakeLight() {
        cameraPort[0] = ComponentFactory.buildCamera(CameraComponentType.CAMERA_V1);
        cameraPort[1] = ComponentFactory.buildCamera(CameraComponentType.CAMERA_V2);
    }

    @Then("The camera component should not be null")
    public void brakeLightComponentShouldNotBeNull() {
        for (int i = 0; i < 2; i++) {
            assertNotNull(cameraPort[i]);
        }
    }

    @Then("The camera turns on when using on-method")
    public void cameraTurnsOn() {
        for (Object camera : cameraPort
        ) {
            try {
                Method start = camera.getClass().getDeclaredMethod("on");
                Method getState = camera.getClass().getDeclaredMethod("getState");
                start.invoke(camera);
                assertEquals("on", getState.invoke(camera));
            } catch (Exception e) {
                e.getStackTrace();
            }
        }
    }

    @Then("The camera turns off when using off-method")
    public void cameraTurnsOff() {
        for (Object camera : cameraPort
        ) {
            try {
                Method start = camera.getClass().getDeclaredMethod("off");
                Method getState = camera.getClass().getDeclaredMethod("getState");
                start.invoke(camera);
                assertEquals("off", getState.invoke(camera));
            } catch (Exception e) {
                e.getStackTrace();
            }
        }
    }
}
