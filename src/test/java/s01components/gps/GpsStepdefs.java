package s01components.gps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import s01components.ComponentFactory;

import java.lang.reflect.Method;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class GpsStepdefs {
    private final Object[] gpsPort = new Object[1];

    @Given("My autonomous vehicle contains a gps")
    public void myVehicleContainsAGPS() {
        gpsPort[0] = ComponentFactory.buildGPS();
    }

    @Then("The gps component should not be null")
    public void gpsComponentShouldNotBeNull() {
        assertNotNull(gpsPort[0]);
    }

    @Then("The gps turns on when using on-method")
    public void gpsTurnedOn() {
        for (Object gps : gpsPort
        ) {
            try {
                Method start = gps.getClass().getDeclaredMethod("on");
                Method getState = gps.getClass().getDeclaredMethod("getState");
                start.invoke(gps);
                assertEquals("on", getState.invoke(gps));
            } catch (Exception e) {
                e.getStackTrace();
            }
        }
    }

    @Then("The gps turns off when using off-method")
    public void gpsTurnedOff() {
        for (Object gps : gpsPort
        ) {
            try {
                Method start = gps.getClass().getDeclaredMethod("off");
                Method getState = gps.getClass().getDeclaredMethod("getState");
                start.invoke(gps);
                assertEquals("off", getState.invoke(gps));
            } catch (Exception e) {
                e.getStackTrace();
            }
        }
    }

    //TODO: finish
    @Given("I have a gps component and its control unit")
    public void gpsAndItsControlUnit() {

    }

    @When("The control unit receives a connect with satellite event")
    public void gpsControlUnitReceivesAnConnectWithSatelliteEvent() {

    }

    @Then("The gps connected with a satellite")
    public void gpsIsConnectedWithSatellite() {
        //assertEquals();
    }
}
