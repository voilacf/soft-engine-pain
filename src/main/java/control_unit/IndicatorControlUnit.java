package control_unit;

import com.google.common.eventbus.Subscribe;
import control_unit.states.IndicatorState;
import events.*;
import factories.ComponentFactory;

public class IndicatorControlUnit extends Subscriber {
    private final Object indicatorPort;

    public IndicatorControlUnit() {
        super(1);
        indicatorPort = ComponentFactory.buildIndicator();
    }

    //TODO: reduce code redundancy?
    @Subscribe
    public void receive(EventLeftIndicatorOn event) {
        IndicatorState result = (IndicatorState) ControlUnitUtils.invokeMethod(indicatorPort,"on",new Class[]{IndicatorState.class},event.getState());
        System.out.println("receive -> indicator | state : " + result);
    }

    @Subscribe
    public void receive(EventLeftIndicatorOff event) {
        IndicatorState result = (IndicatorState) ControlUnitUtils.invokeMethod(indicatorPort,"off",new Class[]{IndicatorState.class},event.getState());
        System.out.println("receive -> indicator | state : " + result);
    }

    @Subscribe
    public void receive(EventRightIndicatorOn event) {
        IndicatorState result = (IndicatorState) ControlUnitUtils.invokeMethod(indicatorPort,"on",new Class[]{IndicatorState.class},event.getState());
        System.out.println("receive -> indicator | state : " + result);
    }

    @Subscribe
    public void receive(EventRightIndicatorOff event) {
        IndicatorState result = (IndicatorState) ControlUnitUtils.invokeMethod(indicatorPort,"off",new Class[]{IndicatorState.class},event.getState());
        System.out.println("receive -> indicator | state : " + result);
    }

    @Subscribe
    public void receive(EventHazardWarningOn event) {
        IndicatorState result = (IndicatorState) ControlUnitUtils.invokeMethod(indicatorPort,"on",new Class[]{IndicatorState.class},event.getState());
        System.out.println("receive -> indicator | state : " + result);
    }

    @Subscribe
    public void receive(EventHazardWarningOff event) {
        IndicatorState result = (IndicatorState) ControlUnitUtils.invokeMethod(indicatorPort,"off",new Class[]{IndicatorState.class},event.getState());
        System.out.println("receive -> indicator | state : " + result);
    }
}
