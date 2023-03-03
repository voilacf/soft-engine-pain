package events;

public class EventEngineDecreaseRPM {
    private int deltaRPM;
    private int seconds;

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
