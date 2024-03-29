package s01components.events;

public class EventBrakeSet {
    private final double percentage;

    public EventBrakeSet(double percentage) {
        this.percentage = percentage;
    }

    public double getPercentage() {
        return percentage;
    }

    public String toString() {
        return "event -> changed brake set";
    }
}
