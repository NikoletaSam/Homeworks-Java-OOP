package wallet;

import currency.*;

public class CurrencyConvertor {

    public static double convertCurrency(Currency fromCurrency, Currency convertedCurrency, double amount){
        double moneyInApl = fromCurrency.convertToApl(amount);

        if (convertedCurrency instanceof Fiat){
            if (((Fiat) convertedCurrency).getCode() == FiatCurrencyCode.USD){
                return moneyInApl / 10;
            }
            if (((Fiat) convertedCurrency).getCode() == FiatCurrencyCode.CAD){
                return moneyInApl / 5;
            }
            if (((Fiat) convertedCurrency).getCode() == FiatCurrencyCode.JAP){
                return moneyInApl / 7;
            }
            if (((Fiat) convertedCurrency).getCode() == FiatCurrencyCode.CHF){
                return moneyInApl / 20;
            }
        } else if (convertedCurrency instanceof Gold){
            return moneyInApl / 1000;
        } else if (convertedCurrency instanceof Hesh){
            if (((Hesh) convertedCurrency).getCode() == HeshCurrencyCode.BTC){
                return moneyInApl / 1054;
            }
            if (((Hesh) convertedCurrency).getCode() == HeshCurrencyCode.SBB){
                return moneyInApl / 55;
            }
            if (((Hesh) convertedCurrency).getCode() == HeshCurrencyCode.RTA){
                return moneyInApl / 0.5;
            }
            if (((Hesh) convertedCurrency).getCode() == HeshCurrencyCode.QAQ){
                return moneyInApl / 0.014;
            }
        } else if (convertedCurrency instanceof NFT){
            return moneyInApl;
        }

        throw new IllegalArgumentException("Invalid currency type");
    }
}
