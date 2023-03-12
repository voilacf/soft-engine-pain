public class ElectricEngineX {
    private static final ElectricEngineX instance = new ElectricEngineX();
    public Port port;
    private ElectricEngineState state;
    private int rpm = 0;

    private ElectricEngineX() {
        port = new Port();
    }

    public static ElectricEngineX getInstance() {
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
        //TODO: implement seconds (s02)
    }

    private void innerDecreaseRPM(int deltaRPM, int seconds) {
        rpm -= deltaRPM;
        //TODO: implement seconds (s02)
    }

    private int innerComputePowerDrawPerSecond() {
        return 3 * rpm;
    }

    private ElectricEngineState innerGetState(){
        return this.state;
    }

    private int innerGetRPM() {
        return rpm;
    }

    public class Port implements IElectricEngine {
        @Override
        public int getRPM(){
            return innerGetRPM();
        }

        @Override
        public String getState(){
            return innerGetState().toString().toLowerCase();
        }

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
