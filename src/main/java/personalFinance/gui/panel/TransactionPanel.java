package personalFinance.gui.panel;

import personalFinance.gui.MainFrame;
import personalFinance.gui.dialog.TransactionAddEditDialog;
import personalFinance.gui.handler.FunctionsHandler;
import personalFinance.gui.table.TransactionTableDate;
import personalFinance.gui.toolbar.FunctionsToolBar;
import personalFinance.settings.Style;

import javax.swing.*;

public class TransactionPanel extends RightPanel{

    public TransactionPanel(MainFrame frame) {
        super(frame, new TransactionTableDate(new FunctionsHandler(frame, new TransactionAddEditDialog(frame))), "TRANSACTIONS", Style.ICON_PANEL_TRANSACTIONS,
                new JPanel[]{new FunctionsToolBar(new FunctionsHandler(frame, new TransactionAddEditDialog(frame))), new FilterPanel(frame)});
    }
}
