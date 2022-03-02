package currency;

public class Gold extends Currency{

    public Gold(double kg) {
        super.amount = kg;
    }

    @Override
    public double convertToApl(double amount) {
        return super.amount * 1000;
    }
}
