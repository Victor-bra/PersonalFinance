package personalFinance.gui.panel;

import personalFinance.gui.MainFrame;
import personalFinance.gui.dialog.AccountAddEditDialog;
import personalFinance.gui.dialog.CurrencyAddEditDialog;
import personalFinance.gui.handler.FunctionsHandler;
import personalFinance.gui.table.CurrencyTableDate;
import personalFinance.gui.toolbar.FunctionsToolBar;
import personalFinance.settings.Style;

public class CurrencyPanel extends RightPanel{

    public CurrencyPanel(MainFrame frame) {
        super(frame, new CurrencyTableDate(new FunctionsHandler(frame, new CurrencyAddEditDialog(frame))), "CURRENCIES", Style.ICON_PANEL_CURRENCIES,
                new FunctionsToolBar(new FunctionsHandler(frame, new CurrencyAddEditDialog(frame))));
    }
}
