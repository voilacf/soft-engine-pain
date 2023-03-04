package s01.gps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import s01components.ComponentFactory;
import s01components.control_units.GPSControlUnit;

import static org.junit.jupiter.api.Assertions.assertNotNull;

public class GpsStepdefs {
    private final Object[] gpsPort = new Object[1];
    private GPSControlUnit controlUnit;

    @Given("My autonomous vehicle contains a gps")
    public void myVehicleContainsAGPS() {
        gpsPort[0] = ComponentFactory.buildGPS();
    }

    @Then("The gps component should not be null")
    public void gpsComponentShouldNotBeNull() {
        assertNotNull(gpsPort[0]);
    }

    @Given("I have a gps component and its control unit")
    public void iHaveAGPSAndItsControlUnit() {
        gpsPort[0] = ComponentFactory.buildGPS();
        controlUnit = new GPSControlUnit(gpsPort);
    }

    //TODO: finish
    @When("The gps control unit receives an on event")
    public void gpsControlUnitReceivesAnOnEvent() {

    }

    @Then("The gps turned on")
    public void gpsTurnedOn() {
        //assertEquals();
    }

    @When("The gps control unit receives an off event")
    public void gpsControlUnitReceivesAnOffEvent() {

    }

    @Then("The gps turned off")
    public void gpsTurnedOff() {
        //assertEquals();
    }

    @When("The control unit receives a connect with satellite event")
    public void gpsControlUnitReceivesAnConnectWithSatelliteEvent() {

    }

    @Then("The gps connected with a satellite")
    public void gpsIsConnectedWithSatellite() {
        //assertEquals();
    }
}
