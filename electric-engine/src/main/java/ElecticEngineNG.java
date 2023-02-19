public class ElecticEngineNG {
    private static final ElecticEngineNG instance = new ElecticEngineNG();
    public Port port;
    private ElectricEngineState state;
    private int rpm;

    private ElecticEngineNG() {
        port = new Port();
    }

    public static ElecticEngineNG getInstance() {
        return instance;
    }

    private void innerOn() {
        state = ElectricEngineState.ON;
    }

    private void innerOff() {
        state = ElectricEngineState.OFF;
    }

    private void innerIncreaseRPM(int deltaRPM, int seconds) {
        rpm += deltaRPM;
        //TODO: implements seconds
    }

    private void innerDecreaseRPM(int deltaRPM, int seconds) {
        rpm -= deltaRPM;
    }

    private int innerComputePowerDrawPerSecond() {
        return 3 * rpm;
    }

    public class Port implements IElectricEngine {
        @Override
        public void on() {
            innerOn();
        }

        @Override
        public void off() {
            innerOff();
        }

        @Override
        public void increaseRPM(int deltaRPM, int seconds) {
            innerIncreaseRPM(deltaRPM, seconds);
        }

        @Override
        public void decreaseRPM(int deltaRPM, int seconds) {
            innerDecreaseRPM(deltaRPM, seconds);
        }

        @Override
        public int computePowerDrawPerSecond() {
            return innerComputePowerDrawPerSecond();
        }
    }
}
