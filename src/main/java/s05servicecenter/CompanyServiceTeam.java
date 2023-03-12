package s05servicecenter;

import java.util.ArrayList;

public class CompanyServiceTeam extends ServiceUnit {
    private final VehicleDivision division;
    private final ArrayList<ServiceUnit> subUnits;

    public CompanyServiceTeam(VehicleDivision division) {
        this.division = division;
        this.subUnits = new ArrayList<ServiceUnit>();
        this.subUnits.add(new ServiceEmployee(EmployeeResponsibility.EMERGENCY));
        this.subUnits.add(new ServiceEmployee(EmployeeResponsibility.MAINTANCE));
        this.subUnits.add(new ServiceEmployee(EmployeeResponsibility.MAINTANCE));
    }

    @Override
    public EmployeeState getState() {
        return null;
    }

    @Override
    public EmployeeResponsibility getResposibility() {
        return null;
    }

    @Override
    public VehicleDivision getDivison() {
        return this.division;
    }

    @Override
    public void printInformation() {
    }

    @Override
    public boolean handleEmergency(EmployeeResponsibility emergencyType, VehicleDivision vehicleType) {
        for (ServiceUnit subunit : this.subUnits) {
            if (subunit.getResposibility().equals(emergencyType) && subunit.getState().equals(EmployeeState.AVAILABLE)) {
                return subunit.handleEmergency(emergencyType, vehicleType);
            }
        }
        return false;
    }
}
