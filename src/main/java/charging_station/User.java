package charging_station;

public class User {
    private String name;
    private UserMemberCard userMemberCard;

    public User(String name, IUserMemberCardEncryptionStrategy encryptionStrategy){
        this.name = name;
        this.userMemberCard = new UserMemberCard(encryptionStrategy);
    }
}
