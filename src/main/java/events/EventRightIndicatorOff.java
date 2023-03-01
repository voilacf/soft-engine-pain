package events;

import control_unit.states.IndicatorState;

public class EventRightIndicatorOff {
    private IndicatorState state;

    public EventRightIndicatorOff(IndicatorState state) {
        this.state = state;
    }

    public IndicatorState getState() {
        return state;
    }

    public String toString() {
        return "event -> right indicator off";
    }
}
