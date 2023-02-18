package charging_station;

public class Blue extends LoyaltyState {
    public Blue(UserMemberCard userMemberCard) {
        super(userMemberCard);
    }

    //TODO check promote()
    @Override
    public void promote() {
        int loyaltyPoints = decryptLoyaltyPoints();

        if(loyaltyPoints >= MINIMUM_FOR_SILVER){
            userMemberCard.setLoyaltyState(new Silver(userMemberCard));
            System.out.println("LoyaltyState changed: \tBLUE -> SILVER");
        }
    }
    //TODO check addCharging(...)
    @Override
    public void addCharging(int amountOfEnergy) {
        int loyaltyPoints = decryptLoyaltyPoints();
        double credits = decryptCredits();
        userMemberCard.setEncryptedCredits(credits-(amountOfEnergy * 0.35));
        userMemberCard.setEncryptedLoyaltyPoints(loyaltyPoints + amountOfEnergy);
        System.out.println("Bill: \tcosts: "+ amountOfEnergy*0.35+" Euro \tcollected loyaltyPoints: "+amountOfEnergy+" Points");
    }
}
