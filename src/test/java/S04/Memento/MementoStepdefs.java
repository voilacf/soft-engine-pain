package S04.Memento;

import application.ApplicationConfiguration;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import memento.DriveMusic;
import memento.NaggingPassengersBehavior;
import memento.VehicleConfiguration;
import memento.VehicleConfigurationMemento;

import static org.junit.jupiter.api.Assertions.*;

public class MementoStepdefs {
    VehicleConfigurationMemento memento;
    VehicleConfiguration configuration;
    ApplicationConfiguration applicationConfiguration;

    @Given("I have a configuration memento")
    public void iHaveAConfigurationMemento() {
        memento = new VehicleConfigurationMemento();
    }

    @Then("The memento should have the default settings")
    public void theMementoShouldHaveTheDefaultSettings() {
        assertTrue(memento.rejectDrunkenPassengers);
        assertTrue(memento.stopByPoliceRequest);
        assertTrue(memento.allowDriveByNight);
        assertSame(memento.behaviorWithNaggingPassengers, NaggingPassengersBehavior.STOP_AND_WAIT_FOR_EXCUSE);
        assertSame(memento.musicDuringDrive, DriveMusic.AC_DC);
    }


    @Given("I have a vehicle configuration")
    public void iHaveAVehicleConfiguration() {
        configuration = new VehicleConfiguration();
    }

    @When("I load the settings from the json file")
    public void iLoadTheSettingsFromTheJsonFile() {
        applicationConfiguration = ApplicationConfiguration.loadJSONConfig("test_config.json");
    }

    @When("I restore the settings from the memento")
    public void iRestoreTheSettingsFromTheJsonFile() {
        configuration.restore(applicationConfiguration.getVehicleConfigurationMemento());
    }

    @Then("The memento should have the settings from the json file")
    public void theMementoShouldHaveTheSettingsFromTheJsonFile() {
        assertEquals(applicationConfiguration.getVehicleConfigurationMemento().rejectDrunkenPassengers, configuration.isRejectDrunkenPassengers());
        assertEquals(applicationConfiguration.getVehicleConfigurationMemento().stopByPoliceRequest, configuration.isStopByPoliceRequest());
        assertEquals(applicationConfiguration.getVehicleConfigurationMemento().allowDriveByNight, configuration.isAllowDriveByNight());
        assertEquals(applicationConfiguration.getVehicleConfigurationMemento().behaviorWithNaggingPassengers, configuration.getBehaviorWithNaggingPassengers());
        assertEquals(applicationConfiguration.getVehicleConfigurationMemento().musicDuringDrive, configuration.getMusicDuringDrive());
    }

    @When("I print the settings it should not throw an exception")
    public void iPrintTheSettingsItShouldNotThrowAnException() {
        assertDoesNotThrow(() -> configuration.print());
    }

    @When("I change the settings")
    public void iChangeTheSettings() {
        configuration.setParameter("rejectDrunkenPassengers", 0);
        configuration.setParameter("stopByPoliceRequest", 0);
        configuration.setParameter("allowDriveByNight", 0);
        configuration.setParameter("behaviorWithNaggingPassengers", 0);
        configuration.setParameter("musicDuringDrive", 0);
    }

    @Then("The settings should be changed")
    public void theSettingsShouldBeChanged() {
        assertFalse(configuration.isRejectDrunkenPassengers());
        assertFalse(configuration.isStopByPoliceRequest());
        assertFalse(configuration.isAllowDriveByNight());
        assertSame(configuration.getBehaviorWithNaggingPassengers(), NaggingPassengersBehavior.DO_NOTHING);
        assertSame(configuration.getMusicDuringDrive(), DriveMusic.HELENE_FISCHER);
    }

    @When("I save the settings")
    public void iSaveTheSettingsToTheJsonFile() {
        applicationConfiguration.setVehicleConfigurationMemento(configuration.save());
        applicationConfiguration.saveJSONConfig();
    }
}
