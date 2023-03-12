package s01components.indicator;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import s01components.ComponentFactory;
import s01components.control_units.IndicatorControlUnit;
import s01components.events.*;

import java.lang.reflect.Method;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class IndicatorStepdefs {
    private final Object[] indicatorPort = new Object[1];
    private IndicatorControlUnit controlUnit;

    @Given("My autonomous vehicle contains an indicator")
    public void myVehicleContainsAnIndicator() {
        indicatorPort[0] = ComponentFactory.buildIndicator();
    }

    @Then("The indicator components should not be null")
    public void indicatorComponentShouldNotBeNull() {
        assertNotNull(indicatorPort[0]);
    }

    @Given("I have an indicator component and its control unit")
    public void iHaveAIndicatorAndItsControlUnit() {
        indicatorPort[0] = ComponentFactory.buildIndicator();
        controlUnit = new IndicatorControlUnit(indicatorPort);
    }

    @When("The control unit receives an Left-Indicator On Event")
    public void controlUnitReceivesLeftOnEvent() {
        controlUnit.receive(new EventLeftIndicatorOn());
    }

    @Then("The left indicator turns on")
    public void leftIndicatorIsTurnedOn() {
        for (Object indicator : indicatorPort
        ) {
            try {
                Method getState = indicator.getClass().getDeclaredMethod("getState");
                assertEquals("left_on", getState.invoke(indicator));
            } catch (Exception e) {
                e.getStackTrace();
            }
        }
    }

    @When("The control unit receives an Left-Indicator Off Event")
    public void controlUnitReceivesLeftOffEvent() {
        controlUnit.receive(new EventLeftIndicatorOff());
    }

    @Then("The left indicator turns off")
    public void leftIndicatorIsTurnedOff() {
        for (Object indicator : indicatorPort
        ) {
            try {
                Method getState = indicator.getClass().getDeclaredMethod("getState");
                assertEquals("left_off", getState.invoke(indicator));
            } catch (Exception e) {
                e.getStackTrace();
            }
        }
    }

    @When("The control unit receives an Right-Indicator On Event")
    public void controlUnitReceivesRightOnEvent() {
        controlUnit.receive(new EventRightIndicatorOn());
    }

    @Then("The right indicator turns on")
    public void rightIndicatorIsTurnedOn() {
        for (Object indicator : indicatorPort
        ) {
            try {
                Method getState = indicator.getClass().getDeclaredMethod("getState");
                assertEquals("right_on", getState.invoke(indicator));
            } catch (Exception e) {
                e.getStackTrace();
            }
        }
    }

    @When("The control unit receives an Right-Indicator Off Event")
    public void controlUnitReceivesRightOffEvent() {
        controlUnit.receive(new EventRightIndicatorOff());
    }

    @Then("The right indicator turns off")
    public void rightIndicatorIsTurnedOff() {
        for (Object indicator : indicatorPort
        ) {
            try {
                Method getState = indicator.getClass().getDeclaredMethod("getState");
                assertEquals("right_off", getState.invoke(indicator));
            } catch (Exception e) {
                e.getStackTrace();
            }
        }
    }

    @When("The control unit receives an Hazard On Event")
    public void controlUnitReceivesHazardOnEvent() {
        controlUnit.receive(new EventHazardWarningOn());
    }

    @Then("The hazard turns on")
    public void indicatorHazardIsOn() {
        for (Object indicator : indicatorPort
        ) {
            try {
                Method getState = indicator.getClass().getDeclaredMethod("getState");
                assertEquals("on", getState.invoke(indicator));
            } catch (Exception e) {
                e.getStackTrace();
            }
        }
    }

    @When("The control unit receives an Hazard Off Event")
    public void controlUnitReceivesHazardOffEvent() {
        controlUnit.receive(new EventHazardWarningOff());
    }

    @Then("The hazard turns off")
    public void indicatorHazardIsOff() {
        for (Object indicator : indicatorPort
        ) {
            try {
                Method getState = indicator.getClass().getDeclaredMethod("getState");
                assertEquals("off", getState.invoke(indicator));
            } catch (Exception e) {
                e.getStackTrace();
            }
        }
    }
}
