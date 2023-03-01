package events;

public class EventGPSConnectSatellite {
    private String frequency;

    public EventGPSConnectSatellite(String frequency) {
        this.frequency = frequency;
    }

    public String getFrequency() {
        return frequency;
    }

    public String toString() {
        return "event -> Connecting Satellite to GPS";
    }
}
