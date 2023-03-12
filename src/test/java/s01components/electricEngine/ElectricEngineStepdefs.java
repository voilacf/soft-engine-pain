package s01components.electricEngine;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import s01components.ComponentFactory;
import s01components.application.EngineComponentType;
import s01components.control_units.EngineControlUnit;
import s01components.events.EventEngineDecreaseRPM;
import s01components.events.EventEngineIncreaseRPM;

import java.lang.reflect.Method;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class ElectricEngineStepdefs {
    private Object enginePort;
    private EngineControlUnit controlUnit;
    private EventEngineIncreaseRPM eventIncreaseRPM;
    private EventEngineDecreaseRPM eventDecreaseRPM;

    @Given("My autonomous vehicle contains an electric engine")
    public void myVehicleContainsAnElectricEngine() {
        enginePort = ComponentFactory.buildEngine(EngineComponentType.ENGINE_NG);
    }

    @Then("The electric engine component should not be null")
    public void electricEngineComponentShouldNotBeNull() {
        assertNotNull(enginePort);
    }

    @Then("The engine turns on when using on-method")
    public void electricEngineTurnsOn() {
        try {
            Method start = enginePort.getClass().getDeclaredMethod("on");
            Method getState = enginePort.getClass().getDeclaredMethod("getState");
            start.invoke(enginePort);
            assertEquals("on", getState.invoke(enginePort));
        } catch (Exception e) {
            e.getStackTrace();
        }
    }

    @Then("The engine turns off when using off-method")
    public void electricEngineTurnsOff() {
        try {
            Method start = enginePort.getClass().getDeclaredMethod("off");
            Method getState = enginePort.getClass().getDeclaredMethod("getState");
            start.invoke(enginePort);
            assertEquals("off", getState.invoke(enginePort));
        } catch (Exception e) {
            e.getStackTrace();
        }
    }

    @Given("I have an electric engine component and its control unit")
    public void iHaveAnElectricEngineAndItsControlUnit() {
        enginePort = ComponentFactory.buildEngine(EngineComponentType.ENGINE_NG);
        controlUnit = new EngineControlUnit(enginePort);
    }

    @When("The electric engine control unit receives an increase rpm event")
    public void electricEngineControlUnitReceivesIncreaseRPMEvent() {
        eventIncreaseRPM = new EventEngineIncreaseRPM(23, 100);
        controlUnit.receive(eventIncreaseRPM);
    }

    @Then("The electric engine rpm has increased")
    public void electricEngineRPMIncreased() {
        try {
            Method getState = enginePort.getClass().getDeclaredMethod("getRPM");
            assertEquals(eventIncreaseRPM.getDeltaRPM(), getState.invoke(enginePort));
        } catch (Exception e) {
            e.getStackTrace();
        }
    }

    @When("The electric engine control unit receives a decrease rpm event")
    public void electricEngineControlUnitReceivesDecreaseRPMEvent() {
        eventDecreaseRPM = new EventEngineDecreaseRPM(23, 100);
        controlUnit.receive(eventDecreaseRPM);
    }

    @Then("The electric engine rpm has decreased")
    public void electricEngineRPMDecreased() {
        try {
            Method getState = enginePort.getClass().getDeclaredMethod("getRPM");
            assertEquals(-eventDecreaseRPM.getDeltaRPM(), getState.invoke(enginePort));
        } catch (Exception e) {
            e.getStackTrace();
        }
    }
}
