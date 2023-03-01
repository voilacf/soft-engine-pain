package s03.facade;

import com.tngtech.jgiven.junit5.ScenarioTest;
import events.*;
import org.junit.jupiter.api.Test;
import testutils.GivenAutonomousVehicle;

public class VehicleControlUnitFacadeTest extends ScenarioTest<GivenAutonomousVehicle, WhenVehicleControlUnit, ThenVehicleControlUnit> {

    @Test
    public void startup() {
        given().a_amazon_zoox().with().a_control_bus_listener();
        when().startup_is_called();
        then().control_bus_has_received_events(new Class[]{
                EventEngineOn.class,
                EventLEDOn.class,
                EventGPSOn.class,
                EventGPSConnectSatellite.class,
                EventCameraOn.class,
                EventLidarOn.class,
                EventLeftIndicatorOff.class,
                EventRightIndicatorOff.class
        });
    }

    @Test
    public void move() {
        given().a_amazon_zoox().with().a_control_bus_listener();
        when().move_is_called(100, 10);
        then().control_bus_has_received_events(new Class[]{
                EventLeftIndicatorOff.class,
                EventRightIndicatorOff.class,
                EventLEDDimmed.class,
                EventEngineIncreaseRPM.class,
                EventBrakeSet.class,
                EventBrakeLightOff.class
        });
    }

    @Test
    public void leftTurn() {
        given().a_amazon_zoox().with().a_control_bus_listener();
        when().left_turn_is_called(100, 10);
        then().control_bus_has_received_events(new Class[]{
                EventLeftIndicatorOn.class,
                EventEngineDecreaseRPM.class,
                EventBrakeSet.class,
                EventBrakeLightOn.class
        });
    }

    @Test
    public void rightTurn() {
        given().a_amazon_zoox().with().a_control_bus_listener();
        when().right_turn_is_called(100, 10);
        then().control_bus_has_received_events(new Class[]{
                EventRightIndicatorOn.class,
                EventEngineDecreaseRPM.class,
                EventBrakeSet.class,
                EventBrakeLightOn.class
        });
    }

    @Test
    public void stop() {
        given().a_amazon_zoox().with().a_control_bus_listener();
        when().stop_is_called();
        then().control_bus_has_received_events(new Class[]{
                EventBrakeSet.class,
                EventBrakeLightOn.class
        });
    }

    @Test
    public void emergencyStop() {
        given().a_amazon_zoox().with().a_control_bus_listener();
        when().emergency_stop_is_called();
        then().control_bus_has_received_events(new Class[]{
                EventBrakeSet.class,
                EventBrakeLightOn.class,
                EventHazardWarningOn.class,
                EventEngineOff.class,
                EventLedHighBeam.class,
                EventCameraOff.class,
                EventLidarOff.class
        });
    }

    @Test
    public void shutdown() {
        given().a_amazon_zoox().with().a_control_bus_listener();
        when().shutdown_is_called();
        then().control_bus_has_received_events(new Class[]{
                EventBrakeSet.class,
                EventEngineOff.class,
                EventBrakeLightOff.class,
                EventLEDOff.class,
                EventHazardWarningOff.class,
                EventGPSOff.class,
                EventCameraOff.class,
                EventLidarOff.class
        });
    }
}
