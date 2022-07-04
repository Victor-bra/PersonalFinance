package personalFinance.gui.panel;

import personalFinance.gui.MainFrame;
import personalFinance.gui.dialog.TransferAddEditDialog;
import personalFinance.gui.handler.FunctionsHandler;
import personalFinance.gui.table.TransferTableDate;
import personalFinance.gui.toolbar.FunctionsToolBar;
import personalFinance.settings.Style;

import javax.swing.*;

public class TransferPanel extends RightPanel {

    public TransferPanel(MainFrame frame) {
        super(frame, new TransferTableDate(new FunctionsHandler(frame, new TransferAddEditDialog(frame))), "TRANSFERS", Style.ICON_PANEL_TRANSFERS,
                new JPanel[]{new FunctionsToolBar(new FunctionsHandler(frame, new TransferAddEditDialog(frame))), new FilterPanel(frame)});
    }
}
