package personalFinance.gui.panel;

import personalFinance.gui.MainFrame;
import personalFinance.gui.dialog.AccountAddEditDialog;
import personalFinance.gui.handler.FunctionsHandler;
import personalFinance.gui.table.AccountTableDate;
import personalFinance.gui.toolbar.FunctionsToolBar;
import personalFinance.settings.Style;

public class AccountPanel extends RightPanel {

    public AccountPanel(MainFrame frame) {
        super(frame, new AccountTableDate(new FunctionsHandler(frame, new AccountAddEditDialog(frame))), "ACCOUNTS", Style.ICON_PANEL_ACCOUNTS,
                new FunctionsToolBar(new FunctionsHandler(frame, new AccountAddEditDialog(frame))));
    }
}
