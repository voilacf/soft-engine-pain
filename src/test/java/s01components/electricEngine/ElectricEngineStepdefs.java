package s01components.electricEngine;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import s01components.ComponentFactory;
import s01components.application.EngineComponentType;
import s01components.control_units.EngineControlUnit;

import static org.junit.jupiter.api.Assertions.assertNotNull;

public class ElectricEngineStepdefs {
    private final Object[] enginePort = new Object[2];
    private EngineControlUnit controlUnit;

    @Given("My autonomous vehicle contains an electric engine")
    public void myVehicleContainsAnElectricEngine() {
        enginePort[0] = ComponentFactory.buildEngine(EngineComponentType.ENGINE_NG);
        enginePort[1] = ComponentFactory.buildEngine(EngineComponentType.ENGINE_X);
    }

    @Then("The electric engine component should not be null")
    public void electricEngineComponentShouldNotBeNull() {
        assertNotNull(enginePort[0]);
        assertNotNull(enginePort[1]);
    }

    @Given("I have an electric engine component and its control unit")
    public void iHaveAnElectricEngineAndItsControlUnit() {
        enginePort[0] = ComponentFactory.buildEngine(EngineComponentType.ENGINE_NG);
        enginePort[1] = ComponentFactory.buildEngine(EngineComponentType.ENGINE_X);
        controlUnit = new EngineControlUnit(enginePort);
    }

    @When("The electric engine control unit receives an on event")
    public void electricEngineControlUnitReceivesAnOnEvent() {

    }

    @Then("The electric engine turned on")
    public void electricEngineTurnedOn() {
        //assertEquals();
    }

    @When("The electric engine control unit receives an off event")
    public void electricEngineControlUnitReceivesAnOffEvent() {

    }

    @Then("The electric engine turned off")
    public void electricEngineTurnedOff() {
        //assertEquals();
    }

    @When("The electric engine control unit receives an increase rpm event")
    public void electricEngineControlUnitReceivesIncreaseRPMEvent() {

    }

    @Then("The electric engine rpm has increased")
    public void electricEngineRPMIncreased() {
        //assertEquals();
    }

    @When("The electric engine control unit receives a decrease rpm event")
    public void electricEngineControlUnitReceivesDecreaseRPMEvent() {

    }

    @Then("The electric engine rpm has decreased")
    public void electricEngineRPMDecreased() {
        //assertEquals();
    }
}
