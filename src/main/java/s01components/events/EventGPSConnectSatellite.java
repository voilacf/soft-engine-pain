package s01components.events;

public class EventGPSConnectSatellite {
    private final String frequency;

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
