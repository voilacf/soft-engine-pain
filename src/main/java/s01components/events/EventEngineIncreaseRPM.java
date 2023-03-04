package s01components.events;

public class EventEngineIncreaseRPM {
    private final int deltaRPM;
    private final int seconds;

    public EventEngineIncreaseRPM(int deltaRPM, int seconds) {
        this.deltaRPM = deltaRPM;
        this.seconds = seconds;
    }

    public int getDeltaRPM() {
        return deltaRPM;
    }

    public String toString() {
        return "event -> decreasing engine RPM";
    }

    public int getSeconds() {
        return seconds;
    }
}
