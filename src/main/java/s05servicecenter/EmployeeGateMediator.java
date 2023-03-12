package s05servicecenter;

public class EmployeeGateMediator implements IEmployeeGateMediator, EmployeePresenceDetectorListener {

    private EmployeeGate firstGate;
    private EmployeeGate secondGate;

    @Override
    public void setFirstGate() {
        new EmployeeGate(this);
    }

    @Override
    public void setSecondGate() {
        new EmployeeGate(this);
    }

    @Override
    public void openGate() {

    }

    @Override
    public void closeGate() {

    }

    @Override
    public void employeeAfterFirstDoor() {

    }

    @Override
    public void employeeAfterSecondDoor() {

    }
}
