package door_button;

import observer.IButtonPressedListener;

import java.util.ArrayList;

public class Button {
    private final ICommand command;
    private final ArrayList<IButtonPressedListener> listeners = new ArrayList<>();

    public Button(ICommand command) {
        this.command = command;
    }

    public void pressButton() {
        if (command != null) {
            System.out.println("Button pressed. Executing command " + command.getClass().getSimpleName());
            command.execute();
        }

        for (IButtonPressedListener listener : listeners) {
            listener.buttonPressed();
        }
    }

    public void addListener(IButtonPressedListener listener) {
        listeners.add(listener);
    }

    public void removeListener(IButtonPressedListener listener) {
        listeners.remove(listener);
    }
}
