package s05servicecenter;

public class ServiceEmployee extends ServiceUnit {

    private final EmployeeMagnetCard employeeMagnetCard;
    private EmployeeResponsibility responsibility;
    private EmployeeState state;

    public ServiceEmployee(EmployeeResponsibility responsibility) {
        this.responsibility = responsibility;
        employeeMagnetCard = new EmployeeMagnetCard();
    }

    public ServiceEmployee(EmployeeResponsibility responsibility, CompanyServiceTeam[] teams) {
        this.responsibility = responsibility;
        employeeMagnetCard = new EmployeeMagnetCard();
        this.subUnits.add(teams[0]);
        this.subUnits.add(teams[1]);
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
        }
        else {
            this.state = EmployeeState.BUSY;
            return true;
        }
        return false;
    }
}
