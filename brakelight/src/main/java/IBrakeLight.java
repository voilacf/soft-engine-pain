public interface IBrakeLight {
    void on();

    void off();

    String getState();

    void accept(Object visitor);
}
