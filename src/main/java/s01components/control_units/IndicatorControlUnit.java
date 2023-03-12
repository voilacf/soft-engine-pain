package s01components.control_units;

import com.google.common.eventbus.Subscribe;
import s01components.events.*;

public class IndicatorControlUnit extends Subscriber {
    private final Object[] indicators;

    public IndicatorControlUnit(Object[] indicators) {
        super(8);
        this.indicators = indicators;
    }

    @Subscribe
    public void receive(EventLeftIndicatorOn event) {
        for (Object indicator : indicators) {
            ComponentUtils.invokeMethod(indicator, "on", new Class[]{int.class}, IndicatorSide.LEFT.ordinal());
            System.out.println("receive -> indicator | state : left on");
        }
    }

    @Subscribe
    public void receive(EventLeftIndicatorOff event) {
        for (Object indicator : indicators) {
            ComponentUtils.invokeMethod(indicator, "off", new Class[]{int.class}, IndicatorSide.LEFT.ordinal());
            System.out.println("receive -> indicator | state : left off");
        }
    }

    @Subscribe
    public void receive(EventRightIndicatorOn event) {
        for (Object indicator : indicators) {
            ComponentUtils.invokeMethod(indicator, "on", new Class[]{int.class}, IndicatorSide.RIGHT.ordinal());
            System.out.println("receive -> indicator | state : right on");
        }
    }

    @Subscribe
    public void receive(EventRightIndicatorOff event) {
        for (Object indicator : indicators) {
            ComponentUtils.invokeMethod(indicator, "off", new Class[]{int.class}, IndicatorSide.RIGHT.ordinal());
            System.out.println("receive -> indicator | state : right off");
        }
    }

    @Subscribe
    public void receive(EventHazardWarningOn event) {
        for (Object indicator : indicators) {
            ComponentUtils.invokeMethod(indicator, "on", new Class[]{int.class}, IndicatorSide.HAZARD.ordinal());
            System.out.println("receive -> indicator | state : hazard on");
        }
    }

    @Subscribe
    public void receive(EventHazardWarningOff event) {
        for (Object indicator : indicators) {
            ComponentUtils.invokeMethod(indicator, "off", new Class[]{int.class}, IndicatorSide.HAZARD.ordinal());
            System.out.println("receive -> indicator | state : hazard off");
        }
    }
}
