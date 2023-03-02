package s03.facade;

import application.ApplicationConfiguration;
import builder.AutonomousVehicle;
import com.google.common.eventbus.Subscribe;
import com.tngtech.jgiven.Stage;
import com.tngtech.jgiven.annotation.ProvidedScenarioState;
import control_unit.Subscriber;
import control_unit.VehicleControlUnit;
import factories.AutonomousVehicleFactory;
import service_center.ServiceCenter;

import java.util.ArrayList;

public class GivenAutonomousVehicle extends Stage<GivenAutonomousVehicle> {
    @ProvidedScenarioState
    public VehicleControlUnit vehicleControlUnit;

    @ProvidedScenarioState
    public AutonomousVehicle autonomousVehicle;

    @ProvidedScenarioState
    public ServiceCenter serviceCenter;

    @ProvidedScenarioState
    public ControlBusSubscriber controlBusSubscriber;

    public GivenAutonomousVehicle aAmazonZoox() {
        serviceCenter = new ServiceCenter();
        autonomousVehicle = AutonomousVehicleFactory.buildAmazonZoox(serviceCenter, ApplicationConfiguration.loadJSONConfig("config.json"));
        vehicleControlUnit = new VehicleControlUnit(autonomousVehicle);
        return self();
    }

    public GivenAutonomousVehicle aAutoX() {
        serviceCenter = new ServiceCenter();
        autonomousVehicle = AutonomousVehicleFactory.buildAutoX(serviceCenter, ApplicationConfiguration.loadJSONConfig("config.json"));
        vehicleControlUnit = new VehicleControlUnit(autonomousVehicle);
        return self();
    }

    public GivenAutonomousVehicle aControlBusListener() {
        controlBusSubscriber = new ControlBusSubscriber();
        vehicleControlUnit.addSubscriber(controlBusSubscriber);
        return self();
    }

    public static class ControlBusSubscriber extends Subscriber {
        private ArrayList<Object> receivedEvents = new ArrayList<>();

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
