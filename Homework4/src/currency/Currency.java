package currency;

public abstract class Currency {
    protected double amount;

    public void increaseAmount(double money){
        this.amount += money;
    }

    public void decreaseAmount(double money){
        if ((this.amount - money) >= 0){
            this.amount -= money;
        }
    }

    public double getAmount() {
        return amount;
    }

    public abstract double convertToApl(double amount);
}
