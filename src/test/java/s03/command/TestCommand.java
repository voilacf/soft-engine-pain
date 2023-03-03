package s03.command;

import com.tngtech.jgiven.junit5.ScenarioTest;
import org.junit.jupiter.api.Test;
import s03.GivenAutonomousVehicle;

public class TestCommand extends ScenarioTest<GivenAutonomousVehicle, WhenCommand, ThenCommand> {

    @Test
    public void doorIsInitiallyClosed() {
        given().aAmazonZoox();
        then().theDoorIsClosed();
    }

    @Test
    public void doorShouldBeOpenAfterToggle() {
        given().aAmazonZoox();
        when().theDoorToggleDoorButtonIsPressed();
        then().theDoorIsOpen();
    }

    @Test
    public void doorShouldBeClosedAfterTwoToggles() {
        given().aAmazonZoox();
        when().theDoorToggleDoorButtonIsPressed()
                .and().theDoorToggleDoorButtonIsPressed();
        then().theDoorIsClosed();
    }

    @Test
    public void doorEmergencyButtonWorks() {
        given().aAmazonZoox();
        when().theDoorEmergencyButtonIsPressed();
        then().serviceCenterGotNotifiedAboutEmergency();
    }

    @Test
    public void keyStartupButtonWorks() {
        given().aAmazonZoox();
        when().pressingTheKeyEnableButton();
        then().theVehicleIsStarted();
    }

    @Test
    public void keyShutdownButtonWorks() {
        given().aAmazonZoox();
        when().pressingTheKeyEnableButton()
                .and().pressingTheKeyDisableButton();
        then().theVehicleIsStopped();
    }
}
