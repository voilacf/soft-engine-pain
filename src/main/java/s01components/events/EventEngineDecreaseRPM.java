package s01components.events;

public class EventEngineDecreaseRPM {
    private final int deltaRPM;
    private final int seconds;

    public EventEngineDecreaseRPM(int deltaRPM, int seconds) {
        this.deltaRPM = deltaRPM;
        this.seconds = seconds;
    }

    public int getDeltaRPM() {
        return deltaRPM;
    }

    public String toString() {
        return "event -> increasing engine RPM";
    }

    public int getSeconds() {
        return seconds;
    }
}
