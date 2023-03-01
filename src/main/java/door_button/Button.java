package door_button;

import observer.IButtonPressedListener;

import java.util.ArrayList;
import java.util.Random;

public class Button {
    private final ICommand command;
    private final ArrayList<IButtonPressedListener> listeners = new ArrayList<>();

    public Button(ICommand command) {
        this.command = command;
    }

    //Simulate button press and execute command or notify listeners
    public void pressButton() {
        Random rand = new Random();
        int randomNumber = rand.nextInt(2);

        if (randomNumber == 0) {
            if (command != null) {
                System.out.println("Button pressed. Executing command " + command.getClass().getSimpleName());
                command.execute();
            }
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
