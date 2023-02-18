package service_center;

public interface IEmployeeGateMediator {
    public void setFirstGate(EmployeeGate gate);

    public void setSecondGate(EmployeeGate gate);

    public void openGate();

    public void closeGate();
}
