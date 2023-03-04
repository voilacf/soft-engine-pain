package s05servicecenter;

import java.util.ArrayList;

abstract public class ServiceUnit {
    private ServiceUnit parentUnit;
    private ArrayList<ServiceUnit> subUnits;

    public void isComposite() {
    }

    abstract public void printInformation();

    abstract public boolean handleEmergency();
}
