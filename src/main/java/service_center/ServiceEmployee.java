package service_center;

public class ServiceEmployee extends ServiceUnit {

    private final EmployeeMagnetCard employeeMagnetCard;
    private EmployeeResponsibility responsibility;
    private EmployeeState state;

    public ServiceEmployee() {

        employeeMagnetCard = new EmployeeMagnetCard();

    }

    @Override
    public void printInformation() {

    }

    @Override
    public boolean handleEmergency() {
        return false;
    }
}
