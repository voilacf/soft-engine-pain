package service_center;

import java.util.ArrayList;

public class EmployeePresenceDetector {
    private ArrayList<EmployeePresenceDetectorListener> listeners;

    public void employeeAfterFirstDoor(){};
    public void employeeAfterSecondDoor(){};
    public void addListener(EmployeePresenceDetectorListener listener){};
    public void removeListener(EmployeePresenceDetectorListener listener){};
}
