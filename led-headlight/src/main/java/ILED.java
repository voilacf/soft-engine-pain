public interface ILED {
    void on();
    void off();
    void dimm();
    void beam();
    String getState();

    void accept(Object visitor);
}
