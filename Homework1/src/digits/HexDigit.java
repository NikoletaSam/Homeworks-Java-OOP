package digits;

import calculators.Digit;

public class HexDigit extends Digit {

    public HexDigit(String number){
        super.decimalNumber = toDecimalNumber(number);
        super.binaryNumber = super.toBinaryNumber(decimalNumber);
        super.octNumber = super.toOctNumber(decimalNumber);
        super.hexNumber = number;
        super.nativeDigit = number;
    }

    @Override
    public int toDecimalNumber(String textNumber) {
        return Integer.parseInt(textNumber, 16);
    }
}
