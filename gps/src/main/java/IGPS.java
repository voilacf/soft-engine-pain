public interface IGPS {
    void on();
    void off();
    void connectSatellite(String frequency);
    String getState();
    //void visit(IComponentVisitor visitor);
}
