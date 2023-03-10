public interface ILidar {
    void on();
    void off();
    String getState();
    void accept(Object visitor);
}
