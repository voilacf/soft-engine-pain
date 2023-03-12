package s05servicecenter;

public class EmployeeGate {
    private EmployeeGateState state;
    private final IEmployeeGateMediator gateMediator;
    private final EmployeePresenceDetector detector;

    public EmployeeGate(IEmployeeGateMediator gateMediator){
        this.gateMediator = gateMediator;
        this.detector = new EmployeePresenceDetector();
    }

    public void open() {
        this.state = EmployeeGateState.OPEN;
    }

    public void close() {
        this.state = EmployeeGateState.CLOSED;
    }

}
