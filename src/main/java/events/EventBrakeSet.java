package events;

public class EventBrakeSet {
    private double percentage;

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
