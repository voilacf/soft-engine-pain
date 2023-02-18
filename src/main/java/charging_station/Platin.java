package charging_station;

public class Platin extends LoyaltyState {
    public Platin(UserMemberCard userMemberCard) {
        super(userMemberCard);
    }

    //TODO check promote(UserMemberCard userMemberCard)
    @Override
    public void promote() {
        //TODO check if promote could stay empty
    }

    //TODO check addCharging(...)
    @Override
    public void addCharging(int amountOfEnergy) {
        int loyaltyPoints = decryptLoyaltyPoints();
        double credits = decryptCredits();
        if(userMemberCard.getChargingSessionSinceLastFreebie() == 0){
            userMemberCard.setEncryptedLoyaltyPoints(loyaltyPoints + amountOfEnergy);
            System.out.println("Bill: \tcosts: 0,0 Euro \tcollected loyaltyPoints: "+amountOfEnergy+" Points");
        }
        else if((userMemberCard.getChargingSessionSinceLastFreebie()%5) == 0){
            System.out.println("Bill: \tcosts: 0,0 Euro \tcollected loyaltyPoints: 0");
        }
        else{
            userMemberCard.setEncryptedCredits(credits-(amountOfEnergy * 0.35));
            userMemberCard.setEncryptedLoyaltyPoints(loyaltyPoints + amountOfEnergy*2);
            System.out.println("Bill: \tcosts: "+ amountOfEnergy*0.35+" Euro \tcollected loyaltyPoints: "+amountOfEnergy*2+" Points");
        }
        userMemberCard.setChargingSessionSinceLastFreebie(userMemberCard.getChargingSessionSinceLastFreebie()+1);
    }
}
