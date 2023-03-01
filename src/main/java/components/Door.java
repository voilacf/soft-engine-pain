package components;

import door_button.Button;
import door_button.CommandEmergency;
import door_button.CommandToggleDoor;
import observer.IButtonPressedListener;
import service_center.ServiceCenter;
import state.DoorStateClosed;

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