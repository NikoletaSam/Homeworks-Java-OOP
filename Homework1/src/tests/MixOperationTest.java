package tests;

import calculators.AbstractCalculator;
import calculators.Digit;
import digits.BinaryDigit;
import digits.DecimalDigit;

public class MixOperationTest {

    public static void test(AbstractCalculator calculator) {

        Digit a   = new BinaryDigit("10010110");
        Digit b  = new DecimalDigit("57");
        Digit addResult = calculator.add(a, b);
        calculator.renderNative(addResult);
        calculator.renderDecimal(addResult);

        Digit subResult = calculator.sub(a, b);
        calculator.renderNative(subResult);
        calculator.renderBinary(subResult);

        Digit mulResult = calculator.mul(a, b);
        calculator.renderNative(mulResult);
        calculator.renderOct(mulResult);

        Digit divResult = calculator.div(a, b);
        calculator.renderNative(divResult);
        calculator.renderHex(divResult);
    }
}
