package s05servicecenter;

import java.util.ArrayList;

abstract public class ServiceUnit {
    private ServiceUnit parentUnit;
    protected ArrayList<ServiceUnit> subUnits;

    abstract public EmployeeState getState();

    abstract public EmployeeResponsibility getResposibility();

    abstract public VehicleDivision getDivison();

    public void isComposite() {
    }

    abstract public void printInformation();

    abstract public boolean handleEmergency(EmployeeResponsibility emergencyType, VehicleDivision vehicleType);
}
