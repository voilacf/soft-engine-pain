public interface IGPS {
    void on();

    void off();

    void connectSatellite(String frequency);
    //void visit(IComponentVisitor visitor);
}
