package events;

import control_unit.states.IndicatorState;

public class EventLeftIndicatorOff {
    private IndicatorState state;

    public EventLeftIndicatorOff(IndicatorState state) {
        this.state = state;
    }

    public IndicatorState getState() {
        return state;
    }

    public String toString() {
        return "event -> left indicator off";
    }
}
