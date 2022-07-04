package personalFinance.gui.table.model;

import personalFinance.model.Article;
import personalFinance.model.Currency;
import personalFinance.saveLoad.SaveData;
import personalFinance.settings.Format;

public class CurrencyTableModel extends MainTableModel {

    private static final int TITLE = 0;
    private static final int CODE = 1;
    private static final int RATE = 2;
    private static final int ON = 3;
    private static final int BASE = 4;

    public CurrencyTableModel(String[] columns) {
        super(SaveData.getInstance().getCurrencies(), columns);
    }

    @Override
    protected void updateDate() {
        date = SaveData.getInstance().getCurrencies();
    }

    @Override
    public Object getValueAt(int row, int column) {
        if (date.isEmpty()) return null;
        Currency currency = (Currency) date.get(row);
        switch (column) {
            case TITLE:
                return currency.getTitle();
            case  CODE:
                return currency.getCode();
            case  RATE:
                return Format.rate(currency.getRate(), SaveData.getInstance().getBaseCurrency());
            case  ON:
                return Format.yesNo(currency.isOn());
            case  BASE:
                return Format.yesNo(currency.isBase());
        }
        return null;
    }
}
