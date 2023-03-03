package events;

import control_unit.states.IndicatorState;

public class EventHazardWarningOff {
    private IndicatorState state;

    public EventHazardWarningOff(IndicatorState state) {
        this.state = state;
    }

    public IndicatorState getState() {
        return state;
    }

    public String toString() {
        return "event -> hazard warning off";
    }
}
