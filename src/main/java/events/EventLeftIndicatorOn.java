package events;

import control_unit.states.IndicatorState;

public class EventLeftIndicatorOn {
    private IndicatorState state;

    public EventLeftIndicatorOn(IndicatorState state) {
        this.state = state;
    }

    public IndicatorState getState() {
        return state;
    }

    public String toString() {
        return "event -> left indicator on";
    }
}
