package s04state;

import s03command.Door;

public interface IDoorState {
    void toggle(Door door);
}
