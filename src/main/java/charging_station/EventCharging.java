package charging_station;

public class EventCharging {
    private final int amountOfEnergy;

    public EventCharging(int amountOfEnergy) {
        this.amountOfEnergy = amountOfEnergy;
    }

    public int getAmountOfEnergy() {
        return amountOfEnergy;
    }

    @Override
    public String toString() {
        return "event -> charging";
    }
}
