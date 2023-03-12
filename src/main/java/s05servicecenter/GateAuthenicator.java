package s05servicecenter;

public class GateAuthenicator {
    private IAuthenticationStrategy auth;
    private IEncryptionStrategy enc;
    private EmployeeGate firstDoor;

    public GateAuthenicator(){
        this.auth = new AuthenticationFace();
        this.enc = new EncryptionSHA256();
    }

    public boolean authenticateEmployee(ServiceEmployee e, EmployeeMagnetCard eCard){
        String card = eCard.getIrisHash();
        String face = enc.encrypt(e.iris);
        if(face.equals(card)){
            return true;
        }
            return false;
    }
}
