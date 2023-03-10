public interface ICamera {
    void on();
    void off();
    String getState();
    void accept(Object visitor);
}
