package s03facade;

import com.tngtech.jgiven.junit5.ScenarioTest;
import org.junit.jupiter.api.Test;
import s01components.events.*;

public class TestVehicleControlUnit extends ScenarioTest<GivenAutonomousVehicle, WhenVehicleControlUnit, ThenVehicleControlUnit> {

    @Test
    public void startup() {
        given().aAmazonZoox().with().aControlBusListener();
        when().startupIsCalled();
        then().controlBusHasReceivedEvents(new Class[]{
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
        given().aAmazonZoox().with().aControlBusListener();
        when().moveIsCalled(100, 10);
        then().controlBusHasReceivedEvents(new Class[]{
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
        given().aAmazonZoox().with().aControlBusListener();
        when().leftTurnIsCalled(100, 10);
        then().controlBusHasReceivedEvents(new Class[]{
                EventLeftIndicatorOn.class,
                EventEngineDecreaseRPM.class,
                EventBrakeSet.class,
                EventBrakeLightOn.class
        });
    }

    @Test
    public void rightTurn() {
        given().aAmazonZoox().with().aControlBusListener();
        when().right_turn_is_called(100, 10);
        then().controlBusHasReceivedEvents(new Class[]{
                EventRightIndicatorOn.class,
                EventEngineDecreaseRPM.class,
                EventBrakeSet.class,
                EventBrakeLightOn.class
        });
    }

    @Test
    public void stop() {
        given().aAmazonZoox().with().aControlBusListener();
        when().stopIsCalled();
        then().controlBusHasReceivedEvents(new Class[]{
                EventBrakeSet.class,
                EventBrakeLightOn.class
        });
    }

    @Test
    public void emergencyStop() {
        given().aAmazonZoox().with().aControlBusListener();
        when().emergencyStopIsCalled();
        then().controlBusHasReceivedEvents(new Class[]{
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
        given().aAmazonZoox().with().aControlBusListener();
        when().shutdownIsCalled();
        then().controlBusHasReceivedEvents(new Class[]{
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
