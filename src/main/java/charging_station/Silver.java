package charging_station;

public class Silver extends LoyaltyState {
    public Silver(UserMemberCard userMemberCard) {
        super(userMemberCard);
    }

    //TODO check promote()
    public void promote() {
        int minPointsForChange = 2000;

        ContextEncryption contextEncryption = new ContextEncryption(userMemberCard.getEncryptionStrategy());
        String loyaltyPoints = userMemberCard.getEncryptedLoyaltyPoints();
        loyaltyPoints = contextEncryption.executeDecryptionStrategy(loyaltyPoints);
        int points = Integer.parseInt(loyaltyPoints);

        if(points >= minPointsForChange){
            userMemberCard.setLoyaltyState(new Gold(userMemberCard));
            System.out.println("LoyaltyState changed: \tSILVER -> GOLD");
        }

    }
}
