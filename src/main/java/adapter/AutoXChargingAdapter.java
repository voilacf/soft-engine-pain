package adapter;

public class AutoXChargingAdapter extends AutoXBatteryCharger implements IChargable {
    @Override
    public void plugIn2Pin() {
        plugIn3Pin();
    }
}
