public interface IIndicator {
    void on(IndicatorSide side);

    void off(IndicatorSide side);
    //void visit(IComponentVisitor visitor);
}
