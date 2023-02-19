package control_unit;

import com.google.common.eventbus.Subscribe;
import control_unit.states.BrakeLightState;
import control_unit.states.IndicatorState;
import events.*;
import factories.IndicatorFactory;

import java.lang.reflect.Method;

public class IndicatorControlUnit extends Subscriber {
    private final Object indicatorPort;

    public IndicatorControlUnit() {
        super(1);
        indicatorPort = IndicatorFactory.build();
    }

    private void invokeMethod(Object indicator, String indicatorMethod) {
        try {
            Method m = indicator.getClass().getMethod(indicatorMethod);
            m.invoke(indicator);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //TODO: distinguishing between left, right and hazard
    @Subscribe
    public void receive(EventLeftIndicatorOn event) {
        try {
            Method onMethod = indicatorPort.getClass().getDeclaredMethod("on");
            IndicatorState result = (IndicatorState) onMethod.invoke(indicatorPort);
            System.out.println("receive -> indicator | state : " + result);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    @Subscribe
    public void receive(EventLeftIndicatorOff event) {
        try {
            Method onMethod = indicatorPort.getClass().getDeclaredMethod("on");
            IndicatorState result = (IndicatorState) onMethod.invoke(indicatorPort);
            System.out.println("receive -> indicator | state : " + result);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    @Subscribe
    public void receive(EventRightIndicatorOn event) {

    }

    @Subscribe
    public void receive(EventRightIndicatorOff event) {

    }

    @Subscribe
    public void receive(EventHazardWarningOn event) {

    }

    @Subscribe
    public void receive(EventHazardWarningOff event) {

    }
}
