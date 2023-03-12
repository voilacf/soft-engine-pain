package s02adapter;

import com.tngtech.jgiven.junit5.ScenarioTest;
import org.junit.jupiter.api.Test;

public class TestAdapter extends ScenarioTest<GivenAdapter, WhenAdapter, ThenAdapter> {
    @Test
    public void zoox() {
        given().aZooxCharger();
        when().charging();
        then().zooxChargerWasPluggedIn();
    }

    @Test
    public void autoX() {
        given().aAutoXAdapter();
        when().charging();
        then().autoXChargerWasPluggedIn();
    }
}
