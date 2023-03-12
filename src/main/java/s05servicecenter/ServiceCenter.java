package s05servicecenter;

public class ServiceCenter {
    private final CompanyServiceTeam[] teams;
    private final ServiceEmployee supervisor;

    public ServiceCenter() {
        this.teams = new CompanyServiceTeam[]{new CompanyServiceTeam(VehicleDivision.AUTO_X),
            new CompanyServiceTeam(VehicleDivision.ZOOX)};
        this.supervisor = new ServiceEmployee(EmployeeResponsibility.SUPERVISOR, this.teams);
    }

    //Separate test class for different scenarios
    public boolean handleSpecificEmergency(EmployeeResponsibility emergencyType, VehicleDivision vehicleType) {
        System.out.println("Service center received emergency call");
        return (supervisor.handleEmergency(emergencyType, vehicleType));
    }

    public void handleEmergency() {
        System.out.println("Service center received emergency call");
        EmployeeResponsibility emergencyType = EmployeeResponsibility.EMERGENCY;
        VehicleDivision vehicleType = VehicleDivision.AUTO_X;
        if(supervisor.handleEmergency(emergencyType, vehicleType)){
            System.out.println("Emergency is being handled");
        }
        else{
            System.out.println("Service Center not available");
        }
    }
}
