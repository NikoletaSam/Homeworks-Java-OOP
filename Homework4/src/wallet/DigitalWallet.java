package wallet;

import currency.Currency;
import currency.Fiat;
import currency.FiatCurrencyCode;

import java.util.ArrayList;
import java.util.List;

public class DigitalWallet {
    private List<Currency> currencies;
    private String bank;
    private boolean isBlocked;

    public DigitalWallet(String bank) {
        this.bank = bank;
        this.currencies = new ArrayList<>();
        this.isBlocked = false;
    }

    public void addCurrency(Currency currency){
        this.currencies.add(currency);
    }

    public List<Currency> getCurrencies() {
        return currencies;
    }

    public String getBank() {
        return bank;
    }

    public boolean isBlocked() {
        return isBlocked;
    }

    public void setBlocked(boolean isBlocked){
        this.isBlocked = isBlocked;
    }

    public void transferMoney(DigitalWallet wallet, double moneyAmount, Currency currencySent, Currency currencyToConvert){
        if (isTransactionPossible(wallet, moneyAmount, currencySent)){
            Currency currency = getCurrencyToSend(currencySent);
            currency.decreaseAmount(totalMoneyNeeded(wallet, moneyAmount, currencySent));

            for (Currency currencyToReceive : wallet.getCurrencies()){
                if (currencyToReceive.getClass().equals(currencyToConvert.getClass())){
                    moneyAmount = CurrencyConvertor.convertCurrency(currencySent, currencyToConvert, moneyAmount);

                    currencyToReceive.increaseAmount(moneyAmount);
                }
            }
        }
    }

    private boolean isTransactionPossible(DigitalWallet wallet, double moneyAmount, Currency currencySent){
        double moneyNeeded = this.totalMoneyNeeded(wallet, moneyAmount, currencySent);
        Currency toSend = getCurrencyToSend(currencySent);

        if (wallet == this || (toSend.getAmount() < moneyNeeded) || wallet.isBlocked()){
            return false;
        }
        return true;
    }

    private Currency getCurrencyToSend(Currency currencySent){
        Currency toSend = null;
        for (Currency currency : this.currencies){
            if (currency.getClass().equals(currencySent.getClass())){
                toSend = currency;
                break;
            }
        }

        return toSend;
    }

    private double totalMoneyNeeded(DigitalWallet wallet, double moneyAmount, Currency currencySent){
        double moneyNeeded;
        if (wallet.getBank().equals(this.bank)){
            double commissionForTransaction = CurrencyConvertor.convertCurrency(new Fiat(FiatCurrencyCode.USD, 1), currencySent, 1);
            moneyNeeded = moneyAmount + commissionForTransaction;
        } else {
            moneyNeeded = moneyAmount + 0.01 * moneyAmount + 0.01 * moneyAmount + 0.01 * moneyAmount;
        }

        return moneyNeeded;
    }
}
