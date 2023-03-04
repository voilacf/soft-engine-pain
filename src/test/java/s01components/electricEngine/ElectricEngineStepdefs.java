package s01components.electricEngine;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import s01components.ComponentFactory;
import s01components.application.EngineComponentType;
import s01components.control_units.EngineControlUnit;

import java.lang.reflect.Method;

import static org.junit.jupiter.api.Assertions.assertEquals;
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
        for (int i = 0; i < 2; i++) {
            assertNotNull(enginePort[0]);
        }
    }

    @Then("The engine turns on when using on-method")
    public void electricEngineTurnsOn() {
        for (Object engine : enginePort
        ) {
            try {
                Method start = engine.getClass().getDeclaredMethod("on");
                Method getState = engine.getClass().getDeclaredMethod("getState");
                start.invoke(engine);
                assertEquals("on", getState.invoke(engine));
            } catch (Exception e) {
                e.getStackTrace();
            }
        }
    }

    @Then("The engine turns off when using off-method")
    public void electricEngineTurnsOff() {
        for (Object engine : enginePort
        ) {
            try {
                Method start = engine.getClass().getDeclaredMethod("off");
                Method getState = engine.getClass().getDeclaredMethod("getState");
                start.invoke(engine);
                assertEquals("off", getState.invoke(engine));
            } catch (Exception e) {
                e.getStackTrace();
            }
        }
    }

    @Given("I have an electric engine component and its control unit")
    public void iHaveAnElectricEngineAndItsControlUnit() {
        enginePort[0] = ComponentFactory.buildEngine(EngineComponentType.ENGINE_NG);
        enginePort[1] = ComponentFactory.buildEngine(EngineComponentType.ENGINE_X);
        controlUnit = new EngineControlUnit(enginePort);
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
