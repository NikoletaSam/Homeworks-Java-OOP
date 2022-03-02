package currency;

public class NFT extends Currency{

    public NFT(double amount) {
        super.amount = amount;
    }

    @Override
    public double convertToApl(double amount) {
        return super.amount;
    }
}
