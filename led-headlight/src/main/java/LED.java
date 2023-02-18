public class LED {
    private static final LED instance = new LED();
    public Port port;
    private LEDState state;

    public LED() {
        port = new Port();
    }

    public void innerOn() {
        state = LEDState.ON;
    }

    public void innerOff() {
        state = LEDState.OFF;
    }

    public void innerDimm() {
        state = LEDState.DIMMED;
    }

    public void innerBeam() {
        state = LEDState.HIGHBEAM;
    }

    public class Port implements ILED {

        public void on() {
            innerOn();
        }

        public void off() {
            innerOff();
        }

        public void dimm() {
            innerDimm();
        }

        public void beam() {
            innerBeam();
        }
    }
}
