package personalFinance.gui.table.model;

import personalFinance.model.Account;
import personalFinance.saveLoad.SaveData;
import personalFinance.settings.Format;

public class AccountTableModel extends MainTableModel {

    private static final int TITLE = 0;
    private static final int AMOUNT = 1;

    public AccountTableModel(String[] columns) {
        super(SaveData.getInstance().getAccounts(), columns);
    }

    @Override
    protected void updateDate() {
        date = SaveData.getInstance().getAccounts();
    }

    @Override
    public Object getValueAt(int row, int column) {
        if (date.isEmpty()) return null;
        Account account = (Account) date.get(row);
        switch (column) {
            case TITLE:
                return account.getTitle();
            case AMOUNT:
                return Format.amount(account.getAmount(), account.getCurrency());
        }
        return null;
    }
}
