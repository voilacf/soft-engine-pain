package charging_station;

import adapter.IChargable;

public class ChargingStation {
    //TODO check if energy has to be own class with attribute cost
    private int energy = 500000;

    public void plugInDevice(IChargable device) {
        device.plugIn2Pin();
        System.out.println("Device is plugged in");
    }

    public void finishChargingSession(int amountOfEnergy, UserMemberCard userMemberCard) {
        boolean enoughCreditsForChargingSuccess;
        if ((getEnergy() - amountOfEnergy) >= 0) {
            enoughCreditsForChargingSuccess = userMemberCard.getLoyaltyState().addCharging(amountOfEnergy);
            if(enoughCreditsForChargingSuccess) {
                setEnergy(getEnergy() - amountOfEnergy);
                userMemberCard.getLoyaltyState().promote();
            } else System.out.println("Cancelled charging because card has not enough credits");
        } else System.out.println("Charging station does not contain enough energy for this charging session");
    }

    public int getEnergy() {
        return energy;
    }

    public void setEnergy(int energy) {
        this.energy = energy;
    }
}
