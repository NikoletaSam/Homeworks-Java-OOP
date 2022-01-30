package calculators;

public abstract class AbstractCalculator {

    public abstract Digit add(Digit a, Digit b);
    public abstract Digit addMulti(Digit ...collection);
    public abstract Digit sub(Digit a, Digit b);
    public abstract Digit subMulti(Digit ...collection);
    public abstract Digit mul(Digit a, Digit b);
    public abstract Digit mulMulti(Digit ...collection);

    public abstract Digit div(Digit a, Digit b);
    public abstract Digit divMulti(Digit ...collection);

    public abstract void renderNative(Digit digit);
    public abstract void renderDecimal(Digit digit);
    public abstract void renderBinary(Digit digit);
    public abstract void renderOct(Digit digit);
    public abstract void renderHex(Digit digit);
}
