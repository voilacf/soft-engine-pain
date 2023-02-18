public class BatteryCell extends BatteryUnit {
    private boolean energy = true;

    public BatteryCell(BatteryUnit parentUnit) {
        super(parentUnit);
    }

    @Override
    public void printBatterySummary() {
        System.out.println("Battery cell is " + (energy ? "full" : "empty"));
    }

    @Override
    public int getEnergyCount() {
        return energy ? 1 : 0;
    }

    @Override
    public int useEnergyCount(int count) {
        if (energy) {
            // Energy is available, use it
            energy = false;
            return 1;
        } else {
            // No energy available that could be used
            return 0;
        }
    }
}
