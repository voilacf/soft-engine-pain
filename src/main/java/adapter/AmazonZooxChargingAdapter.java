package adapter;

public class AmazonZooxChargingAdapter extends AmazonZooxBatteryCharger implements IChargable {
    @Override
    public void plugIn2Pin() {
        plugIn4Pin();
    }
}
