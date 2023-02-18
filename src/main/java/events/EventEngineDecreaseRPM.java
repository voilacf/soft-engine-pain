package events;

public class EventEngineDecreaseRPM {
    private int deltaRPM;
    private int seconds;

    public EventEngineDecreaseRPM(int deltaRPM, int seconds) {
        this.deltaRPM = deltaRPM;
        this.seconds = seconds;
    }

    public String toString() {
        return "event -> increasing engine RPM";
    }
}
