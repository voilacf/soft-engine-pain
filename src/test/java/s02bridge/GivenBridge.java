package s02bridge;

import com.tngtech.jgiven.Stage;
import com.tngtech.jgiven.annotation.ProvidedScenarioState;
import s01components.ComponentFactory;
import s01components.application.EngineComponentType;
import s01components.control_units.ComponentUtils;

public class GivenBridge extends Stage<GivenBridge>{
    @ProvidedScenarioState
    public Object engine;
    @ProvidedScenarioState
    public EnginePowerProvider powerProvider;
    @ProvidedScenarioState
    public Object battery;

    public GivenBridge aEngineWithBridgeAndBattery(EngineComponentType type){
        engine = ComponentFactory.buildEngine(type);
        battery = ComponentFactory.buildBattery();
        powerProvider = new EnginePowerProvider(engine, battery);
        ComponentUtils.invokeMethod(engine, "setPowerProvider", new Class[]{Object.class}, powerProvider);
        return self();
    }
}
