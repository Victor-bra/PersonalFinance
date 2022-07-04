package personalFinance.gui.panel;

import personalFinance.gui.MainFrame;
import personalFinance.gui.dialog.AccountAddEditDialog;
import personalFinance.gui.dialog.ArticleAddEditDialog;
import personalFinance.gui.handler.FunctionsHandler;
import personalFinance.gui.table.AccountTableDate;
import personalFinance.gui.table.ArticleTableDate;
import personalFinance.gui.toolbar.FunctionsToolBar;
import personalFinance.settings.Style;

public class ArticlePanel extends RightPanel {

    public ArticlePanel(MainFrame frame) {
        super(frame, new ArticleTableDate(new FunctionsHandler(frame, new ArticleAddEditDialog(frame))), "ARTICLES", Style.ICON_PANEL_ARTICLES,
                new FunctionsToolBar(new FunctionsHandler(frame, new ArticleAddEditDialog(frame))));
    }
}
