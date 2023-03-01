package S04.Observer;

import control_unit.ComponentUtils;
import factories.ComponentFactory;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import observer.IBatteryCellTemperatureListener;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class ObserverStepdefs {
    Object batteryCell;
    TestListener listener;

    public static class TestListener implements IBatteryCellTemperatureListener {
        public double lastTemperature = -1;
        public boolean temperatureUpdateReceived = false;

        @Override
        public void batteryTemperatureChanged(double temperature, Object battery) {
            lastTemperature = temperature;
            temperatureUpdateReceived = true;
        }
    }

    @Given("I have a battery cell")
    public void iHaveABatteryCell() {
        Object battery = ComponentFactory.buildBattery();
        List<Object> batteryMainCells = (List<Object>)ComponentUtils.invokeMethod(battery, "getSubUnits");
        assert batteryMainCells != null;
        List<Object> batterySubCells = (List<Object>)ComponentUtils.invokeMethod(batteryMainCells.get(0), "getSubUnits");
        assert batterySubCells != null;
        List<Object> batteryCells = (List<Object>)ComponentUtils.invokeMethod(batterySubCells.get(0), "getSubUnits");
        assert batteryCells != null;

        batteryCell = batteryCells.get(0);
        listener = new TestListener();
        ComponentUtils.invokeMethod(batteryCell, "addListener", new Class[] {Object.class}, listener);
    }

    @When("I discharge the battery")
    public void iDischargeTheBattery() {
        ComponentUtils.invokeMethod(batteryCell, "useEnergy", new Class[] {int.class}, 1);
    }

    @Then("The temperature should change")
    public void theTemperatureShouldChange() {
        assertTrue(listener.temperatureUpdateReceived);
        assertNotEquals(-1, listener.lastTemperature);
    }
}
