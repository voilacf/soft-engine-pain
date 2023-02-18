package charging_station;

public class Silver extends LoyaltyState {
    public Silver(UserMemberCard userMemberCard) {
        super(userMemberCard);
    }
    @Override
    public void promote() {
        int loyaltyPoints = decryptLoyaltyPoints();

        if(loyaltyPoints >= MINIMUM_FOR_GOLD){
            userMemberCard.setLoyaltyState(new Gold(userMemberCard));
            System.out.println("LoyaltyState changed: \tSILVER -> GOLD");
        }
    }

    //TODO check addCharging(...)
    @Override
    public void addCharging(int amountOfEnergy) {
        int loyaltyPoints = decryptLoyaltyPoints();
        double credits = decryptCredits();
        userMemberCard.setEncryptedCredits(credits-(amountOfEnergy * 0.35));
        userMemberCard.setEncryptedLoyaltyPoints(loyaltyPoints + amountOfEnergy + 150);
        System.out.println("Bill: \tcosts: "+ amountOfEnergy*0.35+" Euro \tcollected loyaltyPoints: "+amountOfEnergy+150+" Points");
    }
}
