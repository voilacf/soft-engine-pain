public class LED implements ILED{
    private LEDState state;

    public LED(){
        state = LEDState.OFF;
    }

    public void on(){
        state = LEDState.ON;
    }

    public void off(){
        state = LEDState.OFF;
    }

    public void dimm(){
        state = LEDState.DIMMED;
    }

    public void beam(){
        state = LEDState.HIGHBEAM;
    }
}
