package s02adapter;

public class AutoXBatteryCharger {
    private boolean pluggedIn = false;

    public void plugIn3Pin() {
        System.out.println("AutoX Battery charges");
        pluggedIn = true;
    }

    public boolean isPluggedIn() {
        return pluggedIn;
    }
}