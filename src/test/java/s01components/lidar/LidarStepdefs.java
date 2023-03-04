package s01components.lidar;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import s01components.ComponentFactory;
import s01components.application.LidarComponentType;

import java.lang.reflect.Method;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class LidarStepdefs {
    private final Object[] lidarPort = new Object[2];

    @Given("My autonomous vehicle contains a lidar")
    public void myVehicleContainsALidar() {
        lidarPort[0] = ComponentFactory.buildLidar(LidarComponentType.LIDAR_NG);
        lidarPort[1] = ComponentFactory.buildLidar(LidarComponentType.LIDAR_XG);
    }

    @Then("The lidar component should not be null")
    public void lidarComponentShouldNotBeNull() {
        for (int i = 0; i < 2; i++) {
            assertNotNull(lidarPort[i]);
        }
    }

    @Then("The lidar turns on when using on-method")
    public void lidarTurnsOn() {
        for (Object lidar : lidarPort
        ) {
            try {
                Method start = lidar.getClass().getDeclaredMethod("on");
                Method getState = lidar.getClass().getDeclaredMethod("getState");
                start.invoke(lidar);
                assertEquals("on", getState.invoke(lidar));
            } catch (Exception e) {
                e.getStackTrace();
            }
        }
    }

    @Then("The lidar turns off when using off-method")
    public void lidarTurnsOff() {
        for (Object lidar : lidarPort
        ) {
            try {
                Method start = lidar.getClass().getDeclaredMethod("off");
                Method getState = lidar.getClass().getDeclaredMethod("getState");
                start.invoke(lidar);
                assertEquals("off", getState.invoke(lidar));
            } catch (Exception e) {
                e.getStackTrace();
            }
        }
    }
}
