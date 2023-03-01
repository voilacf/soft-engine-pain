package events;

import control_unit.states.IndicatorState;

public class EventRightIndicatorOn {
    private IndicatorState state;

    public EventRightIndicatorOn(IndicatorState state) {
        this.state = state;
    }

    public IndicatorState getState() {
        return state;
    }

    public String toString() {
        return "event -> right indicator on";
    }
}
