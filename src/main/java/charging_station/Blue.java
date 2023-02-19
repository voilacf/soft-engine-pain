package charging_station;


public class Blue extends LoyaltyState {
    public Blue(UserMemberCard userMemberCard) {
        super(userMemberCard);
    }

    @Override
    public void promote() {
        int loyaltyPoints = decryptLoyaltyPoints();

        if (loyaltyPoints >= MINIMUM_FOR_SILVER) {
            userMemberCard.setLoyaltyState(new Silver(userMemberCard));
            System.out.println("LoyaltyState changed: \tBLUE -> SILVER");
        }
    }

    @Override
    public boolean addCharging(int amountOfEnergy) {
        int loyaltyPoints = decryptLoyaltyPoints();
        double credits = decryptCredits();
        double costs = credits - (amountOfEnergy * 0.35);
        if(costs >= 0) {
            userMemberCard.setEncryptedCredits(costs);
            userMemberCard.setEncryptedLoyaltyPoints(loyaltyPoints + amountOfEnergy);
            System.out.println("Bill: \tcosts: " + amountOfEnergy * 0.35 + " Euro \tcollected loyaltyPoints: " + amountOfEnergy + " Points");
            return true;
        }
        return false;
    }
}
