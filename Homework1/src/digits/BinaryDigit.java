package digits;

import calculators.Digit;

import javax.print.DocPrintJob;

public class BinaryDigit extends Digit {

    public BinaryDigit(String number){
        super.decimalNumber = toDecimalNumber(number);
        super.binaryNumber = number;
        super.octNumber = super.toOctNumber(decimalNumber);
        super.hexNumber = super.toHexNumber(decimalNumber);
        super.nativeDigit = number;
    }

    @Override
    public int toDecimalNumber(String textNumber) {
        return Integer.parseInt(textNumber, 2);
    }
}
