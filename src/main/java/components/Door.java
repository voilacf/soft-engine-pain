package components;

import observer.IButtonPressedListener;
import state.DoorStateClosed;
import state.DoorStateOpened;
import door_button.Button;

public class Door implements IButtonPressedListener {
    private Button emergencyButton;
    private Button toggleButton;
    private IDoorState state;



    public Door() {
        state = new DoorStateClosed();
    }



    public void toggleDoorState() {
        if(state instanceof DoorStateClosed) {
            state = new DoorStateOpened();
        } else {
            state = new DoorStateClosed();
        }
    }

    //Todo passt evtl auch schon
    public void buttonPressed() {
        toggleDoorState();
    }
}