package s01components.ledHeadLight;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import s01components.ComponentFactory;

import java.lang.reflect.Method;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class LEDHeadLightStepdefs {
    private final Object[] ledPort = new Object[2];

    @Given("My autonomous vehicle contains a led component")
    public void myVehicleContainsALedHeadLight() {
        for (int i = 0; i < 2; i++) {
            ledPort[i] = ComponentFactory.buildLED();
        }
    }

    @Then("The led component should not be null")
    public void ledHeadLightComponentShouldNotBeNull() {
        for (int i = 0; i < 2; i++) {
            assertNotNull(ledPort[i]);
        }
    }


    @Then("The led turns on when using on-method")
    public void ledTurnsOn() {
        for (Object led : ledPort
        ) {
            try {
                Method start = led.getClass().getDeclaredMethod("on");
                Method getState = led.getClass().getDeclaredMethod("getState");
                start.invoke(led);
                assertEquals("on", getState.invoke(led));
            } catch (Exception e) {
                e.getStackTrace();
            }
        }
    }

    @Then("The led turns off when using off-method")
    public void ledTurnsOff() {
        for (Object led : ledPort
        ) {
            try {
                Method start = led.getClass().getDeclaredMethod("off");
                Method getState = led.getClass().getDeclaredMethod("getState");
                start.invoke(led);
                assertEquals("off", getState.invoke(led));
            } catch (Exception e) {
                e.getStackTrace();
            }
        }
    }

    @Then("The led activated its high beam when using beam-method")
    public void ledActivatedHighBeam() {
        for (Object led : ledPort
        ) {
            try {
                Method start = led.getClass().getDeclaredMethod("beam");
                Method getState = led.getClass().getDeclaredMethod("getState");
                start.invoke(led);
                assertEquals("highbeam", getState.invoke(led));
            } catch (Exception e) {
                e.getStackTrace();
            }
        }
    }

    @Then("The led is dimmed when using dimm-method")
    public void ledIsDimmed() {
        for (Object led : ledPort
        ) {
            try {
                Method start = led.getClass().getDeclaredMethod("dimm");
                Method getState = led.getClass().getDeclaredMethod("getState");
                start.invoke(led);
                assertEquals("dimmed", getState.invoke(led));
            } catch (Exception e) {
                e.getStackTrace();
            }
        }
    }
}
