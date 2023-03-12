package s02bridge;

import com.tngtech.jgiven.junit5.ScenarioTest;
import org.junit.jupiter.api.Test;
import s01components.application.EngineComponentType;

public class TestBridge extends ScenarioTest<GivenBridge, WhenBridge, ThenBridge> {
    @Test
    public void engineX() {
        given().aEngineWithBridgeAndBattery(EngineComponentType.ENGINE_X);
        when().increasingRpm(120, 60);
        then().shouldHaveUsedEnergy(480); // 120 iterations * 4 energy per iteration
    }

    @Test
    public void engineNG() {
        given().aEngineWithBridgeAndBattery(EngineComponentType.ENGINE_NG);
        when().increasingRpm(120, 60);
        then().shouldHaveUsedEnergy(360); // 120 iterations * 3 energy per iteration
    }
}
