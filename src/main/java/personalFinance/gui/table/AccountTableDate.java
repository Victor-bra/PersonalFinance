package personalFinance.gui.table;

import personalFinance.gui.handler.FunctionsHandler;
import personalFinance.gui.table.model.AccountTableModel;
import personalFinance.settings.Style;

import javax.swing.*;

public class AccountTableDate extends TableDate {

    private final static String[] columns = new String[]{"TITLE", "AMOUNT"};
    private final static ImageIcon[] icons = new ImageIcon[]{Style.ICON_TITLE,Style.ICON_AMOUNT};

    public AccountTableDate(FunctionsHandler handler) {
        super(new AccountTableModel(columns), handler,  columns, icons);
    }
}
