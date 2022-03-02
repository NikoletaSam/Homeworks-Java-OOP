package tests;

import currency.Fiat;
import currency.FiatCurrencyCode;
import currency.Gold;
import wallet.DigitalWallet;

public class TransferMoneyTest {
    public void run(){
        this.transferMoneyFromTheSameBank();
        this.transferMoneyFromSameWallet();
        this.transferMoreMoneyThanPresent();
        this.transferMoneyToBlockedWallet();
    }

    private void transferMoneyFromTheSameBank(){
        DigitalWallet first = new DigitalWallet("One");
        DigitalWallet second = new DigitalWallet("One");

        Gold gold = new Gold(10);
        Fiat fiat = new Fiat(FiatCurrencyCode.USD, 10);

        first.addCurrency(gold);
        second.addCurrency(fiat);

        first.transferMoney(second, 5, gold, fiat);

        if (first.getCurrencies().get(0).getAmount() == 4.99){
            System.out.println("Test passed!");
        } else {
            System.out.println("Test failed!");
        }
    }

    private void transferMoneyFromSameWallet(){
        DigitalWallet first = new DigitalWallet("One");
        Gold gold = new Gold(10);
        first.addCurrency(gold);

        first.transferMoney(first, 5, gold, gold);

        if (first.getCurrencies().get(0).getAmount() == 10){
            System.out.println("Test passed!");
        } else {
            System.out.println("Test failed!");
        }
    }

    private void transferMoreMoneyThanPresent(){
        DigitalWallet first = new DigitalWallet("One");
        DigitalWallet second = new DigitalWallet("One");

        Gold gold = new Gold(10);
        Fiat fiat = new Fiat(FiatCurrencyCode.USD, 10);

        first.addCurrency(gold);
        second.addCurrency(fiat);

        first.transferMoney(second, 115, gold, fiat);

        if (first.getCurrencies().get(0).getAmount() == 10){
            System.out.println("Test passed!");
        } else {
            System.out.println("Test failed!");
        }
    }

    private void transferMoneyToBlockedWallet(){
        DigitalWallet first = new DigitalWallet("One");
        DigitalWallet second = new DigitalWallet("One");

        Gold gold = new Gold(10);
        Fiat fiat = new Fiat(FiatCurrencyCode.USD, 10);

        first.addCurrency(gold);
        second.addCurrency(fiat);

        second.setBlocked(true);

        first.transferMoney(second, 5, gold, fiat);

        if (first.getCurrencies().get(0).getAmount() == 10){
            System.out.println("Test passed!");
        } else {
            System.out.println("Test failed!");
        }
    }
}
