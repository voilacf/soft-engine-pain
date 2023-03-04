package s03command;

import s04observer.IButtonPressedListener;
import s04state.DoorStateClosed;
import s04state.IDoorState;
import s05servicecenter.ServiceCenter;

public class Door implements IButtonPressedListener {
    private final Button emergencyButton;
    private final Button toggleButton;
    private IDoorState state;

    //Create a new door and add buttons and the default state
    public Door(ServiceCenter serviceCenter) {
        emergencyButton = new Button(new CommandEmergency(serviceCenter));
        toggleButton = new Button(new CommandToggleDoor(this));
        state = new DoorStateClosed();
    }

    public void toggleDoorState() {
        state.toggle(this);
    }


    public void buttonPressed() {
        toggleDoorState();
    }

    public Button getEmergencyButton() {
        return emergencyButton;
    }

    public Button getToggleButton() {
        return toggleButton;
    }

    public IDoorState getState() {
        return state;
    }

    public void setState(IDoorState state) {
        this.state = state;
    }
}