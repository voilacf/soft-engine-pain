package charging_station;

public class Gold extends LoyaltyState {
    public Gold(UserMemberCard userMemberCard) {
        super(userMemberCard);
    }

    //TODO check promote()
    public void promote() {
        int minPointsForChange = 10000;

        ContextEncryption contextEncryption = new ContextEncryption(userMemberCard.getEncryptionStrategy());
        String loyaltyPoints = userMemberCard.getEncryptedLoyaltyPoints();
        loyaltyPoints = contextEncryption.executeDecryptionStrategy(loyaltyPoints);
        int points = Integer.parseInt(loyaltyPoints);

        if(points >= minPointsForChange){
            userMemberCard.setLoyaltyState(new Platin(userMemberCard));
            System.out.println("LoyaltyState changed: \tGOLD -> PLATIN");
        }

    }
}
