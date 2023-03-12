package s02bridge;

public class EnginePowerProvider {
    private Object engine;
    private Object battery;

    public EnginePowerProvider(Object engine, Object battery){
        this.engine = engine;
        this.battery = battery;
    }

    public void simulateEnergyUsageSecond(int rpm) {
        double rotationPerSecond = rpm/60.0;
        int usagePerRotation = (int) ComponentUtils.invokeMethod(engine, "getPowerDrawPerRotation");
        int energyUsage = (int)Math.round(rotationPerSecond * usagePerRotation);
        System.out.println("Electric engine uses " + energyUsage + " energy per second");

        ComponentUtils.invokeMethod(battery, "useEnergy", new Class[] {int.class}, energyUsage);
    }
}
