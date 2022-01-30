package digits;

import calculators.Digit;

public class DecimalDigit extends Digit {

    public DecimalDigit(String number){
        super.decimalNumber = toDecimalNumber(number);
        super.binaryNumber = super.toBinaryNumber(decimalNumber);
        super.octNumber = super.toOctNumber(decimalNumber);
        super.hexNumber = super.toHexNumber(decimalNumber);
        super.nativeDigit = number;
    }

    @Override
    public int toDecimalNumber(String textNumber) {
        return Integer.parseInt(textNumber);
    }
}
