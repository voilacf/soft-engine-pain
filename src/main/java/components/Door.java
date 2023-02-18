package components;

import observer.IButtonPressedListener;

import java.awt.*;

public class Door implements IButtonPressedListener {
    private Button emergencyButton;
    private Button toggleButton;

    private IDoorState state;

    //Todo
    public void toggleDoorState() {

    }

    //Todo
    public void buttonPressed() {
        toggleDoorState();

    }
}