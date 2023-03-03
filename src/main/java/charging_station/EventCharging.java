package charging_station;

//TODO where to add in InteliJ + where to add in VPP (currently in s06)?
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
