package s01.battery;

import s01components.ComponentFactory;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

import static org.junit.jupiter.api.Assertions.*;

public class BatteryStepdefs {
    private Object[] batteryPort;

    @Given("My autonomous vehicle contains a battery")
    public void myVehicleContainsABattery(){
        batteryPort = new Object[1];
        batteryPort[0] = ComponentFactory.buildBattery();
    }

    @Then("The battery component should not be null")
    public void batteryComponentShouldNotBeNull(){
        assertNotNull(batteryPort[0]);
    }
}
