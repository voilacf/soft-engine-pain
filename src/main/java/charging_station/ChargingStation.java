package charging_station;

import adapter.IChargable;

public class ChargingStation {
    //TODO check if energy has to be own class with attribute cost
    private int energy = 500000;

    //TODO implement plugInDevice(IChargable device) whats task of method????
    public void plugInDevice(IChargable device) {
        device.plugIn2Pin();
        System.out.println("Device is plugged in");
    }

    //TODO check finishChargingSession(int amount, UserMemberCard userMemberCard)
    public void finishChargingSession(int amountOfEnergy, UserMemberCard userMemberCard) {
        if ((getEnergy() - amountOfEnergy) >= 0) {
            setEnergy(getEnergy() - amountOfEnergy);
            userMemberCard.getLoyaltyState().addCharging(amountOfEnergy);
            userMemberCard.getLoyaltyState().promote();
        } else System.out.println("Charging station does not contain enough energy for this charging session");
    }

    public int getEnergy() {
        return energy;
    }

    public void setEnergy(int energy) {
        this.energy = energy;
    }
}
