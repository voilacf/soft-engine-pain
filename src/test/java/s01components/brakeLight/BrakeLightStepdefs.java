package s01components.brakeLight;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import s01components.ComponentFactory;

import java.lang.reflect.Method;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class BrakeLightStepdefs {
    private final Object[] brakeLightPort = new Object[2];

    @Given("My autonomous vehicle contains a brake light")
    public void myVehicleContainsABrakeLight() {
        for (int i = 0; i < 2; i++) {
            brakeLightPort[i] = ComponentFactory.buildBrakeLight();
        }
    }

    @Then("The brake light component should not be null")
    public void brakeLightComponentShouldNotBeNull() {
        for (int i = 0; i < 2; i++) {
            assertNotNull(brakeLightPort[i]);
        }
    }

    @Then("The brake light turns on when using on-method")
    public void brakeLightTurnsOn() {
        for (Object blp : brakeLightPort
        ) {
            try {
                Method start = blp.getClass().getDeclaredMethod("on");
                Method getState = blp.getClass().getDeclaredMethod("getState");
                start.invoke(blp);
                assertEquals("on", getState.invoke(blp));
            } catch (Exception e) {
                e.getStackTrace();
            }
        }
    }

    @Then("The brake light turns off when using off-method")
    public void brakeLightTurnsOff() {
        for (Object blp : brakeLightPort
        ) {
            try {
                Method start = blp.getClass().getDeclaredMethod("off");
                Method getState = blp.getClass().getDeclaredMethod("getState");
                start.invoke(blp);
                assertEquals("off", getState.invoke(blp));
            } catch (Exception e) {
                e.getStackTrace();
            }
        }
    }
}
