package tests;

import calculators.AbstractCalculator;
import calculators.Digit;
import digits.BinaryDigit;
import digits.DecimalDigit;
import digits.HexDigit;
import digits.OctDigit;

public class MultiOperationTest {

    public static void test(AbstractCalculator calculator) {

        Digit a = new BinaryDigit("010011");
        Digit b = new OctDigit("67");
        Digit c = new DecimalDigit("67");
        Digit d = new HexDigit("67");

        Digit addResult = calculator.addMulti(a, b, c, d);
        calculator.renderNative(addResult);
        calculator.renderBinary(addResult);

        Digit subResult = calculator.subMulti(a, b, c, d);
        calculator.renderNative(subResult);
        calculator.renderOct(subResult);

        Digit mulResult = calculator.mulMulti(a, b, c, d);
        calculator.renderNative(mulResult);
        calculator.renderDecimal(mulResult);

        Digit divResult = calculator.divMulti(a, b, c, d);
        calculator.renderNative(divResult);
        calculator.renderHex(divResult);
    }
}
