import tests.ConvertCurrencyTest;
import tests.TransferMoneyTest;

public class Main {
    public static void main(String[] args) {

        ConvertCurrencyTest convertTest = new ConvertCurrencyTest();
        convertTest.run();

        TransferMoneyTest transferTest = new TransferMoneyTest();
        transferTest.run();
    }
}
