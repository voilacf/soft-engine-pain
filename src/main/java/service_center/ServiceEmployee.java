package service_center;

public class ServiceEmployee extends ServiceUnit{

    private EmployeeResponsibility responsibility;
    private EmployeeState state;

    private final EmployeeMagnetCard employeeMagnetCard;

    public ServiceEmployee(){

        employeeMagnetCard  = new EmployeeMagnetCard();

    }

    @Override
    public void printInformation() {

    }

    @Override
    public boolean handleEmergency() {
        return false;
    }
}
