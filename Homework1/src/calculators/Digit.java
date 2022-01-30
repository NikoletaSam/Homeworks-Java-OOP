package calculators;

public abstract class Digit {
    protected String nativeDigit;
    protected int decimalNumber;
    protected String binaryNumber;
    protected String octNumber;
    protected String hexNumber;

    public abstract int toDecimalNumber(String textNumber);

    public String toBinaryNumber(int decimalNumber){
        return Integer.toBinaryString(decimalNumber);
    }

    public String toOctNumber(int decimalNumber){
        return Integer.toOctalString(decimalNumber);
    }

    public String toHexNumber(int decimalNumber){
        return Integer.toHexString(decimalNumber);
    }

    public String getNativeDigit() {
        return this.nativeDigit;
    }

    public int getDecimalNumber() {
        return this.decimalNumber;
    }

    public String getBinaryNumber() {
        return this.binaryNumber;
    }

    public String getOctNumber() {
        return this.octNumber;
    }

    public String getHexNumber() {
        return this.hexNumber;
    }
}
