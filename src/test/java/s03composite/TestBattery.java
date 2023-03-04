package s03composite;

import com.tngtech.jgiven.junit5.ScenarioTest;
import org.junit.jupiter.api.Test;

public class TestBattery extends ScenarioTest<GivenBattery, WhenBattery, ThenBattery> {
    private static final int batteryCapacity = 500 * 100 * 5; // Main cells * sub cells * single cells

    @Test
    public void batteryIsInitiallyFullyCharged() {
        given().aBattery();
        then().theBatteryHasCharge(batteryCapacity);
    }

    @Test
    public void batteryCanDischarge() {
        given().aBattery();
        when().useEnergy(batteryCapacity);
        then().theBatteryHasCharge(0);
    }

    @Test
    public void batteryCanCharge() {
        given().aBattery();
        when().useEnergy(batteryCapacity)
                .and().chargeBattery(batteryCapacity);
        then().theBatteryHasCharge(batteryCapacity);
    }

    @Test
    public void batterySupportsPartialDischarge() {
        given().aBattery();
        when().useEnergy(batteryCapacity / 2);
        then().theBatteryHasCharge(batteryCapacity / 2);
    }

    @Test
    public void batteryHas500MainCells() {
        given().aBattery();
        then().theBatteryHasSubunits(500);
    }

    @Test
    public void mainCellHas100SubCells() {
        given().aMainCell();
        then().theBatteryHasSubunits(100);
    }

    @Test
    public void subCellHas5SingleCells() {
        given().aSubCell();
        then().theBatteryHasSubunits(5);
    }

    @Test
    public void singleCellHasOneCapacity() {
        given().aSingleBatteryCell();
        then().theBatteryHasCharge(1);
    }
}
