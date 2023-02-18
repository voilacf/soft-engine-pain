package charging_station;

public class Gold extends LoyaltyState {
    public Gold(UserMemberCard userMemberCard) {
        super(userMemberCard);
    }

    @Override
    public void promote() {
        int loyaltyPoints = decryptLoyaltyPoints();

        if (loyaltyPoints >= MINIMUM_FOR_PLATIN) {
            userMemberCard.setLoyaltyState(new Platin(userMemberCard));
            System.out.println("LoyaltyState changed: \tGOLD -> PLATIN");
        }
    }

    //TODO check addCharging(...)
    @Override
    public void addCharging(int amountOfEnergy) {
        int loyaltyPoints = decryptLoyaltyPoints();
        double credits = decryptCredits();
        userMemberCard.setEncryptedCredits(credits - (amountOfEnergy * 0.35));
        userMemberCard.setEncryptedLoyaltyPoints(loyaltyPoints + amountOfEnergy * 2);
        System.out.println("Bill: \tcosts: " + amountOfEnergy * 0.35 + " Euro \tcollected loyaltyPoints: " + amountOfEnergy * 2 + " Points");
    }
}
