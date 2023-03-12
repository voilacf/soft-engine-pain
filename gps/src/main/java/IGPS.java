public interface IGPS {
    void on();

    void off();

    void connectSatellite(String frequency);

    String getState();

    String getFrequency();

    void accept(Object visitor);
}
