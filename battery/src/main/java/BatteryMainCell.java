public class BatteryMainCell extends BatteryUnit {
    public BatteryMainCell(BatteryUnit parent) {
        super(parent);

        for (int i = 0; i < 100; i++) {
            addSubUnit(new BatterySubCell(this));
        }
    }

    @Override
    public void printBatterySummary() {
        System.out.println("Battery main cell with 100 sub cells and " + getEnergy() + " energy stored");
        super.printSubBatterySummary();
        System.out.println();
    }
}
