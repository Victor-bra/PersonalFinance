package personalFinance.gui.panel;

import personalFinance.gui.MainFrame;
import personalFinance.gui.dialog.TransactionAddEditDialog;
import personalFinance.gui.handler.FunctionsHandler;
import personalFinance.gui.table.TransactionTableDate;
import personalFinance.settings.Settings;
import personalFinance.settings.Style;

public class OverviewPanel extends RightPanel{

    public OverviewPanel(MainFrame frame) {
        super(frame, new TransactionTableDate(new FunctionsHandler(frame, new TransactionAddEditDialog(frame)),Settings.COUNT_OVERVIEW_ROWS),
                "LAST_TRANSACTIONS", Style.ICON_PANEL_OVERVIEW);
    }
}
