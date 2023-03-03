package s03;

import application.ApplicationConfiguration;
import builder.AutonomousVehicle;
import com.google.common.eventbus.Subscribe;
import com.tngtech.jgiven.Stage;
import com.tngtech.jgiven.annotation.ProvidedScenarioState;
import components.VehicleKey;
import components.VehicleKeyReceiverModule;
import control_unit.Subscriber;
import factories.AutonomousVehicleFactory;
import observer_S04.VehicleControlUnit;
import service_center.ServiceCenter;

import java.util.ArrayList;

import static org.mockito.Mockito.spy;

public class GivenAutonomousVehicle extends Stage<GivenAutonomousVehicle> {
    @ProvidedScenarioState
    public VehicleControlUnit vehicleControlUnit;

    @ProvidedScenarioState
    public AutonomousVehicle autonomousVehicle;

    @ProvidedScenarioState
    public ServiceCenter serviceCenter;

    @ProvidedScenarioState
    public VehicleKey key;

    @ProvidedScenarioState
    public ControlBusSubscriber controlBusSubscriber;

    public GivenAutonomousVehicle aAmazonZoox() {
        serviceCenter = spy(new ServiceCenter());
        autonomousVehicle = AutonomousVehicleFactory.buildAmazonZoox(serviceCenter, ApplicationConfiguration.loadJSONConfig("config.json"));
        vehicleControlUnit = autonomousVehicle.getControlUnit();
        key = new VehicleKey(new VehicleKeyReceiverModule(vehicleControlUnit), autonomousVehicle.getType());
        return self();
    }

    public GivenAutonomousVehicle aAutoX() {
        serviceCenter = spy(new ServiceCenter());
        autonomousVehicle = AutonomousVehicleFactory.buildAutoX(serviceCenter, ApplicationConfiguration.loadJSONConfig("config.json"));
        vehicleControlUnit = autonomousVehicle.getControlUnit();
        key = new VehicleKey(new VehicleKeyReceiverModule(vehicleControlUnit), autonomousVehicle.getType());
        return self();
    }

    public GivenAutonomousVehicle aControlBusListener() {
        controlBusSubscriber = new ControlBusSubscriber();
        vehicleControlUnit.addSubscriber(controlBusSubscriber);
        return self();
    }

    public static class ControlBusSubscriber extends Subscriber {
        private final ArrayList<Object> receivedEvents = new ArrayList<>();

        public ControlBusSubscriber() {
            super(10);
        }

        @Subscribe
        public void receive(Object event) {
            receivedEvents.add(event);
        }

        public ArrayList<Object> getReceivedEvents() {
            return receivedEvents;
        }
    }
}
