import java.util.ArrayList;

public abstract class BatteryUnit implements IBattery {
    protected final ArrayList<BatteryUnit> subUnits = new ArrayList<>();
    private final BatteryUnit parentUnit;

    public BatteryUnit(BatteryUnit parentUnit) {
        this.parentUnit = parentUnit;
    }

    public abstract void printBatterySummary();

    public void printSubBatterySummary() {
        subUnits.forEach(BatteryUnit::printBatterySummary);
    }

    protected void addSubUnit(BatteryUnit subUnit) {
        subUnits.add(subUnit);
    }

    public boolean isComposite() {
        return subUnits.size() > 0;
    }

    public int getEnergyCount() {
        if (!isComposite())
            throw new RuntimeException("This isn't a composite in the battery. It must implement getEnergyCount() from BatteryUnit.");
        return subUnits.stream().mapToInt(BatteryUnit::getEnergyCount).sum();
    }

    public int useEnergyCount(int count) {
        if (!isComposite())
            throw new RuntimeException("This isn't a composite in the battery. It must implement useEnergyCount() from BatteryUnit.");

        int usedEnergy = 0;
        for (BatteryUnit subUnit : subUnits) {
            usedEnergy += subUnit.useEnergyCount(count - usedEnergy);
            if (usedEnergy == count) {
                break;
            }
        }

        return usedEnergy;
    }
}
