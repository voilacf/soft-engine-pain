public class LED {
    private static final LED instance = new LED();
    public Port port;
    private LEDState state;

    private LED() {
        port = new Port();
    }

    public static LED getInstance() {
        return instance;
    }

    private void innerOn() {
        state = LEDState.ON;
    }

    private void innerOff() {
        state = LEDState.OFF;
    }

    private void innerDimm() {
        state = LEDState.DIMMED;
    }

    private void innerBeam() {
        state = LEDState.HIGHBEAM;
    }

    private LEDState innerGetState(){
        return state;
    }


    public class Port implements ILED {
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
        public void dimm() {
            innerDimm();
        }

        @Override
        public void beam() {
            innerBeam();
        }
    }
}
