package s05servicecenter;
import java.util.ArrayList;
import java.util.Random;

public class ServiceEmployee extends ServiceUnit {

    public final EmployeeMagnetCard employeeMagnetCard;
    private final EmployeeResponsibility responsibility;
    private final ArrayList<ServiceUnit> subUnits;
    private EmployeeState state;
    public final char[][] iris;
    public final char[][] fingerprint;

    public ServiceEmployee(EmployeeResponsibility responsibility) {
        this.responsibility = responsibility;
        this.state = EmployeeState.AVAILABLE;
        this.iris = getBodyFeature();
        this.fingerprint = getBodyFeature();
        EncryptionSHA256 enc = new EncryptionSHA256();
        employeeMagnetCard = new EmployeeMagnetCard(enc.encrypt(iris), enc.encrypt(fingerprint));
        this.subUnits = new ArrayList<ServiceUnit>();
    }

    public ServiceEmployee(EmployeeResponsibility responsibility, CompanyServiceTeam[] teams) {
        this.responsibility = responsibility;
        this.iris = getBodyFeature();
        this.fingerprint = getBodyFeature();
        EncryptionSHA256 enc = new EncryptionSHA256();
        employeeMagnetCard = new EmployeeMagnetCard(enc.encrypt(iris), enc.encrypt(fingerprint));
        this.subUnits = new ArrayList<ServiceUnit>();
        this.subUnits.add(teams[0]);
        this.subUnits.add(teams[1]);
    }

    private char[][] getBodyFeature() {
        String chars = ".:*+";
        Random rd = new Random();
        char[][] bodyFeature = new char[10][10];
        for (int i = 0; i<= 9; i++){
            for(int j = 0; j<= 9; j++){
                bodyFeature[i][j] = chars.charAt(rd.nextInt(chars.length()));
            }
        }
        return bodyFeature;
    }

    @Override
    public EmployeeState getState() {
        return this.state;
    }

    @Override
    public EmployeeResponsibility getResposibility() {
        return this.responsibility;
    }

    @Override
    public VehicleDivision getDivison() {
        return null;
    }

    @Override
    public void printInformation() {

    }

    @Override
    public boolean handleEmergency(EmployeeResponsibility emergencyType, VehicleDivision vehicleType) {
        if (this.responsibility == EmployeeResponsibility.SUPERVISOR) {
            for (ServiceUnit subunit : this.subUnits) {
                if (subunit.getDivison().equals(vehicleType)) {
                    return subunit.handleEmergency(emergencyType, vehicleType);
                }
            }
        } else {
            this.state = EmployeeState.BUSY;
            return true;
        }
        return false;
    }
}
