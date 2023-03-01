package events;

import control_unit.states.IndicatorState;

public class EventHazardWarningOn {
    private IndicatorState state;

    public EventHazardWarningOn(IndicatorState state) {
        this.state = state;
    }

    public IndicatorState getState() {
        return state;
    }

    public String toString() {
        return "event -> hazard warning on";
    }
}
