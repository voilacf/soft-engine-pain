package s01components.battery;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import s01components.ComponentFactory;

import static org.junit.jupiter.api.Assertions.assertNotNull;

public class BatteryStepdefs {
    private Object[] batteryPort;

    @Given("My autonomous vehicle contains a battery")
    public void myVehicleContainsABattery() {
        batteryPort = new Object[1];
        batteryPort[0] = ComponentFactory.buildBattery();
    }

    @Then("The battery component should not be null")
    public void batteryComponentShouldNotBeNull() {
        assertNotNull(batteryPort[0]);
    }
}
