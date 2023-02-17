import javax.sound.sampled.Port;

public class Battery {

    private static final Battery instance = new Battery();

    private static int energyCount;

    public Port port;

    private Battery() {
        port = new Port();
    }

    public static Battery getInstance() {
        return instance;
    }

    public void printBatterySummary() {
        System.out.println("Battery Summary:");
        System.out.println("Engine count: " + port.getEngineCount());
    }

    public static class Port implements IBattery {


        @Override
        public int getEngineCount() {
            return 0;
        }

        @Override
        public boolean useEnergy(int count) {
            return false;
        }
    }


}
