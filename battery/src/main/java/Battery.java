public class Battery {
    private static final Battery instance = new Battery();
    public Port port;

    private Battery() {
        port = new Port();
    }

    public static Battery getInstance() {
        return instance;
    }

    public int innerGetEnergyCount(){
        //TODO: making this a bit more useful
        return 0;
    }

    public int innerUseEnergyCount(int count){
        //TODO: making this a bit more useful
        return count;
    }

    public static class Port extends BatteryUnit implements IBattery{
        public Port() {
            super(null);

            for (int i = 0; i < 500; i++) {
                addSubUnit(new BatteryMainCell(this));
            }
        }

        public int getEnergyCount(){
            return getInstance().innerGetEnergyCount();
        }

        public int useEnergyCount(int count){
            return getInstance().innerUseEnergyCount(count);
        }

        @Override
        public void printBatterySummary() {
            System.out.println("Battery port with 500 main cells and " + getEnergyCount() + " energy stored");
            super.printSubBatterySummary();
            System.out.println();
        }
    }
}
