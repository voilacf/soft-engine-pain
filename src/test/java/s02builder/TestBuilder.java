package s02builder;

import com.tngtech.jgiven.junit5.ScenarioTest;
import org.junit.jupiter.api.Test;

public class TestBuilder extends ScenarioTest<GivenBuilder, WhenBuilder, ThenBuilder> {
    @Test
    public void zoox() {
        given().aConfigurationAndServiceCenter();
        when().buildingAmazonZoox();
        then().hasAChassis()
                .and().hasAEngine()
                .and().hasBattery()
                .and().hasHeadlights(4)
                .and().hasBrakes(4)
                .and().hasIndicators(2) // 2 pairs = 4
                .and().hasDoors(4)
                .and().hasSeatBenches(2)
                .and().hasWheels(4)
                .and().hasGps(2)
                .and().hasCameras(4)
                .and().hasLidars(4);
    }

    @Test
    public void autoX() {
        given().aConfigurationAndServiceCenter();
        when().buildingAutoX();
        then().hasAChassis()
                .and().hasAEngine()
                .and().hasBattery()
                .and().hasHeadlights(2)
                .and().hasBrakes(8)
                .and().hasIndicators(2) // 2 pairs = 4
                .and().hasDoors(4)
                .and().hasSeats(6)
                .and().hasWheels(4)
                .and().hasGps(2)
                .and().hasCameras(2)
                .and().hasLidars(4);
    }
}
