package s03command;

import s04observer.IButtonPressedListener;

import java.util.ArrayList;

/**
 * Button class that can be pressed to execute a command (Command pattern) or notify listeners (Observer pattern).
 */
public class Button {
    private final ICommand command;
    private final ArrayList<IButtonPressedListener> listeners = new ArrayList<>();

    public Button(ICommand command) {
        this.command = command;
    }

    /**
     * Simulate button press and execute command or notify listeners.
     * If both a command and listeners are set, the method will randomly(50:50) choose one of them.
     * Otherwise, the one available will be executed.
     */
    public void pressButton() {
        if (command != null && (Math.random() > 0.5 || listeners.isEmpty())) {
            System.out.println("Button pressed. Executing command " + command.getClass().getSimpleName());
            command.execute();
        } else {
            for (IButtonPressedListener listener : listeners) {
                listener.buttonPressed();
            }
        }
    }

    public void addListener(IButtonPressedListener listener) {
        listeners.add(listener);
    }

    public void removeListener(IButtonPressedListener listener) {
        listeners.remove(listener);
    }
}
