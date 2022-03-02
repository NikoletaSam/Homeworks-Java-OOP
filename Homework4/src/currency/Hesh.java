package currency;

public class Hesh extends Currency{
    private HeshCurrencyCode code;
    private String direction;

    public Hesh(HeshCurrencyCode code, double amount) {
        this.code = code;
        super.amount = amount;
        this.setDirection();
    }

    public HeshCurrencyCode getCode() {
        return code;
    }

    private void setDirection(){
        if (this.code == HeshCurrencyCode.BTC){
            this.direction = "Straight";
        }
        if (this.code == HeshCurrencyCode.SBB){
            this.direction = "Straight";
        }
        if (this.code == HeshCurrencyCode.RTA){
            this.direction = "Reversed";
        }
        if (this.code == HeshCurrencyCode.QAQ){
            this.direction = "Reversed";
        }
    }

    @Override
    public double convertToApl(double amount) {
        if (this.code == HeshCurrencyCode.BTC){
            return super.amount * 1054;
        }
        if (this.code == HeshCurrencyCode.SBB){
            return super.amount * 55;
        }
        if (this.code == HeshCurrencyCode.RTA){
            return super.amount * 0.5;
        }
        if (this.code == HeshCurrencyCode.QAQ){
            return super.amount * 0.014;
        }

        throw new IllegalArgumentException("Invalid Fiat currency code");
    }
}
