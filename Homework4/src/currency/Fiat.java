package currency;

public class Fiat extends Currency{
    private FiatCurrencyCode code;

    public Fiat(FiatCurrencyCode code, double amount) {
        this.code = code;
        super.amount = amount;
    }

    public FiatCurrencyCode getCode() {
        return code;
    }

    @Override
    public double convertToApl(double amount) {
        if (this.code == FiatCurrencyCode.USD){
            return super.amount * 10;
        }
        if (this.code == FiatCurrencyCode.CAD){
            return super.amount * 5;
        }
        if (this.code == FiatCurrencyCode.JAP){
            return super.amount * 7;
        }
        if (this.code == FiatCurrencyCode.CHF){
            return super.amount * 20;
        }

        throw new IllegalArgumentException("Invalid Fiat currency code");
    }
}
