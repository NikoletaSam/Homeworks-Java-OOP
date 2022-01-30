package digits;

import calculators.Digit;

public class OctDigit extends Digit {

    public OctDigit(String number){
        super.decimalNumber = toDecimalNumber(number);
        super.binaryNumber = super.toBinaryNumber(decimalNumber);
        super.octNumber = number;
        super.hexNumber = super.toHexNumber(decimalNumber);
        super.nativeDigit = number;
    }

    @Override
    public int toDecimalNumber(String textNumber) {
        return Integer.parseInt(textNumber, 8);
    }
}
