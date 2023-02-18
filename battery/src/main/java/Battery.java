public class Battery {
    private static final Battery instance = new Battery();
    public Port port;

    private Battery() {
        port = new Port();
    }

    public static Battery getInstance() {
        return instance;
    }

    public static class Port extends BatteryUnit {
        public Port() {
            super(null);

            for (int i = 0; i < 500; i++) {
                addSubUnit(new BatteryMainCell(this));
            }
        }

        // getEnergyCount and useEnergyCount are implemented in BatteryUnit which also implements IBattery

        @Override
        public void printBatterySummary() {
            System.out.println("Battery port with 500 main cells and " + getEnergyCount() + " energy stored");
            super.printSubBatterySummary();
            System.out.println();
        }
    }
}
