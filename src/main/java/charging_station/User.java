package charging_station;

public class User {
    private String name;
    private UserMemberCard userMemberCard;

    public User(String name, IUserMemberCardEncryptionStrategy encryptionStrategy){
        setName(name);
        setUserMemberCard(new UserMemberCard(encryptionStrategy));
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public UserMemberCard getUserMemberCard() {
        return userMemberCard;
    }

    public void setUserMemberCard(UserMemberCard userMemberCard) {
        this.userMemberCard = userMemberCard;
    }
}
