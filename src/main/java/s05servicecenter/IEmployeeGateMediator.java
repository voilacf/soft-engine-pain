package s05servicecenter;

public interface IEmployeeGateMediator {
    void setFirstGate(EmployeeGate gate);

    void setSecondGate(EmployeeGate gate);

    void openGate();

    void closeGate();
}
