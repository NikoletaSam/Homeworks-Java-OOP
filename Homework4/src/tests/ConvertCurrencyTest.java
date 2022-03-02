package tests;

import currency.*;
import wallet.CurrencyConvertor;

public class ConvertCurrencyTest {

    public void run(){
        this.convertFromFiatToFiat();
        this.convertFromGoldToFiat();
        this.convertFromFiatToHesh();
    }

    private void convertFromFiatToFiat(){
        Fiat from  = new Fiat(FiatCurrencyCode.USD, 1000);
        Fiat to = new Fiat(FiatCurrencyCode.USD, 5);
        double converted = CurrencyConvertor.convertCurrency(from, to, from.getAmount());

        if (converted == 1000){
            System.out.println("Test passed!");
        } else {
            System.out.println("Test failed!");
        }
    }

    private void convertFromGoldToFiat(){
        Gold fromGold = new Gold(5);
        Fiat to = new Fiat(FiatCurrencyCode.CAD, 3);
        double converted = CurrencyConvertor.convertCurrency(fromGold, to, fromGold.getAmount());

        if (converted == 1000){
            System.out.println("Test passed!");
        } else {
            System.out.println("Test failed!");
        }
    }

    private void convertFromFiatToHesh(){
        Fiat from  = new Fiat(FiatCurrencyCode.USD, 1000);
        Hesh to = new Hesh(HeshCurrencyCode.RTA, 8);
        double converted = CurrencyConvertor.convertCurrency(from, to, from.getAmount());

        if (converted == 20000){
            System.out.println("Test passed!");
        } else {
            System.out.println("Test failed!");
        }
    }
}
