package s02adapter;

public class AmazonZooxBatteryCharger {
    private boolean pluggedIn = false;

    public void plugIn4Pin() {
        System.out.println("Amazon Zoox charges");
        pluggedIn = true;
    }

    public boolean isPluggedIn() {
        return pluggedIn;
    }
}
