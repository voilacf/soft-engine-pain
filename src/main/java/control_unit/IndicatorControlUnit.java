package control_unit;

import com.google.common.eventbus.Subscribe;
import control_unit.states.IndicatorState;
import events.*;
import factories.ComponentFactory;

public class IndicatorControlUnit extends Subscriber {
    private final Object[] indicators;

    public IndicatorControlUnit(Object[] indicators) {
        super(8);
        this.indicators = indicators;
    }

    //TODO: reduce code redundancy?
    @Subscribe
    public void receive(EventLeftIndicatorOn event) {
        for (Object indicator : indicators) {
            IndicatorState result = (IndicatorState) ControlUnitUtils.invokeMethod(indicator, "on", new Class[]{IndicatorState.class}, event.getState());
            System.out.println("receive -> indicator | state : " + result);
        }
    }

    @Subscribe
    public void receive(EventLeftIndicatorOff event) {
        for (Object indicator : indicators) {
            IndicatorState result = (IndicatorState) ControlUnitUtils.invokeMethod(indicator, "off", new Class[]{IndicatorState.class}, event.getState());
            System.out.println("receive -> indicator | state : " + result);
        }
    }

    @Subscribe
    public void receive(EventRightIndicatorOn event) {
        for (Object indicator : indicators) {
            IndicatorState result = (IndicatorState) ControlUnitUtils.invokeMethod(indicator, "on", new Class[]{IndicatorState.class}, event.getState());
            System.out.println("receive -> indicator | state : " + result);
        }
    }

    @Subscribe
    public void receive(EventRightIndicatorOff event) {
        for (Object indicator : indicators) {
            IndicatorState result = (IndicatorState) ControlUnitUtils.invokeMethod(indicator, "off", new Class[]{IndicatorState.class}, event.getState());
            System.out.println("receive -> indicator | state : " + result);
        }
    }

    @Subscribe
    public void receive(EventHazardWarningOn event) {
        for (Object indicator : indicators) {
            IndicatorState result = (IndicatorState) ControlUnitUtils.invokeMethod(indicator, "on", new Class[]{IndicatorState.class}, event.getState());
            System.out.println("receive -> indicator | state : " + result);
        }
    }

    @Subscribe
    public void receive(EventHazardWarningOff event) {
        for (Object indicator : indicators) {
            IndicatorState result = (IndicatorState) ControlUnitUtils.invokeMethod(indicator, "off", new Class[]{IndicatorState.class}, event.getState());
            System.out.println("receive -> indicator | state : " + result);
        }
    }
}
