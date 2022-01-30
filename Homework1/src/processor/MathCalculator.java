package processor;

import calculators.AbstractCalculator;
import calculators.Digit;
import digits.BinaryDigit;
import digits.DecimalDigit;
import digits.HexDigit;
import digits.OctDigit;

public class MathCalculator extends AbstractCalculator {

    private Digit returnDigit(Digit a, int result){
        if (a instanceof BinaryDigit){
            return new BinaryDigit(Integer.toBinaryString(result));
        }
        if (a instanceof DecimalDigit){
            return new DecimalDigit(String.valueOf(result));
        }
        if (a instanceof OctDigit){
            return new OctDigit(Integer.toOctalString(result));
        }
        if (a instanceof HexDigit){
            return new HexDigit(Integer.toHexString(result));
        }
        throw new UnsupportedOperationException();
    }

    public Digit add(Digit a, Digit b) {
        int first = a.getDecimalNumber();
        int second = b.getDecimalNumber();
        int result = first + second;

        return returnDigit(a, result);
    }

    @Override
    public Digit addMulti(Digit... collection) {
        int result = 0;

        Digit a = collection[0];

        for (Digit current : collection){
            result += current.getDecimalNumber();
        }

        return returnDigit(a, result);
    }

    public Digit sub(Digit a, Digit b) {
        int first = a.getDecimalNumber();
        int second = b.getDecimalNumber();
        int result = first - second;

        return returnDigit(a, result);
    }

    @Override
    public Digit subMulti(Digit... collection) {
        Digit a = collection[0];

        int result = a.getDecimalNumber();

        for (int i = 1; i < collection.length; i++) {
            Digit current = collection[i];
            result -= current.getDecimalNumber();
        }

        return returnDigit(a, result);
    }

    public Digit mul(Digit a, Digit b) {
        int first = a.getDecimalNumber();
        int second = b.getDecimalNumber();
        int result = first * second;

        return returnDigit(a, result);
    }

    @Override
    public Digit mulMulti(Digit... collection) {
        Digit a = collection[0];

        int result = 1;

        for (Digit current : collection){
            result = result * current.getDecimalNumber();
        }

        return returnDigit(a, result);
    }

    public Digit div(Digit a, Digit b) {
        int first = a.getDecimalNumber();
        int second = b.getDecimalNumber();
        int result = first / second;

        return returnDigit(a, result);
    }

    @Override
    public Digit divMulti(Digit... collection) {
        Digit a = collection[0];

        int result = a.getDecimalNumber();

        for (int i = 1; i < collection.length; i++) {
            Digit current = collection[i];
            result = result / (current.getDecimalNumber());
        }

        return returnDigit(a, result);
    }

    /**
     *
     * Визуализирира числото, във формата към който принадлежи
     * •	BinaryDigit – двоично
     * •	OctDigit - осмично
     * •	DecimalDigit – десетично
     * •	HexDigit – шестнаисетично
     *
     * #Пример:
     * BinaryDigit a = new BinaryDigit(“0101”);
     * MathCalculator calculator = new MathCalculator();
     * calculator.nativeRender(a) // 0101
     * @param digit
     */
    @Override
    public void renderNative(Digit digit) {
        System.out.println(digit.getNativeDigit());
    }

    /**
     * Визуализира числото в десетичен формат
     *
     * Пример:
     * BinaryDigit a = new BinaryDigit(“0101”);
     * MathCalculator calculator = new MathCalculator();
     * calculator.decimalRender(a) // 5
     * @param digit
     */
    @Override
    public void renderDecimal(Digit digit) {
        System.out.println(digit.getDecimalNumber());
    }

    /**
     * Визуализира числото в двуичен формат
     * @param digit
     */
    @Override
    public void renderBinary(Digit digit) {
        System.out.println(digit.getBinaryNumber());
    }

    /**
     * Визуализира числото в осмичен формат
     * @param digit
     */
    @Override
    public void renderOct(Digit digit) {
        System.out.println(digit.getOctNumber());
    }

    /**
     * Визуализира числото в шестнадесетичен формат
     * @param digit
     */
    @Override
    public void renderHex(Digit digit) {
        System.out.println(digit.getHexNumber());
    }
}
