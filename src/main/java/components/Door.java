package components;

import observer.IButtonPressedListener;

public class Door implements IButtonPressedListener {
    // TODO: attributes

    public void toggleDoorState() {
        // TODO: implement
    }

    @Override
    public void buttonPressed() {
        toggleDoorState();
    }
}
