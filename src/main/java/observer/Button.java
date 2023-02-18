package observer;

import door_button.ICommand;


import java.util.ArrayList;

public class Button {
    private ICommand command;
    private ArrayList<IButtonPressedListener> listeners;

    public Button() {
        listeners = new ArrayList<>();
    }


    //Todo
    public void pressButton() {
    }

    public void addListener(IButtonPressedListener listener) {
        listeners.add(listener);
    }

    public void removeListener(IButtonPressedListener listener) {
        listeners.remove(listener);
    }
}
