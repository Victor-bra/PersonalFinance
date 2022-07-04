package personalFinance.model;

import personalFinance.saveLoad.SaveData;

import java.util.HashMap;
import java.util.List;

public class Statistics {

    public static double getBalanceCurrency(Currency currency) {
        SaveData sd = SaveData.getInstance();
        double amount = 0;
        for (Account account : sd.getAccounts()) {
            if (currency.equals(account.getCurrency()))
                amount += account.getAmount();
        }
        return amount;
    }

    public static double getBalance(Currency currency) {
        SaveData sd = SaveData.getInstance();
        double amount = 0;
        for (Account account : sd.getAccounts()) {
            amount += account.getAmount() * account.getCurrency().getRateByCurrency(currency);
        }
        return amount;
    }

    public static HashMap<String, Double> getDateForChartOnIncomeArticle() {
        return getDateForChartOnArticles(true);
    }

    public static HashMap<String, Double> getDateForChartOnExpArticle() {
        return getDateForChartOnArticles(false);
    }

    private static HashMap<String, Double> getDateForChartOnArticles(boolean income) {
        List<Transaction> transactions = SaveData.getInstance().getFilterTransactions();
        HashMap<String, Double> date = new HashMap<>();
        for (Transaction transaction : transactions) {
            if ((income && transaction.getAmount() > 0) || (!income && transaction.getAmount() < 0)) {
                String key = transaction.getArticle().getTitle();
                double summa = 0;
                double amount = transaction.getAmount();
                if (!income) amount *= -1;
                if (date.containsKey(key))
                    summa = date.get(key);
                summa += amount * transaction.getAccount().getCurrency().getRateByCurrency(SaveData.getInstance().getBaseCurrency());
                date.put(key, round(summa));
            }
        }
        return date;
    }

    private static double round(double value) {
        return (double) Math.round(value * 100 / 100);
    }
}
