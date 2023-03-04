package S04.Observer;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import s01components.ComponentFactory;
import s01components.control_units.ComponentUtils;
import s03command.Door;
import s04observer.IBatteryCellTemperatureListener;
import s04observer.IButtonPressedListener;
import s04observer.IUltraSonicSensorListener;
import s04observer.UltraSonicSensor;
import s05servicecenter.ServiceCenter;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ObserverStepdefs {
    Object batteryCell;
    TestBatteryListener listenerBattery;
    UltraSonicSensor ultraSonicSensor;
    TestUltrasonicListener listenerUltrasonic;
    Door door;
    TestDoorButtonSensorListener listenerDoorButtonSensor;

    @Given("I have a battery cell")
    public void iHaveABatteryCell() {
        Object battery = ComponentFactory.buildBattery();
        List<Object> batteryMainCells = (List<Object>) ComponentUtils.invokeMethod(battery, "getSubUnits");
        assert batteryMainCells != null;
        List<Object> batterySubCells = (List<Object>) ComponentUtils.invokeMethod(batteryMainCells.get(0), "getSubUnits");
        assert batterySubCells != null;
        List<Object> batteryCells = (List<Object>) ComponentUtils.invokeMethod(batterySubCells.get(0), "getSubUnits");
        assert batteryCells != null;
        batteryCell = batteryCells.get(0);
    }

    @Given("I have a battery listener")
    public void iHaveAListener() {
        listenerBattery = new TestBatteryListener();
    }

    @When("I add the listener to the battery cell")
    public void iAddTheListenerToTheBatteryCell() {
        ComponentUtils.invokeMethod(batteryCell, "addListener", new Class[]{Object.class}, listenerBattery);
    }

    @When("I discharge the battery")
    public void iDischargeTheBattery() {
        ComponentUtils.invokeMethod(batteryCell, "useEnergy", new Class[]{int.class}, 1);
    }

    @Then("The listener should receive a temperature change")
    public void theListenerShouldReceiveATemperatureChange() {
        assertTrue(listenerBattery.temperatureUpdateReceived);
        assertNotEquals(-1, listenerBattery.lastTemperature);
    }

    @Given("I have an ultrasonic sensor")
    public void iHaveAnUltrasonicSensor() {
        ultraSonicSensor = new UltraSonicSensor(0);

    }

    @Given("I have a ultrasonic sensor listener")
    public void iHaveAUltrasonicSensorListener() {
        listenerUltrasonic = new TestUltrasonicListener();
    }

    @When("I add a listener to the sensor")
    public void iAddAListenerToTheSensor() {
        ultraSonicSensor.addListener(listenerUltrasonic);

    }

    @When("The distance changes")
    public void theDistanceChanges() {
        ultraSonicSensor.setDistance(5);
    }

    @Then("The listener should receive a distance change")
    public void theListenerShouldReceiveADistanceChange() {
        assertTrue(listenerUltrasonic.distanceUpdateReceived);
        assertNotEquals(-1, listenerUltrasonic.lastDistance);
    }

    @Given("I have a door with a button sensor")
    public void iHaveADoorWithAButtonSensor() {
        ServiceCenter serviceCenter = new ServiceCenter();
        door = new Door(serviceCenter);
    }

    @Given("I have a door button sensor listener")
    public void iHaveADoorButtonSensorListener() {
        listenerDoorButtonSensor = new TestDoorButtonSensorListener();

    }

    @When("I add a listener to the door button sensor")
    public void iAddAListenerToTheDoorButtonSensor() {
        door.getToggleButton().addListener(listenerDoorButtonSensor);
    }

    @When("I press the door button sensor")
    public void iPressTheButton() {
        door.getToggleButton().pressButton();
    }

    @Then("The listener should receive a button press")
    public void theListenerShouldReceiveAButtonPress() {
        assertTrue(listenerDoorButtonSensor.buttonPressReceived);
    }

    public static class TestBatteryListener implements IBatteryCellTemperatureListener {
        public double lastTemperature = -1;
        public boolean temperatureUpdateReceived = false;

        @Override
        public void batteryTemperatureChanged(double temperature, Object battery) {
            lastTemperature = temperature;
            temperatureUpdateReceived = true;
        }
    }

    public static class TestUltrasonicListener implements IUltraSonicSensorListener {
        public double lastDistance = -1;
        public boolean distanceUpdateReceived = false;

        @Override
        public void ultraSonicMeasurement(UltraSonicSensor sensor, double distance) {
            lastDistance = distance;
            distanceUpdateReceived = true;

        }
    }

    public static class TestDoorButtonSensorListener implements IButtonPressedListener {

        public boolean buttonPressReceived = false;

        @Override
        public void buttonPressed() {
            buttonPressReceived = true;
        }
    }
}
