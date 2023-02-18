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
        rpm = (int) (2 * Math.PI * deltaRPM) / (seconds / 60);
        //TODO: change rpm to double? + check if calculation is correct
    }

    private void innerDecreaseRPM(int deltaRPM, int seconds) {
        rpm = (int) (2 * Math.PI * deltaRPM) / (seconds / 60);
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
