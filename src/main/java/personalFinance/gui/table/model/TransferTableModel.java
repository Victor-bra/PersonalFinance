package personalFinance.gui.table.model;

import personalFinance.model.Transaction;
import personalFinance.model.Transfer;
import personalFinance.saveLoad.SaveData;
import personalFinance.settings.Format;

public class TransferTableModel extends MainTableModel {

    private static final int DATE = 0;
    private static final int FROM_ACCOUNT = 1;
    private static final int TO_ACCOUNT = 2;
    private static final int FROM_AMOUNT = 3;
    private static final int TO_AMOUNT = 4;
    private static final int NOTICE = 5;

    public TransferTableModel(String[] columns) {
        super(SaveData.getInstance().getFilterTransfer(), columns);
    }

    @Override
    protected void updateDate() {
        date = SaveData.getInstance().getFilterTransfer();
    }

    @Override
    public Object getValueAt(int row, int column) {
        if (date.isEmpty()) return null;
        Transfer transfer = (Transfer) date.get(row);
        switch (column) {
            case DATE:
                return Format.date(transfer.getDate());
            case FROM_ACCOUNT:
                return transfer.getFromAccount().getTitle();
            case TO_ACCOUNT:
                return transfer.getToAccount().getTitle();
            case FROM_AMOUNT:
                return Format.amount(transfer.getFromAmount(), transfer.getFromAccount().getCurrency());
            case TO_AMOUNT:
                return Format.amount(transfer.getToAmount(), transfer.getToAccount().getCurrency());
            case NOTICE:
                return transfer.getNotice();
        }
        return null;
    }
}
