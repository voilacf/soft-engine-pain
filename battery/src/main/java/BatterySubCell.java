public class BatterySubCell extends BatteryUnit {
    public BatterySubCell(BatteryUnit parentUnit) {
        super(parentUnit);

        for(int i = 0; i < 5; i++) {
            addSubUnit(new BatteryCell(this));
        }
    }

    @Override
    public void printBatterySummary() {
        System.out.println("Battery sub cell with 5 cells and " + getEnergyCount() + " energy stored");
        super.printSubBatterySummary();
    }
}
