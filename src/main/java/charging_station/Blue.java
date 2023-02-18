package charging_station;

public class Blue extends LoyaltyState {
    public Blue(UserMemberCard userMemberCard) {
        super(userMemberCard);
    }

    //TODO check promote()
    public void promote() {
        int minPointsForChange = 500;

        ContextEncryption contextEncryption = new ContextEncryption(userMemberCard.getEncryptionStrategy());
        String loyaltyPoints = userMemberCard.getEncryptedLoyaltyPoints();
        loyaltyPoints = contextEncryption.executeDecryptionStrategy(loyaltyPoints);
        int points = Integer.parseInt(loyaltyPoints);

        if(points >= minPointsForChange){
            userMemberCard.setLoyaltyState(new Silver(userMemberCard));
            System.out.println("LoyaltyState changed: \tBLUE -> SILVER");
        }

    }
}
