package charging_station;

import adapter.IChargable;

public class ChargingStation {
    //TODO check if energy has to be own class with attribute cost
    private int energy = 500000;

    //TODO implement plugInDevice(IChargable device)
    public void plugInDevice(IChargable device){

    }
    //TODO implement finishChargingSession(int amount, UserMemberCard userMemberCard)
    public void finishChargingSession(int amount, UserMemberCard userMemberCard){
        userMemberCard.getLoyaltyState().promote();
    }
}
