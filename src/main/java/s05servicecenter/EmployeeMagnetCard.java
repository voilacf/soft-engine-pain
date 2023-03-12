package s05servicecenter;

public class EmployeeMagnetCard {

    private final String irisHash;
    private final String fingerprintHash;

    public EmployeeMagnetCard(String irisHash, String fingerprintHash){
        this.irisHash = irisHash;
        this.fingerprintHash = fingerprintHash;
    }

    public String getIrisHash(){
        return irisHash;
    }

    public String getFingerprintHash(){
        return fingerprintHash;
    }
}
