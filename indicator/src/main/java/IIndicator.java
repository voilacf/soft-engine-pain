public interface IIndicator {
    void on(IndicatorSide side);

    void off(IndicatorSide side);

    String getState();

    void accept(Object visitor);
}
